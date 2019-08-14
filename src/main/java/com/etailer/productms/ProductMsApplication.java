package com.etailer.productms;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.filter.CorsFilter;

import com.etailer.productms.model.Product;
import com.etailer.productms.service.ProductService;

@SpringBootApplication
@EnableDiscoveryClient
public class ProductMsApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductMsApplication.class, args);
	}

	@Bean
	CommandLineRunner runner(ProductService productService) {
		return args -> {
			productService.save(new Product(1L, "TV Set", 300.00, "http://192.168.99.100:8080/tv.jpg"));
			productService.save(new Product(2L, "Game Console", 200.00, "http://192.168.99.100:8080/gameconsole.jpeg"));
			productService.save(new Product(3L, "Sofa", 100.00, "http://192.168.99.100:8080/sofa.jpeg"));
			productService.save(new Product(4L, "Laptop", 5.00, "http://192.168.99.100:8080/laptop.jpeg"));
			productService.save(new Product(6L, "Phone", 500.00, "http://192.168.99.100:8080/phone.jpeg"));
			productService.save(new Product(7L, "Watch", 30.00, "http://192.168.99.100:8080/watch.jpeg"));
		};
	}
	
	@Bean
    public CorsFilter corsFilter() {
    	System.out.println("CORS filter executing");
        UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
        CorsConfiguration config = new CorsConfiguration();
        config.setAllowCredentials(true);
        config.addAllowedOrigin("*");
        config.addAllowedHeader("*");
        config.addAllowedMethod("OPTIONS");
        config.addAllowedMethod("GET");
        config.addAllowedMethod("POST");
        config.addAllowedMethod("PUT");
        config.addAllowedMethod("DELETE");
        source.registerCorsConfiguration("/**", config);
        return new CorsFilter(source);
    }
}
