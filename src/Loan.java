public class Loan {
    private double annual_interest_rate;
    private int number_of_years;
    private double loan_amount;
    private java.util.Date loan_date;

    public Loan() {
        annual_interest_rate = 2.5;
        number_of_years = 1;
        loan_amount = 1000;
    }

    // Параметризованный конструктор; используются сеттеры, так как в них установлены проверки исключений
    public Loan(double annualInterestRate, int numberOfYears, double loanAmount) {
        setAnnualInterestRate(annualInterestRate);
        setNumberOfYears(numberOfYears);
        setLoanAmount(loanAmount);
        loan_date = new java.util.Date();
    }

    // Сеттеры и геттеры
    public double getAnnualInterestRate() { return annual_interest_rate; }

    public void setAnnualInterestRate(double annual_interest_rate) {
        if (annual_interest_rate <= 0) {
            throw new IllegalArgumentException("Ошибка: годовая процентная ставка должна быть больше нуля");
        }
        this.annual_interest_rate = annual_interest_rate;
    }

    public int getNumberOfYears() { return number_of_years; }

    public void setNumberOfYears(int number_of_years) {
        if (number_of_years <= 0) {
            throw new IllegalArgumentException("Ошибка: срок кредита должен быть больше нуля");
        }
        this.number_of_years = number_of_years;
    }

    public double getLoanAmount() { return loan_amount; }

    public void setLoanAmount(double loan_amount) {
        if (loan_amount <= 0) {
            throw new IllegalArgumentException("Ошибка: сумма кредита должна быть больше нуля");
        }
        this.loan_amount = loan_amount;
    }

    public java.util.Date getLoanDate() {
        return loan_date;
    }

    // Вычисление ежемесячного платежа
    public double getMonthlyPayment() {
        double monthlyInterestRate = annual_interest_rate / 1200;
        return loan_amount * monthlyInterestRate / (1 - (1 / Math.pow(1 + monthlyInterestRate, number_of_years * 12)));
    }

    // Вычисление общей суммы платежа
    public double getTotalPayment() {
        return getMonthlyPayment() * number_of_years * 12;
    }
}
