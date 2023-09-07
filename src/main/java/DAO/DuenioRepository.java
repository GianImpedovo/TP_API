package DAO;

import entity.DuenioEntity;
import entity.EdificioEntity;
import entity.PersonaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DuenioRepository extends JpaRepository<DuenioEntity, Integer> {

}
