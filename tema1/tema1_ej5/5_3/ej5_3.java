import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.util.Date;
import java.util.Scanner;

public class ej5_3 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Path fichero = Path.of("tema1/tema1_ej5/5_3", "personas.dat");
        String name;
        String email;
        String fecha;
        System.out.println("-----------MENU-----------\n" +
                "1. Introducir datos de personas\n" +
                "2. Buscar entre los datos existentes");
        try (FileOutputStream fos = new FileOutputStream(fichero.toFile());
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            System.out.print("Nombre: ");
            name = read.nextLine();
            System.out.print("Email: ");
            email = read.nextLine();
            System.out.print("Fecha de nacimiento: ");
            fecha = read.nextLine();
        } catch (Exception ex) {
            System.out.println("Se ha encontrado un error");
        }
    }
}
