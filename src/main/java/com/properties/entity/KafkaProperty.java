package com.properties.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


public class KafkaProperty {

	String name;
	String defaultValue;
	String owner;
	String descrRus;
	String descrEng;
	String recomRus;
	String recomEng;
	String updateMode;
	public KafkaProperty(String name, String defaultValue, String owner, String descrRus, String descrEng,
			String recomRus, String recomEng, String updateMode) {
		super();
		this.name = name;
		this.defaultValue = defaultValue;
		this.owner = owner;
		this.descrRus = descrRus;
		this.descrEng = descrEng;
		this.recomRus = recomRus;
		this.recomEng = recomEng;
		this.updateMode= updateMode;
	}
	
	public String getUpdateMode() {
		return updateMode;
	}

	
	public void setUpdateMode(String updateMode) {
		this.updateMode = updateMode;
	}

	public void setName(String name) {
		this.name = name;
	}
	public void setDefaultValue(String defaultValue) {
		this.defaultValue = defaultValue;
	}
	public void setOwner(String owner) {
		this.owner = owner;
	}
	public void setDescrRus(String descrRus) {
		this.descrRus = descrRus;
	}
	public void setDescrEng(String descrEng) {
		this.descrEng = descrEng;
	}
	public void setRecomRus(String recomRus) {
		this.recomRus = recomRus;
	}
	public void setRecomEng(String recomEng) {
		this.recomEng = recomEng;
	}
	public KafkaProperty() {
		super();
	}
	public String getName() {
		return name;
	}
	public String getDefaultValue() {
		return defaultValue;
	}
	public String getOwner() {
		return owner;
	}
	public String getDescrRus() {
		return descrRus;
	}
	public String getDescrEng() {
		return descrEng;
	}
	public String getRecomRus() {
		return recomRus;
	}
	public String getRecomEng() {
		return recomEng;
	}

	@Override
	public String toString() {
		return "KafkaProperty [name=" + name + ", defaultValue=" + defaultValue + ", owner=" + owner + ", descrRus="
				+ descrRus + ", descrEng=" + descrEng + ", recomRus=" + recomRus + ", recomEng=" + recomEng
				+ ", updateMode=" + updateMode + "]";
	}

	
}
