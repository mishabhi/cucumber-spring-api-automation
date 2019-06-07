package com.test.automation.api.common;

public enum AppConstants {
	PROPERTY_FILE_PATH("src/test/resources"), PROPERTY_FILE_NAME("application");
	
	private Object value;
	private AppConstants(Object value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return this.value.toString();
	}
}
