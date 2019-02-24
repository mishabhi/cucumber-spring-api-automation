package com.mycom.pa.spm.api.test.util;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import com.mycom.pa.spm.api.config.AppConfiguration;
import cucumber.api.CucumberOptions;
import cucumber.api.java.Before;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
				plugin = { "pretty", "html:target/cucumber", "json:target/cucumber/cucumber.json" }, 
				features = {"src/test/resources/feature"},
				glue = {"classpath:com.mycom.pa.spm.api.test.steps"},
				tags = { "@RunTest" })
@ContextConfiguration(classes= AppConfiguration.class)
public class TestRunner{
	
}
