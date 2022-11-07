import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.nio.file.Path;


public class clasePrincipal {
    public static void main(String[] args) {
        Path fichero = Path.of("tema1/tema1_ej8", "formula1_2021season_calendar.xml");
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(calendar.class);
            Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
            calendar cl = (calendar) jaxbUnmarshaller.unmarshal(fichero.toFile());
            System.out.println("Nombre: "+cl.getCircuitName());

        }catch(JAXBException e) {
            e.printStackTrace();
        }

    }
}
