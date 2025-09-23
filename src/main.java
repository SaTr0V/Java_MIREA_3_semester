import java.util.Scanner;
import java.util.InputMismatchException;

public class main {
    public static void main(String[] args) {
        String[] months = {"январь", "февраль", "март", "апрель", "май",
                            "июнь", "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь"};
        int[] dom = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

        Scanner in = new Scanner(System.in);

        try {
            System.out.print("Введите целое число от 1 до 12: ");
            int month_number = in.nextInt();

            // Проверка, входит ли введенное число в диапазон
            if (month_number < 1 || month_number > 12) {
                throw new ArrayIndexOutOfBoundsException();
            }

            System.out.println("Месяц: " + months[month_number - 1]);
            System.out.println("Количество дней: " + dom[month_number - 1]);
        }
        catch (InputMismatchException e) {
            System.out.println("Ошибка: введено не целое число.");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Недопустимое число. Введите число от 1 до 12.");
        }
    }
}
