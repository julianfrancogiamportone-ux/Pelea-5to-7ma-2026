package fighting.gold.juego.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fighting.gold.juego.entidades.Peleador;
import fighting.gold.juego.repository.PeleadorRepository;
import fighting.gold.juego.iservice.PeleadorIservice;

@Service

public class PeleadorService implements PeleadorIservice {

    @Autowired
    private PeleadorRepository PeleadorRepository;

    public List<Peleador> findAllPeleadores() {
        return PeleadorRepository.findAll();
    }

    public Peleador savePeleador(Peleador peleador) {
        return PeleadorRepository.save(peleador);
    }
}
