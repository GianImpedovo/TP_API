package DAO;

import entity.ImagenEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ImagenRepository extends JpaRepository<ImagenEntity, Integer> {
}