package pl.polsl.bookstore.profit;

public class ProfitPerBook {

    String title;
    Float profit;

    public ProfitPerBook() {
    }

    public ProfitPerBook(String title, Float profit) {
        this.title = title;
        this.profit = profit;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Float getProfit() {
        return profit;
    }

    public void setProfit(Float profit) {
        this.profit = profit;
    }
}
