package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "duenios")
public class DuenioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int identificador; // fk con unidad
    private String documento; // fk con persona

    public DuenioEntity() {}

    public DuenioEntity(int id, int identificador, String documento) {
        this.id = id;
        this.identificador = identificador;
        this.documento = documento;
    }

    public int getId() {
        return id;
    }

    public int getIdentificador() {
        return identificador;
    }

    public String getDocumento() {
        return documento;
    }
}
