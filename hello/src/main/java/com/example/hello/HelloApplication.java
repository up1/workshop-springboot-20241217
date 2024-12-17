package com.example.hello;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HelloApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context
				= SpringApplication.run(HelloApplication.class, args);

		String[] beans = context.getBeanDefinitionNames();
		for (String bean : beans) {
			System.out.println(bean);
		}

		// Number of instances
		System.out.println(context.getBeanDefinitionCount());
	}

}