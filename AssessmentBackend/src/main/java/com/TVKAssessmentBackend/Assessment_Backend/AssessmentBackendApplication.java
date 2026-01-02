package com.TVKAssessmentBackend.Assessment_Backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class AssessmentBackendApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssessmentBackendApplication.class, args);
	}

}
