package com.ciq;

import org.apache.log4j.Logger;

public class DemoDAO {

	private static final Logger LOGGER = Logger.getLogger(DemoDAO.class);

	public void save() {
		LOGGER.info("Demo DAO Save Start");
		LOGGER.info("DEMO DAO Logic");
		LOGGER.info("Demo DAO Save End");
	}

}
