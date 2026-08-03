package fighting.gold.juego.iservice;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import fighting.gold.juego.entidades.Arma;

public interface ArmaIservice {
    List<Arma> findAllArmas();

    Arma saveArma(Arma arma);
}
