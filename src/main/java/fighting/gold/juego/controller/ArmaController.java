package fighting.gold.juego.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import fighting.gold.juego.entidades.Arma;
import fighting.gold.juego.iservice.ArmaIservice;
import fighting.gold.juego.iservice.PeleadorIservice;

@RestController
@RequestMapping("/armas")
public class ArmaController {
    @Autowired
    private ArmaIservice aIservice;

    @GetMapping
    public List<Arma> findAllArmas() {
        return aIservice.findAllArmas();
    }

    @PostMapping
    public Arma saveArma(@RequestBody Arma arma) {
        return aIservice.saveArma(arma);
    }

}
