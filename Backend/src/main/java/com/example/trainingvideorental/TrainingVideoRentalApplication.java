package com.example.trainingvideorental;

import com.example.trainingvideorental.rental.SpringSecurityAuditorAware;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing(auditorAwareRef="auditorAware")
@SpringBootApplication
public class TrainingVideoRentalApplication {


    @Bean
    public AuditorAware<String> auditorAware() {
        return new SpringSecurityAuditorAware();
    }
    public static void main(String[] args) {
        SpringApplication.run(TrainingVideoRentalApplication.class, args);
    }


}
