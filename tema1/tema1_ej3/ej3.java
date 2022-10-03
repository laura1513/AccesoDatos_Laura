import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collectors;

public class ej3 {
    public static void main(String[] args) {
        String[] prod;
        List<Product> lista = new ArrayList<Product>();
        Path fichero = Path.of("tema1/tema1_ej3/Ej03_LeerFicheros.csv");
        try {
            List<String> linea = Files.readAllLines(fichero);
            System.out.println("Todos los productos");
            for (int i = 1; i < linea.size(); i++) {
                Product product = new Product();
                prod = linea.get(i).split(",");
                product.setId(Integer.parseInt(prod[0]));
                product.setName(prod[1]);
                product.setSupplier(Integer.parseInt(prod[2]));
                product.setCategory(Integer.parseInt(prod[3]));
                product.setUnitPrice(Double.parseDouble(prod[5]));
                product.setUnitsInStock((Integer.parseInt(prod[6])));
                lista.add(product);
                System.out.println(product.toString());
            }
            System.out.println();

            System.out.println("Nombres de los productos");
            lista.forEach(p-> System.out.println(p.getName()));
            System.out.println();

            System.out.println("Nombre de los productos que tienen menos de 10 unidades en stock");
            lista.stream().filter(p -> p.getUnitsInStock()<10).forEach(p -> System.out.println(p.getName()));
            System.out.println();

            System.out.println("Nombre de los productos con unidades en stock mayor de 10 ordenados por unidad de stock de forma descendente");
            lista.stream().filter(p-> p.getUnitsInStock()>10).sorted((p1,p2) ->Integer.compare(p2.getUnitsInStock(), p1.getUnitsInStock())).forEach(p-> System.out.println(p.getName()));
            System.out.println();

            System.out.println("Número de productos agrupados por proveedor");
            lista.stream().collect(Collectors.groupingBy(Product::getSupplier, Collectors.counting())).entrySet().stream().forEach(System.out::println);
            System.out.println();

            System.out.println("Producto con el precio unitario más alto");
            System.out.println(lista.stream().max(Comparator.comparingDouble(Product::getUnitPrice)).get().getName());
            System.out.println();

            System.out.println("Promedio de existencias en el almacen");
            System.out.println(lista.stream().mapToDouble(p -> p.getUnitsInStock()).average().orElse(0));

        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
