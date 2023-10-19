package DAO;

import modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonaRepository extends JpaRepository <Persona, String> {
    public Optional<Persona> findByDocumento(String documento);

    Optional<Persona> findByMail(String mail);
    public void delete(Persona persona);

}
