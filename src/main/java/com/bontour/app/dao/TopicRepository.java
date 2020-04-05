package com.bontour.app.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.bontour.app.model.Topic;

@Repository
public interface TopicRepository extends CrudRepository<Topic, Integer> {

  Topic findByName(String name);
}
