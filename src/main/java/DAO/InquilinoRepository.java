package DAO;

import entity.EdificioEntity;
import entity.InquilinoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InquilinoRepository extends JpaRepository<InquilinoEntity, Integer> {
    List<InquilinoEntity> findAllByIdentificador(int identificador);
}
