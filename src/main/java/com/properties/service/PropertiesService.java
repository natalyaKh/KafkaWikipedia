package com.properties.service;


import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URI;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.springframework.stereotype.Service;

import com.properties.entity.KafkaProperty;
import com.properties.enums.StatusKafkaWiki;


@Service
public class PropertiesService {

//	public Map<String, String> getProperty(String value) {
		public StatusKafkaWiki getProperty(String value) {

		Map<String, String> map = new HashMap<>();
	    String filePath = "C:\\Projects\\KafkaWiki\\files\\" + value + ".txt";
		try (Stream<String> lines = Files.lines(Paths.get(filePath))) {
	        lines.filter(line -> line.contains(":"))
	            .forEach(line -> {
	                String[] keyValuePair = line.split(":", 2);
	                String key = keyValuePair[0];
	                String propvalue = keyValuePair[1];
	                map.putIfAbsent(key, propvalue);
	                System.out.println(map.toString());
	                
	            });
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    return StatusKafkaWiki.OK;
	}




	public List<Path> getAllProperties() {
		List<Path> rez = null;
		try {
			rez = Files.walk(Paths.get("C:\\Projects\\KafkaWiki\\files"))
			 .filter(Files::isRegularFile)
			 .collect(Collectors.toList());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(rez.toString() + " reault");
		return rez;
	}

	public String createProperty(KafkaProperty kafkaProperty) {
		 String str = "name:"+kafkaProperty.getName()+"\n"+ "defaultValue:" +kafkaProperty.getDefaultValue();
	
		 String fileName = "C:\\Projects\\KafkaWiki\\files\\" + kafkaProperty.getName() + ".txt";
		    FileOutputStream outputStream;
			try {
				outputStream = new FileOutputStream(fileName);
				byte[] strToBytes = str.getBytes();
		    outputStream.write(strToBytes);
		    outputStream.close();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		    
		return "OK";
	}

}
