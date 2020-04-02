public class dice {
    public static void main(String[] args) {
        int i,j,k;
        for (i=1; i<7; i++) {
            for (j=1;j<7; j++) {
                for (k=1;k<7; k++)
                    System.out.println(i+j+k+"\t"+i+"\t"+j+"\t"+k);
            }
        }
    }
}
