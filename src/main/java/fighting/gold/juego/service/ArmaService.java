package fighting.gold.juego.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fighting.gold.juego.entidades.Arma;
import fighting.gold.juego.repository.ArmaRepostory;

@Service

public class ArmaService {
    @Autowired
    private ArmaRepostory ArmaRepostory;

    public List<Arma> findAllArmas() {
        return ArmaRepostory.findAll();
    }

    public Arma saveArma(Arma arma) {
        return ArmaRepostory.save(arma);
    }

}
