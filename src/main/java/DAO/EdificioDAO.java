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
@Component
public class EdificioDAO {

    @Autowired
    EdificioRepository edificioRepositorio;


    //Verificar que se realiza la inyeccion
    public void init() {
        System.out.println("Se inyecta EdificioRepository: " + (edificioRepositorio != null));
    }

    public Edificio ObtenerEdificioCodigo(int codigo){
        Optional<EdificioEntity> ee = edificioRepositorio.findByCodigo(codigo);

        if (ee.isPresent()){
            return toNegocio(ee.get());
        }
        return toNegocio(ee.get());
    }

    public List<Edificio> obtenerTodosEdificios(){
        List<EdificioEntity> edificiosEntidad = edificioRepositorio.findAll();
        List<Edificio> edificios = new ArrayList<>();
        for (EdificioEntity ee: edificiosEntidad)
            edificios.add(toNegocio(ee));
        return edificios;
    }

    public void guardarEdificio(EdificioEntity e){
        edificioRepositorio.save(e);
    }

//    public List<UnidadEntity> obtenerUnidadesEdificio(int codigo){
//        Optional<EdificioEntity> ee= edificioRepositorio.findByCodigo(codigo);
//        if (ee.isPresent()){
//            agregarUnidadesAlEdificio(ee.get());
//        }
//        return ee.get().getUnidades();
//    }

//    public void agregarUnidadesAlEdificio(EdificioEntity edificio){
//        List<UnidadEntity> unidades = new ArrayList<>();
//        Optional<EdificioEntity> ee= edificioRepositorio.findByCodigo(edificio.getCodigo());
//        if (ee.isPresent()){
//            for (UnidadEntity ue: ee.get().getUnidades())
//                unidades.add(ue);
//        }
//        edificio.setUnidades(unidades);
//    }

    public Edificio toNegocio(EdificioEntity ee){
        Edificio e = new Edificio(ee.getCodigo(), ee.getNombre(), ee.getDireccion());
        return e;
    }

}
