package com.logger.Log4j;

import java.io.IOException;

import org.apache.log4j.Appender;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.FileAppender;
import org.apache.log4j.HTMLLayout;
import org.apache.log4j.Layout;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.SimpleLayout;
import org.apache.log4j.xml.XMLLayout;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Log4jApplication {

	// step:1- create logger object/variable
	private static Logger logger = Logger.getLogger(Log4jApplication.class);

	public static void main(String[] args) throws IOException {
		SpringApplication.run(Log4jApplication.class, args);

		//step:2- Layout or format
		//Layout layout=new SimpleLayout();
		
		//Layout layout= new XMLLayout();
		
		//Layout layout = new HTMLLayout();
		
		Layout layout = new PatternLayout("%p %d %C %M %m %n"); //Recommended we used company-realtime-project
		
		//Appender where to store or display
		//Appender appender=new ConsoleAppender(layout);
		
		Appender appender = new FileAppender(layout, "C:\\Shekharp\\Shekharp.log");
		
		//we are giving the details to the logger impl
		logger.addAppender(appender);
		
		logger.info("This is INFO level logging");
		logger.warn("This is WARN level logging ");
		logger.error("This is ERROR level logging");
		logger.fatal("This is FATAL level logging");
		logger.trace("This is TRACE level logging");
		logger.debug("This is DEBUG level logging");
		
	}

}
