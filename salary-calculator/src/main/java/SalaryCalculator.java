public class SalaryCalculator {

    private final double SALARY_BASE = 1_000.0;

    public double multiplierPerDaysSkipped(int daysSkipped) { return daysSkipped > 5 ? SALARY_BASE * 0.15 : 0; }

    public int multiplierPerProductsSold(int productsSold) {
        return productsSold < 20 ?
                productsSold * 10 :
                productsSold * 13;
    }

    public double bonusForProductSold(int productsSold) { return SALARY_BASE + multiplierPerProductsSold(productsSold); }

    public double finalSalary(int daysSkipped, int productsSold) {
        double total = bonusForProductSold(productsSold) - multiplierPerDaysSkipped(daysSkipped);

        return Math.min(total, 2000.0);

    }

}
