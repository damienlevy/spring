package fr.ul.chevauxcloud.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Arrays;

@Component
public class InitBD implements CommandLineRunner {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public void run(String... args) throws Exception {

        System.out.println("Création et initialisation de la base de données");

        String sqlStatements[] = {
                "drop table chevaux if exists",
                "create table chevaux(id serial,nom varchar(255) ,age INT)",
                "INSERT INTO chevaux (nom, age) VALUES('Quovadis',14);",
                "INSERT INTO chevaux (nom, age) VALUES('Rosignol',13);",
                "INSERT INTO chevaux (nom, age) VALUES('Aventurine',10);"
        };

        Arrays.asList(sqlStatements).stream().forEach(sql ->{
            System.out.println(sql);
            jdbcTemplate.execute(sql);
        });

        System.out.println("Affichage de tout les chevaux --------------------");
        jdbcTemplate.query("select * from chevaux",
                new RowMapper<Object>() {

                    @Override
                    public Object mapRow(ResultSet chevaux, int i) throws SQLException {
                        System.out.println("id : "+chevaux.getString("id")+" "+
                                "nom : "+chevaux.getString("nom") +" "+
                                "age : "+chevaux.getInt("age")
                        );
                        return null;
                    }
                });
    }


}
