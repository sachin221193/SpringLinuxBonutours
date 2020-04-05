package com.bontour.app.webModel;

import com.bontour.app.common.ApiResponse;

public class LoginResponse extends ApiResponse {
  
  private String jwt;

  public LoginResponse(String jwt) {
    this.jwt = jwt;
  }

  public String getJwt() {
    return jwt;
  }

  public void setJwt(String jwt) {
    this.jwt = jwt;
  }  

}
