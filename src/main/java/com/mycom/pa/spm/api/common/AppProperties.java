package com.mycom.pa.spm.api.common;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class AppProperties {
	
	private static Properties configProperties;
	
	private AppProperties() throws IOException{
		synchronized(this) {
			if(!(configProperties instanceof Properties)) {
				FileInputStream configFile = new FileInputStream(AppConstants.PROPERTY_FILE_PATH.toString() + File.separator + AppConstants.PROPERTY_FILE_NAME.toString() + ".properties");
				configProperties = new Properties();
				configProperties.load(configFile);
			}
		}
	}
	
	public static Properties getConfigProperties() throws IOException{	
		if(!(configProperties instanceof Properties)) {
			new AppProperties();
		}
		return configProperties;
	}
}