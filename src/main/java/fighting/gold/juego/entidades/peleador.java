package fighting.gold.juego.entidades;

import jakarta.persistence.*;
@Entity
public class peleador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private arma inventario[];
    private ataque habilidades[];
    private int energia;
    private String nombre;
    private int vida;
    private arma arma;
    private float defensa;

    public peleador(String nombre, int vida, arma arma, ataque habilidades[],int id, int energia, arma inventario[], float defensa) {
        this.nombre = nombre;
        this.vida = vida;
        this.arma = arma;
        this.habilidades = habilidades;
        this.id = id;
        this.energia = energia;
        this.inventario = inventario;
        this.defensa = defensa;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public arma[] getInventario() {
        return inventario;
    }

    public void setInventario(arma[] inventario) {
        this.inventario = inventario;
    }

    public ataque[] getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(ataque[] habilidades) {
        this.habilidades = habilidades;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public arma getArma() {
        return arma;
    }

    public void setArma(arma arma) {
        this.arma = arma;
    }

    public float getDefensa() {
        return defensa;
    }

    public void setDefensa(float defensa) {
        this.defensa = defensa;
    }

    
}
