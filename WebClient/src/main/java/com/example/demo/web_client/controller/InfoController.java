package com.example.demo.web_client.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.web_client.WebClientProperties;

@RestController
public class InfoController {

	@Value("${server.port}")
    private int port;
	
	@Autowired
	private WebClientProperties _props;
	
	@RequestMapping("/info")
	public String getWebAppInfo() {
		String lst = null; 
		
		if (_props.getListVar() != null) {
			lst = "";
			
			for (String s: _props.getListVar())
				lst += "," + s;
		}	

		return "<p>Port: " + port + "</p>" + 
				"<p>Boolean Param: " + _props.getBoolVar() + "</p>" + 
				"<p>Integer Param: " + _props.getIntVar() + "</p>" + 
				"<p>Double Param: " + _props.getDblVar() + "</p>" + 
				"<p>String Param: " + _props.getStrVar() + "</p>" +
				"<p>List Param: " + (lst == null ? null : lst.substring(1)) + "</p>";
	}
}
