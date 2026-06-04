package fighting.gold.juego.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fighting.gold.juego.entidades.Peleador;

@Repository

public interface PeleadorRepository extends JpaRepository<Peleador, Long> {

}
