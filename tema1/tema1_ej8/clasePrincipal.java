import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;

import java.nio.file.Path;
import java.util.ArrayList;


public class clasePrincipal {
    public static void main(String[] args) {
        Path fichero = Path.of("tema1/tema1_ej8/formula1_2021season_calendar.xml");
        JAXBContext context = null;
        try {
            context = JAXBContext.newInstance(calendar.class);
            Unmarshaller jaxbUnmarshaller = context.createUnmarshaller();
            arrayListCalendario cl = (arrayListCalendario) jaxbUnmarshaller.unmarshal(fichero.toFile());

            ArrayList<calendar> c = cl.getCls();

            for (calendar cale: c) {
                System.out.println(cale.getRound()+", "+cale.getCountry()+ ", "+cale.getCircuitname()+", "+cale.getGpname()+", "+cale.getRacedate()+", "+cale.getFirstgp()+", "+cale.getNumberoflaps()+", "+cale.getCircuitlength()+", "+cale.getRacedistance()+", "+cale.getLaprecord()+", "+cale.getRecordowner()+", "+cale.getRecordyear()+", "+cale.getTurns()+", "+cale.getDrszones());
            }

        }catch(JAXBException e) {
            e.printStackTrace();
        }

    }
}
