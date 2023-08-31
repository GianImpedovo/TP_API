package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reclamos")
public class ReclamoEntity {

    @Id
    private int idReclamo;

    @ManyToOne
    @JoinColumn(name = "documento")
    private PersonaEntity persona; // fk con personas

    @ManyToOne
    @JoinColumn(name = "codigo")
    private EdificioEntity edificio; // fk con edificio
    private String ubicacion;
    private String descripcion;

    @ManyToOne
    @JoinColumn(name = "identificador")
    private UnidadEntity unidad; // fk con unidad, no esta especificado en el diagrama sql



}
