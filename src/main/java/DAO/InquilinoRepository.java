package DAO;

import entity.DuenioEntity;
import entity.EdificioEntity;
import entity.InquilinoEntity;
import entity.UnidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InquilinoRepository extends JpaRepository<InquilinoEntity, Integer> {
    List<InquilinoEntity> findByIdentificador(UnidadEntity unidad);
}
