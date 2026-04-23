package fighting.gold.juego.entidades;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class arma {
    private int id;
    private String nombre;
    private int bonificadordanio;
    private float peso;

    public arma(int id, String nombre, int bonificadordanio, float peso) {
        this.id = id;
        this.nombre = nombre;
        this.bonificadordanio = bonificadordanio;
        this.peso = peso;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getBonificadordanio() {
        return bonificadordanio;
    }

    public void setBonificadordanio(int bonificadordanio) {
        this.bonificadordanio = bonificadordanio;
    }

    public float getPeso() {
        return peso;
    }

    public void setPeso(float peso) {
        this.peso = peso;
    }

}
