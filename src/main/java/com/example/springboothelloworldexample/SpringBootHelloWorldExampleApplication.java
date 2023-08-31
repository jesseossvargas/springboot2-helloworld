package com.example.springboothelloworldexample;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;

import com.example.springboothelloworldexample.exception.UrlAccessException;

@SpringBootApplication
public class SpringBootHelloWorldExampleApplication implements CommandLineRunner{
	
	@Autowired
	ConfigProperties configProperties;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootHelloWorldExampleApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println(" *** mail properties ***");
		System.out.println(" From : "+configProperties.getFrom());
		System.out.println(" To : "+configProperties.getTo());
		System.out.println(" Default Object :"+configProperties.getDefaultObject());
	}

	@EventListener(classes = ContextRefreshedEvent.class)
	public void listen() {
		throw new UrlAccessException("http://www.example.com");
	}
	
}
