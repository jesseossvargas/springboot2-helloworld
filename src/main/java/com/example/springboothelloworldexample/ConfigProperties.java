package com.example.springboothelloworldexample;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

@Configuration
@ConfigurationProperties(prefix = "mail")
public class ConfigProperties {

	private String from;
	
	private String to;
	
	private String defaultObject;
	
}
