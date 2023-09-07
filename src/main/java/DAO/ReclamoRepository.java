package DAO;

import entity.ReclamoEntity;
import entity.UnidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReclamoRepository extends JpaRepository<ReclamoEntity, Integer> {
}
