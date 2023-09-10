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

    @ManyToOne
    @JoinColumn(name = "idReclamo")
    private ReclamoEntity reclamo;

    public ImagenEntity() {}

    public ImagenEntity(String path, String tipo, ReclamoEntity reclamo) {
        this.path = path;
        this.tipo = tipo;
        this.reclamo = reclamo;
    }

    public int getNumero() {
        return numero;
    }

    public String getPath() {
        return path;
    }

    public String getTipo() {
        return tipo;
    }

    public ReclamoEntity getIdReclamo() {
        return reclamo;
    }

}
