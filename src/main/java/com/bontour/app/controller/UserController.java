package com.bontour.app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.bontour.app.constants.ApiResponseStatus;
import com.bontour.app.service.MyUserDetailsService;
import com.bontour.app.utils.JwtUtils;
import com.bontour.app.webModel.LoginResponse;
import com.bontour.app.webModel.UserLoginRequest;

@RestController
public class UserController {
  
  @Autowired
  private AuthenticationManager authenticationManager;
  
  @Autowired
  private MyUserDetailsService userDetailsService;
  
  @Autowired
  private JwtUtils jwtUtils;
  
  @PostMapping(value="/authenticate")
  public ResponseEntity<?> userLogin(@RequestBody UserLoginRequest loginRequest) throws Exception{
    try {
      authenticationManager.authenticate(
          new UsernamePasswordAuthenticationToken(loginRequest.getUserName(), loginRequest.getPassword())
          );
    }catch(BadCredentialsException e) {
      throw new Exception("Incorrect UserName or Password.");
    }
    
    final UserDetails userDetails = userDetailsService.loadUserByUsername(loginRequest.getUserName());
    final String jwt = jwtUtils.generateToken(userDetails);
    LoginResponse loginResponse = new LoginResponse(jwt);
    loginResponse.setMessage("User login Successfully.");
    loginResponse.setStatus(ApiResponseStatus.SUCCESS.name());
    return new ResponseEntity<LoginResponse>(loginResponse, HttpStatus.OK);
  } 
}
