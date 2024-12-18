package com.example.hello;

import com.example.hello.product.Product;
import com.example.hello.product.ProductRepository;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
public class HelloApplication {

	@Autowired
	ProductRepository productRepository;

	@PostConstruct
	void initialData() {
		Product p100 = new Product();
		p100.setId(100);
		p100.setName("Product 100");
		productRepository.save(p100);
	}

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
