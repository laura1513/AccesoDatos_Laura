public class sprintQualifyingResults {
    private String track;
    private String position;
    private int no;
    private String driver;
    private String team;
    private int startingGrid;
    private int laps;
    private double time;
    private double points;

    public sprintQualifyingResults(String track, String position, int no, String driver, String team, int startingGrid, int laps, double time, double points) {
        this.track = track;
        this.position = position;
        this.no = no;
        this.driver = driver;
        this.team = team;
        this.startingGrid = startingGrid;
        this.laps = laps;
        this.time = time;
        this.points = points;
    }
}
