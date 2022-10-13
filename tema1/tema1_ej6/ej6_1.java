import java.io.FileWriter;
import java.io.RandomAccessFile;
import java.util.*;

public class ej6_1 {
    public static void main(String[] args) {
        FileWriter fichero;
        Scanner read = new Scanner(System.in);
        Product prod;
        int id;
        String name;
        int supplier;
        int category;
        double unitPrice;
        int unitsInStock;
        List<Product> lista = new ArrayList<>();
        try {
            prod = new Product();
            fichero = new FileWriter("tema1/tema1_ej3/Ej03_LeerFicheros.csv");
            System.out.println("Introduce el id del producto");
            id = read.nextInt();
            System.out.println("Escribe el nombre del producto");
            name = read.next();
            System.out.println("Escribe el código del proveedor");
            supplier = read.nextInt();
            System.out.println("Escribe el código de la categoria");
            category = read.nextInt();
            System.out.println("Introduce el precio unitario");
            unitPrice = read.nextDouble();
            System.out.println("Introduce las unidades en stock");
            unitsInStock = read.nextInt();
            prod.setId(id);
            prod.setName(name);
            prod.setSupplier(supplier);
            prod.setCategory(category);
            prod.setUnitPrice(unitPrice);
            prod.setUnitsInStock(unitsInStock);
            lista.add(prod);
            int[] longitud = new int[lista.size()];
            for (int i = 0; i<lista.size(); i++) {
                longitud[i] = lista.size();
            }
            boolean encontrado = false;
            String palabraClave = Integer.toString(prod.getId());
            String lineanew = "asd";
            String lineaold = "asd";
            int delStrSiza = 0;

            RandomAccessFile raf = new RandomAccessFile(String.valueOf(fichero), "r");
            String linea = raf.readLine();

            while (linea != null) {
                if (linea.contains(palabraClave)) {
                    encontrado = true;
                    lineanew = id+","+name+","+supplier+","+category+",null"+unitPrice+","+unitsInStock+",null,null,null";
                    lineaold = linea;
                }
                linea = raf.readLine();
            }
            raf.close();
            if (!encontrado) {
                fichero.write(id+","+name+","+supplier+","+category+",null"+unitPrice+","+unitsInStock+",null,null,null");
            } else {
                raf = new RandomAccessFile(String.valueOf(fichero), "rw");
                linea = raf.readLine();
                while (linea != null) {
                    if (linea.contains(lineaold)) {
                        raf.seek(0);
                        raf.writeBytes(lineanew);
                    }
                     linea = raf.readLine();
                }
            }
            raf.close();
        } catch (Exception ex) {
            System.out.println("error");
        }
    }
}
