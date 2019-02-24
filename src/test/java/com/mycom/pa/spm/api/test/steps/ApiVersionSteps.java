package com.mycom.pa.spm.api.test.steps;


import java.util.LinkedHashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import com.mycom.pa.spm.api.common.AppProperties;
import com.mycom.pa.spm.api.common.RestClient;
import com.mycom.pa.spm.api.common.RestMethod;
import com.mycom.pa.spm.api.config.AppConfiguration;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.response.Response;
import org.junit.Assert;

@ContextConfiguration(classes= AppConfiguration.class)
public class ApiVersionSteps{
	
	@Autowired
	private RestClient restClient;
	
	@Autowired
	private Response apiResponse;
	
	@When("^I hit the \"(.*?)\" hello api$")
	public void i_hit_the_hello_api(String apiUrl) throws Throwable{
		
      Map<String, String> requestHeaders = new LinkedHashMap<String, String>();
      requestHeaders.put("Authorization", "Bearer ddfc30cc-9b22-4a5b-93e3-1a53ec69c67c");
      //restClient.setApiEndPoint("/hello");
      //System.out.println("Property file value is :" + AppProperties.getConfigProperties().getProperty(apiUrl));
		
		 this.apiResponse = restClient.setServerURL(AppProperties.getConfigProperties().getProperty("spm.ingestion.server.url"))
				 					.setApiEndPoint(AppProperties.getConfigProperties().getProperty(apiUrl))
		 							.setRequestHeaders(requestHeaders).getApiResponse(RestMethod.GET);	 
	}

	@Then("^I get the application name \"(.*?)\"$")
	public void the_application_name(String productName) throws Throwable{
      System.out.println("API Status code is :" + apiResponse.getStatusCode());
      Assert.assertEquals(AppProperties.getConfigProperties().getProperty(productName).trim(), apiResponse.getBody().asString().split(" ")[0].trim());
	}

	@And("^I get the api version \"(.*?)\"$")
	public void the_API_version(String apiVersion) throws Throwable{
		//Assert.assert(productName, apiResponse.getBody().asString().split(" ")[0]);
	}
}
