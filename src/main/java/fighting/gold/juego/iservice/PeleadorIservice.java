package fighting.gold.juego.iservice;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import fighting.gold.juego.repository.PeleadorRepository;
import fighting.gold.juego.entidades.Peleador;

public interface PeleadorIservice {
    List<Peleador> findAllPeleadores();

    Peleador savePeleador(Peleador peleador);
}
