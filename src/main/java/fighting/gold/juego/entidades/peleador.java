package fighting.gold.juego.entidades;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class peleador {
    private String nombre;
    private int id;
    private int puntosdevida;
    private int energia;
    private float defensabase;
    private arma armaequipada;
    private List inventario;
    private List habilidades;

    public peleador(String nombre, int id, int puntosdevida, int energia, float defensabase, arma armaequipada,
            List inventario, List habilidades) {
        this.nombre = nombre;
        this.id = id;
        this.puntosdevida = puntosdevida;
        this.energia = energia;
        this.defensabase = defensabase;
        this.armaequipada = armaequipada;
        this.inventario = inventario;
        this.habilidades = habilidades;

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public int getid() {
        return id;
    }

    public void setid(int id) {
        this.id = id;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public int getpuntosdevida() {
        return puntosdevida;
    }

    public void setpuntosdevida(int puntosdevida) {
        this.puntosdevida = puntosdevida;
    }

    public int energia() {
        return energia;
    }

    public void energia(int energia) {
        this.energia = energia;

    }

    public float getDefensabase() {
        return defensabase;
    }

    public void setDefensabase(float defensabase) {
        this.defensabase = defensabase;
    }

    public arma getArmaequipada() {
        return armaequipada;
    }

    public void setArmaequipada(arma armaequipada) {
        this.armaequipada = armaequipada;
    }

    public List getInventario() {
        return inventario;
    }

    public void setInventario(List inventario) {
        this.inventario = inventario;
    }

    public List getHabilidades() {
        return habilidades;
    }

    public void setHabilidades(List habilidades) {
        this.habilidades = habilidades;
    }

}