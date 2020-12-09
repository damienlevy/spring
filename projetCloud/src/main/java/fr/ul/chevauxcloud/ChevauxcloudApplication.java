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

   private static final Logger log = LoggerFactory.getLogger(ChevauxcloudApplication.class);

    @Bean
    public CommandLineRunner clr(ChevauxRepository repository){
        return (args -> {
            repository.save(new Chevaux(1,"Quovadis",14));
            repository.save(new Chevaux(2,"Rosignol",13));

           log.info("affichage de tous les chevaux -----(findAll)------");
           for (Chevaux ch :repository.findAll()){
               log.info(ch.toString());
           }
           log.info("affichage d'un cheval ----(findById(1))------");
           Chevaux ch = repository.findById(1);
           log.info(ch.toString());
            log.info("affichage d'un cheval ----(findByNom('Rosignol')------");
            repository.findByNom("Rosignol").forEach(chevaux -> {log.info(chevaux.toString());});
        });
    }

    public static void main(String[] args) {
        SpringApplication.run(ChevauxcloudApplication.class, args);
    }

}
