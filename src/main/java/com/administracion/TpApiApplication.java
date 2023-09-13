package com.administracion;

import DAO.*;
import controlador.Controlador;
import modelo.Persona;
import modelo.Reclamo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import vista.*;

import javax.swing.plaf.IconUIResource;
import java.util.List;
import java.util.Scanner;


@SpringBootApplication
@EntityScan("entity")
@EnableJpaRepositories("DAO")
@ComponentScan(basePackages = {"DAO", "entity", "controlador"})
public class TpApiApplication implements CommandLineRunner{

	@Autowired
	Controlador controlador;

	Scanner entradaEscaner = new Scanner(System.in);
	public static void main(String[] args) {
		SpringApplication.run(TpApiApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
		// Traer todos los eficicios
		/*System.out.println("-----  TRAER TODOS LOS EDIFICIOS -----");
		List<EdificioView> edificios = controlador.getEdificios();
		for (EdificioView e: edificios)
			System.out.println(e.toString());

		entradaEscaner.nextLine ();*/

		// Traer unidades por edificio
		/*System.out.println("-----  TRAER TODAS LAS UNIDADES POR EDIFICIO -----");
		List<UnidadView> unidades = controlador.getUnidadesPorEdificio(1);
		for(UnidadView u: unidades)
			System.out.println(u.toString());

		entradaEscaner.nextLine();*/

		// Traer habilitados por edificio
		/*System.out.println("-----  TRAER LOS HABILITADOS POR EDIFICIO -----");
		List<PersonaView> habilitados = controlador.habilitadosPorEdificio(1);
		for (PersonaView p: habilitados)
			System.out.println(p.toString());

		entradaEscaner.nextLine();*/

		// Traer duenios por edificio
		/*System.out.println("-----  TRAER TODOS LOS DUENIOS POR EDIFICIO -----");
		List<PersonaView> duenios = controlador.dueniosPorEdificio(1);
		for (PersonaView d: duenios)
			System.out.println(d.toString());

		entradaEscaner.nextLine();*/

		// Traer habitantes por edificio
		/*System.out.println("-----  TRAER TODOS LOS HABITANTES POR EDIFICIO -----");
		List<PersonaView> habitantes = controlador.habitantesPorEdificio(1);
		for(PersonaView h: habitantes)
			System.out.println(h.toString());

		entradaEscaner.nextLine();*/

		// Traer duenios por unidad
		/*System.out.println("-----  TRAER TODOS LOS DUENIOS POR UNIDAD -----");
		List<PersonaView> duenios = controlador.dueniosPorUnidad(1, "10", "5");
		for(PersonaView h: duenios)
			System.out.println(h.toString());

		entradaEscaner.nextLine();*/

		// Traer inquilinos por unidad
		/*System.out.println("-----  TRAER TODOS LOS INQUILINOS POR UNIDAD -----");
		List<PersonaView> inquilinos = controlador.inquilinosPorUnidad(1, "9", "2");
		for (PersonaView i: inquilinos)
			System.out.println(i.toString());

		entradaEscaner.nextLine();*/

		// Transferir unidad   CPA3449614
		/*System.out.println("-----  TRANSFERIR UNIDAD -----");
		System.out.println("-> Duenio actual:");
		List<PersonaView> duenios = controlador.dueniosPorUnidad(1, "10", "5");
		for(PersonaView h: duenios)
			System.out.println(h.toString());

		controlador.transferirUnidad(1, "10", "5", "CPA3449614");

		System.out.println("-> Duenio nuevo:");
		duenios = controlador.dueniosPorUnidad(1, "10", "5");
		for(PersonaView h: duenios)
			System.out.println(h.toString());

		entradaEscaner.nextLine();*/

		// Agregar duenio a unidad
		/*System.out.println("-----  AGREGAR DUEÑO A UNIDAD -----");
		controlador.agregarDuenioUnidad(1, "10", "5", "DNI29988738");
		List<PersonaView> duenios = controlador.dueniosPorUnidad(1, "10", "5");
		for(PersonaView h: duenios)
			System.out.println(h.toString());

		entradaEscaner.nextLine();*/

		// Alquilar unidad
		/*System.out.println("-----  ALQUILAR UNIDAD -----");
		controlador.alquilarUnidad(1, "10", "6", "DNI29988738");
		List<PersonaView> inquilinos = controlador.inquilinosPorUnidad(1, "10", "6");
		for (PersonaView i: inquilinos)
			System.out.println(i.toString());

		entradaEscaner.nextLine();*/

		// Agregar inquilino a unidad
		/*System.out.println("-----  AGREGAR INQUILINO A UNIDAD -----");
		System.out.println("-> Inquilinos antes:");
		List<PersonaView> inquilinos = controlador.inquilinosPorUnidad(1, "9", "5");
		for (PersonaView i: inquilinos)
			System.out.println(i.toString());

		controlador.agregarInquilinoUnidad(1, "9", "5", "DNI39076419");

		System.out.println("-> Inquilinos despues:");
		inquilinos = controlador.inquilinosPorUnidad(1, "9", "5");
		for (PersonaView i: inquilinos)
			System.out.println(i.toString());

		entradaEscaner.nextLine();*/

		// Librar unidad   CI 13230978
		/*System.out.println("-----  LIBERAR UNA UNIDAD -----");
		System.out.println("-> Inquilinos antes:");
		List<PersonaView> inquilinos = controlador.inquilinosPorUnidad(1, "9", "5");
		for (PersonaView i: inquilinos)
			System.out.println(i.toString());

		controlador.liberarUnidad(1, "9", "5");

		System.out.println("-> Inquilinos despues:");
		inquilinos = controlador.inquilinosPorUnidad(1, "9", "5");
		for (PersonaView i: inquilinos)
			System.out.println(i.toString());

		entradaEscaner.nextLine();*/

		// Habitar unidad
		/*System.out.println("-----  HABITAR UNA UNIDAD -----");
		controlador.habitarUnidad(1, "10", "1");

		entradaEscaner.nextLine();*/

		// Agregar persona
		/*System.out.println("-----  AGREGAR PERSONA -----");
		controlador.agregarPersona("DNI55555555", "PEREZ, JOSE");

		entradaEscaner.nextLine();*/

		// Eliminar persona SIN TERMINAR
		/*System.out.println("-----  ELIMINAR PERSONA -----");
		//controlador.agregarPersona("DNI36542189", "RODRIGUEZ, SOFIA");
		//controlador.alquilarUnidad(1, "10", "4", "DNI36542189");

		controlador.eliminarPersona("DNI36542189");

		entradaEscaner.nextLine();*/

		// Agregar reclamo
		/*System.out.println("-----  AGREGAR RECLAMO -----");
		int reclamo = controlador.agregarReclamo(1, "9", "5", "DNI39076419", "Hall de entrada", "Pérdida de agua");
		System.out.println(reclamo);

		entradaEscaner.nextLine();*/

		// Agregar imagenes al reclamo
		/*System.out.println("-----  AGREGAR IMAGEN AL RECLAMO -----");
		controlador.agregarImagenAReclamo(2, "./imagenes", "JPG");

		entradaEscaner.nextLine();*/

		// Cambiar estado del reclamo
		/*System.out.println("-----  CAMBIAR ESTADO DEL RECLAMO -----");
		controlador.cambiarEstado(2, Estado.enProceso);

		entradaEscaner.nextLine();*/

		// Buscar reclamos por persona
		/*System.out.println("-----  BUSCAR RECLAMOS POR PERSONA -----");
		List<Reclamo> reclamos = controlador.reclamosPorPersona("DNI39076419");
		for(Reclamo r: reclamos)
			System.out.println(r.toString());*/

		// Buscar reclamo por numero
		/*System.out.println("-----  BUSCAR RECLAMOS POR NUMERO -----");
		Reclamo reclamo = controlador.reclamosPorNumero(2);
		System.out.println(reclamo.toString());*/

		// Buscar reclamos por unidad
		/*System.out.println("-----  BUSCAR RECLAMOS POR UNIDAD -----");
		List<Reclamo> reclamos = controlador.reclamosPorUnidad(1, "9", "5");
		for(Reclamo r: reclamos)
			System.out.println(r.toString());*/

		// Buscar reclamos por edificio
		/*System.out.println("-----  BUSCAR RECLAMOS POR EDIFICIO -----");
		List<Reclamo> reclamos = controlador.reclamosPorEdificio(1);
		for(Reclamo r: reclamos)
			System.out.println(r.toString());*/
	}

}


