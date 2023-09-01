package entity;

import jakarta.persistence.*;
import modelo.Edificio;

@Entity
@Table(name = "unidades")
public class UnidadEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int identificador;

    private String piso;
    private String numero;
    private char habitado;
    @ManyToOne
    //@Column(name = "codigoEdificio")
    @JoinColumn(name = "codigo_edificio")
    private EdificioEntity edificio; // fk con edificio

    public int getIdentificador() {
        return identificador;
    }

    public String getPiso() {
        return piso;
    }

    public String getNumero() {
        return numero;
    }

    public char getHabitado() {
        return habitado;
    }

    public EdificioEntity getEdificio() {
        return edificio;
    }
}
