import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ej5_3 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        Path fichero = Path.of("tema1/tema1_ej5/5_3", "personas.dat");
        String name;
        String email;
        String fecha;
        Date date;
        int opcion;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        List<Persona> pers = new ArrayList<>();
        do {
            System.out.println("-----------MENU-----------\n" +
                    "1. Introducir datos de personas\n" +
                    "2. Buscar entre los datos existentes\n" +
                    "3. Salir");
            opcion =  read.nextInt();
            try (FileOutputStream fos = new FileOutputStream(fichero.toFile());
                 ObjectOutputStream oos = new ObjectOutputStream(fos)) {
                if (opcion >=1 && opcion <=3) {
                    if (opcion == 1) {
                        System.out.println("Has seleccionado añadir persona");
                        System.out.print("Nombre: ");
                        name = read.nextLine();
                        System.out.print("Email: ");
                        email = read.nextLine();
                        System.out.print("Fecha de nacimiento (dd/MM/yyyy): ");
                        fecha = read.nextLine();
                        date = formato.parse(fecha);
                        pers.add(new Persona(name, email, date));
                        oos.writeObject(pers);
                    } else if (opcion == 2) {

                    }
                } else {
                    System.out.println("Opción no disponible");
                }

            } catch (Exception ex) {
                System.out.println("Se ha encontrado un error");
            }
        } while(opcion != 3);
        System.out.println("Has salido.");
    }
}
