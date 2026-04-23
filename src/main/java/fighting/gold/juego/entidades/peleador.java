package fighting.gold.juego.entidades;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "peleador_ataque")
public class peleador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String nombre;
    private int puntosdevida;
    private int energia;
    private float defensabase;
    @ManyToMany
    @JoinTable(name = "peleador_ataques", joinColumns = @JoinColumn(name = "peleador_id"), inverseJoinColumns = @JoinColumn(name = "ataque_id"))
    private List<ataque> ataques;
    @ManyToMany
    @JoinTable(name = "peleador_armas", joinColumns = @JoinColumn(name = "peleador_id"), inverseJoinColumns = @JoinColumn(name = "arma_id"))
    private List<arma> armas;

    public peleador(String nombre, int id, int puntosdevida, int energia, float defensabase, List<ataque> ataques) {
        this.nombre = nombre;
        this.id = id;
        this.puntosdevida = puntosdevida;
        this.energia = energia;
        this.defensabase = defensabase;
        this.ataques = ataques;
    }

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

    public List<ataque> getAtaques() {
        return ataques;
    }

    public void setAtaques(List<ataque> ataques) {
        this.ataques = ataques;
    }

}
