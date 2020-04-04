import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Class to implement programming project 10 from Savitch 8/e Ch. 10.
 * Read a half marathon race log and display runner stats. Log file
 * format:
 * +------------------------------+
 * | HH MM SS                     |  <--- header
 * | sensorID, runnerID, HH MM SS |  ) \
 * | sensorID, runnerID, HH MM SS |  ) - log entries
 * | sensorID, runnerID, HH MM SS |  ) /
 * | ...                          |
 * +------------------------------+
 * Header shows the hour (HH), minute (MM), and second (SS) the race
 * gun went off. Log show the time (HH MM SS) a runnder (runnderID),
 * crossed an RFID sensor (sensorID) along the racetrack.
 *
 * For this problem, we asuume three sensors (indexed 0, 1, 2), but
 * we introduce a static final parameter (MAX_SENSORS) to accommodate
 * easy changes and also parametric loops.
 *
 */
public class Ch10PP10 {

    private static final int MAX_RUNNERS = 10;
    private static final int MAX_SENSORS = 3;
    private static final int MAX_ROWS = MAX_RUNNERS*MAX_SENSORS;
    private static final int DATA_FIELDS = 3;
    private static final String RACELOG_FILENAME =  "racelog.txt";
    private static final int SENSOR = 0; // these are the corresponding columns in raceLog for
    private static final int RUNNER = 1; // sensor number, runner number, and time. Using these
    private static final int TIME = 2;   // variables as array indices makes code more readable.

    /**
     * While we are planning for MAX_ROWS = MAX_RUNNERS*MAX_SENSORS entries in our log array,
     * we may not fill all of them (e.g., runner drops out and does not trigger the finish line
     * sensor, etc). Field userRows counts how many rows in the race log array are actually used.
     */
    private int usedRows=0;
    private int[][] raceLog = new int[MAX_ROWS][DATA_FIELDS];
    private int startTime;

    /**
     * A method to convert time shown in h:m:s to seconds. Seconds are this class's
     * internal representation for time.
     */
    private static int timeInSeconds(int h, int m, int s) {
        return h * 3600 + m * 60 + s;
    }

    /**
     * A method to convert seconds into a string formatted HH:MM:SS
     */
    private static String timeHMS (int seconds) {
        int h = (int) Math.round(seconds/3600);
        int m = (int) Math.round((seconds-h*3600)/60);
        int s = seconds - m*60 - h*3600;
        String HMS = String.format("%02d:",h)+String.format("%02d:",m)+String.format("%02d",s);
        return HMS;
    }

