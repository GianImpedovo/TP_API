package DAO;

import modelo.Imagen;
import modelo.Reclamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ImagenDAO {

    @Autowired
    ImagenRepository imagenRepository;

    public ImagenDAO() {}

//    public void agregarImagen(ImagenEntity imagen) {
//        imagenRepository.save(imagen);
//    }
    public void agregarImagen(Imagen i) {
        imagenRepository.save(i);
    }

}
