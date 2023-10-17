package DAO;

import modelo.Edificio;
import modelo.Unidad;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UnidadRepository extends JpaRepository<Unidad, Integer> {
    public Optional<Unidad> findByIdentificador(int identificador);

    Optional<Unidad> findByEdificioAndPisoAndNumero(Edificio edificio, String piso, String numero);
}
