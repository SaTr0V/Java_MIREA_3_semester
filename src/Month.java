public class Month {
    private String month_name;
    private int days_in_month;
    private int year;
    private boolean is_leap_year;

    private Month(String month_name, int days_in_month, int year, boolean is_leap_year) {
        this.month_name = month_name;
        this.days_in_month = days_in_month;
        this.year = year;
        this.is_leap_year = is_leap_year;
    }

    // Метод для создания объекта MonthInfo без года (все кроме февраля)
    public static Month createWithoutYear(int monthNumber, MonthService monthService) {
        String monthName = monthService.getMonthName(monthNumber);
        int daysInMonth = monthService.getBaseDaysInMonth(monthNumber);

        // Для месяцев кроме февраля год не важен
        return new Month(monthName, daysInMonth, 0, false);
    }

    // Метод для создания объекта Month с годом (для февраля)
    public static Month createWithYear(int month_number, int year, MonthService monthService) {
        String monthName = monthService.getMonthName(month_number);
        int daysInMonth = monthService.getDaysInMonth(month_number, year);
        boolean isLeap = monthService.isLeapYear(year);

        return new Month(monthName, daysInMonth, year, isLeap);
    }

    // Геттеры
    public String getMonthName() { return month_name; }
    public int getDaysInMonth() { return days_in_month; }
    public int getYear() { return year; }
    public boolean isLeapYear() { return is_leap_year; }

    public void displayInfo() {
        System.out.println("\nИНФОРМАЦИЯ О МЕСЯЦЕ");
        System.out.println("Месяц: " + month_name);
        System.out.println("Количество дней: " + days_in_month);

        if (month_name.equals("февраль")) {
            System.out.println("Год: " + year);
            System.out.println("Високосный год: " + (is_leap_year ? "да" : "нет"));
        }
        System.out.println("--------------------------\n");
    }
}