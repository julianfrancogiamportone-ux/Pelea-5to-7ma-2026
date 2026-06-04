package fighting.gold.juego.entidades;

import jakarta.persistence.*;
import java.util.List;

@Entity
@Table(name = "peleador_ataque")
public class Peleador {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String nombre;
    private float puntosdevida;
    private int energia;
    private float defensabase;
    private float bonificadordanio;
    @ManyToMany
    @JoinTable(name = "peleador_ataques", joinColumns = @JoinColumn(name = "peleador_id"), inverseJoinColumns = @JoinColumn(name = "ataque_id"))
    private List<Ataque> ataques;
    @ManyToMany
    @JoinTable(name = "peleador_armas", joinColumns = @JoinColumn(name = "peleador_id"), inverseJoinColumns = @JoinColumn(name = "arma_id"))
    private List<Arma> armas;

    public Peleador(String nombre, long id, float puntosdevida, int energia, float defensabase, float bonificadordanio,
            List<Ataque> Ataques) {
        this.nombre = nombre;
        this.id = id;
        this.puntosdevida = puntosdevida;
        this.energia = energia;
        this.defensabase = defensabase;
        this.bonificadordanio = bonificadordanio;
        this.ataques = Ataques;

    }

    public long getid() {
        return id;
    }

    public void setid(long id) {
        this.id = id;
    }

    public String getnombre() {
        return nombre;
    }

    public void setnombre(String nombre) {
        this.nombre = nombre;
    }

    public float getpuntosdevida() {
        return puntosdevida;
    }

    public void setpuntosdevida(float puntosdevida) {
        this.puntosdevida = puntosdevida;
    }

    public int getEnergia() {
        return energia;
    }

    public void setEnergia(int energia) {
        this.energia = energia;

    }

    public float getDefensabase() {
        return defensabase;
    }

    public void setDefensabase(float defensabase) {
        this.defensabase = defensabase;
    }

    public List<Ataque> getAtaques() {
        return ataques;
    }

    public void setAtaques(List<Ataque> ataques) {
        this.ataques = ataques;
    }

    public List<Arma> getArmas() {
        return armas;
    }

    public void setArmas(List<Arma> armas) {
        this.armas = armas;
    }

    public float getBonificadordanio() {
        return bonificadordanio;
    }

    public void setBonificadordanio(float bonificadordanio) {
        this.bonificadordanio = bonificadordanio;
    }

    public void imprimir() {
        System.out.println("Peleador: " + nombre);
        System.out.println("Puntos de Vida: " + puntosdevida);
        System.out.println("Energía: " + energia);
        System.out.println("Defensa Base: " + defensabase);
        System.out.println("Armas:");
        for (Arma arma : armas) {
            System.out.println(" - " + arma.getNombre());
        }
        System.out.println("Ataques:");
        for (Ataque ataque : ataques) {
            System.out.println(" - " + ataque.getNombre());
        }
    }
}
