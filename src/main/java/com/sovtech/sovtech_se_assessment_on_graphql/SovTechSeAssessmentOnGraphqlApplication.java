/**
 * SovTech SE Assessment
 * Oct 25th 2022
 */

package com.sovtech.sovtech_se_assessment_on_graphql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@Configuration
@EnableAutoConfiguration
@ComponentScan(basePackages = {"com.sovtech.sovtech_se_assessment_on_graphql"})
public class SovTechSeAssessmentOnGraphqlApplication {

	@Bean
	public WebClient.Builder getWebClient(){
		return WebClient.builder();
	}

	public static void main(String[] args) {
		SpringApplication.run(SovTechSeAssessmentOnGraphqlApplication.class, args);
	}

}
