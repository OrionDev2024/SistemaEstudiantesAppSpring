package od.estudiantes;


import od.estudiantes.modelo.Estudiante;
import od.estudiantes.servicio.EstudianteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;

import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class EstudiantesApplication implements CommandLineRunner {

	@Autowired
	private EstudianteServicio estudianteServicio;

	private static final Logger logger = LoggerFactory.getLogger(EstudiantesApplication.class);

	String nl = System.lineSeparator();

	public static void main(String[] args) {
		logger.info("Iniciando la aplicación...");
		//Levantar la fabrica de Spring
		SpringApplication.run(EstudiantesApplication.class, args);
		logger.info(("Aplicación finalizada!"));
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("Ejecutando método run de Spring..." + nl);
		var salir = false;
		var consola = new Scanner(System.in);
		while (!salir){
			mostrarMenu();
			salir = ejecutarOpciones(consola);
			logger.info(nl);
		}//Fin de ciclo while
	}

	private  void mostrarMenu(){
		logger.info(nl);
		logger.info("""
				*** Sistema de Estudiantes ***
				1. Listar Estudiantes.
				2. Buscar Estudiante.
				3. Agregar Estudiante.
				4. Modificar Estudiante.
				5. Eliminar Estudiante.
				6. Salir
				Elige una opción: """);
	}//fin de mostrarMenu
	private boolean ejecutarOpciones(Scanner consola){
		var opcion = Integer.parseInt(consola.nextLine());
		var salir = false;
		switch (opcion){
			case 1 ->{
				//Listar estudiantes
				logger.info(nl + "Listado de Estudiantes: " + nl);
				List<Estudiante> estudiantes = estudianteServicio.listarEstudiantes();
				estudiantes.forEach((estudiante -> logger.info(estudiante.toString() + nl)));

			}//fin de caso 1

		}// fin de switch
		return salir;
	}
}
