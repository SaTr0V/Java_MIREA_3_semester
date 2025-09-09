import java.util.Scanner;

public class Main {
    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        System.out.print("Yuan: ");
        int yuan = in.nextInt();

        double roubles = yuan * 11.91;

        if (yuan > 5 && yuan < 21) {
            System.out.print(yuan + " Юайней" + " равняется ");
        }
        else if (yuan % 10 == 1) {
            System.out.print(yuan + " Юань" + " равняется ");
        }
        else if (yuan % 10 > 1 && yuan % 10 < 5) {
            System.out.print(yuan + " Юаня" + " равняется ");
        }
        else {
            System.out.print(yuan + " Юаней" + " равняется ");
        }

        if ((int)roubles != roubles) {
            System.out.print(roubles + " Рубля.");
        }
        else {
            if (roubles % 10 == 1) {
                System.out.print(roubles + " Рублю.");
            }
            else if (roubles >= 1000 && roubles % 10 == 0) {
                System.out.print(roubles + " Рублей.");
            }
            else {
                System.out.print(roubles + " Рублям.");
            }
        }
    }
}