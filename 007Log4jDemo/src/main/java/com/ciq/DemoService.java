package com.ciq;

import org.apache.log4j.Logger;

public class DemoService {
	
	private DemoDAO demoDAO = new DemoDAO();
	private static final Logger LOGGER = Logger.getLogger(DemoService.class);
	public void save() {
		LOGGER.info("Demo Service Save Start");
		demoDAO.save();
		LOGGER.info("Demo Service Save End");
	}

}
