package DAO;

import modelo.Edificio;
import modelo.Persona;
import modelo.Reclamo;
import modelo.Unidad;
import org.springframework.data.jpa.repository.JpaRepository;
import vista.Estado;
import java.util.List;
import java.util.Optional;

public interface ReclamoRepository extends JpaRepository<Reclamo, Integer> {
    List<Reclamo> findByEdificio(Edificio edificio);

    List<Reclamo> findByUnidad(Unidad unidad);

    List<Reclamo> findByUsuario(Persona persona);


    List<Reclamo> findByEstado(Estado estado);
}
