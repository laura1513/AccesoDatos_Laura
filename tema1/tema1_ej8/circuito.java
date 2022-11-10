import jakarta.xml.bind.annotation.*;

import java.util.Date;

@XmlAccessorType (XmlAccessType.FIELD)
@XmlRootElement (name = "race")
public class circuito {
    @XmlAttribute(name = "round")
    private int round;
    @XmlElement(name = "country")
    private String country;
    @XmlElement(name = "city")
    private String city;
    @XmlElement(name = "circuitname")
    private String circuitname;
    @XmlElement(name = "gpname")
    private String gpname;
    @XmlElement(name = "racedate")
    private Date racedate;
    @XmlElement(name = "firstgp")
    private String firstgp;
    @XmlElement(name = "numberoflaps")
    private int numberoflaps;
    @XmlElement(name = "circuitlength")
    private double circuitlength;
    @XmlElement(name = "racedistance")
    private double racedistance;
    @XmlElement(name = "laprecord")
    private String laprecord;
    @XmlElement(name = "recordowner")
    private String recordowner;
    @XmlElement(name = "recordyear")
    private String recordyear;
    @XmlElement(name = "turns")
    private int turns;
    @XmlElement(name = "drszones")

    private int drszones;

    public circuito() {

    }
    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    public String getCircuitname() {
        return circuitname;
    }

    public void setCircuitname(String circuitname) {
        this.circuitname = circuitname;
    }


    public String getGpname() {
        return gpname;
    }

    public void setGpname(String gpname) {
        this.gpname = gpname;
    }


    public Date getRacedate() {
        return racedate;
    }

    public void setRacedate(Date racedate) {
        this.racedate = racedate;
    }


    public String getFirstgp() {
        return firstgp;
    }

    public void setFirstgp(String firstgp) {
        this.firstgp = firstgp;
    }


    public int getNumberoflaps() {
        return numberoflaps;
    }

    public void setNumberoflaps(int numberoflaps) {
        this.numberoflaps = numberoflaps;
    }


    public double getCircuitlength() {
        return circuitlength;
    }

    public void setCircuitlength(double circuitlength) {
        this.circuitlength = circuitlength;
    }


    public double getRacedistance() {
        return racedistance;
    }

    public void setRacedistance(double racedistance) {
        this.racedistance = racedistance;
    }


    public String getLaprecord() {
        return laprecord;
    }

    public void setLaprecord(String laprecord) {
        this.laprecord = laprecord;
    }


    public String getRecordowner() {
        return recordowner;
    }

    public void setRecordowner(String recordowner) {
            this.recordowner = recordowner;
    }


    public String getRecordyear() {
        return recordyear;
    }

    public void setRecordyear(String recordyear) {
        this.recordyear = recordyear;
    }


    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

    public int getDrszones() {
        return drszones;
    }

    public void setDrszones(int drszones) {
        this.drszones = drszones;
    }
}
