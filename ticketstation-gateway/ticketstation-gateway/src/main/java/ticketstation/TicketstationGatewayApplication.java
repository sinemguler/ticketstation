package ticketstation;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
@SpringBootApplication
@EnableEurekaClient
public class TicketstationGatewayApplication {

	public static void main(String[] args) {
		SpringApplication.run(TicketstationGatewayApplication.class, args);
	}

}
