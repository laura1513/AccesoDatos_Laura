import java.io.*;
import java.nio.file.Path;
import java.util.Date;

public class ej5_1 {
    public static void main(String[] args) {
        Path fichero = Path.of("tema1/tema1_ej5/5_1", "personas.dat");
        try (FileOutputStream fos = new FileOutputStream(fichero.toFile());
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            Date fecha1 = new Date(1980-9-25);
            Date fecha2 = new Date(2003-1-15);
            Date fecha3 = new Date(2000-11-3);

            Persona pers = new Persona("Roberto", "roberto1980@gmail.com", fecha1);
            oos.writeObject(pers);
            pers = new Persona("Juliana", "juls_lopez@gmail.com", fecha2);
            oos.writeObject(pers);
            pers = new Persona("Toni", "garciatoni@gmail.com", fecha3);
            oos.writeObject(pers);

        } catch (Exception ex) {
            System.out.println("Se ha encontrado un error");
        }
    }
}
