import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;


public class clasePrincipal {
    private static final String COMMA_DELIMITER=",";
    public static void main(String[] args) {
        List<race> races = new ArrayList<>();
        List<sprint> sprint = new ArrayList<>();
        Path fichero = Path.of("tema1/tema1_ej8/formula1_2021season_calendar.xml");
        JAXBContext context = null;
        try (FileReader fr = new FileReader("tema1/tema1_ej8/formula1_2021season_raceResults.csv");
             BufferedReader br = new BufferedReader(fr);
             FileReader f = new FileReader("tema1/tema1_ej8/formula1_2021season_sprintQualifyingResults.csv");
             BufferedReader b = new BufferedReader(f)){

            context = JAXBContext.newInstance(arrayListCalendario.class);
            Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();

            arrayListCalendario cl = (arrayListCalendario) jaxbUnmarshaller.unmarshal(fichero.toFile());

            String linea;
            br.readLine();
            /*for (circuito ci : cl.getCls()) {
                System.out.println(ci.toString());
            }*/
            while ((linea = br.readLine()) != null) {
                String[] piloto = linea.split(COMMA_DELIMITER);
                race ra = new race();
                for (circuito ci : cl.getCls()) {
                    if (piloto[0].equalsIgnoreCase(ci.getGpname())) {
                        ra.setTrack(ci);
                    }
                }
                if (Objects.equals(piloto[1], "NC")) {
                    ra.setPosition("0");
                } else if (Objects.equals(piloto[1], "DQ")){
                    ra.setPosition("0");
                }else {
                    ra.setPosition(piloto[1]);
                }
                ra.setNo(Integer.parseInt(piloto[2]));
                ra.setDriver(piloto[3]);
                ra.setTeam(piloto[4]);
                ra.setStartingGrid(Integer.parseInt(piloto[5]));
                ra.setLaps(Integer.parseInt(piloto[6]));
                ra.setTime(piloto[7]);
                ra.setPoints(Double.parseDouble(piloto[8]));
                ra.setExtraPoints(piloto[9]);
                ra.setFastestLap(piloto[10]);
                races.add(ra);
            }
            System.out.println("Un listado de cada gran premio y su ganador.");
            System.out.println();
            HashMap<String, String> ganadorPremio = new HashMap<>();
            for (race ci : races) {
                if(!ganadorPremio.containsKey(ci.getTrack().getGpname())) {
                    ganadorPremio.put(ci.getTrack().getGpname(), ci.getDriver());
                }
            }
            ganadorPremio.entrySet().stream().forEach(System.out::println);

            System.out.println();

            System.out.println("Un listado del número de grandes premios celebrados por país.");
            System.out.println();
            HashMap<String,Integer> premiosPorPais = new HashMap<>();
            for (circuito circ : cl.getCls()) {
                if (!premiosPorPais.containsKey(circ.getCountry())) {
                    premiosPorPais.put(circ.getCountry(), 1);
                } else {
                    premiosPorPais.put(circ.getCountry(), premiosPorPais.get(circ.getCountry())+1);
                }
            }
            premiosPorPais.entrySet().stream().filter(p->p.getValue()>=0).forEach(System.out::println);
        }catch(JAXBException | IOException e) {
            e.printStackTrace();
        }

    }
}