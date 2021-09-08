package config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import controller.FirstWebTest;

@Configuration
public class ControllerConfig {

	@Bean
	public FirstWebTest helloController() {
		return new FirstWebTest();
	}

}
