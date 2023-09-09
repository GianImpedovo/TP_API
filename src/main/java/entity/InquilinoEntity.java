package entity;

import jakarta.persistence.*;
import modelo.Persona;
import modelo.Unidad;

@Entity
@Table(name = "inquilinos")
public class InquilinoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    @JoinColumn(name = "identificador")
    private UnidadEntity identificador; // fk con unidad

    @ManyToOne
    @JoinColumn(name = "documento")
    private PersonaEntity documento; // fk con persona

    public InquilinoEntity() {}

    public InquilinoEntity(UnidadEntity identificador, PersonaEntity documento) {
        this.identificador = identificador;
        this.documento = documento;
    }

    public UnidadEntity getIdentificador() {
        return identificador;
    }

    public PersonaEntity getDocumento() {
        return documento;
    }

    public void setIdentificador(UnidadEntity identificador) {
        this.identificador = identificador;
    }

    public void setDocumento(PersonaEntity documento) {
        this.documento = documento;
    }
}