    /**
     * Method to read race log, determine the time the race gun
     * went off, and assign sensor data to array raceLog.
     */
    public void readRaceLog() {
        // Set up a Scanner object to read data from the log file.
        Scanner f=null;
        try
        {
            f = new Scanner(new File(RACELOG_FILENAME));
        }
        // catch
        catch (FileNotFoundException e) {
            System.out.println("Cannot find/open file: "+RACELOG_FILENAME);
            System.exit(0);
        }

        // At this point the scanner object is successfully connected to the race log data file

        /**
         * boolean logHeader indicates whether or not we have read the first line of the
         * race log data file. We need to differentiate beteween the first line of the
         * file and the remaining lines, because the first line is formatted differently
         * and captures only the time when the race gun went off. The remaining lines
         * capture data about the times at which individual runners crossed the various RFID
         * sensors along the racetrack.
         */
        boolean logHeader=true;

        /**
         * currentLine captures each line read by the scanner.
         */
        String currentLine;

        /**
         * Each line read by the scanner and captures by currentLine is then tokenized
         * into array currentLineElements, using a single space as the delimited for split().
         * There first line of the race log file will yield three tokens and the
         * remaining lines, 5 tokens -- so we initialize this array to 5 elements.
         */
        String[] currentLineComponents = new String[5];

        int h,m,s;
        usedRows = 0;

        /**
         * The loop below reads the race log data file, one line at a time, differentiating
         * between the heading line and the remaining lines -- the differentiation is achieved
         * with boolean logHeader which remains false after the first line is read. The
         * loop performs the following tasks:
         *   - reads one line at a time
         *   - tokenizes the line accordingly (header v. runner data)
         *   - converts the tokens from Strings to Integers using Integer.parseInt()
         *   - for the header data, is registers the time of the race start into
         *     class fiels startTime
         *   - for the remaining lines, it converts their tokens into integer values
         *     for the sensor ID, the runner ID, and the time at which the runner crossed
         *     the RFID sensor, and stores them in array raceLog. Notice that for these
         *     lines, the tokens for sensorID and runnerID contain commas and we need to
         *     remove those before parsing the strings to integers. The removal is
         *     accomplished with the replace() method.
         */

        while (f.hasNextLine()) {
            currentLine = f.nextLine();
            currentLineComponents = currentLine.split(" ");
            if (logHeader) {
                logHeader = false;
                h = Integer.parseInt(currentLineComponents[0]); // currentLine token with hour value
                m = Integer.parseInt(currentLineComponents[1]); // currentLine token with minute value
                s = Integer.parseInt(currentLineComponents[2]); // currentLine token with seconds value
                startTime = timeInSeconds(h,m,s);               // h m s values are converted to the
                                                                //  Class's internal representation for time
            } else {
                raceLog[usedRows][SENSOR] = Integer.parseInt(currentLineComponents[0].replace(",",""));
                raceLog[usedRows][RUNNER] = Integer.parseInt(currentLineComponents[1].replace(",",""));
                raceLog[usedRows][TIME] = timeInSeconds(Integer.parseInt(currentLineComponents[2]),
                        Integer.parseInt(currentLineComponents[3]),
                        Integer.parseInt(currentLineComponents[4]));
                usedRows++;
            }
        }
    }

    /**
     * For future use
     */
    public boolean runnerFound(int runnerID) {
        boolean found = false;
        for (int i=0; i<usedRows;i++)
            if (raceLog[i][1]==runnerID) { found = true; }
        return found;
    }

    /**
     * For future use -- incomplete for now
     */
    public int[][] runnerRank() {
        int runners = usedRows/MAX_SENSORS; // number of runners
        int[][] ranking = new int[runners][2];
        for (int i=0;i<usedRows;i++) {
            // make a 2D array with overall time for each runner (runnerID @ [0]
            // then sort by time (@ [1]).
        }
        return ranking;
    }

    /**
     * Prints out performance data for a given runner; for now it omits shown
     * the runners overall ranking in the race, because method runnerRank above
     * is still incomplete.
     */
    public void runnerStatistics(int runnerID) {
       // assume runnerID valid
        // array raceLog has three records for each runner in ascending order of sensor
        int[] runnerTimes = new int[MAX_SENSORS];
        for (int i=0;i<MAX_SENSORS;i++) {
            for (int j=0;j<MAX_ROWS;j++) {
                // we are at row j and we want column SENSOR==i and column RUNNER==runnerID
                if ( raceLog[j][SENSOR] == i && raceLog[j][RUNNER] == runnerID) {
                    runnerTimes[i] = raceLog[j][TIME];
                }
            }
        }
        // p is a Leo method for lazy printing
        p("\nRace results for runner "+runnerID);
        p("---------------------------");
        p("Race started at "+timeHMS(startTime));
        p("Runner crossed start line at "+timeHMS(runnerTimes[0]));
        p("                 midpoint at "+timeHMS(runnerTimes[1]));
        p("      crossed finish line at "+timeHMS(runnerTimes[2]));
        p("                Overall time "+timeHMS((runnerTimes[2]-runnerTimes[0])));
        p("             First half-time "+timeHMS((runnerTimes[1]-runnerTimes[0])));
        p("            Second half-time "+timeHMS((runnerTimes[2]-runnerTimes[1])));
    }

    public static void main(String args[]) {
        Ch10PP10 demo = new Ch10PP10();
        demo.readRaceLog();
        demo.runnerStatistics(102);
    }

    /**
     * A local method so that I wont have to type System.out.printl() all the time.
     */
    public static void p(String text) {
        System.out.println(text);
    }
}
