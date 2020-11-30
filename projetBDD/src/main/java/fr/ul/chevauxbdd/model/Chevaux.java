package fr.ul.chevauxbdd.model;

import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Chevaux {
    private String nom;
    private int age;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }


    public Chevaux() {}

    public Chevaux(int id,String nom, int age) {
        this.id = id;
        this.age = age;
        this.nom = nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return this.nom;
    }


    public void setId(Integer id) {
        this.id = id;
    }

    @Id
    public Integer getId() {
        return id;
    }

    @Override
    public String toString() {
        return "Chevaux{" +
                "nom='" + nom + '\'' +
                ", age=" + age +
                ", id=" + id +
                '}';
    }
}
