import java.io.FileWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class ej4_3 {
    public static void main(String[] args) {
        SimpleDateFormat formater = new SimpleDateFormat("dd-MM-yyyy 'at' HH:mm");
        Date date = new Date(System.currentTimeMillis());
        FileWriter fichero;
        Scanner read = new Scanner(System.in);
        String cadena;
        try {
            fichero = new FileWriter("tema1/tema1_ej4/4_3/anotaciones.txt", true);
            do {
                System.out.println("Introduce una cadena, cuando quieras finalizar no escribas nada");
                cadena = read.nextLine();
                fichero.write(cadena+" "+ formater.format(date)+"\n");
            } while (!cadena.isEmpty());
            fichero.close();
        } catch (Exception e) {
            System.out.println("Ha habido un error");
        }
    }
}
