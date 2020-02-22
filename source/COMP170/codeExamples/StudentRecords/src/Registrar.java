
public class Registrar {

    public static void main(String[] args) {

        Student s1 = new Student("Leo", "Irakliotis", "Bachelor");
        Student s2 = new Student("Konstantin", "Laufer", "Masters");
        Student s3 = new Student("Sarah", "Russe", "Ph.D.");

        System.out.println("This student: "+
                s1.getNames()+" is " +
                s1.undergradOrGrad());

        System.out.println("This student: "+
                s2.getNames()+" is " +
                s2.undergradOrGrad());

        System.out.println("This student: "+
                s3.getNames()+" is " +
                s3.undergradOrGrad());

    }

} // class Registrar