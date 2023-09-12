package DAO;

import entity.ImagenEntity;
import entity.ReclamoEntity;
import modelo.Imagen;
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
    public void agregarImagen(ReclamoEntity re, String direccion, String tipo) {
        ImagenEntity i = new ImagenEntity(direccion, tipo, re);
        imagenRepository.save(i);
    }

    public Imagen toNegocio(ImagenEntity imagen) {
        Imagen nueva = new Imagen(imagen.getPath(), imagen.getTipo());
        return nueva;
    }

}
