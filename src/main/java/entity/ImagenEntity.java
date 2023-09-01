package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "imagenes")
public class ImagenEntity {

    @Id
    private int numero;
    private String path;
    private String tipo;
    private int idReclamo;

}
