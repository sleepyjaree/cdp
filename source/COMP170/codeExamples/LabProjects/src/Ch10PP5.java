/**
 * Class for Savitch, Ch. 10, Prog. Project 5
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Ch10PP5 {

    private static final int MAX_ABBREVIATIONS = 10;
    private static final String ABBREVIATIONS_FILENAME = "abbreviations.txt";
    private static final String INPUT_FILENAME = "inputMessage.txt";
    private String[] abbreviations = new String[MAX_ABBREVIATIONS];
    private String readText="";
    private String markedUpText="";
    private int used;


    /**
     * loads abbreviations from file into array
     */
    public void loadAbbreviations()  {
        Scanner s=null;
        used = 0;
        try
        {
            s = new Scanner(new File(ABBREVIATIONS_FILENAME));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error opening file "+ABBREVIATIONS_FILENAME);
            System.exit(0);
        }
        while (s.hasNextLine() && used<MAX_ABBREVIATIONS) {
            abbreviations[used] = s.nextLine();
            System.out.println("Loaded: ["+abbreviations[used]+"] at position: "+used);
            used++;
        }
    }

    /**
     * reads text file into one large string
     */
    public void readTextMessage() {
        Scanner s=null;
        try
        {
            s = new Scanner(new File(INPUT_FILENAME));
        }
        catch(FileNotFoundException e)
        {
            System.out.println("Error opening file "+INPUT_FILENAME);
            System.exit(0);
        }
        while (s.hasNextLine()) {
            readText = readText + " " + s.nextLine();
        }
    }

    /**
     * marks up occurrences of abbreviations with <> enclosures
     */
    public void markUp() {
        // loop over abbreviations
        // for each abbreviation:
        //   scan readText.lower()
        //   find if abbreviation[i].lower in readText.lower()
        //   mark position
        //   add <>
        //   build new string
        String replaceThis, withThis;
        markedUpText = readText;
        for (int i=0; i<used; i++) {
            replaceThis = abbreviations[i] + " ";
            withThis = "<" + abbreviations[i] + "> ";
            markedUpText = markedUpText.replace(replaceThis, withThis);
            replaceThis = " "+abbreviations[i] ;
            withThis = " <" + abbreviations[i] + ">";
            markedUpText = markedUpText.replace(replaceThis, withThis);

        }

    }

    public static void main(String args[]) {
        Ch10PP5 demo = new Ch10PP5();
        demo.loadAbbreviations();
        demo.readTextMessage();
        System.out.println(demo.readText);
        demo.markUp();
        System.out.println(demo.markedUpText);
    }

}
