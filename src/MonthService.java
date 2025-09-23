public class MonthService {
    private String[] months = {"январь", "февраль", "март", "апрель", "май",
            "июнь", "июль", "август", "сентябрь", "октябрь", "ноябрь", "декабрь"};
    private int[] dom = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public boolean isLeapYear(int year) {
        return (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0);
    }

    // Метод для получения названия месяца по номеру
    public String getMonthName(int month_number) {
        if (month_number < 1 || month_number > 12) {
            throw new ArrayIndexOutOfBoundsException("Номер месяца должен быть от 1 до 12");
        }
        return months[month_number - 1];
    }

    // Метод для получения количества дней в месяце
    public int getDaysInMonth(int month_number, int year) {
        if (month_number < 1 || month_number > 12) {
            throw new ArrayIndexOutOfBoundsException("Номер месяца должен быть от 1 до 12");
        }

        int days = dom[month_number - 1];

        // Особый случай для февраля
        if (month_number == 2 && isLeapYear(year)) {
            days = 29;
        }

        return days;
    }

    // Метод для получения базового количества дней (без учета високосного года)
    public int getBaseDaysInMonth(int month_number) {
        if (month_number < 1 || month_number > 12) {
            throw new ArrayIndexOutOfBoundsException("Номер месяца должен быть от 1 до 12");
        }
        return dom[month_number - 1];
    }
}