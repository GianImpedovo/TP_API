package DAO;

import modelo.Persona;
import modelo.Unidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface PersonaRepository extends JpaRepository <Persona, String> {
    public Optional<Persona> findByDocumento(String documento);

    Optional<Persona> findByMail(String mail);
    public void delete(Persona persona);


}
