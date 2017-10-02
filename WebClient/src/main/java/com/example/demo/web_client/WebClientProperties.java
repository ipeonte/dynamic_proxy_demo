package com.example.demo.web_client;

import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("test")
public class WebClientProperties {

	private Boolean boolVar;
	
	private Integer intVar;
	
	private Double dblVar;
	
	private String strVar;

	private List<String> listVar;
	
	public Boolean getBoolVar() {
		return boolVar;
	}

	public void setBoolVar(Boolean boolVar) {
		this.boolVar = boolVar;
	}

	public Integer getIntVar() {
		return intVar;
	}

	public void setIntVar(Integer intVar) {
		this.intVar = intVar;
	}

	public Double getDblVar() {
		return dblVar;
	}

	public void setDblVar(Double dblVar) {
		this.dblVar = dblVar;
	}

	public String getStrVar() {
		return strVar;
	}

	public void setStrVar(String strVar) {
		this.strVar = strVar;
	}

	public List<String> getListVar() {
		return listVar;
	}

	public void setListVar(List<String> listVar) {
		this.listVar = listVar;
	}
	
	
}
