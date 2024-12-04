package net.vkolev.springjsonbexample.http;

import net.vkolev.springjsonbexample.entities.Recepie;
import net.vkolev.springjsonbexample.services.RecepieService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RecepieController {

    private final RecepieService recepieService;

    public RecepieController(RecepieService recepieService) {
        this.recepieService = recepieService;
    }

    @GetMapping("/")
    public List<Recepie> index() {
        return recepieService.getAllRecepies();
    }

    @GetMapping("/topping/{name}")
    public List<Recepie> topping(@PathVariable String name) {
        return recepieService.getWithTopping(name);
    }

}
