package com.test.automation.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.restassured.RestAssured;
import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@ComponentScan(basePackages = {"com.test.automation.api"})
public class AppConfiguration{
	
	@Bean
	public RequestSpecification getRequest() {
		return RestAssured.given();
	}
	
	@Bean
	public Response getResponseObject() {
		return new RestAssuredResponseImpl();
	}
	
	@Bean
	public ObjectMapper getObjectMapper() {
		return new ObjectMapper();
	}
}

