package com.example.webflux.reactor;

import com.example.webflux.reactor.patrones.factory.Animal;
import com.example.webflux.reactor.patrones.factory.AnimalFactory;
import com.example.webflux.reactor.patrones.factory.TipoAnimal;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class WebfluxReactorApplication implements CommandLineRunner {

	public static int dividir(int a, int b) {
		if (b == 0) {
				throw new ArithmeticException("Denominador 'b' no puede ser cero"); //Mensaje de error en consola
		}
		return a/b;
	}

	public static void main(String[] args) {
		SpringApplication.run(WebfluxReactorApplication.class, args);

		/**
		 * Exception:(error en compilacion) Exception verificada, el programa o compilador obliga a manejar estas excepcinoes mediante "try-catch"
		 * o declararlas en la firma del metodo con "throws".
		 * Representa errores que el programa puede prevenir y manejar, Ejm: problemas de E/S, exceptiones de red.
		 */

		/**
		 * RuntimeException:(error en tiempo de ejecución) Exception no verificada, el compilador no obliga a manejarlas ni declararlas en la firma del metodo.
		 * Lanza excepciones en tiempo de ejecucucion, no se utiliza try-catch
		 * representa errores que ocurre debido a problemas de logica del programa. ejmplo: NullPointerException, ArrayIndexOutOfBoundsException.
		 * Generalmente son errores que el programador debe evitar mediante una buena validacion.
		 */
		try {

			int resultado = dividir(10,0);
			System.out.println("Resultado division: " + resultado);

		} catch (Exception e){
			System.out.println("ERROR: " + e.getMessage()); // Captura la exception y envia el mensaje al usuario final.

		}
		System.out.println("Finaliza el proceso...");

	}

	@Override
	public void run(String... args) throws Exception {

		// String pool -> es una espacio caché donde almacena el objeto que se aprovecha para optimizar la memoria.
		/*String a = "Hola"; //se almacena en String pool, apuntan al mismo region de memoria.
		String b = "Hola"; //se almacena en String pool, apuntan al mismo region de memoria.*/

		String a = new String("Hola"); //Se crea una direccioin de memoria en regiones diferentes 0xs87
		String b = new String("Hola"); //se crea una direccioin de memoria en regiones diferentes 0xa51

		// Usa el metodo equals() para comparar los valores del contenido de los objetos en memoria.
		/*if (a.equals(b)) {
			System.out.println("son iguales a y b");
		} else {
			System.out.println("no son iguales a y b");
		}*/




		/*Flux<String> listName = Flux.just("Luis", "Jesus", "Beto");

		listName.doOnNext(name -> System.out.println(name))
				.subscribe();

		obtenerMono().doOnNext(name -> System.out.println(name)).subscribe();*/

		//mono();
		//flux();
		//fluxMono();
		//Ejercicio_01 ej1 = new Ejercicio_01();
		//ej1.mono();
		//ej1.rangeFlux();
		//ej1.map();
		//ej1.filter();
		//ej1.monoEmpty();
		//ej1.monoError();
		//ej1.fluxMerge();
	}

	public void mono() {
		Mono.just(new Person("Hitson", "Lapa"))
				.subscribe(p -> System.out.println(p.toString()));
	}

	public void flux() {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Jesus", "Lopez"));
		persons.add(new Person("Carlos", "Rojas"));
		persons.add(new Person("Luis", "Perez"));

		Flux.fromIterable(persons)
				.subscribe(p -> System.out.println(p.toString()));
	}

	public void fluxMono() {
		List<Person> persons = new ArrayList<>();
		persons.add(new Person("Jesus", "Lopez"));
		persons.add(new Person("Carlos", "Rojas"));
		persons.add(new Person("Luis", "Perez"));

		Flux.fromIterable(persons)
				.collectList()
				.subscribe(list -> System.out.println(list.toString()));
	}

}
