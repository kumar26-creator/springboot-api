package com.spring.example.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.spring.example.model.Topics;
import com.spring.example.services.ServiceUtility;

@RestController
public class MyController
{
	@Autowired
	private ServiceUtility serviceutility;
	
	@RequestMapping("/topics")
	public List<Topics> getAllTopics()
	{
		return serviceutility.showTopics();
	}
	
	@RequestMapping("topics/{id}")
	public Optional<Topics> getTopic(@PathVariable int id)
	{
		return serviceutility.getTopic(id);
	}
	
	@RequestMapping(method = RequestMethod.POST,value = "/topics")
	public String addTopic(@RequestBody Topics topic)
	{
		serviceutility.addTopic(topic);
		return "Topic Added Successfully";
	}
	
	@RequestMapping(method = RequestMethod.PUT,value = "/topics/{id}")
	public String addTopic(@RequestBody Topics topic,@PathVariable int id)
	{
		serviceutility.updateTopic(topic,id);
		return "Topic Updated Successfully";
	}
	
	@RequestMapping(method = RequestMethod.DELETE,value = "/topics/{id}")
	public String deleteTopic(@PathVariable int id)
	{
		serviceutility.deleteTopic(id);
		return "Topic delete Successfully";
	}
	
	
	
}
