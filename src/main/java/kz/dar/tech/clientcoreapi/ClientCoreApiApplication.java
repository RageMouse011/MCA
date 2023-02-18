package kz.dar.tech.clientcoreapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class ClientCoreApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClientCoreApiApplication.class, args);
	}

}
