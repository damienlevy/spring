package fr.ul.chevauxbdd.dao;

import fr.ul.chevauxbdd.model.Chevaux;
import org.springframework.data.repository.CrudRepository;

public interface ChevauxRepository extends CrudRepository<Chevaux,Integer> {
    Iterable<Chevaux> findByNom(String nom);

    Chevaux findById(int id);

    void deleteById(int id);




}
