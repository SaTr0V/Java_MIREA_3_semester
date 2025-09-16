import java.util.Scanner;

public class Main {
    public static void main(String args[]) {

        Scanner in = new Scanner(System.in);
        System.out.print("Yuan: ");
        double yuan = in.nextInt();

        double roubles = yuan * 11.91;

        System.out.println(yuan + " Yuan = " + roubles + " Roubles");
    }
}