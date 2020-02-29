import java.util.Scanner;
public class CompletingCode {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int howMany = keyboard.nextInt();
        if (howMany>0 && howMany<80) {
            for (int i=1;i<=howMany;i++) {
                System.out.println("#".repeat(i));
            }
        }
    }
}
