package rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import vista.EdificioView;

import java.util.List;
import controlador.Controlador;
import vista.UnidadView;

@RestController
//@RequestMapping("/personas")
public class ControladorRestPersona {

    @Autowired
    Controlador controlador;

    @GetMapping("/edificios/listar")
    public List<EdificioView> start(){
        return controlador.getEdificios();
    }

        @GetMapping("/personas/duenio")
    public List<UnidadView> verUnidades(){
        return controlador.obtenerUnidades();
    }

}
