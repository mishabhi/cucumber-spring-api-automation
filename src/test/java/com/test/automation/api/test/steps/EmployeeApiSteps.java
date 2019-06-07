package com.test.automation.api.test.steps;


import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.test.automation.api.common.AppProperties;
import com.test.automation.api.common.RestClient;
import com.test.automation.api.config.AppConfiguration;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.cucumber.datatable.DataTable;
import io.restassured.http.Method;
import io.restassured.response.Response;
import org.apache.commons.lang3.StringUtils;
import org.junit.Assert;

@ContextConfiguration(classes= AppConfiguration.class)
public class EmployeeApiSteps{
	
	@Autowired
	private RestClient restClient;
	
	@Autowired
	private Response apiResponse;
	
	@Autowired
	private ObjectMapper jsonMapper;
	
	@When("^User hits the (.*?) api to retrieve the list of employees$")
	public void getAllEmployees(String apiEndPointKey) throws Throwable{
		
      Map<String, String> requestHeaders = new LinkedHashMap<String, String>();
   
      this.apiResponse = restClient.setServerUrl(AppProperties.getConfigProperties().getProperty("api.server.url"))
				 					.setApiEndPoint(AppProperties.getConfigProperties().getProperty(StringUtils.trim(apiEndPointKey)))
		 							.setRequestHeaders(requestHeaders).getApiResponse(Method.GET);	 
	}

	@Then("^Api returns (.*?) status code$")
	public void verifyStatusCode(int statusCode){
      System.out.println("API Status code is :" + apiResponse.getStatusCode());
      Assert.assertEquals(this.apiResponse.getStatusCode(), statusCode);
	}
	
	@And("^Response should have the list of employees.$")
	public void verifyGetEmployeesListApiResponse(){
      Assert.assertTrue(apiResponse.jsonPath().getList("").size()>0);
	}
	
	@When("^User hits the (.*?) api to create an employee with$")
	public void createEmployee(String apiEndPointKey, DataTable dataTable) throws Throwable{
	  List<Map<String, String>> employeeData = dataTable.asMaps();
	  String apiPayload = jsonMapper.writeValueAsString(employeeData.get(0));
      Map<String, String> requestHeaders = new LinkedHashMap<String, String>();
   
      this.apiResponse = restClient.setServerUrl(AppProperties.getConfigProperties().getProperty("api.server.url"))
				 					.setApiEndPoint(AppProperties.getConfigProperties().getProperty(StringUtils.trim(apiEndPointKey)))
		 							.setRequestHeaders(requestHeaders).getApiResponse(Method.POST, apiPayload);	 
	}
	
	@Then("^Response should have the id generated for Employee.$")
	public void verifyCreateApiResponse(){
      Assert.assertTrue(apiResponse.jsonPath().get("id")!=null);
	}

}
