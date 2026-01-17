package Joytishcharya_EurekaServer.Joytishcharya_EurekaServer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class JoytishcharyaEurekaServerApplication {

	public static void main(String[] args) {
		SpringApplication.run(JoytishcharyaEurekaServerApplication.class, args);
	}

}
