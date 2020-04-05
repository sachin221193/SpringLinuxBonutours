package com.bontour.app.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.bontour.app.constants.ApiResponseStatus;
import com.bontour.app.dao.TopicRepository;
import com.bontour.app.model.Topic;
import com.bontour.app.webModel.TopicRequest;
import com.bontour.app.webModel.TopicResponse;

@Service
public class TopicService {
  @Autowired
  private TopicRepository topicRepository;

  @Autowired
  private RestTemplate restTemplate;

  private static final String requestUrl = "http://localhost:9000/locations";
  
  private static final String result = "data";

  public TopicResponse getTopic(int id) {
    TopicResponse topicResponse = new TopicResponse();
    Optional<Topic> topic = topicRepository.findById(id);
    if (topic != null) {
      List<Topic> listOfTopics = new ArrayList<Topic>();
      topicResponse.setMessage("Successfully records found");
      topicResponse.setStatus(ApiResponseStatus.SUCCESS.name());
      topicResponse.setData(listOfTopics);
    } else {
      topicResponse.setMessage("No records found");
      topicResponse.setStatus(ApiResponseStatus.FAILED.name());
    }
    return topicResponse;
  }

  public TopicResponse addTopic(TopicRequest request) {
    TopicResponse saveResponse = new TopicResponse();
    Topic existingTopic = topicRepository.findByName(request.getName());
    if (existingTopic == null) {
      com.bontour.app.model.Topic topic = new Topic();
      topic.setName(request.getName());
      topic.setDesc(request.getDesc());
      topicRepository.save(topic);
      saveResponse.setMessage("Topic Save Successfully");
      saveResponse.setStatus(ApiResponseStatus.SUCCESS.name());
    } else {
      saveResponse.setMessage("Duplicate Name Saved in records");
      saveResponse.setStatus(ApiResponseStatus.FAILED.name());
    }
    return saveResponse;
  }

  public TopicResponse updateTopic(Topic request, int id) {
    Optional<Topic> existingTopic = topicRepository.findById(id);
    TopicResponse response = new TopicResponse();
    if (existingTopic != null) {
      existingTopic.get().setName(request.getName());
      existingTopic.get().setDesc(request.getDesc());
      topicRepository.save(existingTopic.get());
      response.setMessage("Records updated successfully");
      response.setStatus(ApiResponseStatus.SUCCESS.name());

    } else {
      response.setMessage("No Records updated..!");
      response.setStatus(ApiResponseStatus.FAILED.name());
    }
    return response;
  }

  public String deleteTopic(int id) {
    Optional<Topic> existingTopic = topicRepository.findById(id);
    if (existingTopic != null) {
      topicRepository.deleteById(id);
      return "Record delete Successfully.";
    } else {
      return "No Record delete.";
    }

  }

  public TopicResponse getTopicList() {
    TopicResponse response = new TopicResponse();
    List<Topic> listOfTopics = new ArrayList<Topic>();
    topicRepository.findAll().forEach(listOfTopics::add);
    if (listOfTopics.size() > 0) {
      response.setData(listOfTopics);
      response.setMessage("Records found Successfully");
      response.setStatus(ApiResponseStatus.SUCCESS.name());
      getRestApiCall();
    } else {
      response.setMessage("No Records Found.");
      response.setStatus("Failed");
    }
    return response;
  }

  public void getRestApiCall() {
    ResponseEntity<String> response = restTemplate.getForEntity(requestUrl, String.class); 
    JSONObject responseBody = getJsonObjectBody(response.getBody());     
    JSONArray resultData = responseBody.getJSONArray(result);
    for(int i = 0;i < resultData.length() ;i++) {
      JSONObject locationObj = resultData.getJSONObject(i);
      System.out.println(locationObj.getString("locationName"));
    }
    
  }

  public RestTemplate getRestTemplate() {
    HttpComponentsClientHttpRequestFactory httpComponentsClientsHttpRequestFactory =
        new HttpComponentsClientHttpRequestFactory();
    httpComponentsClientsHttpRequestFactory.setConnectTimeout(60000);
    httpComponentsClientsHttpRequestFactory.setReadTimeout(60000);
    return new RestTemplate(httpComponentsClientsHttpRequestFactory);
  }

  private static JSONObject getJsonObjectBody(String response) {
    return new JSONObject(new String(response));
  }


}
