package com.test.automation.api.test.util;

import org.junit.runner.RunWith;
import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
				plugin = { "pretty", "html:target/cucumber", "json:target/cucumber/cucumber.json" }, 
				features = {"src/test/resources/feature"},
				glue = {"classpath:com.test.automation.api.test.steps"},
				tags = { "@RunTest" })
public class TestRunner{
	
}
