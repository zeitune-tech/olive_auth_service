package sn.zeitune.oliveinsuranceauthservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@EnableDiscoveryClient
@RestController
public class OliveInsuranceAuthServiceApplication {

    @GetMapping
    public String home() {
        return "Welcome to Olive Insurance Auth Service!";
    }

    public static void main(String[] args) {
        SpringApplication.run(OliveInsuranceAuthServiceApplication.class, args);
    }

}
