import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ej3 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        String[] prod;
        List<Product> lista = new ArrayList<Product>();
        Path fichero = Path.of("tema1/tema1_ej3/Ej03_LeerFicheros.csv");
        try {
            List<String> linea = Files.readAllLines(fichero);
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

        } catch (FileNotFoundException e) {
            System.out.println("Fichero no encontrado");
        } catch (IOException e) {
            System.out.println("Error");
        }
    }
}
