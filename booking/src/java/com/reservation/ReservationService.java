package com.reservation;

import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

import com.PlaningService;
import com.RegistrationService;
import com.core.Traveler;
import com.core.Trip;

import org.bson.types.ObjectId;
import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ReservationService {

  private ReservationRepository reservationRepository;

  private RegistrationService registrationService;
  private PlaningService planingService;

  public Reservation save(String tripId, String travelerId) {

    return reservationRepository.save(
      new Reservation(
        new ObjectId(tripId),
        new ObjectId(travelerId)));
  }

  public List<Reservation> findAll()
      throws InterruptedException, ExecutionException {

    List<Reservation> reservations = getReservations();

    populateReservations(reservations);

    return reservations;

  }

  private void populateReservations(List<Reservation> reservations)
      throws InterruptedException, ExecutionException {
    for (Reservation reservation : reservations) {
      Trip trip = getTripFromService(reservation.getTripId());
      Traveler traveler = getTravelerFromService(reservation.getTravelerId());
      reservation.setTraveler(traveler);
      reservation.setTrip(trip);
    }
  }

  private List<Reservation> getReservations()
      throws InterruptedException, ExecutionException {
    CompletableFuture<List<Reservation>> reservationsFuture =
      CompletableFuture.supplyAsync(
          () -> reservationRepository.findAll());
    return reservationsFuture.get();
  }

  public List<Reservation> findAllByTravelerId(String id)
      throws InterruptedException, ExecutionException {

    ObjectId tId = new ObjectId(id);
    List<Reservation> reservations = getReservationsByTravelerId(tId);
    Traveler traveler = getTravelerFromService(tId);

    populateReservations(reservations, traveler);

    return reservations;

  }

  public void deleteAll() {
    reservationRepository.deleteAll();
  }

  private List<Reservation> getReservationsByTravelerId(ObjectId travelerId)
      throws InterruptedException, ExecutionException {
    CompletableFuture<List<Reservation>> reservationsFuture =
      CompletableFuture.supplyAsync(
          () -> reservationRepository.findByTravelerId(travelerId));
    return reservationsFuture.get();
  }

  private void populateReservations(
      List<Reservation> reservations,
      Traveler traveler) throws ExecutionException, InterruptedException {
    for (Reservation reservation : reservations) {
      Trip trip = getTripFromService(reservation.getTripId());
      reservation.setTraveler(traveler);
      reservation.setTrip(trip);
    }
  }

  private Traveler getTravelerFromService(ObjectId travelerId)
      throws InterruptedException, ExecutionException {
    CompletableFuture<Traveler> travelersFuture =
        CompletableFuture.supplyAsync(
            () -> registrationService.findTravelerById(travelerId));
    return travelersFuture.get();
  }

  private Trip getTripFromService(ObjectId tripId)
      throws ExecutionException, InterruptedException {
    CompletableFuture<Trip> tripFuture =
        CompletableFuture.supplyAsync(
            () -> planingService.findTripById(tripId));
    return tripFuture.get();
  }
}
