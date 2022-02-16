package com;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import com.core.Traveler;
import com.service.AccountService;
import com.user.AppUser;
import com.user.UserDto;

import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AccountRestController {
	
  private AccountService accountService;
  private RegistrationService registrationService;

  @PostMapping("/register")
  @ResponseBody
  public AppUser registerUserAccount(
    @ModelAttribute("user") @Valid UserDto userDto,
    HttpServletRequest request,
    Errors errors) {
    UserDto userDto2 = (UserDto) request.getAttribute("user"); 

    AppUser user = accountService.registerNewUserAccount(userDto2);

    registrationService.save(
        new Traveler(
          user.getId(),
          userDto.getFirstName(),
          userDto.getLastName())
        );

    return user;
  }

}

