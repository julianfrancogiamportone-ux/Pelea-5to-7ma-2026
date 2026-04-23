package fighting.gold.juego.entidades;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class ataque {
    private int id;
    private String nombre;
    int costoenergia;
    int daniobase;

    public ataque(int id, String nombre, int costoenergia, int daniobase) {
        this.id = id;
        this.nombre = nombre;
        this.costoenergia = costoenergia;
        this.daniobase = daniobase;
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

    public int getCostoenergia() {
        return costoenergia;
    }

    public void setCostoenergia(int costoenergia) {
        this.costoenergia = costoenergia;
    }

    public int getDaniobase() {
        return daniobase;
    }

    public void setDaniobase(int daniobase) {
        this.daniobase = daniobase;
    }

}
