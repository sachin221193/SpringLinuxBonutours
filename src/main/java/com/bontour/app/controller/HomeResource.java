package com.bontour.app.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomeResource {

  @GetMapping("/")
  public String common() {
    return "Welcome";
  }
  
  @GetMapping("/user")
  public String user() {
    return "Welcome to User";
  }
  
  @GetMapping("/admin")
  public String admin() {
    return "Welcome to admin";
  }
}
