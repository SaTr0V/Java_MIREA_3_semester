import java.util.Scanner;

public class main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        try {
            System.out.print("Введите годовую процентную ставку (например, 8.25): ");
            double annualInterestRate = in.nextDouble();

            System.out.print("Введите срок кредита в годах: ");
            int numberOfYears = in.nextInt();

            System.out.print("Введите сумму кредита: ");
            double loanAmount = in.nextDouble();

            Loan loan = new Loan(annualInterestRate, numberOfYears, loanAmount);

            System.out.println("Дата получения кредита: " + loan.getLoanDate());
            System.out.println("Ежемесячный платеж: " + loan.getMonthlyPayment());
            System.out.println("Общая сумма платежа: " + loan.getTotalPayment());

        }
        catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }
        catch (Exception e) {
            System.out.println("Произошла ошибка при вводе данных");
        }
    }
}
