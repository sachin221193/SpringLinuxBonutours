package com.bontour.app.controller;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.bontour.app.model.Topic;
import com.bontour.app.service.TopicService;
import com.bontour.app.webModel.TopicRequest;
import com.bontour.app.webModel.TopicResponse;

@RestController
public class TopicController {

  @Autowired
  private TopicService topicService;

  @RequestMapping(value = "/greet", method = RequestMethod.GET)
  public String GreetMessage() {
    return "index.jsp";
  }

  @GetMapping(value = "/topics")
  public ResponseEntity<?> getAllTopics() {
    TopicResponse response = new TopicResponse();
    response = topicService.getTopicList();
    return new ResponseEntity<TopicResponse>(response, HttpStatus.OK);
  }

  @GetMapping(value = "/topic/{id}")
  public ResponseEntity<?> getTopic(@PathVariable int id) {
    TopicResponse response = new TopicResponse();
    response = topicService.getTopic(id); 
    return new ResponseEntity<TopicResponse>(response, HttpStatus.OK);
  }

  @PostMapping(value = "/topic")
  public ResponseEntity<?> saveTopic(@RequestBody TopicRequest request) {
    TopicResponse response = new TopicResponse();
    response = topicService.addTopic(request);
    return new ResponseEntity<TopicResponse>(response, HttpStatus.OK);
  }

  @PutMapping(value = "/topic/{id}")
  public ResponseEntity<?> updateTopic(@RequestBody Topic request, @PathVariable int id) {
    TopicResponse updateResponse = new TopicResponse();
    updateResponse = topicService.updateTopic(request, id); 
    return new ResponseEntity<TopicResponse>(updateResponse, HttpStatus.OK);
  }

  @DeleteMapping(value = "/topic/{id}")
  public String deleteTopic(@PathVariable int id) {
    return topicService.deleteTopic(id);
  }
}
