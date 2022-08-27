package com.spring.example.services;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.spring.example.model.Topics;

@Service
public class ServiceUtility {
	
	
	//Creating Instance of CrudRepository Interface
	@Autowired
	private TopicRepository topicRepository;
	
	
	public List<Topics> showTopics()
	{
		
		List<Topics> allTopics=(List<Topics>) topicRepository.findAll();
		return allTopics;
	}
	
	public Optional<Topics> getTopic(int id)
	{
		return topicRepository.findById(id);
	}
	
	public void addTopic(Topics topic)
	{
		topicRepository.save(topic);
	}

	public Topics updateTopic(Topics topic, int id) {
		
		Topics topicObj = topicRepository.findById(id).orElseThrow(()-> new RuntimeException("Topic not found!"));
		topicObj.setName(topic.getName());
		topicObj.setDescription(topic.getDescription());
		
		Topics topicUpdated=topicRepository.save(topicObj);
		
		return topicUpdated;
	}

	public void deleteTopic(int id) {
		
		Topics topicObj = topicRepository.findById(id).orElseThrow(()-> new RuntimeException("Topic not found!"));
		topicRepository.delete(topicObj);
	}
}
