import java.util.ArrayList;
import java.util.List;

public class race {
    private List<principal> race = new ArrayList();
    private String track;
    private String position;
    private int no;
    private String driver;
    private String team;
    private int startingGrid;
    private int laps;
    private String time;
    private double points;
    private String extraPoints;
    private String fastestLap;

    public race(String track, String position, int no, String driver, String team, int startingGrid, int laps, String time, double points, String extraPoints, String fastestLap) {
        this.track = track;
        this.position = position;
        this.no = no;
        this.driver = driver;
        this.team = team;
        this.startingGrid = startingGrid;
        this.laps = laps;
        this.time = time;
        this.points = points;
        this.extraPoints = extraPoints;
        this.fastestLap = fastestLap;
    }
    public race() {

    }

    public double getPoints() {
        return points;
    }

    public void setPoints(double points) {
        this.points = points;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getLaps() {
        return laps;
    }

    public void setLaps(int laps) {
        this.laps = laps;
    }

    public int getStartingGrid() {
        return startingGrid;
    }

    public void setStartingGrid(int startingGrid) {
        this.startingGrid = startingGrid;
    }

    public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getTrack() {
        return track;
    }

    public void setTrack(String track) {
        this.track = track;
    }


    public String isExtraPoints() {
        return extraPoints;
    }

    public void setExtraPoints(String extraPoints) {
        this.extraPoints = extraPoints;
    }

    public String getFastestLap() {
        return fastestLap;
    }

    public void setFastestLap(String fastestLap) {
        this.fastestLap = fastestLap;
    }

    @Override
    public String toString() {
        return "Position: " + position + ", Track: " + track + ", No: " + no + ", Driver: " + driver + ", Starting Grid: " + startingGrid + ", Time: " + time + ", Points: " + points + ", Extra Points: " + extraPoints + ", Fastest Lap: " +fastestLap;
    }

}
