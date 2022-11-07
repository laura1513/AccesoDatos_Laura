import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.Date;

@XmlRootElement (name = "calendar")
@XmlType (propOrder = {"round", "country", "city", "circuitName", "gpName", "raceDate", "firstGP", "laps", "circuitLength", "raceDistance", "lapRecord", "recordOwner", "recordYear", "turns", "drs"})
public class calendar {
    private int round;
    private String country;
    private String city;
    private String circuitName;
    private String gpName;
    private Date raceDate;
    private String firstGP;
    private int laps;
    private double circuitLength;
    private double raceDistance;
    private String lapRecord;
    private String recordOwner;
    private String recordYear;
    private int turns;
    private int drs;

    @XmlElement(name = "round")
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

    @XmlElement(name = "circuitName")
    public String getCircuitName() {
        return circuitName;
    }

    public void setCircuitName(String circuitName) {
        this.circuitName = circuitName;
    }

    @XmlElement(name = "gpName")
    public String getGpName() {
        return gpName;
    }

    public void setGpName(String gpName) {
        this.gpName = gpName;
    }

    @XmlElement(name = "raceDate")
    public Date getRaceDate() {
        return raceDate;
    }

    public void setRaceDate(Date raceDate) {
        this.raceDate = raceDate;
    }

    @XmlElement(name = "firstGP")
    public String getFirstGP() {
        return firstGP;
    }

    public void setFirstGP(String firstGP) {
        this.firstGP = firstGP;
    }

    @XmlElement(name = "laps")
    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }

    @XmlElement(name = "circuitLength")
    public double getCircuitLength() {
        return circuitLength;
    }

    public void setCircuitLength(double circuitLength) {
        this.circuitLength = circuitLength;
    }

    @XmlElement(name = "raceDistance")
    public double getRaceDistance() {
        return raceDistance;
    }

    public void setRaceDistance(double raceDistance) {
        this.raceDistance = raceDistance;
    }

    @XmlElement(name = "lapRecord")
    public String getLapRecord() {
        return lapRecord;
    }

    public void setLapRecord(String lapRecord) {
        this.lapRecord = lapRecord;
    }

    @XmlElement(name = "recordOwner")
    public String getRecordOwner() {
        return recordOwner;
    }

    public void setRecordOwner(String recordOwner) {
            this.recordOwner = recordOwner;
    }

    @XmlElement(name = "recordYear")
    public String getRecordYear() {
        return recordYear;
    }

    public void setRecordYear(String recordYear) {
        this.recordYear = recordYear;
    }

    @XmlElement(name = "turns")
    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

    @XmlElement(name = "drs")
    public int getDrs() {
        return drs;
    }

    public void setDrs(int drs) {
        this.drs = drs;
    }
}
