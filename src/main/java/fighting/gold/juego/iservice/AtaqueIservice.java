package fighting.gold.juego.iservice;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fighting.gold.juego.entidades.Arma;

public interface AtaqueIservice {
    List<Arma> findAllArmas();

    Arma saveArma(Arma arma);
}
