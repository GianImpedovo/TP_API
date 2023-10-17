package DAO;


import org.springframework.data.jpa.repository.JpaRepository;
import modelo.Imagen;

public interface ImagenRepository extends JpaRepository<Imagen, Integer> {
}