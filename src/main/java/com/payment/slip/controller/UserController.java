package com.payment.slip.controller;

import com.payment.slip.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

  @GetMapping
  public User getUser() {
    return new User("Martel", "King");
  }
}
