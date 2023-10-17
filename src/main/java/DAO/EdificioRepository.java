package DAO;

import modelo.Edificio;
import org.springframework.data.jpa.repository.JpaRepository;


import java.util.Optional;


public interface EdificioRepository extends JpaRepository<Edificio, Integer>{
    public Optional<Edificio> findByCodigo(int codigo);

}
