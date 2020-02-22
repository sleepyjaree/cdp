
public class FancyRegistrar {

    public static void main(String[] args) {

        Student s[] = new Student[10];

        s[0] = new Student("Leo", "Irakliotis", "Bachelor");
        s[1] = new Student("Konstantin", "Laufer", "Masters");
        s[2] = new Student("Sarah", "Russe", "Ph.D.");

        int i = 0 ;
        do {
            if (s[i] != null) {
                System.out.println("This student: "+
                        s[i].getNames()+" is " +
                        s[i].undergradOrGrad());
            } // end if
            i++;
        } while (i<10);
    }
}
