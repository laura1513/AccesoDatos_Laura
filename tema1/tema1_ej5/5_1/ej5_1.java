import java.io.*;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ej5_1 {
    public static void main(String[] args) {
        Path fichero = Path.of("tema1/tema1_ej5/5_1", "personas.dat");
        try (FileOutputStream fos = new FileOutputStream(fichero.toFile());
            ObjectOutputStream oos = new ObjectOutputStream(fos)) {

            Date fecha1 = new Date(80,9,20);
            Date fecha2 = new Date(103,1,15);
            Date fecha3 = new Date(100,11,3);
            List<Persona> pers = new ArrayList<>();
            pers.add(new Persona("Roberto", "roberto1980@gmail.com", fecha1));
            pers.add(new Persona("Juliana", "juls_lopez@gmail.com", fecha2));
            pers.add(new Persona("Toni", "garciatoni@gmail.com", fecha3));
            oos.writeObject(pers);

        } catch (Exception ex) {
            System.out.println("Se ha encontrado un error");
        }
    }
}
