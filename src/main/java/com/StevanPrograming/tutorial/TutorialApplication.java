package com.StevanPrograming.tutorial;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TutorialApplication {

	private static Logger logger= LoggerFactory.getLogger(TutorialApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(TutorialApplication.class, args);

		/*logger.debug("mi mensaje debug");
		logger.trace("mi mensaje trace");
		logger.info("mensaje info");
		logger.warn("mensaje warn");
		logger.error("mi mensaje de error");*/
	}

}
