
public class FancyRegistrar {

    public static void main(String[] args) {

        /**
         * Array s is a collection of Student objects. For illustrative
         * purposes, we hardcode the size of the array to 10; however,
         * it would be better if we parametrized the its size.
         */

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
        } while (i<10); // end do

    } // method main

} // class FancyRegistrar
