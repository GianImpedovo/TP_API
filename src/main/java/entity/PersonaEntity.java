package entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "personas")
public class PersonaEntity {

    @Id
    private String documento;
    private String nombre;
    private String mail;
    private String contrasenia;

    public PersonaEntity() {
    }

    public PersonaEntity(String documento, String nombre, String mail, String contrasenia) {
        this.documento = documento;
        this.nombre = nombre;
        this.mail = mail;
        this.contrasenia = contrasenia;
    }

    public String getDocumento() {
        return documento;
    }

    public String getNombre() {
        return nombre;
    }

    public String getMail() {
        return mail;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }
}
