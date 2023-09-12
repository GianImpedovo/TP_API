package DAO;
import entity.EdificioEntity;
import entity.UnidadEntity;
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

    @Autowired
    UnidadDAO unidadDAO;


    //Verificar que se realiza la inyeccion
    public void init() {
        System.out.println("Se inyecta EdificioRepository: " + (edificioRepositorio != null));
    }

    public List<Edificio> obtenerTodosEdificios(){
        List<EdificioEntity> edificiosEntidad = edificioRepositorio.findAll();
        List<Edificio> edificios = new ArrayList<>();
        for (EdificioEntity ee: edificiosEntidad)
            edificios.add(toNegocio(ee));
        return edificios;
    }

    public Edificio obtenerEdificioCodigo(int codigo){
        Optional<EdificioEntity> edificio = edificioRepositorio.findByCodigo(codigo);
        if (edificio.isPresent())
            return toNegocio(edificio.get());
        return null;
    }

    public Edificio toNegocio(EdificioEntity ee){
        Edificio edificio = new Edificio(ee.getCodigo(), ee.getNombre(), ee.getDireccion());
        List<Unidad> unidades = new ArrayList<>();
        for (UnidadEntity ue: ee.getUnidades()){
            unidades.add(unidadDAO.toNegocio(ue));
        }
        edificio.setUnidades(unidades);
        for (Unidad u: edificio.getUnidades())
            u.setEdificio(edificio);
        return edificio;
    }
}
