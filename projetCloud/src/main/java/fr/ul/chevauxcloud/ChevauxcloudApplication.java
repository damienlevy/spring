package fr.ul.chevauxcloud;

import fr.ul.chevauxcloud.dao.ChevauxRepository;
import fr.ul.chevauxcloud.model.Chevaux;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class ChevauxcloudApplication {


    public static void main(String[] args) {
        SpringApplication.run(ChevauxcloudApplication.class, args);
    }

}
