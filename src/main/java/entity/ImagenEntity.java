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

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "idreclamo")
    private ReclamoEntity idReclamo;

    public ImagenEntity() {}

    public ImagenEntity(String path, String tipo, ReclamoEntity idReclamo) {
        this.path = path;
        this.tipo = tipo;
        this.idReclamo = idReclamo;
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
        return idReclamo;
    }

}