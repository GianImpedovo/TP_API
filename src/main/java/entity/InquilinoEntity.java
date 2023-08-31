package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "inquilinos")
public class InquilinoEntity {

    @Id
    private int id;
    private int identificador;
    private String documento;

}
