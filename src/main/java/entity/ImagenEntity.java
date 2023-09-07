package entity;

import jakarta.persistence.*;

@Entity
@Table(name = "imagenes")
public class ImagenEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int numero;
    private String path;
    private String tipo;
    private int idReclamo;

    public ImagenEntity() {}


}
