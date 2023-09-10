package com.administracion;

import DAO.*;
import controlador.Controlador;
import modelo.Reclamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import vista.Estado;

import javax.swing.plaf.IconUIResource;
import java.util.List;


@SpringBootApplication
@EntityScan("entity")
@EnableJpaRepositories("DAO")
@ComponentScan(basePackages = {"DAO", "entity", "controlador"})
public class TpApiApplication implements CommandLineRunner{

	@Autowired
	Controlador controlador;

	@Autowired
	UnidadDAO unidadDAO;
	public static void main(String[] args) {
		SpringApplication.run(TpApiApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
//		List<EdificioView> edificios = controlador.getEdificios();
//		for (EdificioView e: edificios)
//			System.out.println(e.toString());

//		List<PersonaView> unidadesView = controlador.dueniosPorUnidad(1, "70", "23");
//		//System.out.println(unidadesView.size());
//		for (PersonaView u: unidadesView)
//			System.out.println(u.toString());
//
// 		"DNI555555555"

// 		controlador.transferirUnidad(1, "70", "23", "DNI555555555");
// 		controlador.agregarDuenioUnidad(1, "70", "23", "DNI44444444");
//		List<Persona> duenios = unidad.getDuenios();
//		for (Persona d: duenios)
//			System.out.println(d.toView().toString());
//		unidadDAO.eliminarDuenios(unidad);
//		Persona persona = controlador.buscarPersona("DNI555555555");
//		unidadDAO.agregarDuenio();

//		controlador.eliminarPersona("DNI41200440");

//		controlador.agregarInquilinoUnidad(1, "70", "23", "DNI30306216");

		//controlador.liberarUnidad(1,  "70", "23");

		//int numero = controlador.agregarReclamo(1, "70", "23", "DNI41200440", "asdfasdf", "No me anda el banio");
//		List<Reclamo> resultado = controlador.reclamosPorEdificio(1);
//		for (Reclamo r: resultado)
//			System.out.println(r.getNumero());

	//	controlador.agregarReclamo(3, "10", "4", "DNI41200440", "asdf", "No anda la cafetera");

		List<Reclamo> resultado = controlador.reclamosPorPersona("DNI41200440");
		for (Reclamo r: resultado)
			System.out.println(r.getNumero());

//		System.out.println(controlador.reclamosPorNumero(5).getDescripcion());



	}

}


