package pl.polsl.bookstore.profit;

public class ProfitPerMonth {

    private int year;
    private int month;
    private float profit;

    public ProfitPerMonth(int year, int month, float profit) {
        this.year = year;
        this.month = month;
        this.profit = profit;
    }

    public ProfitPerMonth() {
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(int profit) {
        this.profit = profit;
    }
}
