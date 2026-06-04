package fighting.gold.juego.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fighting.gold.juego.entidades.Ataque;

@Repository

public interface AtaqueRepository extends JpaRepository<Ataque, Integer> {

}
