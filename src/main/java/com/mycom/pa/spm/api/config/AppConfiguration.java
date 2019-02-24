package com.mycom.pa.spm.api.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.mycom.pa.spm.api.common.RestClient;

import io.restassured.internal.RestAssuredResponseImpl;
import io.restassured.response.Response;

@Configuration
@ComponentScan(basePackages = { "com.mycom.pa.spm" })
//@PropertySource("classpath:application-${environment}.properties")
public class AppConfiguration{
	
	@Bean
	public RestClient getRestClient() {
		return new RestClient();
	}
	
	@Bean
	public Response getApiResponse() {
		return new RestAssuredResponseImpl();
	}
}
