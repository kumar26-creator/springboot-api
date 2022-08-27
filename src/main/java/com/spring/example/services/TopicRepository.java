package com.spring.example.services;

import org.springframework.data.repository.CrudRepository;

import com.spring.example.model.Topics;

public interface TopicRepository extends CrudRepository<Topics, Integer> {

}
