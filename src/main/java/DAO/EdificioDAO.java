package DAO;

import modelo.Edificio;
import modelo.Unidad;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.time.chrono.MinguoDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Repository
public class EdificioDAO {

    @Autowired
    EdificioRepository edificioRepositorio;



    //Verificar que se realiza la inyeccion
    public void init() {
        System.out.println("Se inyecta EdificioRepository: " + (edificioRepositorio != null));
    }

    public List<Edificio> obtenerTodosEdificios(){
        List<Edificio> edificiosEntidad = edificioRepositorio.findAll();
        return edificiosEntidad;
    }

    public Edificio obtenerEdificioCodigo(int codigo){
        Optional<Edificio> edificio = edificioRepositorio.findByCodigo(codigo);
        if (edificio.isPresent())
            return edificio.get();
        return null;
    }

    public void eliminarEdificio(Edificio e){
        edificioRepositorio.delete(e);
    }

    public void guardarEdificio(Edificio edificio){
        edificioRepositorio.save(edificio);
    }

}
