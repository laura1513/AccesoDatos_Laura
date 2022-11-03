import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class principal {
    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) {
        List<race> race = new ArrayList<race>();
        List<sprint> sprint = new ArrayList<>();
        try (FileReader fr = new FileReader("tema1/tema1_ej7/formula1_2021season_raceResults.csv"); BufferedReader br = new BufferedReader(fr); FileReader f = new FileReader("tema1/tema1_ej7/formula1_2021season_sprintQualifyingResults.csv"); BufferedReader b = new BufferedReader(f)){
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null) {
                String[] piloto = linea.split(COMMA_DELIMITER);
                race r = new race();
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
                sprint s = new sprint();
                s.setTrack(rapida[0]);
                s.setPosition(rapida[1]);
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
            for (race ra : race) {
                //piloto.put("Max Verstappen", p.getPoints());
                if (!clasPilotos.containsKey(ra.getDriver())) {
                    clasPilotos.put(ra.getDriver(), ra.getPoints());
                } else {
                    clasPilotos.put(ra.getDriver(), clasPilotos.get(ra.getDriver())+ra.getPoints());
                }
            }
            for (sprint sp: sprint) {
                if (clasPilotos.containsKey(sp.getDriver())) {
                    clasPilotos.put(sp.getDriver(), clasPilotos.get(sp.getDriver())+sp.getPoints());
                }
            }
            clasPilotos.entrySet().stream().filter(p -> p.getValue() >= 0).sorted((p1, p2) -> Double.compare(p2.getValue(), p1.getValue())).forEach(System.out::println);
            System.out.println();

            //¿Qué escudería se alzó con la victoria en el mundial de constructores?
            System.out.println("---------------Clasificación de escuderías---------------");
            HashMap<String, Double> clasEscuderia = new HashMap<>();
            for (race escRa : race) {
                if (!clasEscuderia.containsKey(escRa.getTeam())) {
                    clasEscuderia.put(escRa.getTeam(), escRa.getPoints());
                } else {
                    clasEscuderia.put(escRa.getTeam(), clasEscuderia.get(escRa.getTeam())+escRa.getPoints());
                }
            }
            for (sprint escSp: sprint) {
                if (clasEscuderia.containsKey(escSp.getDriver())) {
                    clasEscuderia.put(escSp.getTeam(), clasEscuderia.get(escSp.getTeam())+escSp.getPoints());
                }
            }
            clasEscuderia.entrySet().stream().filter(p-> p.getValue()>=0).sorted((p1, p2) -> Double.compare(p2.getValue(), p1.getValue())).forEach(System.out::println);
            System.out.println();

            //¿Qué piloto consiguió más victorias? ¿Y qué equipo?
            System.out.println("---------------Más victorias (piloto)---------------");
            HashMap<String, Integer> masVictoriasPiloto = new HashMap<>();
            HashMap<String, Integer> masVictoriasEscuderia = new HashMap<>();
            for (race vicPi : race) {
                if(Integer.parseInt(vicPi.getPosition()) == 1) {
                    if (!masVictoriasPiloto.containsKey(vicPi.getDriver())) {
                        masVictoriasPiloto.put(vicPi.getDriver(), 1);
                    } else {
                            masVictoriasPiloto.put(vicPi.getDriver(), masVictoriasPiloto.get(vicPi.getDriver())+1);
                    }
                }

            }
            masVictoriasPiloto.entrySet().stream().filter(p->p.getValue()>=0).sorted((p1, p2) -> Integer.compare(p2.getValue(), p1.getValue())).forEach(System.out::println);
            System.out.println();

            System.out.println("---------------Más victorias (escudería)---------------");
            for (race vicEsc : race) {
                if(Integer.parseInt(vicEsc.getPosition()) == 1) {
                    if (!masVictoriasEscuderia.containsKey(vicEsc.getTeam())) {
                        masVictoriasEscuderia.put(vicEsc.getTeam(), 1);
                    } else {
                        masVictoriasEscuderia.put(vicEsc.getTeam(), masVictoriasEscuderia.get(vicEsc.getTeam())+1);
                    }
                }

            }
            masVictoriasEscuderia.entrySet().stream().filter(p->p.getValue()>=0).sorted((p1, p2) -> Integer.compare(p2.getValue(), p1.getValue())).forEach(System.out::println);
            System.out.println();

            //¿Qué piloto consiguió subirse más veces al pódium? ¿Y qué equipo?
            System.out.println("---------------Más podium (piloto)---------------");
            HashMap<String, Integer> masPodioPiloto = new HashMap<>();
            HashMap<String, Integer> masPodioEscuderia = new HashMap<>();
            for (race podPi : race) {
                if(Integer.parseInt(podPi.getPosition()) == 1 || Integer.parseInt(podPi.getPosition()) == 2 || Integer.parseInt(podPi.getPosition()) == 3) {
                    if (!masPodioPiloto.containsKey(podPi.getDriver())) {
                        masPodioPiloto.put(podPi.getDriver(), 1);
                    } else {
                        masPodioPiloto.put(podPi.getDriver(), masPodioPiloto.get(podPi.getDriver())+1);
                    }
                }

            }
            masPodioPiloto.entrySet().stream().filter(p->p.getValue()>=0).sorted((p1, p2) -> Integer.compare(p2.getValue(), p1.getValue())).forEach(System.out::println);
            System.out.println();

            System.out.println("---------------Más podium (escudería)---------------");
            for (race podEsc : race) {
                if(Integer.parseInt(podEsc.getPosition()) == 1 || Integer.parseInt(podEsc.getPosition()) == 2 || Integer.parseInt(podEsc.getPosition()) == 3) {
                    if (!masPodioEscuderia.containsKey(podEsc.getTeam())) {
                        masPodioEscuderia.put(podEsc.getTeam(), 1);
                    } else {
                        masPodioEscuderia.put(podEsc.getTeam(), masPodioEscuderia.get(podEsc.getTeam())+1);
                    }
                }

            }
            masPodioEscuderia.entrySet().stream().filter(p->p.getValue()>=0).sorted((p1, p2) -> Integer.compare(p2.getValue(), p1.getValue())).forEach(System.out::println);
            System.out.println();


            //¿Qué piloto consiguió hacer más poles? ¿Y qué equipo?
            System.out.println("---------------Más poles (piloto)---------------");
            HashMap<String, Integer> masPolesPiloto = new HashMap<>();
            HashMap<String, Integer> masPolesEscuderia = new HashMap<>();
            for (race polPi : race) {
                if(polPi.getStartingGrid() == 1) {
                    if (!masPolesPiloto.containsKey(polPi.getDriver())) {
                        masPolesPiloto.put(polPi.getDriver(), 1);
                    } else {
                        masPolesPiloto.put(polPi.getDriver(), masPolesPiloto.get(polPi.getDriver())+1);
                    }
                }

            }
            masPolesPiloto.entrySet().stream().filter(p->p.getValue()>=0).sorted((p1, p2) -> Integer.compare(p2.getValue(), p1.getValue())).forEach(System.out::println);
            System.out.println();

            System.out.println("---------------Más poles (escudería)---------------");
            for (race polEsc : race) {
                if(polEsc.getStartingGrid() == 1) {
                    if (!masPolesEscuderia.containsKey(polEsc.getTeam())) {
                        masPolesEscuderia.put(polEsc.getTeam(), 1);
                    } else {
                            masPolesEscuderia.put(polEsc.getTeam(), masPolesEscuderia.get(polEsc.getTeam())+1);
                    }
                }

            }
            masPolesEscuderia.entrySet().stream().filter(p->p.getValue()>=0).sorted((p1, p2) -> Integer.compare(p2.getValue(), p1.getValue())).forEach(System.out::println);
            System.out.println();

            //¿Qué pilotos han sufrido más abandonos, ya sea en carrera o que no han podido participar?
            System.out.println("---------------Más abandonos (piloto)---------------");
            HashMap<String, Integer> masAbandonosPiloto = new HashMap<>();
            HashMap<String, Integer> masAbandonosEscuderia = new HashMap<>();
            for (race abPi : race) {
                if(Integer.parseInt(abPi.getPosition()) == 0) {
                    if (!masAbandonosPiloto.containsKey(abPi.getDriver())) {
                        masAbandonosPiloto.put(abPi.getDriver(), 1);
                    } else {
                        masAbandonosPiloto.put(abPi.getDriver(), masAbandonosPiloto.get(abPi.getDriver())+1);
                    }
                }

            }
            masAbandonosPiloto.entrySet().stream().filter(p->p.getValue()>=0).sorted((p1, p2) -> Integer.compare(p2.getValue(), p1.getValue())).forEach(System.out::println);
            System.out.println();

            System.out.println("---------------Más abandonos (escudería)---------------");
            for (race abEsc : race) {
                if(Integer.parseInt(abEsc.getPosition()) == 0) {
                    if (!masAbandonosEscuderia.containsKey(abEsc.getTeam())) {
                        masAbandonosEscuderia.put(abEsc.getTeam(), 1);
                    } else {
                        masAbandonosEscuderia.put(abEsc.getTeam(), masAbandonosEscuderia.get(abEsc.getTeam())+1);
                    }
                }

            }
            masAbandonosEscuderia.entrySet().stream().filter(p->p.getValue()>=0).sorted((p1, p2) -> Integer.compare(p2.getValue(), p1.getValue())).forEach(System.out::println);
            System.out.println();


            System.out.print("Campeón del mundo: ");
            System.out.println(Collections.max(clasPilotos.entrySet(), Map.Entry.comparingByValue()).getKey());
            System.out.print("Escudería ganadora: ");
            System.out.println(Collections.max(clasEscuderia.entrySet(), Map.Entry.comparingByValue()).getKey());
            System.out.print("El piloto con más victorias es: ");
            System.out.println(Collections.max(masVictoriasPiloto.entrySet(), Map.Entry.comparingByValue()).getKey());
            System.out.print("La escuderia con más victorias es: ");
            System.out.println(Collections.max(masVictoriasEscuderia.entrySet(), Map.Entry.comparingByValue()).getKey());
            System.out.print("El piloto con más veces en el podio es: ");
            System.out.println(Collections.max(masPodioPiloto.entrySet(), Map.Entry.comparingByValue()).getKey());
            System.out.print("La escuderia con más veces en el podio es: ");
            System.out.println(Collections.max(masPodioEscuderia.entrySet(), Map.Entry.comparingByValue()).getKey());
            System.out.print("El piloto con más poles: ");
            System.out.println(Collections.max(masPolesPiloto.entrySet(), Map.Entry.comparingByValue()).getKey());
            System.out.print("La escuderia con más poles: ");
            System.out.println(Collections.max(masPolesEscuderia.entrySet(), Map.Entry.comparingByValue()).getKey());
            System.out.print("El piloto con más abandonos es: ");
            System.out.println(Collections.max(masAbandonosPiloto.entrySet(), Map.Entry.comparingByValue()).getKey());
            System.out.print("La escudería con más abandonos es: ");
            System.out.println(Collections.max(masAbandonosEscuderia.entrySet(), Map.Entry.comparingByValue()).getKey());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
