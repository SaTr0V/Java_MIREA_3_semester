import java.util.InputMismatchException;
import java.util.Scanner;

public class Validate {

    // Получение номера месяца от пользователя
    public int getMonthNumber(Scanner in) {
        while (true) {
            try {
                System.out.print("Введите целое число от 1 до 12: ");
                int monthNumber = in.nextInt();

                if (monthNumber < 1 || monthNumber > 12) {
                    throw new ArrayIndexOutOfBoundsException();
                }

                return monthNumber;

            }
            catch (InputMismatchException e) {
                System.out.println("Ошибка: введено не целое число. Попробуйте снова.");
                in.nextLine();  // очистка буфера
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println("Ошибка: недопустимое число. Введите число от 1 до 12.");
            }
        }
    }

    // Получение года от пользователя
    public int getYear(Scanner in, String year) {
        while (true) {
            try {
                System.out.print(year);
                return in.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Ошибка: введен неверный год. Попробуйте снова.");
                in.nextLine(); // Очистка буфера
            }
        }
    }
}