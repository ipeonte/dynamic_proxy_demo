package com.example.demo.dynamic_proxy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@EnableDiscoveryClient
@SpringBootApplication
public class DynamicProxyApplication {

	public static void main(String[] args) {
		SpringApplication.run(DynamicProxyApplication.class, args);
	}
}
