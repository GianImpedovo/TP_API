package entity;

import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "duenios")
public class DuenioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne
    @JoinColumn(name = "identificador")
    private UnidadEntity identificador; // fk con unidad

    @ManyToOne(cascade = CascadeType.REMOVE)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "documento")
    private PersonaEntity documento; // fk con persona

    public DuenioEntity() {}

    public DuenioEntity(UnidadEntity identificador, PersonaEntity documento) {
        this.identificador = identificador;
        this.documento = documento;
    }

    public int getId() {
        return id;
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
