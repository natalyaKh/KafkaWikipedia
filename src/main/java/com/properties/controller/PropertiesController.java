package com.properties.controller;

import java.nio.file.Path;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.properties.entity.KafkaProperty;
import com.properties.enums.StatusKafkaWiki;
import com.properties.service.PropertiesService;


@RestController
@RequestMapping(value = "/prop")
public class PropertiesController {

	@Autowired
	PropertiesService propertiesService;
	
	@GetMapping("/health")
	public String checkHealth() {
		return  "OK";
	}
	
	@GetMapping("/{value}")
	public void getPropertiesByName(@PathVariable String value) {
		 StatusKafkaWiki rez = propertiesService.getProperty(value);
	}
	
	@GetMapping("/values")
	public void getNamesOfAllProperties() {
		 List<Path> rez = propertiesService.getAllProperties();
	}
	
	@PostMapping("/create")
	public void SendPropertiToKafka(@RequestBody KafkaProperty kafkaProperty) {
		String rez = propertiesService.createProperty(kafkaProperty);
	}

}
