package DAO;

import entity.*;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InquilinoRepository extends JpaRepository<InquilinoEntity, Integer> {
    List<InquilinoEntity> findByIdentificador(UnidadEntity unidad);
    List<InquilinoEntity> findByDocumento(PersonaEntity persona);
}
