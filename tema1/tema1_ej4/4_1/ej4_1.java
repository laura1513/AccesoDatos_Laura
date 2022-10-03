import java.io.FileWriter;
import java.util.Scanner;

public class ej4_1 {
    public static void main(String[] args) {
        FileWriter fichero;
        Scanner read = new Scanner(System.in);
        String cadena;
        try {
            fichero =  new FileWriter("tema1/tema1_ej4/4_1/frases.txt");
            do {
                System.out.println("Introduce una cadena, cuando quieras finalizar no escribas nada");
                cadena = read.nextLine();
                fichero.write(cadena+ "\n");
            } while (!cadena.isEmpty());
            fichero.close();
        } catch (Exception e) {
            System.out.println("Ha habido un error");
        }
    }
}
