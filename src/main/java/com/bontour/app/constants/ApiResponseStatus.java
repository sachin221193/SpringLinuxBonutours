package com.bontour.app.constants;

public enum ApiResponseStatus {
  SUCCESS("SUCCESS"),FAILED("FAILED");
  
  private String status;

  private ApiResponseStatus(String status) {
    this.setStatus(status);
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }   
  
}