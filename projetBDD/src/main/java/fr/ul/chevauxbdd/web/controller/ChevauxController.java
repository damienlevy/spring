package fr.ul.chevauxbdd.web.controller;


import fr.ul.chevauxbdd.dao.ChevauxRepository;
import fr.ul.chevauxbdd.model.Chevaux;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
//fusionne @Controller et @ResponseBody , evite d'ecrire @Response body a chaque fonction ayant un retour
public class ChevauxController {

    @Autowired
    private ChevauxRepository dao;

    @GetMapping(value = "/Chevaux")
    public Iterable<Chevaux> getChevaux() {
        return dao.findAll();
    }

    @GetMapping(value = "/Chevaux/{id}")
    public Chevaux getCheval(@PathVariable int id) {
        return dao.findById(id);
    }

    @PostMapping(value = "Chevaux")
    public void addCheval(@RequestBody Chevaux c) {
        dao.save(c);
    }

    @DeleteMapping(value = "/Chevaux/{id}")
    public void supprimerChevaux(@PathVariable int id){
        dao.deleteById(id);
    }

}
