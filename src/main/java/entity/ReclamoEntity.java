package entity;

import jakarta.persistence.*;
import vista.Estado;

@Entity
@Table(name = "reclamos")
public class ReclamoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReclamo;

    @ManyToOne
    @JoinColumn(name = "documento")
    private PersonaEntity documento; // fk con personas

    @ManyToOne
    @JoinColumn(name = "codigo")
    private EdificioEntity codigo; // fk con edificio
    private String ubicacion;
    private String descripcion;

    private int identificador; // identificamos la unidad, no es fk

    @Column(name = "estado")
    private Estado estado;

    public ReclamoEntity() {}

    public ReclamoEntity(PersonaEntity documento, EdificioEntity codigo, String ubicacion, String descripcion, int identificador) {
        this.documento = documento;
        this.codigo = codigo;
        this.ubicacion = ubicacion;
        this.descripcion = descripcion;
        this.identificador = identificador;
        this.estado = Estado.nuevo;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public int getIdReclamo(){
        return idReclamo;
    }

    public PersonaEntity getDocumento() {
        return documento;
    }

    public EdificioEntity getCodigo() {
        return codigo;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public int getIdentificador() {
        return identificador;
    }

    public Estado getEstado() {
        return estado;
    }
}
