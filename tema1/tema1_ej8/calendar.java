import java.util.Date;

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

    public String getCircuitName() {
        return circuitName;
    }

    public void setCircuitName(String circuitName) {
        this.circuitName = circuitName;
    }

    public String getGpName() {
        return gpName;
    }

    public void setGpName(String gpName) {
        this.gpName = gpName;
    }

    public Date getRaceDate() {
        return raceDate;
    }

    public void setRaceDate(Date raceDate) {
        this.raceDate = raceDate;
    }

    public String getFirstGP() {
        return firstGP;
    }

    public void setFirstGP(String firstGP) {
        this.firstGP = firstGP;
    }

    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }

    public double getCircuitLength() {
        return circuitLength;
    }

    public void setCircuitLength(double circuitLength) {
        this.circuitLength = circuitLength;
    }

    public double getRaceDistance() {
        return raceDistance;
    }

    public void setRaceDistance(double raceDistance) {
        this.raceDistance = raceDistance;
    }

    public String getLapRecord() {
        return lapRecord;
    }

    public void setLapRecord(String lapRecord) {
        this.lapRecord = lapRecord;
    }

    public String getRecordOwner() {
        return recordOwner;
    }

    public void setRecordOwner(String recordOwner) {
            this.recordOwner = recordOwner;
    }

    public String getRecordYear() {
        return recordYear;
    }

    public void setRecordYear(String recordYear) {
        this.recordYear = recordYear;
    }

    public int getTurns() {
        return turns;
    }

    public void setTurns(int turns) {
        this.turns = turns;
    }

    public int getDrs() {
        return drs;
    }

    public void setDrs(int drs) {
        this.drs = drs;
    }
}
