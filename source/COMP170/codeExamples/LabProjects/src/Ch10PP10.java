public class Ch10PP10 {

    private static final int MAX_RUNNERS = 1000;
    private static final int MAX_DATA_FIELDS = 3

    private int[][] raceLog = new int[3*MAX_RUNNERS][MAX_DATA_FIELDS];
    private int startTime;

    public int timeInSeconds(int h, int m, int s) {
        return h * 3600 + m * 60 + s;
    }

    public void readRaceLog() {
        // scanner s
        // try
        // catch
       boolean firstLine=true;

        while (s.hasNextLine()) {
            if (firstLine) {
                // startTime:
                // if first line - read time when race gun went off ...
                firstLine = false;
            } else {
                // read runner/sensor data
                // convert sensorID, runnerID, HH MM SS into appropriate data
                // I want an array raceLog[][]
                // raceLog[][sensorID]
                // raceLog[][runnerID]
                // raceLog[][timeInSecond(HH MM SS)]
        }
    }
    }
}
