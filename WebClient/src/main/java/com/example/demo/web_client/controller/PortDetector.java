package com.example.demo.web_client.controller;

import org.springframework.boot.context.embedded.EmbeddedServletContainerInitializedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class PortDetector {

	private int port;
	
	@EventListener
	public void handle(EmbeddedServletContainerInitializedEvent event) {
		port = event.getSource().getPort();
	}
	
	public int getPort() {
		return port;
	}
}
