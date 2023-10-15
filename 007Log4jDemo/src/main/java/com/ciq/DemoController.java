package com.ciq;

import org.apache.log4j.Logger;

public class DemoController {
	
	private DemoService demoService = new DemoService();
	
	private static final Logger LOGGER = Logger.getLogger(DemoController.class);
	
	public void save() {
		LOGGER.info("Demo controller Save  Start");
		demoService.save();
		LOGGER.info("Demo controller Save  End");
	}

}
