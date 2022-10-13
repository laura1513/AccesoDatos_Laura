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
        boolean encontrado;
        String lineanew = "asd";
        String lineaold = "asd";
        RandomAccessFile raf;
        String linea;
        List<Product> lista = new ArrayList<>();
        String ruta = "tema1/tema1_ej3/Ej03_LeerFicheros.csv";
        try {
            prod = new Product();
            fichero = new FileWriter(ruta, true);
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
            fichero.close();
            encontrado = false;
            raf = new RandomAccessFile(ruta, "rw");
            linea = raf.readLine();
            while (linea != null) {
                if (prod.getId() == id) {
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
                //raf = new RandomAccessFile(ruta, "rw");
                //linea = raf.readLine();
                while (linea != null) {
                    if (linea.contains(lineaold)) {
                        raf.seek(lista.size());
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
