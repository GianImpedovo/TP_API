package DAO;

import entity.PersonaEntity;
import modelo.Persona;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PersonaRepository extends JpaRepository <PersonaEntity, String> {

    public Optional<PersonaEntity> findByDocumento(String documento);

}
