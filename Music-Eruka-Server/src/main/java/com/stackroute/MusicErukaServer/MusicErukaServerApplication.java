package com.stackroute.MusicErukaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class MusicErukaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(MusicErukaServerApplication.class, args);
	}

}

