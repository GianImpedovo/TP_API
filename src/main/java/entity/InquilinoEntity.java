package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "inquilinos")
public class InquilinoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int identificador; // fk con unidad
    private String documento; // fk con persona

    public InquilinoEntity() {
    }

    public InquilinoEntity(int id, int identificador, String documento) {
        this.id = id;
        this.identificador = identificador;
        this.documento = documento;
    }

}
