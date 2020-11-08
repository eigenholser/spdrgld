package com.eigenholser.outrider.spdrgld;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpdrGldApplication {
	private static final Logger logger = LogManager.getLogger(SpdrGldApplication.class);

	public static void main(String[] args) {
		logger.debug("***** Startup *****");
		SpringApplication.run(SpdrGldApplication.class, args);
	}
}
