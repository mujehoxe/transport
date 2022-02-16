package com.reservation;

import java.util.List;
import java.util.concurrent.ExecutionException;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ReservationController {

  ReservationService reservationService;

  @GetMapping(path = "/reservations")
  public List<Reservation> getReservations()
      throws InterruptedException, ExecutionException {
    return reservationService.findAll();
  }

  @RequestMapping(path = "/reservation")
  @ResponseBody
  public List<Reservation> getReservationsByTravelerId(
      @RequestParam(name = "tId") String travelerId)
      throws InterruptedException, ExecutionException {
    return reservationService.findAllByTravelerId(travelerId);
  }

}
