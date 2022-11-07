import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;

import java.util.ArrayList;

@XmlRootElement( name = "calendar")
public class arrayListCalendario {
    private ArrayList<calendar> cls = new ArrayList<>();
    public arrayListCalendario() {

    }
    @XmlElement (name = "race")
    public ArrayList<calendar> getCls() {
        return cls;
    }

    public void setCls(ArrayList<calendar> cls) {
        this.cls = cls;
    }
}
