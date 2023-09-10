package DAO;

import entity.EdificioEntity;
import entity.PersonaEntity;
import entity.ReclamoEntity;
import entity.UnidadEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReclamoRepository extends JpaRepository<ReclamoEntity, Integer> {
    List<ReclamoEntity> findByCodigo(EdificioEntity edificio);

    List<ReclamoEntity> findByIdentificador(int identificador);

    List<ReclamoEntity> findByDocumento(PersonaEntity documento);
}
