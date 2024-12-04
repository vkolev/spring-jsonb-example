package net.vkolev.springjsonbexample.services;

import net.vkolev.springjsonbexample.entities.Recepie;
import net.vkolev.springjsonbexample.repositories.RecepieRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RecepieService {

    private final RecepieRepository recepieRepository;

    public RecepieService(RecepieRepository recepieRepository) {
        this.recepieRepository = recepieRepository;
    }

    public List<Recepie> getAllRecepies() {
        return recepieRepository.findAll();
    }

    public List<Recepie> getWithTopping(String name) {
        return recepieRepository.findWithToppings(name);
    }
}
