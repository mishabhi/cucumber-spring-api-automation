package com.mycom.pa.spm.api.common;


import java.util.LinkedHashMap; 
import java.util.Map;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class RestClient {
	private String serverURL;
	private Map<String, String> requestHeaders = new LinkedHashMap<String, String>();
	private String inputRequest;
	private RequestSpecification apiRequest = RestAssured.given();
	private Response response;
	private String apiEndPoint;
	

	public String getServerURL() {
		return this.serverURL;
	}
	
	public RestClient setServerURL(String serverURL) {
		this.apiRequest.baseUri(serverURL);
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
		if(this.requestHeaders!=null)
		{
			this.requestHeaders.putAll(requestHeaders);
			
		}
		if(!this.requestHeaders.containsKey("Content-Type"))
		{
			this.requestHeaders.put("Content-Type", "application/json");
		}	
		return this;
	}
	
	public String getInputRequest() {
		return inputRequest;
	}
	
	public RestClient setInputRequest(String inputRequest) {
		this.apiRequest.body(inputRequest);
		return this;
	}
	
	public Response getApiResponse(RestMethod apiMethod){
		
		/*
		 * if(Enum.valueOf(RestMethod.class,
		 * "POST").equalsIgnoreCase(Method.POST.toString()) ||
		 * this.apiMethod.equalsIgnoreCase(Method.PUT.toString())) {
		 * this.apiRequest.body(inputRequest); }
		 * 
		 * if(this.requestHeaders.size()==0) { this.setRequestHeaders(null); }
		 */
		
		this.apiRequest.headers(this.requestHeaders);
		this.response = this.apiRequest.request(apiMethod.toString());
		
		return this.response;
	}
	
	@Override
	public String toString()
	{
		return this.response.prettyPrint();
	}
	
}
