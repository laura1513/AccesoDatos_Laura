import java.io.FileWriter;
import java.util.Scanner;

public class ej4_4 {
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
        try {
            prod = new Product();
            fichero = new FileWriter("tema1/tema1_ej3/Ej03_LeerFicheros");
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
            //productID,productName,supplierID,categoryID,*,unitPrice,unitsInStock,unitsOnOrder,reorderLevel,discontinued
            //1,Chai,1,1,*,18.00,39,*,*,*
            prod.setId(id);
            prod.setName(name);
            prod.setSupplier(supplier);
            prod.setCategory(category);
            prod.setUnitPrice(unitPrice);
            prod.setUnitsInStock(unitsInStock);
            fichero.write(id+","+name+","+supplier+","+category+",null"+unitPrice+","+unitsInStock+",null,null,null");
            fichero.close();
        } catch (Exception ex) {
            System.out.println("error");
        }
    }
}