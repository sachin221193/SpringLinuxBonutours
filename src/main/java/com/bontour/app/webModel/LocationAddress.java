package com.bontour.app.webModel;


public class LocationAddress {
  private String address1;
  private String address2;
  private String address3;
  private Integer pincode;
  private Integer cityId;
  private Integer stateId;
  private Integer countryId;

  public LocationAddress(LocationAddress locationAddress) {
    this.address1 = locationAddress.getAddress1();
    this.address2 = locationAddress.getAddress2();
    this.address3 = locationAddress.getAddress3();
    this.pincode = locationAddress.getPincode();
    this.cityId = locationAddress.getCityId();
    this.stateId = locationAddress.getStateId();
    this.countryId = locationAddress.getCountryId();
  }

  public String getAddress1() {
    return address1;
  }


  public void setAddress1(String address1) {
    this.address1 = address1;
  }


  public String getAddress2() {
    return address2;
  }


  public void setAddress2(String address2) {
    this.address2 = address2;
  }


  public String getAddress3() {
    return address3;
  }


  public void setAddress3(String address3) {
    this.address3 = address3;
  }


  public Integer getPincode() {
    return pincode;
  }

  public void setPincode(Integer pincode) {
    this.pincode = pincode;
  }

  public Integer getCityId() {
    return cityId;
  }

  public void setCityId(Integer cityId) {
    this.cityId = cityId;
  }

  public Integer getStateId() {
    return stateId;
  }

  public void setStateId(Integer stateId) {
    this.stateId = stateId;
  }

  public Integer getCountryId() {
    return countryId;
  }

  public void setCountryId(Integer countryId) {
    this.countryId = countryId;
  }


}
