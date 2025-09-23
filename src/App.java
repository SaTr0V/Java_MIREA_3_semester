import java.util.Scanner;

public class App {
    private MonthService monthService;
    private Validate inputValidator;

    public App() {
        this.monthService = new MonthService();
        this.inputValidator = new Validate();
    }

    public static void main(String[] args) {
        new App().start();
    }

    public void start() {
        Scanner in = new Scanner(System.in);

        try {
            System.out.println("ОПРЕДЕЛЕНИЕ КОЛИЧЕСТВА ДНЕЙ В МЕСЯЦЕ");

            // Получаем номер месяца
            int month_number = inputValidator.getMonthNumber(in);

            Month month;

            // Если выбран февраль, запрашиваем год
            if (month_number == 2) {
                int year = inputValidator.getYear(in, "Введите год для проверки количества дней в феврале: ");
                month = Month.createWithYear(month_number, year, monthService);
            }
            else {
                month = Month.createWithoutYear(month_number, monthService);
            }

            month.displayInfo();
        }
        catch (Exception e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
    }
}