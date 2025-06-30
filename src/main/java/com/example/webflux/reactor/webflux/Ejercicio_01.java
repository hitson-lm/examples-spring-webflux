package com.example.webflux.reactor.webflux;

import com.example.webflux.reactor.Person;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public class Ejercicio_01 {

    // METODOS DE CREACION Mono(just, empty, error, fromCallable)
    public void mono() {
        Mono.just("hola mono webflux")
                .subscribe(System.out::println);
    }

    public void monoEmpty() {
        Mono<String> monoVacio = Mono.empty();

        monoVacio.subscribe( //Espera una accion
                System.out::println, //doOnNext (recorre cada elemento)
                error -> System.err.println("Error: " + error), //doOnError
                () -> System.out.println("Completed sin emitir elementos") //doOnComplete
        );
    }

    // crea un mono que emite un error en lugar de un elemento.
    public void monoError() {
        Mono<String> mono = Mono.error(new RuntimeException("error simulado"));

        mono.subscribe(
                System.out::println, //No se ejecutará porque hay un error.
                error -> System.err.println("Error Mono: " + error), //Manejo de error, imprime el error
                () -> System.out.println("No Completed sin emitir elementos") //No se ejecutará porque hay un error.
        );
    }

    // Crea un Mono a partir de una operación que devuelve un valor.
    public void monoFromCallable() {
        Mono<String> mono = Mono.fromCallable(() -> "Resultado de Callable");

        mono.subscribe(result -> System.out.println(result));
    }

    public void rangeFlux() {
        Flux.range(1,3)
                .doOnNext(i -> System.out.println("i: "+i)) // doOnNext -> se usa para logger
                .subscribe();
    }


    // METODOS DE TRANSFORMACION Mono(map, flatMap)

    /*
      map: Transforma el elemento emido por el Mono
      flatMap: Transforma el valor emitido en otro Mono
    */
    public void monoMap() {
        Mono<String> mono = Mono.just("Hola")
                .map(value -> value + " | mundo..!!");

        mono.subscribe(n -> System.out.println(n));

    }

    /*
      flatMap: Transforma el valor emitido en otro Mono
    */
    public void monoFlatMap() {

        Mono<String> mono = Mono.just("Hola")
                .flatMap(value -> Mono.just(value + " | Reactivo!"));

        mono.subscribe(n -> System.out.println("Mono1: " + n));

    }

    // METODOS DE TRANSFORMACION Flux(map, flatMap, filter, buffer)

    /* map: Transforma cada elemento emitido por el Flux*/
    public void fluxMap() {
        Flux<Integer> flux = Flux.range(1,5)
                .map(value -> value * 2);

        flux.subscribe(System.out::println);

    }

    /* flatMap: Transforma cada elemento en otro Publisher, publicador Mono o Flux */
    public void fluxFlatMap() {
        Flux<String> flux = Flux.just("A", "B", "C")
                .flatMap(value -> Flux.just(
                        value.toLowerCase(),
                        value.toUpperCase(),
                        "Reactive " + value)
                );

        flux.log().subscribe(System.out::println);

    }

    /* filter: Filtra los elementos según una condicion */
    public void fluxFilter() {
        Flux<Integer> flux = Flux.range(1,10)
                .filter(number -> number % 2 == 0);

        flux.subscribe(System.out::println);

    }

    /* buffer: Agrupa los elementos en listas, List<E> */
    public void fluxBuffer() {
        Flux<List<Integer>> flux = Flux.range(1,10)
                .buffer(3);

        flux.subscribe(System.out::println); // [1, 2, 3], [4, 5, 6], [7, 8, 9], [10]

    }

    /* transforma de un objecto String a tipo Person */
    public void map() {

        Flux<String> listNameString = Flux.just("Jesus", "Leo", "Jorge");

        Flux<Person> persons = listNameString
               .map(name -> new Person(name.toUpperCase(),""));

        persons.subscribe(person -> System.out.println(person.getName()));
    }

    public void filter() {

        Flux<String> listNameString = Flux.just("Jesus Lagos", "Leo Manrique", "Jorge Perez");

        Flux<Person> persons = listNameString
                .map(names -> new Person(
                        names.split(" ")[0],
                        names.split(" ")[1]))
                .filter(p -> p.getName().equals("Jesus"));

        persons.subscribe(person -> System.out.println(
                person.getName()
                .concat(" ")
                .concat(person.getLastName()) + " [Filtrado..!!]"));

    }

    // METODOS DE COMBINACION
    // Mono(zipWith, mergeWith, when)
    // Flux(zip, merge, concat)

    /* zipWith: Combina 2 Mono en uno solo, emitiendo un par de valores (Elementos emparejados) */
    public void monoZipWith() {

        Mono<String> mono1 = Mono.just("mono1");
        Mono<String> mono2 = Mono.just("mono2");

        Mono<String> mono3 = mono1.zipWith(
                mono2,
                (value1, value2)-> value1.concat(" ").concat(value2) // Salida: mono1 mono2 (Elementos emparejados)
        );

        mono3.subscribe(System.out::println);
    }

    /* mergeWith: Combina 2 Mono en un Publisher Flux, emite los valores de ambos de forma CONCURRENTE.
    NOTA: puede variar el orden */
    public void monoMergeWith() {

        Mono<String> mono1 = Mono.just("mono1");
        Mono<String> mono2 = Mono.just("mono2");

        Flux<String> mono3 = mono1.mergeWith(mono2);

        mono3.log().subscribe(System.out::println); //Salida: mono1, mono2
    }

    /* concat: Combina varios Flux de forma SECUENCIAL */
    public void fluxConcat() {
        Flux<String> flux1 = Flux.just("A", "B");
        Flux<String> flux2 = Flux.just("C", "D");

        Flux<String> concatFlux = Flux.concat(flux1,flux2);
        concatFlux.subscribe(System.out::println); // Salida: A, B, C, D
    }

    /* merge: Combina varios Flux de forma CONCURRENTE (puede variar el orden) */
    public void fluxMerge() {
        Flux<String> flux1 = Flux.just("1", "2");
        Flux<String> flux2 = Flux.just("A", "B");

        Flux<String> mergeFlux = Flux.merge(flux1,flux2);
        mergeFlux.log().subscribe(System.out::println); //Salida: 1, 2, A, B
    }

    /* zip: Combina varios Flux en uno(Elementos emparejados), empareja los elementos de distintos objetos; Integer,String,etc */
    public void fluxZip() {
        Flux<Integer> flux1 = Flux.just(1, 2); // Publisher1
        Flux<String> flux2 = Flux.just("A", "B"); // Publisher2

        Flux<String> zipFlux = Flux.zip(
                flux1,
                flux2,
                (number, letter)-> number + letter);

        zipFlux.subscribe(System.out::println); //salida: 1A, 2B (Elementos emparejados)
    }

    // METODOS DE ERRORES Mono(onErrorResume, onErrorReturn)

    // METODOS DE SUSCRIPCION Mono(suscribe, doOnNext, doOnError)






}
