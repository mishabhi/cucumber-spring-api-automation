package com.mycom.pa.spm.api.test.steps;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class TestSetup {
	
	@Before
	public void setup() {
		System.out.println("Inside before setup method");
	}
	
	@After
	public void teardown() {
		System.out.println("Inside after setup method");
	}
}
