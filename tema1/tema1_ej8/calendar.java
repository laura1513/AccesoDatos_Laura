import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.Date;

@XmlRootElement (name = "calendar")
@XmlType (propOrder = {"Round", "Country", "City", "Circuit Name", "Gp Name", "Race Date", "First gp", "Number of laps", "Circuit length", "Race distance", "Lap record", "Record owner", "Record year", "Turns", "DRS zones"})
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

    @XmlElement(name = "Round")
    public int getRound() {
        return round;
    }

    public void setRound(int round) {
        this.round = round;
    }

    @XmlElement(name = "Country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @XmlElement(name = "City")
    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @XmlElement(name = "Circuit Name")
    public String getCircuitName() {
        return circuitName;
    }

    public void setCircuitName(String circuitName) {
        this.circuitName = circuitName;
    }

    @XmlElement(name = "Gp Name")
    public String getGpName() {
        return gpName;
    }

    public void setGpName(String gpName) {
        this.gpName = gpName;
    }

    @XmlElement(name = "Race Date")
    public Date getRaceDate() {
        return raceDate;
    }

    public void setRaceDate(Date raceDate) {
        this.raceDate = raceDate;
    }

    @XmlElement(name = "First gp")
    public String getFirstGP() {
        return firstGP;
    }

    public void setFirstGP(String firstGP) {
        this.firstGP = firstGP;
    }

    @XmlElement(name = "Number of laps")
    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }

    @XmlElement(name = "Circuit length")
    public double getCircuitLength() {
        return circuitLength;
    }

    public void setCircuitLength(double circuitLength) {
        this.circuitLength = circuitLength;
    }

    @XmlElement(name = "Race distance")
    public double getRaceDistance() {
        return raceDistance;
    }

    public void setRaceDistance(double raceDistance) {
        this.raceDistance = raceDistance;
    }

    @XmlElement(name = "Lap record")
    public String getLapRecord() {
        return lapRecord;
    }

    public void setLapRecord(String lapRecord) {
        this.lapRecord = lapRecord;
    }

    @XmlElement(name = "Record ownew")
    public String getRecordOwner() {
        return recordOwner;
    }

    public void setRecordOwner(String recordOwner) {
            this.recordOwner = recordOwner;
    }

    @XmlElement(name = "Record year")
    public String getRecordYear() {
        return recordYear;
    }

    public void setRecordYear(String recordYear) {
        this.recordYear = recordYear;
    }

    @XmlElement(name = "Turns")
    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

    @XmlElement(name = "DRS zones")
    public int getDrs() {
        return drs;
    }

    public void setDrs(int drs) {
        this.drs = drs;
    }
}
