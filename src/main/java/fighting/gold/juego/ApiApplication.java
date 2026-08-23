package fighting.gold.juego;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fighting.gold.juego.entidades.Arma;
import fighting.gold.juego.entidades.Ataque;
import fighting.gold.juego.entidades.Peleador;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);

	}
}
