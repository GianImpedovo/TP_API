package DAO;

import org.springframework.data.jpa.repository.JpaRepository;

import entity.EdificioEntity;

import java.util.Optional;


public interface EdificioRepository extends JpaRepository<EdificioEntity, Integer>{
    public Optional<EdificioEntity> findByCodigo(int codigo);

}
