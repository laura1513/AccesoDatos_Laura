import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class tema0ej2 {
    public static void main(String[] args)
    {
        List<Libro> libros = new ArrayList<>();

        libros.add(new Libro("El Señor de los Anillos", 800, "J.R.R. Tolkien"));
        libros.add(new Libro("El Hobbit", 350, "J.R.R. Tolkien"));
        libros.add(new Libro("Cabo Trafalgar", 320, "Arturo Pérez Reverte"));
        libros.add(new Libro("El corazón de la piedra", 560, "José María García López"));
        libros.add(new Libro("Salmos de vísperas", 95, "Esteban Hernández Castelló"));
        libros.add(new Libro("La música en las catedrales españolas del Siglo de Oro", 600, "Robert Stevenson"));
        libros.add(new Libro("Luces de bohemia", 296, "Ramón del Valle-Inclán"));
        libros.add(new Libro("Contando atardecere", 528, "La vecina rubia"));
        libros.add(new Libro("Master - Roger Federer", 456, "Christopher Clarey"));
        libros.add(new Libro("La teoría de los archipiélagos", 300, "Alice Kellen"));
        libros.add(new Libro("Esperando al diluvio", 576, "Dolores Redondo"));
        libros.add(new Libro("El italiano", 400, "Arturo Pérez Reverte"));
        libros.add(new Libro("Línea de fuego", 688, "Arturo Pérez Reverte"));

        for(Libro l: libros)
        {
            System.out.println("Título: " + l.getTitulo());
            System.out.println("Autor: " + l.getAutor());
        }

        System.out.println("Hay "+libros.stream().filter(l -> l.getNumPaginas() > 500).count()+" libros con más de 500 páginas");

        System.out.println("Hay "+libros.stream().filter(l -> l.getNumPaginas() < 300).count()+" libros con menos de 300 páginas");

        System.out.println();
        System.out.println("Los libros con más de 500 páginas son:");
        libros.stream().filter(l -> l.getNumPaginas() > 500).map(l -> l.getTitulo()).forEach(System.out::println);

        System.out.println();
        System.out.println("Los 3 libros con más páginas son:");
        libros.stream().sorted((l1, l2) -> Integer.compare(l1.getNumPaginas(), l1.getNumPaginas())).limit(3).map(l -> l.getTitulo()).forEach(System.out::println);

        System.out.println();
        System.out.print("La suma total de páginas de todos los libros es: ");
        System.out.println(libros.stream().map(l -> l.getNumPaginas()).reduce(0, (a,b) -> a+b));

        System.out.println();
        System.out.println("Los libros que superan al promedio de páginas son:");
        /* Para este se necesita calcular el número de páginas totales (calculado anteriormente(
        y dividirlo entre el número total de libros.
        Después se filtran aquellos libros cuyo número de páginas sean mayores que el resultado
        de la división y finalmente se saca el título de dichos libros.
        (Se explicarlo pero no se hacerlo :))
         */

        System.out.println();
        System.out.println("Los autores de los libros son:");
        libros.stream().map(l -> l.getAutor()).distinct().forEach(System.out::println);

        System.out.println();
        System.out.println("Los autores con más de un libro son:");
        // No se hacerlo

        System.out.println();
        System.out.print("El libro con más páginas es: ");
        libros.stream().sorted((l1, l2) -> Integer.compare(l1.getNumPaginas(), l1.getNumPaginas())).limit(1).map(l -> l.getTitulo()).forEach(System.out::println);
    }
}
