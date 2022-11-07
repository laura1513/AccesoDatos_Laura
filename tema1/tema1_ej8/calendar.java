import jakarta.xml.bind.annotation.XmlAttribute;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.Date;

@XmlRootElement (name = "race")
@XmlType (propOrder = {"round", "country", "city", "circuitname", "gpname", "racedate", "firstgp", "numberoflaps", "circuitlength", "racedistance", "laprecord", "recordowner", "recordyear", "turns", "drszones"})
public class calendar {
    private int round;
    private String country;
    private String city;
    private String circuitname;
    private String gpname;
    private Date racedate;
    private String firstgp;
    private int numberoflaps;
    private double circuitlength;
    private double racedistance;
    private String laprecord;
    private String recordowner;
    private String recordyear;
    private int turns;
    private int drszones;

    public calendar() {

    }
    @XmlAttribute(name = "round")
    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    @XmlElement(name = "country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @XmlElement(name = "city")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @XmlElement(name = "circuitname")
    public String getCircuitname() {
        return circuitname;
    }

    public void setCircuitname(String circuitname) {
        this.circuitname = circuitname;
    }

    @XmlElement(name = "gpname")
    public String getGpname() {
        return gpname;
    }

    public void setGpname(String gpname) {
        this.gpname = gpname;
    }

    @XmlElement(name = "racedate")
    public Date getRacedate() {
        return racedate;
    }

    public void setRacedate(Date racedate) {
        this.racedate = racedate;
    }

    @XmlElement(name = "firstgp")
    public String getFirstgp() {
        return firstgp;
    }

    public void setFirstgp(String firstgp) {
        this.firstgp = firstgp;
    }

    @XmlElement(name = "numberoflaps")
    public int getNumberoflaps() {
        return numberoflaps;
    }

    public void setNumberoflaps(int numberoflaps) {
        this.numberoflaps = numberoflaps;
    }

    @XmlElement(name = "circuitlength")
    public double getCircuitlength() {
        return circuitlength;
    }

    public void setCircuitlength(double circuitlength) {
        this.circuitlength = circuitlength;
    }

    @XmlElement(name = "racedistance")
    public double getRacedistance() {
        return racedistance;
    }

    public void setRacedistance(double racedistance) {
        this.racedistance = racedistance;
    }

    @XmlElement(name = "laprecord")
    public String getLaprecord() {
        return laprecord;
    }

    public void setLaprecord(String laprecord) {
        this.laprecord = laprecord;
    }

    @XmlElement(name = "recordowner")
    public String getRecordowner() {
        return recordowner;
    }

    public void setRecordowner(String recordowner) {
            this.recordowner = recordowner;
    }

    @XmlElement(name = "recordyear")
    public String getRecordyear() {
        return recordyear;
    }

    public void setRecordyear(String recordyear) {
        this.recordyear = recordyear;
    }

    @XmlElement(name = "turns")
    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

    @XmlElement(name = "drszones")
    public int getDrszones() {
        return drszones;
    }

    public void setDrszones(int drszones) {
        this.drszones = drszones;
    }
}
