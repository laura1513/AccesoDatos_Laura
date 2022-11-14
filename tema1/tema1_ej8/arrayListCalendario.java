import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;

@XmlRootElement( name = "calendar")
public class arrayListCalendario {
    private ArrayList<circuito> cls = null;

    @XmlElement (name = "race")
    public ArrayList<circuito> getCls() {
        return cls;
    }

    public void setCls(ArrayList<circuito> cls) {
        this.cls = cls;
    }
}
