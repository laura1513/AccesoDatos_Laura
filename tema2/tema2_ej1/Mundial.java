import java.nio.file.Path;
import java.sql.*;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Mundial {
    public static void main(String[] args) {
        Scanner read = new Scanner(System.in);

        Path rutaBaseDatos = Path.of("tema2/tema2_ej1/formula1.db");

        try (Connection conexion = DriverManager.getConnection("jdbc:sqlite:" + rutaBaseDatos.toString())){

            //PARTE 1

            //Clasificación final ordenada del mundial de pilotos
            String sentenciaClasificasion = """
                    SELECT SUM(Results.Points) AS Points, Drivers.Name AS Driver
                        FROM Results
                        INNER JOIN Drivers
                        ON Results.DriverID = Drivers.DriverID
                        GROUP BY Drivers.Name
                        ORDER BY Points DESC""";

            PreparedStatement sentencia = conexion.prepareStatement(sentenciaClasificasion);
            ResultSet resultadosClasificacion = sentencia.executeQuery();

            System.out.println("Points\tDriver");
            System.out.println("----------------------------------------------");

            while (resultadosClasificacion.next()) {
                System.out.println(resultadosClasificacion.getString("Driver")+"--->"+resultadosClasificacion.getDouble("Points"));
            }

            resultadosClasificacion.close();
            System.out.println();

            //Pilotos con 30 años o más (a día de hoy), ordenados de mayor a menor edad.

            String sentencia30anyos = """
                    SELECT cast(strftime('%Y.%m%d', 'now') - strftime('%Y.%m%d', Drivers.DateOfBirth ) as int) AS DOB, Drivers.Name
                    FROM Drivers
                    WHERE DOB >= 30
                    GROUP BY Drivers.Name
                    ORDER BY DOB DESC""";

            sentencia = conexion.prepareStatement(sentencia30anyos);
            ResultSet resultadoMas30Anyos = sentencia.executeQuery();

            System.out.println("Driver\tEdad");
            System.out.println("----------------------------------------------");

            while (resultadoMas30Anyos.next()) {
                System.out.println(resultadoMas30Anyos.getString("name")+" "+resultadoMas30Anyos.getString("DOB"));
            }
            resultadoMas30Anyos.close();
            System.out.println();

            /*3. Como en la consulta anterior, pero permite que sea el usuario el que especifique el límite de edad
            mínima de los pilotos a mostrar*/
            int num = 0;
            System.out.print("Introduce el limite de edad: ");
            boolean correct;
            do {
                try {
                    num = read.nextInt();
                    correct = true;
                } catch (Exception e) {
                    correct = false;
                    System.out.println("Limite mal introducido");
                }
            } while (!correct);
            String sentenciaEdadUsuario = """
                    SELECT cast(strftime('%Y.%m%d', 'now') - strftime('%Y.%m%d', Drivers.DateOfBirth ) as int) AS DOB, Drivers.Name
                    FROM Drivers
                    WHERE DOB >= ?
                    GROUP BY Drivers.Name
                    ORDER BY DOB DESC""";

            sentencia = conexion.prepareStatement(sentenciaEdadUsuario);
            sentencia.setInt(1, num);
            ResultSet resultadoEdadUsuario = sentencia.executeQuery();

            System.out.println("Driver\tEdad");
            System.out.println("----------------------------------------------");

            while (resultadoEdadUsuario.next()) {
                System.out.println(resultadoEdadUsuario.getString("name")+" "+resultadoEdadUsuario.getString("DOB"));
            }
            resultadoEdadUsuario.close();
            sentencia.close();

            //Crear tabla
            /*String crearTabla = """
                    CREATE TABLE IF NOT EXISTS Teams (
                    Constructor TEXT NOT NULL,
                    Chassis TEXT NOT NULL,
                    PowerUnit TEXT NOT NULL,
                    PRIMARY KEY (Constructor)
                    )""";

            String borrarContenido = "DELETE From Teams";

            String insertarValores = """
                    INSERT INTO Teams VALUES
                    ('Alfa Romeo Racing-Ferrari', 'C38', 'Ferrari 064'),
                    ('Ferrari','SF90','Ferrari 064'),
                    ('Haas-Ferrari','VF-19','Ferrari 064'),
                    ('McLaren-Renault','MCL34','Renault E-Tech 19'),
                    ('Mercedes', 'F1 W10 EQ Power+', 'Mercedes M10 EQ Power+'),
                    ('Racing Point-BWT Mercedes', 'RP19', 'BWT Mercedes'),
                    ('Red Bull Racing-Honda', 'RB15', 'Honda RA619H'),
                    ('Renault', 'R.S.19', 'Renault E-Tech 19'),
                    ('Scuderia Toro Rosso-Honda', 'STR14', 'Honda RA619H'),
                    ('Williams-Mercedes', 'FW42', 'Mercedes M10 EQ Power+')""";

            sentencia = conexion.prepareStatement(crearTabla);
            int estado = sentencia.executeUpdate();
            System.out.println(estado);
            sentencia = conexion.prepareStatement(borrarContenido);
            estado = sentencia.executeUpdate();
            System.out.println(estado);
            sentencia = conexion.prepareStatement(insertarValores);
            estado = sentencia.executeUpdate();
            System.out.println(estado);*/
            sentencia.close();

        } catch (Exception e) {
            System.err.println(e.getClass().getName() + ": " + e.getMessage());
            System.exit(0);
        }
        //PARTE 2

        String host ="f12019.ci66saah1axn.us-east-1.rds.amazonaws.com:3306";
        String bbdd = "f1_2019";

        String dbUrl = "jdbc:mariadb://" + host + "/" + bbdd;
        String usuario = "admin";
        String passwd = "aadd1234";

        try (Connection conexion = DriverManager.getConnection(dbUrl, usuario, passwd)){
            String sentenciaClasificasion = """
                    SELECT SUM(Results.Points) AS Points, Drivers.Name AS Driver
                        FROM Results
                        INNER JOIN Drivers
                        ON Results.DriverID = Drivers.DriverID
                        GROUP BY Drivers.Name
                        ORDER BY Points DESC""";

            PreparedStatement sentencia = conexion.prepareStatement(sentenciaClasificasion);
            ResultSet resultadosClasificacion = sentencia.executeQuery();

            System.out.println("Points\tDriver");
            System.out.println("----------------------------------------------");

            while (resultadosClasificacion.next()) {
                System.out.println(resultadosClasificacion.getString("Driver")+"--->"+resultadosClasificacion.getDouble("Points"));
            }

            resultadosClasificacion.close();
            System.out.println();
            String sentencia30anyos = """
                    SELECT cast(strftime('%Y.%m%d', 'now') - strftime('%Y.%m%d', Drivers.DateOfBirth ) as int) AS DOB, Drivers.Name
                    FROM Drivers
                    WHERE DOB >= 30
                    GROUP BY Drivers.Name
                    ORDER BY DOB DESC""";

            sentencia = conexion.prepareStatement(sentencia30anyos);
            ResultSet resultadoMas30Anyos = sentencia.executeQuery();

            System.out.println("Driver\tEdad");
            System.out.println("----------------------------------------------");

            while (resultadoMas30Anyos.next()) {
                System.out.println(resultadoMas30Anyos.getString("name")+" "+resultadoMas30Anyos.getString("DOB"));
            }
            resultadoMas30Anyos.close();

        } catch (Exception ex) {

        }
    }
}