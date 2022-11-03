import com.sun.jdi.Value;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.security.Key;
import java.util.*;
import java.util.stream.Collectors;

public class principal {
    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) {
        List<raceResults> race = new ArrayList<raceResults>();
        List<sprintQualifyingResults> sprint = new ArrayList<>();
        try (FileReader fr = new FileReader("tema1/tema1_ej7/formula1_2021season_raceResults.csv"); BufferedReader br = new BufferedReader(fr); FileReader f = new FileReader("tema1/tema1_ej7/formula1_2021season_sprintQualifyingResults.csv"); BufferedReader b = new BufferedReader(f)){
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null) {
                String[] piloto = linea.split(COMMA_DELIMITER);
                raceResults r = new raceResults();
                r.setTrack(piloto[0]);
                if (Objects.equals(piloto[1], "NC")) {
                    r.setPosition("0");
                } else if (Objects.equals(piloto[1], "DQ")){
                    r.setPosition("0");
                }else {
                    r.setPosition(piloto[1]);
                }
                r.setNo(Integer.parseInt(piloto[2]));
                r.setDriver(piloto[3]);
                r.setTeam(piloto[4]);
                r.setStartingGrid(Integer.parseInt(piloto[5]));
                r.setLaps(Integer.parseInt(piloto[6]));
                r.setTime(piloto[7]);
                r.setPoints(Double.parseDouble(piloto[8]));
                r.setExtraPoints(piloto[9]);
                r.setFastestLap(piloto[10]);
                race.add(r);
            }
            String line;
            b.readLine();
            while ((line = b.readLine()) != null) {
                String[] rapida = line.split(COMMA_DELIMITER);
                sprintQualifyingResults s = new sprintQualifyingResults();
                s.setTrack(rapida[0]);
                if (Objects.equals(rapida[1], "NC")) {
                    s.setPosition("0");
                } else if (Objects.equals(rapida[1], "DQ")){
                    s.setPosition("0");
                }else {
                    s.setPosition(rapida[1]);
                }
                s.setNo(Integer.parseInt(rapida[2]));
                s.setDriver(rapida[3]);
                s.setTeam(rapida[4]);
                s.setStartingGrid(Integer.parseInt(rapida[5]));
                s.setLaps(Integer.parseInt(rapida[6]));
                s.setTime(rapida[7]);
                s.setPoints(Double.parseDouble(rapida[8]));
                sprint.add(s);
            }

            //¿Qué piloto consiguió más puntos en el campeonato y, por lo tanto, fue campeón del mundo?
            HashMap<String, Double> clasPilotos = new HashMap<>();
            System.out.println("---------------Clasificación de pilotos---------------");
            for (raceResults ra : race) {
                //piloto.put("Max Verstappen", p.getPoints());
                if (!clasPilotos.containsKey(ra.getDriver())) {
                    clasPilotos.put(ra.getDriver(), ra.getPoints());
                } else {
                    clasPilotos.put(ra.getDriver(), clasPilotos.get(ra.getDriver())+ra.getPoints());
                }
            }
            for (sprintQualifyingResults sp: sprint) {
                if (clasPilotos.containsKey(sp.getDriver())) {
                    clasPilotos.put(sp.getDriver(), clasPilotos.get(sp.getDriver())+sp.getPoints());
                }
            }
            clasPilotos.entrySet().stream().filter(p -> p.getValue() >= 0).sorted((p1, p2) -> Double.compare(p2.getValue(), p1.getValue())).forEach(System.out::println);
            System.out.println();
            System.out.print("Campeón del mundo: ");
            System.out.println(Collections.max(clasPilotos.entrySet(), Map.Entry.comparingByValue()).getKey());


            System.out.println();


            //¿Qué escudería se alzó con la victoria en el mundial de constructores?
            System.out.println("---------------Clasificación de escuderías---------------");
            HashMap<String, Double> clasEscuderia = new HashMap<>();
            for (raceResults escRa : race) {
                if (!clasEscuderia.containsKey(escRa.getTeam())) {
                    clasEscuderia.put(escRa.getTeam(), escRa.getPoints());
                } else {
                    clasEscuderia.put(escRa.getTeam(), clasEscuderia.get(escRa.getTeam())+escRa.getPoints());
                }
            }
            for (sprintQualifyingResults escSp: sprint) {
                if (clasEscuderia.containsKey(escSp.getDriver())) {
                    clasEscuderia.put(escSp.getTeam(), clasEscuderia.get(escSp.getTeam())+escSp.getPoints());
                }
            }
            clasEscuderia.entrySet().stream().filter(p-> p.getValue()>=0).sorted((p1, p2) -> Double.compare(p2.getValue(), p1.getValue())).forEach(System.out::println);
            System.out.println();
            System.out.print("Escudería ganadora: ");
            System.out.println(Collections.max(clasEscuderia.entrySet(), Map.Entry.comparingByValue()).getKey());


            System.out.println();

            //¿Qué piloto consiguió más victorias? ¿Y qué equipo?
            System.out.println("---------------Más victorias (piloto)---------------");
            HashMap<String, Integer> masVictoriasPiloto = new HashMap<>();
            HashMap<String, Integer> masVictoriasEscuderia = new HashMap<>();
            for (raceResults vicRa : race) {
                if(Integer.parseInt(vicRa.getPosition()) == 1) {
                    if (!masVictoriasPiloto.containsKey(vicRa.getDriver())) {
                        masVictoriasPiloto.put(vicRa.getDriver(), 1);
                    } else {
                            masVictoriasPiloto.put(vicRa.getDriver(), masVictoriasPiloto.get(vicRa.getDriver())+1);
                    }
                }

            }
            masVictoriasPiloto.entrySet().stream().filter(p->p.getValue()>=0).sorted((p1, p2) -> Integer.compare(p2.getValue(), p1.getValue())).forEach(System.out::println);
            System.out.println();
            System.out.print("El piloto con más victorias es: ");
            System.out.println(Collections.max(masVictoriasPiloto.entrySet(), Map.Entry.comparingByValue()).getKey());

            System.out.println("---------------Más victorias (escudería)---------------");
            for (raceResults vicSp : race) {
                if(Integer.parseInt(vicSp.getPosition()) == 1) {
                    if (!masVictoriasEscuderia.containsKey(vicSp.getTeam())) {
                        masVictoriasEscuderia.put(vicSp.getTeam(), 1);
                    } else {
                        masVictoriasPiloto.put(vicSp.getTeam(), masVictoriasPiloto.get(vicSp.getTeam())+1);
                    }
                }

            }
            masVictoriasEscuderia.entrySet().stream().filter(p->p.getValue()>=0).sorted((p1, p2) -> Integer.compare(p2.getValue(), p1.getValue())).forEach(System.out::println);
            System.out.println();
            System.out.print("La escuderia con más victorias es: ");
            System.out.println(Collections.max(masVictoriasEscuderia.entrySet(), Map.Entry.comparingByValue()).getKey());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
