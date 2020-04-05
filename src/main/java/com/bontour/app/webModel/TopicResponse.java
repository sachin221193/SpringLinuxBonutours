package com.bontour.app.webModel;

import java.io.Serializable;
import java.util.List;
import com.bontour.app.common.ApiResponse;
import com.bontour.app.model.Topic;

public class TopicResponse extends ApiResponse implements Serializable {

  /**
   * 
   */
  private static final long serialVersionUID = 1L;

  private List<Topic> data;
  
  private List<LocationDto> locationData;

  public List<Topic> getData() {
    return data;
  }

  public void setData(List<Topic> data) {
    this.data = data;
  }

  public List<LocationDto> getLocationData() {
    return locationData;
  }

  public void setLocationData(List<LocationDto> locationData) {
    this.locationData = locationData;
  }

}
