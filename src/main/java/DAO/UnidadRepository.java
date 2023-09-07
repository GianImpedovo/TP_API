package DAO;

import entity.UnidadEntity;
import modelo.Unidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UnidadRepository extends JpaRepository<UnidadEntity, Integer> {
    public Optional<UnidadEntity> findByIdentificador(int identificador);
    public List<UnidadEntity> findByCodigo(int codigo);
}
