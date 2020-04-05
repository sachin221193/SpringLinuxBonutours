package com.bontour.app.webModel;

public class LocationContact {
  private String mobileNo;
  private String phoneNo;
  private String fax;
  private String emailId;
  
  public LocationContact(LocationContact locationContact) {
    this.mobileNo = locationContact.getMobileNo();
    this.phoneNo = locationContact.getPhoneNo();
    this.fax = locationContact.getFax();
    this.emailId = locationContact.getEmailId();
  }

  public String getMobileNo() {
    return mobileNo;
  }

  public void setMobileNo(String mobileNo) {
    this.mobileNo = mobileNo;
  }

  public String getPhoneNo() {
    return phoneNo;
  }

  public void setPhoneNo(String phoneNo) {
    this.phoneNo = phoneNo;
  }

  public String getFax() {
    return fax;
  }

  public void setFax(String fax) {
    this.fax = fax;
  }

  public String getEmailId() {
    return emailId;
  }

  public void setEmailId(String emailId) {
    this.emailId = emailId;
  }

}
