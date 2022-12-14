import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

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

            //??Qu?? piloto consigui?? m??s puntos en el campeonato y, por lo tanto, fue campe??n del mundo?
            HashMap<String, Double> clasPilotos = new HashMap<>();
            System.out.println("---------------Clasificaci??n de pilotos---------------");
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

            //??Qu?? escuder??a se alz?? con la victoria en el mundial de constructores?
            System.out.println("---------------Clasificaci??n de escuder??as---------------");
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

            //??Qu?? piloto consigui?? m??s victorias? ??Y qu?? equipo?
            System.out.println("---------------M??s victorias (piloto)---------------");
            HashMap<String, Integer> masVictoriasPiloto = new HashMap<>();
            HashMap<String, Integer> masVictoriasEscuderia = new HashMap<>();
            for (raceResults vicPi : race) {
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

            System.out.println("---------------M??s victorias (escuder??a)---------------");
            for (raceResults vicEsc : race) {
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

            //??Qu?? piloto consigui?? subirse m??s veces al p??dium? ??Y qu?? equipo?
            System.out.println("---------------M??s podium (piloto)---------------");
            HashMap<String, Integer> masPodioPiloto = new HashMap<>();
            HashMap<String, Integer> masPodioEscuderia = new HashMap<>();
            for (raceResults podPi : race) {
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

            System.out.println("---------------M??s podium (escuder??a)---------------");
            for (raceResults podEsc : race) {
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


            //??Qu?? piloto consigui?? hacer m??s poles? ??Y qu?? equipo?
            System.out.println("---------------M??s poles (piloto)---------------");
            HashMap<String, Integer> masPolesPiloto = new HashMap<>();
            HashMap<String, Integer> masPolesEscuderia = new HashMap<>();
            for (raceResults polPi : race) {
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

            System.out.println("---------------M??s poles (escuder??a)---------------");
            for (raceResults polEsc : race) {
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

            //??Qu?? pilotos han sufrido m??s abandonos, ya sea en carrera o que no han podido participar?
            System.out.println("---------------M??s abandonos (piloto)---------------");
            HashMap<String, Integer> masAbandonosPiloto = new HashMap<>();
            HashMap<String, Integer> masAbandonosEscuderia = new HashMap<>();
            for (raceResults abPi : race) {
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

            System.out.println("---------------M??s abandonos (escuder??a)---------------");
            for (raceResults abEsc : race) {
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


            System.out.print("Campe??n del mundo: ");
            System.out.println(Collections.max(clasPilotos.entrySet(), Map.Entry.comparingByValue()).getKey());
            System.out.print("Escuder??a ganadora: ");
            System.out.println(Collections.max(clasEscuderia.entrySet(), Map.Entry.comparingByValue()).getKey());
            System.out.print("El piloto con m??s victorias es: ");
            System.out.println(Collections.max(masVictoriasPiloto.entrySet(), Map.Entry.comparingByValue()).getKey());
            System.out.print("La escuderia con m??s victorias es: ");
            System.out.println(Collections.max(masVictoriasEscuderia.entrySet(), Map.Entry.comparingByValue()).getKey());
            System.out.print("El piloto con m??s veces en el podio es: ");
            System.out.println(Collections.max(masPodioPiloto.entrySet(), Map.Entry.comparingByValue()).getKey());
            System.out.print("La escuderia con m??s veces en el podio es: ");
            System.out.println(Collections.max(masPodioEscuderia.entrySet(), Map.Entry.comparingByValue()).getKey());
            System.out.print("El piloto con m??s poles: ");
            System.out.println(Collections.max(masPolesPiloto.entrySet(), Map.Entry.comparingByValue()).getKey());
            System.out.print("La escuderia con m??s poles: ");
            System.out.println(Collections.max(masPolesEscuderia.entrySet(), Map.Entry.comparingByValue()).getKey());
            System.out.print("El piloto con m??s abandonos es: ");
            System.out.println(Collections.max(masAbandonosPiloto.entrySet(), Map.Entry.comparingByValue()).getKey());
            System.out.print("La escuder??a con m??s abandonos es: ");
            System.out.println(Collections.max(masAbandonosEscuderia.entrySet(), Map.Entry.comparingByValue()).getKey());


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
