package fighting.gold.juego.entidades;

import jakarta.persistence.*; 
@Entity
public class ataque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int daniobase;
    private int costoenergia;
    public ataque(int id, String nombre, int daniobase, int costoenergia) {
        this.id = id;
        this.nombre = nombre;
        this.daniobase = daniobase;
        this.costoenergia = costoenergia;
    }
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
    public int getDaniobase() {
        return daniobase;
    }
    public void setDaniobase(int daniobase) {
        this.daniobase = daniobase;
    }
    public int getCostoenergia() {
        return costoenergia;
    }
    public void setCostoenergia(int costoenergia) {
        this.costoenergia = costoenergia;
    }

    
}
