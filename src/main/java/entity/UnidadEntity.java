package entity;

import jakarta.persistence.*;
import modelo.Edificio;

@Entity
@Table(name = "unidades")
public class UnidadEntity {

    @Id
    private int identificador;

    private int piso;
    private int numero;
    private char habitado;

    @ManyToOne
    @JoinColumn(name = "codigoEdificio")
    private EdificioEntity edificio; // fk con edificio

}
