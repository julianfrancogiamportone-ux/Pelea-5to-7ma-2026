package fighting.gold.juego;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fighting.gold.juego.entidades.Arma;
import fighting.gold.juego.entidades.Ataque;
import fighting.gold.juego.entidades.Peleador;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@SpringBootApplication
public class ApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(ApiApplication.class, args);

		Ataque patada = new Ataque(1, "Patada", 30, 15);
		Ataque puñetazo = new Ataque(2, "PUÑO DEL DRAGON", 20, 10);
		Ataque rayo = new Ataque(3, "IMPACTRUENO", 80, 150);
		Arma espada = new Arma(1, "EXCALIBUR", 20, 10);
		Arma escudo = new Arma(2, "RHO AIAS", 10, 20);
		Arma lanza = new Arma(3, "LANZA DE LONGINUS", 30, 15);
		Peleador goku = new Peleador("Goku", 1, 100, 100, 0.2f, 80, null);
		Peleador vegeta = new Peleador("Vegeta", 2, 100, 100, 0.3f, 80, null);
		System.out.println("¡Bienvenidos a FIGHTING GOLD(PRE ALPHA)!");
		System.out.println("Peleadores disponibles:");
		System.out.println("1. Goku");
		System.out.println("2. Vegeta");
		System.out.println("Selecciona tu peleador (1 o 2):");
		System.out.println("¡Has seleccionado a " + goku.getnombre() + "!");
		System.out.println("armas del peleador:+");
		espada.imprimirarma();
		patada.imprimirataque();
		System.out.println("¡Has seleccionado a " + vegeta.getnombre() + "!");
		vegeta.imprimir();
		rayo.imprimirataque();
		escudo.imprimirarma();
		if (goku.getArmas().get(0).getBonificadordanio() > vegeta.getArmas().get(0).getBonificadordanio()) {
			System.out.println(goku.getnombre() + " gana la pelea!");
		} else if (vegeta.getArmas().get(0).getBonificadordanio() > goku.getArmas().get(0).getBonificadordanio()) {
			System.out.println(vegeta.getnombre() + " gana la pelea!");
		} else {
			System.out.println("¡Es un empate!");
		}
		for (Arma arma : goku.getArmas()) {
			arma.imprimirarma();
		}
		for (Arma arma : vegeta.getArmas()) {
			arma.imprimirarma();
		}

		goku.setArmas(new ArrayList<>(Arrays.asList(espada, escudo, lanza, null)));
		for (Arma armasdisponibles : goku.getArmas()) {
			armasdisponibles.imprimirarma();
		}
		vegeta.setArmas(new ArrayList<>(Arrays.asList(espada, escudo, lanza, null)));
		for (Arma armasdisponibles : vegeta.getArmas()) {
			armasdisponibles.imprimirarma();
		}
		goku.setAtaques(new ArrayList<>(Arrays.asList(patada, puñetazo, rayo, null)));
		for (Ataque ataquesdisponibles : goku.getAtaques()) {
			ataquesdisponibles.imprimirataque();
			if (patada.getDaniobase() > puñetazo.getDaniobase() && patada.getDaniobase() > rayo.getDaniobase()) {
				System.out.println("El ataque más poderoso de " + goku.getnombre() + " es: " + patada.getNombre());
			} else if (puñetazo.getDaniobase() > patada.getDaniobase()
					&& puñetazo.getDaniobase() > rayo.getDaniobase()) {
				System.out.println("El ataque más poderoso de " + goku.getnombre() + " es: " + puñetazo.getNombre());
			} else if (rayo.getDaniobase() > patada.getDaniobase() && rayo.getDaniobase() > puñetazo.getDaniobase()) {
				System.out.println("El ataque más poderoso de " + goku.getnombre() + " es: " + rayo.getNombre());
			} else {
				System.out.println("¡Es un empate en ataques!");
			}
		}
		vegeta.setAtaques(new ArrayList<>(Arrays.asList(patada, puñetazo, rayo, null)));
		for (Ataque ataquesdisponibles : vegeta.getAtaques()) {
			ataquesdisponibles.imprimirataque();
			if (patada.getDaniobase() > puñetazo.getDaniobase() && patada.getDaniobase() > rayo.getDaniobase()) {
				System.out.println("El ataque más poderoso de " + vegeta.getnombre() + " es: " + patada.getNombre());
			} else if (puñetazo.getDaniobase() > patada.getDaniobase()
					&& puñetazo.getDaniobase() > rayo.getDaniobase()) {
				System.out.println("El ataque más poderoso de " + vegeta.getnombre() + " es: " + puñetazo.getNombre());
			} else if (rayo.getDaniobase() > patada.getDaniobase() && rayo.getDaniobase() > puñetazo.getDaniobase()) {
				System.out.println("El ataque más poderoso de " + vegeta.getnombre() + " es: " + rayo.getNombre());
			} else {
				System.out.println("¡Es un empate en ataques!");
			}
		}
		if ((patada.getCostoenergia() + puñetazo.getCostoenergia() + rayo.getCostoenergia()) / 3 > 50) {
			System.out.println("Los ataques de " + goku.getnombre() + " son muy costosos en energía.");
		}
	}

	public static void golpear(Peleador atacante, Peleador defensor, Ataque ataque) {
		if (atacante.getEnergia() < ataque.getCostoenergia()) {
			System.out.println("El ataque " + ataque.getNombre() + " es muy costoso en energía.");
			return;
		}

		float danioTotal = ataque.getDaniobase() + atacante.getBonificadordanio() - defensor.getDefensabase();
		if (danioTotal > 0) {
			defensor.setpuntosdevida(defensor.getpuntosdevida() - danioTotal);
			System.out.println(atacante.getnombre() + " golpea a " + defensor.getnombre() + " con " + ataque.getNombre()
					+ " causando " + danioTotal + " de daño.");
		} else {
			System.out.println(atacante.getnombre() + " golpea a " + defensor.getnombre() + " con " + ataque.getNombre()
					+ " pero no causa daño.");
		}
	}
	
}
