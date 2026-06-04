package fighting.gold.juego.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import fighting.gold.juego.entidades.Arma;

@Repository
public interface ArmaRepostory extends JpaRepository<Arma, Long> {

}
