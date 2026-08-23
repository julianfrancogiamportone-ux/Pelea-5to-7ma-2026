package fighting.gold.juego.entidades;

import jakarta.persistence.*;
import java.util.List;
@Entity
public class Arma {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private int bonificadordanio;
    private float peso;
    @ManyToMany(mappedBy = "armas")
    private List<Peleador> peleadores;
    
    public Arma() {
    }

    public Arma(long id, String nombre, int bonificadordanio, float peso) {
        this.id = id;
        this.nombre = nombre;
        this.bonificadordanio = bonificadordanio;
        this.peso = peso;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
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

    public void imprimirarma() {
        System.out.println("Arma: " + nombre);
        System.out.println("Bonificación de daño: " + bonificadordanio);
        System.out.println("Peso: " + peso);
    }

}
