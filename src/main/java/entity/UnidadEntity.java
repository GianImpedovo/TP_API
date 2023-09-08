package entity;

import jakarta.persistence.*;
import modelo.Edificio;
import org.hibernate.type.TrueFalseConverter;

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
    @JoinColumn(name = "codigoEdificio")
    private EdificioEntity edificio; // fk con edificio

    public UnidadEntity() {}

    public UnidadEntity(int identificador, String piso, String numero, char habitado, EdificioEntity edificio) {
        this.identificador = identificador;
        this.piso = piso;
        this.numero = numero;
        this.habitado = habitado;
        this.edificio = edificio;
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getPiso() {
        return piso;
    }

    public String getNumero() {
        return numero;
    }

    public boolean getHabitado() {
        if (habitado != 'N')
            return true;
        return false;
    }

    public EdificioEntity getEdificio() {
        return edificio;
    }
}
