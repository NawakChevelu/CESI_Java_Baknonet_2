package com.formation.bankonet.controller;

import com.formation.bankonet.models.Compte;
import com.formation.bankonet.models.CompteCourant;
import com.formation.bankonet.repositories.CompteCourantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller // This means that this class is a Controller
@RequestMapping(path="/compteCourant")
public class CompteCourantController {
    @Autowired

    private CompteCourantRepository compteCourantRepository;
    /*
            CompteCourant Handling

            addNewCompteCourant -> POST

            getCompteCourantList -> GET
     */
    @PostMapping(path="/addCompteCourant") // Map ONLY POST Requests
    public @ResponseBody
    String addNewCompteCourant (@RequestParam String p_intitule
            , @RequestParam int p_solde
            , @RequestParam int p_tauxInteret) {
        // @ResponseBody means the returned String is the response, not a view name
        // @RequestParam means it is a parameter from the GET or POST request

        CompteCourant n = new CompteCourant();
        n.setIntitule(p_intitule);
        n.setSolde(p_solde);
        compteCourantRepository.save(n);
        return "Compte courant Saved";
    }

    @GetMapping(path="/allCompteCourant")
    public @ResponseBody Iterable<CompteCourant> getCompteCourantList() {
        // This returns a JSON or XML with the users
        return compteCourantRepository.findAll();
    }

    @DeleteMapping(path="/deleteCompteCourant")
    public @ResponseBody String deleteCompteById(@RequestParam int p_CompteID) {

        compteCourantRepository.deleteById(p_CompteID);
        return "Compte courant deleted";
    }

    @PatchMapping(path="/updateCompte")
    public @ResponseBody String getCompteCourantList(@RequestParam int p_compteID,@RequestParam String p_intitule
            , @RequestParam int p_solde
            , @RequestParam int p_tauxInteret) {

        CompteCourant n = new CompteCourant();
        n.setIntitule(p_intitule);
        n.setSolde(p_solde);
        n.setNumero(p_compteID);

        compteCourantRepository.save(n);
        return "Compte courant updated";
    }
}
