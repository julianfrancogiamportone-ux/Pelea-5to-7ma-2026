package fighting.gold.juego.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import fighting.gold.juego.entidades.Arma;
import fighting.gold.juego.iservice.AtaqueIservice;

@RestController
@RequestMapping("/ataques")
public class AtaqueController {
    @Autowired
    private AtaqueIservice ataqueIservice;

    @GetMapping
    public List<Arma> findAllArmas() {
        return ataqueIservice.findAllArmas();
    }

    @PostMapping
    public Arma saveArma(@RequestBody Arma arma) {
        return ataqueIservice.saveArma(arma);
    }
}
