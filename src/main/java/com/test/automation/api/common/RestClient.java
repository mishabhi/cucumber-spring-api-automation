package com.test.automation.api.common;

import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import io.restassured.http.Method;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

@Component
@Scope("prototype")
public class RestClient {

	@Autowired(required = true)
	private RequestSpecification apiRequest;

	@Autowired(required = true)
	private Response response;

	private String apiPayload;
	private String apiEndPoint;
	private String serverUrl;
	private Map<String, String> requestHeaders = new LinkedHashMap<String,String>();
	
	public String getServerUrl() {
		return this.serverUrl;
	}

	public RestClient setServerUrl(String serverUrl) {
		this.serverUrl = serverUrl;
		this.apiRequest.baseUri(serverUrl);
		return this;
	}

	public RestClient setApiEndPoint(String apiEndPoint) {
		this.apiRequest.basePath(apiEndPoint);
		this.apiEndPoint = apiEndPoint;
		return this;
	}

	public String getApiEndPoint() {
		return this.apiEndPoint;
	}

	public Map<String, String> getRequestHeaders() {
		return this.requestHeaders;
	}

	public RestClient setRequestHeaders(Map<String, String> requestHeaders) {
		if (requestHeaders!=null)
			this.requestHeaders.putAll(requestHeaders);

		if (!this.requestHeaders.containsKey("Content-Type"))
			this.requestHeaders.put("Content-Type", "application/json");

		return this;
	}

	public String getApiRequestPayload() {
		return apiPayload;
	}

	private RestClient setApiRequestPayload(String apiPayload) {
		this.apiPayload = apiPayload;
		this.apiRequest.body(apiPayload);
		return this;
	}

	public Response getApiResponse(Method apiMethod, String apiPayload) {
		 if(apiMethod.equals(Method.POST) || apiMethod.equals(Method.PUT)){
			 this.setApiRequestPayload(apiPayload);
		 } else {
			 throw new IllegalArgumentException("Method type should be POST or PUT");
		 }
		 
		 if(this.requestHeaders.size()==0){ 
			 this.setRequestHeaders(null); 
		 }
		
		this.apiRequest.headers(this.requestHeaders);
		this.response = this.apiRequest.request(apiMethod.toString());

		return this.response;
	}
	
	public Response getApiResponse(Method apiMethod) {
		 if(!apiMethod.equals(Method.GET) && !apiMethod.equals(Method.DELETE)){
			 throw new IllegalArgumentException("Method type should be GET or DELETE");
		 } 
		 
		 if(this.requestHeaders.size()==0){ 
			 this.setRequestHeaders(null); 
		 }
		
		this.apiRequest.headers(this.requestHeaders);
		this.response = this.apiRequest.request(apiMethod);

		return this.response;
	}

	public String getResponseText() {
		return this.response.prettyPrint();
	}

}
