package com.administracion;

import controlador.Controlador;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import vista.UnidadView;

import java.util.List;

@SpringBootApplication
@EntityScan("modelo")
@EnableJpaRepositories("DAO")
@ComponentScan(basePackages = {"DAO", "controlador", "rest"})
public class TpApiApplication implements CommandLineRunner{

	@Autowired
	Controlador controlador;

	public static void main(String[] args) {
		SpringApplication.run(TpApiApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {


		// Traer todos los eficicios
//		System.out.println("-----  TRAER TODOS LOS EDIFICIOS -----");
//		List<EdificioView> edificios = controlador.getEdificios();
//		for (EdificioView e: edificios)
//			System.out.println(e.toString());


		// Traer unidades por edificio
//		System.out.println("-----  TRAER TODAS LAS UNIDADES POR EDIFICIO -----");
//		List<UnidadView> unidades = controlador.getUnidadesPorEdificio(1);
//		for(UnidadView u: unidades)
//			System.out.println(u.toString());


		// Traer habilitados por edificio
//		System.out.println("-----  TRAER LOS HABILITADOS POR EDIFICIO -----");
//		List<PersonaView> habilitados = controlador.habilitadosPorEdificio(1);
//		for (PersonaView p: habilitados)
//			System.out.println(p.toString());


		// Traer duenios por edificio
//		System.out.println("-----  TRAER TODOS LOS DUENIOS POR EDIFICIO -----");
//		List<PersonaView> duenios = controlador.dueniosPorEdificio(1);
//		for (PersonaView d: duenios)
//			System.out.println(d.toString());


		// Traer habitantes por edificio
//		System.out.println("-----  TRAER TODOS LOS HABITANTES POR EDIFICIO -----");
//		List<PersonaView> habitantes = controlador.habitantesPorEdificio(1);
//		for(PersonaView h: habitantes)
//			System.out.println(h.toString());



		// Traer duenios por unidad
//		System.out.println("-----  TRAER TODOS LOS DUENIOS POR UNIDAD -----");
//		List<PersonaView> duenios = controlador.dueniosPorUnidad(1, "10", "5");
//		for(PersonaView h: duenios)
//			System.out.println(h.toString());


		// Traer inquilinos por unidad
//		System.out.println("-----  TRAER TODOS LOS INQUILINOS POR UNIDAD -----");
//		List<PersonaView> inquilinos = controlador.inquilinosPorUnidad(1, "10", "2");
//		for (PersonaView i: inquilinos)
//			System.out.println(i.toString());

		// Transferir unidad   CPA3449614
//		System.out.println("-----  TRANSFERIR UNIDAD -----");
//		System.out.println("-> Duenio actual:");
//		List<PersonaView> duenios = controlador.dueniosPorUnidad(1, "10", "6");
//		for(PersonaView h: duenios)
//			System.out.println(h.toString());
//
//		controlador.transferirUnidad(1, "10", "6", "DNI41200440");
//
//		System.out.println("-> Duenio nuevo:");
//		duenios = controlador.dueniosPorUnidad(1, "10", "6");
//		for(PersonaView h: duenios)
//			System.out.println(h.toString());

		// Agregar duenio a unidad
//		System.out.println("-----  AGREGAR DUEÑO A UNIDAD -----");
//		controlador.agregarDuenioUnidad(1, "10", "5", "DNI29988738");
//		List<PersonaView> duenios = controlador.dueniosPorUnidad(1, "10", "5");
//		for(PersonaView h: duenios)
//			System.out.println(h.toString());

		// Alquilar unidad
//		System.out.println("-----  ALQUILAR UNIDAD -----");
//		controlador.alquilarUnidad(1, "10", "2", "DNI41200440");
//		List<PersonaView> nuevosI = controlador.inquilinosPorUnidad(1, "10", "2");
//		for (PersonaView i: nuevosI)
//			System.out.println(i.toString());

		// Agregar inquilino a unidad
//		System.out.println("-----  AGREGAR INQUILINO A UNIDAD -----");
//		System.out.println("-> Inquilinos antes:");
//		List<PersonaView> inquilinos = controlador.inquilinosPorUnidad(1, "10", "2");
//		for (PersonaView i: inquilinos)
//			System.out.println(i.toString());
//
//		controlador.agregarInquilinoUnidad(1, "10", "2", "DNI30306216");
//
//		System.out.println("-> Inquilinos despues:");
//		inquilinos = controlador.inquilinosPorUnidad(1, "10", "2");
//		for (PersonaView i: inquilinos)
//			System.out.println(i.toString());

		// Librar unidad
//		System.out.println("-----  LIBERAR UNA UNIDAD -----");
//		System.out.println("-> Inquilinos antes:");
//		List<PersonaView> inquilinos = controlador.inquilinosPorUnidad(1, "10", "2");
//		for (PersonaView i: inquilinos)
//			System.out.println(i.toString());
//
//		controlador.liberarUnidad(1, "10", "2");
//
//		System.out.println("-> Inquilinos despues:");
//		inquilinos = controlador.inquilinosPorUnidad(1, "10", "2");
//		for (PersonaView i: inquilinos)
//			System.out.println(i.toString());

//		 Habitar unidad
//		System.out.println("-----  HABITAR UNA UNIDAD -----");
//		controlador.habitarUnidad(1, "10", "2");

		// Agregar persona
//		System.out.println("-----  AGREGAR PERSONA -----");
//		controlador.agregarPersona("DNI41200440", "PEREZ, GIAN");

		// Eliminar persona
//		System.out.println("-----  ELIMINAR PERSONA -----");
//		controlador.eliminarPersona("DNI41200440");

		// Agregar reclamo
//		System.out.println("-----  AGREGAR RECLAMO -----");
//		int reclamo = controlador.agregarReclamo(1, "9", "5", "DNI30306216", "Hall de entrada", "Pérdida de agua");
//		System.out.println(reclamo);


		// Agregar imagenes al reclamo
//		System.out.println("-----  AGREGAR IMAGEN AL RECLAMO -----");
//		controlador.agregarImagenAReclamo(1, "./imagenes", "JPG");


		// Cambiar estado del reclamo
//		System.out.println("-----  CAMBIAR ESTADO DEL RECLAMO -----");
//		controlador.cambiarEstado(1, Estado.enProceso);
//		System.out.println("Cambio de estado realizado");


		// Buscar reclamos por persona
//		System.out.println("-----  BUSCAR RECLAMOS POR PERSONA -----");
//		List<ReclamoView> reclamos = controlador.reclamosPorPersona("DNI30306216");
//		for(ReclamoView r: reclamos)
//			System.out.println(r.toString());

		// Buscar reclamo por numero
//		System.out.println("-----  BUSCAR RECLAMOS POR NUMERO -----");
//		ReclamoView reclamo = controlador.reclamosPorNumero(1);
//		System.out.println(reclamo.toString());

		// Buscar reclamos por unidad
//		System.out.println("-----  BUSCAR RECLAMOS POR UNIDAD -----");
//		List<ReclamoView> reclamos = controlador.reclamosPorUnidad(1, "9", "5");
//		for(ReclamoView r: reclamos)
//			System.out.println(r.toString());

		// Buscar reclamos por edificio
//		System.out.println("-----  BUSCAR RECLAMOS POR EDIFICIO -----");
//		List<ReclamoView> reclamos = controlador.reclamosPorEdificio(1);
//				for(ReclamoView r: reclamos)
//			System.out.println(r.toString());

//		List<UnidadView> unidades = controlador.obtenerUnidades();
//		for(UnidadView u: unidades){
//			System.out.println(u.toString());
//		}
	}


}


