import java.io.*;
import java.nio.file.Path;
import java.util.Date;

public class ej5_1 {
    public static void main(String[] args) {
        Path fichero = Path.of("tema1/tema1_ej5/5_1", "personas.dat");
        try (FileOutputStream fos = new FileOutputStream(fichero.toFile());
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            Date fecha = new Date(1980-9-25);
            Persona pers = new Persona("Roberto", "roberto1980@gmail.com", fecha);
            oos.writeObject(pers);
        } catch (Exception ex) {
            System.out.println("Se ha encontrado un error");
        }

        try (FileInputStream fis = new FileInputStream(fichero.toFile()); ObjectInputStream ois = new ObjectInputStream(fis)) {

            Persona pers = (Persona) ois.readObject();
            pers.escribir();
        } catch (Exception ex) {
            System.out.println("Se ha encontrado un error");
        }
    }
}
