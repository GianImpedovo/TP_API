package DAO;

import entity.UnidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UnidadRepository extends JpaRepository<UnidadEntity, Integer> {
    public Optional<UnidadEntity> findByIdentificador(int identificador);
}
