package com.ticketstation.ticketstationeurekaserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class TicketstationEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketstationEurekaServerApplication.class, args);
	}

}
