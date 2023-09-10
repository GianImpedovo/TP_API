package com.administracion;

import controlador.Controlador;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import vista.PersonaView;

import java.util.List;

@SpringBootTest
class TpApiApplicationTests {

	@Autowired
	Controlador controlador;

	@Test
	void listaDeEdificios(){
	}

}
