import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class principal {
    private static final String COMMA_DELIMITER = ",";

    public static void main(String[] args) {
        List<List<String>> race = new ArrayList<>();
        List<List<String>> sprint = new ArrayList<>();
        List<raceResults> race2 = new ArrayList<raceResults>();
        List<sprintQualifyingResults> sprint2 = new ArrayList<>();
        try (FileReader fr = new FileReader("tema1/tema1_ej7/formula1_2021season_raceResults.csv"); BufferedReader br = new BufferedReader(fr)){
            String linea;
            br.readLine();
            while ((linea = br.readLine()) != null) {
                String[] piloto = linea.split(COMMA_DELIMITER);
                race.add(Arrays.asList(piloto));
                raceResults r = new raceResults();
                r.setTrack(piloto[0]);
                r.setPosition(piloto[1]);
                r.setNo(Integer.parseInt(piloto[2]));
                r.setDriver(piloto[3]);
                r.setTeam(piloto[4]);
                r.setStartingGrid(Integer.parseInt(piloto[5]));
                r.setLaps(Integer.parseInt(piloto[6]));
                r.setTime(piloto[7]);
                r.setPoints(Double.parseDouble(piloto[8]));
                r.setExtraPoints(piloto[9]);
                r.setFastestLap(piloto[10]);
                race2.add(r);
            }
            /*for (raceResults ra : race2) {
                System.out.println(ra.toString());
            }*/
            double acum = 0;
            race2.stream().filter(p-> Objects.equals(p.getDriver(), "Max Verstappen")).forEach(System.out::println);
            System.out.println(race2.stream().filter(p -> Objects.equals(p.getDriver(), "Max Verstappen")).mapToDouble(p -> p.getPoints()).sum());

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
