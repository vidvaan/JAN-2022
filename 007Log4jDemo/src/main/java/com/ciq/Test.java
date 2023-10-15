package com.ciq;

import org.apache.log4j.Logger;

public class Test {
	
	private static final Logger LOGGER = Logger.getLogger(Test.class);
	
	public static void main(String[] args) {
		
		LOGGER.info("Main Start");
		DemoController demoController= new DemoController();
		demoController.save();
		LOGGER.info("Main End");
		
		
		LOGGER.debug("Main End");
		
		LOGGER.info("Main End");
		
		LOGGER.warn("Main End");
		
		LOGGER.fatal("Main End");
		
		LOGGER.error("Main End");
		
	}

}
