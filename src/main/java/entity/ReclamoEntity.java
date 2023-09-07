package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "reclamos")
public class ReclamoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    public ReclamoEntity() {}

    public ReclamoEntity(int idReclamo, PersonaEntity persona, EdificioEntity edificio, String ubicacion, String descripcion, UnidadEntity unidad) {
        this.idReclamo = idReclamo;
        this.persona = persona;
        this.edificio = edificio;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.unidad = unidad;
    }

    public int getIdReclamo() {
        return idReclamo;
    }

    public PersonaEntity getPersona() {
        return persona;
    }

    public EdificioEntity getEdificio() {
        return edificio;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public UnidadEntity getUnidad() {
        return unidad;
    }
}
