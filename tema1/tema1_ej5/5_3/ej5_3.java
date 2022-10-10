import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class ej5_3 {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("""
                    -----------MENU-----------
                    1. Introducir datos de personas
                    2. Buscar entre los datos existentes
                    3. Cargar todos
                    4. Salir""");
            opcion =  read.nextInt();
            read.nextLine();
            if (opcion == 1) {
                guardarPersona();
            } else if (opcion == 2) {
                buscarPersona();
            } else if (opcion == 3) {
                cargarPersonas();
            } else if (opcion > 4) {
                System.out.println("Opción no disponible");
            }
        } while (opcion != 4);
    }
    public static void guardarPersona() {
        Scanner read = new Scanner(System.in);
        Path fichero = Path.of("tema1/tema1_ej5/5_3", "personas.dat");
        String name;
        String email;
        String fecha;
        Date date;
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
        List<Persona> pers = new ArrayList<>();
        try (FileOutputStream fos = new FileOutputStream(fichero.toFile());
             ObjectOutputStream oos = new ObjectOutputStream(fos)) {
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
        } catch (Exception ex) {
            System.out.println("Se ha encontrado un error");
        }
    }

    public static void buscarPersona() {
        Scanner read = new Scanner(System.in);
        String name2;
        Path fichero = Path.of("tema1/tema1_ej5/5_3", "personas.dat");
        try (FileInputStream fis = new FileInputStream(fichero.toFile()); ObjectInputStream ois = new ObjectInputStream(fis)) {
            List<Persona> pers = (List<Persona>) (ois.readObject());
            System.out.println("Escribe el nombre que quieres buscar");
            name2= read.nextLine();
            for (Persona p: pers) {
                if (pers.contains(name2)) {
                    p.escribir();
                } else {
                    System.out.println("probando");
                }
            }
        } catch (Exception ex) {
            System.out.println("Se ha encontrado un error");
        }
    }
    public static void cargarPersonas() {
        Path fichero = Path.of("tema1/tema1_ej5/5_3", "personas.dat");
        try (FileInputStream fis = new FileInputStream(fichero.toFile()); ObjectInputStream ois = new ObjectInputStream(fis)) {
            List<Persona> pers = (List<Persona>) (ois.readObject());
            for (Persona p: pers) {
                p.escribir();
            }
        } catch (Exception ex) {
            System.out.println("Se ha encontrado un error");
        }
    }
}
