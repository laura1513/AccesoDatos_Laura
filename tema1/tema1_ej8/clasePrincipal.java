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
        /*List<race> races = new ArrayList<>();
        List<sprint> sprint = new ArrayList<>();*/
        Path fichero = Path.of("tema1/tema1_ej8/formula1_2021season_calendar.xml");
        JAXBContext context = null;
        try (FileReader fr = new FileReader("tema1/tema1_ej8/formula1_2021season_raceResults.csv");
             BufferedReader br = new BufferedReader(fr);
             FileReader f = new FileReader("tema1/tema1_ej8/formula1_2021season_sprintQualifyingResults.csv");
             BufferedReader b = new BufferedReader(f)){

            context = JAXBContext.newInstance(arrayListCalendario.class);
            Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();

            arrayListCalendario cl = (arrayListCalendario) jaxbUnmarshaller.unmarshal(fichero.toFile());

            ArrayList<circuito> c = cl.getCls();
            for (circuito ci : cl.getCls()) {
                System.out.println(ci.toString());
            }
            /*HashMap<String, String> ganadorPremio = new HashMap<>();
            for (race ci : races) {
                if(!ganadorPremio.containsKey(ci.getTrack().getGpname())) {
                    ganadorPremio.put(ci.getTrack().getGpname(), ci.getDriver());
                }
            }
            ganadorPremio.entrySet().stream().forEach(System.out::println);*/
        }catch(JAXBException | IOException e) {
            e.printStackTrace();
        }

    }
}
