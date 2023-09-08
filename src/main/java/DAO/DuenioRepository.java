package DAO;

import entity.DuenioEntity;
import entity.EdificioEntity;
import entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface DuenioRepository extends JpaRepository<DuenioEntity, Integer> {
List<DuenioEntity> findAllByIdentificador(int identificador);
}
