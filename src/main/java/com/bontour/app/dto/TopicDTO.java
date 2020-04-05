package com.bontour.app.dto;

public class TopicDTO {

  private Integer id;
  private String name;
  private String desc;

  public TopicDTO(int topicId, String topicName, String topicDesc) {
    super();
    this.id = topicId;
    this.name = topicName;
    this.desc = topicDesc;
  }

  public Integer getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public String getDesc() {
    return desc;
  }

}
