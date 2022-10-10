import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.nio.file.Path;
import java.util.List;

public class ej5_2 {
    public static void main(String[] args) {
        Path fichero = Path.of("tema1/tema1_ej5/5_1", "personas.dat");
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
