import java.nio.file.Path;
import java.sql.*;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Mundial {
    public static void main(String[] args) {
        Connection conexion = null;
        PreparedStatement sentencia = null;

        try {
            Path rutaBaseDatos = Path.of("tema2/tema2_ej1/formula1.db");
            conexion = DriverManager.getConnection("jdbc:sqlite:" + rutaBaseDatos.toString());

            //Clasificación final ordenada del mundial de pilotos
            String sentenciaClasificasion = "SELECT Results.Points, Drivers.Name FROM Results INNER JOIN Drivers ON Results.DriverID = Drivers.DriverID";

            sentencia = conexion.prepareStatement(sentenciaClasificasion);
            ResultSet resultadosClasificacion = sentencia.executeQuery();

            System.out.println("Points\tDriver");
            System.out.println("----------------------------------------------");
            HashMap<String, Double> puntos = new HashMap<>();
            while (resultadosClasificacion.next()) {
                // System.out.println(rs.getInt(1) + "\t" + rs.getString(2) + "\t" + rs.getString(3) + "\t" + rs.getString(4));
                if (!puntos.containsKey(resultadosClasificacion.getString("name"))) {
                    puntos.put(resultadosClasificacion.getString("name"), resultadosClasificacion.getDouble("points"));
                } else {
                    puntos.put(resultadosClasificacion.getString("name"), puntos.get(resultadosClasificacion.getString("name"))+resultadosClasificacion.getDouble("points"));
                }
            }
            puntos.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).forEach(r -> System.out.println(r.getValue()+"  "+r.getKey()));

            resultadosClasificacion.close();

            //Pilotos con 30 años o más (a día de hoy), ordenados de mayor a menor edad.

            String sentencia30anyos = "SELECT strftime('%d/%m/%Y', Drivers.DateOfBirth) as DOB, Drivers.Name FROM Drivers";

            sentencia = conexion.prepareStatement(sentencia30anyos);
            ResultSet resultadoMas30Anyos = sentencia.executeQuery();

            System.out.println("Edad\tDriver");
            System.out.println("----------------------------------------------");

            HashMap<String, Integer> masDe30 = new HashMap<>();

            while (resultadoMas30Anyos.next()) {

            }

            conexion.close();

        } catch ( Exception e ) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
    }
}