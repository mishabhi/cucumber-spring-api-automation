package com.mycom.pa.spm.api.common;

public enum AppConstants {
	PROPERTY_FILE_PATH("src/test/resources"), PROPERTY_FILE_NAME("application");
	
	private String value;
	private AppConstants(String value) {
		this.value = value;
	}
	
	@Override
	public String toString() {
		return value;
	}
}
