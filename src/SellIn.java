public class SellIn {
    private int days;

    public SellIn(int days) {
        this.days = days;
    }

    public int getDays() {
        return this.days;
    }

    public void setDays(int days) {
        this.days = days;
    }

    public void addDays(int value) {
        this.days += value;
    }
}
