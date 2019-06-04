package pl.polsl.bookstore.profit;

public class ProfitPerAuthor {
    private String firstName;
    private String Surname;
    private float profit;

    public ProfitPerAuthor() {
    }

    public ProfitPerAuthor(String firstName, String surname, float profit) {
        this.firstName = firstName;
        Surname = surname;
        this.profit = profit;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSurname() {
        return Surname;
    }

    public void setSurname(String surname) {
        Surname = surname;
    }

    public float getProfit() {
        return profit;
    }

    public void setProfit(float profit) {
        this.profit = profit;
    }
}
