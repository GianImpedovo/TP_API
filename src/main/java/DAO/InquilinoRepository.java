package DAO;

import entity.EdificioEntity;
import entity.InquilinoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InquilinoRepository extends JpaRepository<InquilinoEntity, Integer> {
}
