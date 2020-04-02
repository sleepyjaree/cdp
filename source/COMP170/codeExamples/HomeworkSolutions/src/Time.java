/**
 * Class Time implements programming project 3 from chapter 6
 */
public class Time {

    private int hour, minute;

    public Time() {
        hour = 0;
        minute = 0;
    } // default constructor

    /**
     * Method to ensure that the values passed to constructors are within the
     * appropriate range for hours in 24-hour format and minutes.
     * @param h value of hour in 24-hour format
     * @param m minutes
     * @return true if h:[0,23] and m:[0,59]; false otherwise
     */
    public boolean isValid(int h, int m) {
        return (h>=0 && h<=24) && (m>=0 && m<=59);
    } // method isValid

    /**
     * A mutator for both fields of class Time (hour, minute)
     * @param h value of hour in 24-hour format
     * @param m minutes
     */
    public void setTime(int h, int m) {
        if (isValid(h,m)) {
            hour = h;
            minute = m;
        }
    } // method setTime

    /**
     * A mutator for both fields of class Time (hour, minute) allowing the value for
     * field hour to be entered in 12-hour format [0,11] followed by an boolean
     * flag indicating if it's ante or post-meridiem time (AM/PM).
     * @param h value of hour in 12-hour format
     * @param m minutes
     * @param isAM flag for ante/post meridiem time
     */
    public void setTime(int h, int m, boolean isAM) {
        if (h>-1 && h<13) {
            if (!isAM) { h=h+12; }
            if (isValid(h, m)) {
                hour = h;
                minute = m;
            }
        }
    } // method setTime AM/PM conversion

    /**
     * Yet another mutator only for field hour to enable/disable dayling saving
     * time by adding/subtracting 1 hour (spring-forward/fall-back)
     * This is one of the two analogous methods required by Programing Project 3.
     * @param daylightSaving is set to "on" to switch to DST, "off" to return to ST
     */
    public void setTime(String daylightSaving) {
        if (daylightSaving.equals("on")) {
            hour = (hour+1) % 24;
        } else if (daylightSaving.equals("off")) {
            if (hour==0) {
                hour = 23;
            } else {
                hour = hour-1;
            }
        }
    } // method setTime for DST on/off

    /**
     * One last mutator for field hour, allowing the user to time the time to
     * h:00, i.e., the top of the hour.
     * This is one of the two analogous methods required by Programing Project 3.
     * @param h value of hour in 24-hour format
     */
    public void setTime(int h) {
        hour = h;
        minute = 0;
    } // method setTime, set to the hour

    /**
     * A accessor method to return a string with the time shown in military/24hr format
     * @return a string with the time in military format
     */
    public String getTime24() {
        String time24 = String.format("%02d",hour) + String.format("%02d",minute);
        return  time24;
    }

    /**
     * A accessor method to return a string with the time shown in AM/PM format
     * @return a string with the time in AM/PM format
     */
    public String getTime12() {
        String time12 = new String(" PM");
        if (hour < 12) { time12 = " AM"; }
        time12 = String.format("%1d",hour) +":"+ String.format("%02d",minute) + time12;
        return time12;
    }

    /**
     * Main method, mainly for quick testing and verification purposes
     */
    public static void main(String[] args) {
        Time myClock = new Time();

        // test 24 and 12-hour formats
        for (int h=0;h<24;h+=2) {
            System.out.print("\n\nTesting DST/ST mutator: ");
            myClock.setTime(h);
            myClock.setTime("off");
            System.out.print(myClock.getTime24()+"->"+myClock.getTime12());
            myClock.setTime("on");
            System.out.print("    "+myClock.getTime24()+"->"+myClock.getTime12()+"\n");
            System.out.print("Testing 12/14hr accessors: ");
            for (int m=6;m<90;m+=12) {
                myClock.setTime(h, m);
                System.out.print(myClock.getTime24()+"->"+myClock.getTime12()+"    ");
            }
        }
    }
}