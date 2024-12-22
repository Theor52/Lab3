public class Item {
    private ItemDetails details;
    private SellIn sellIn;

    public Item(String name, int sellIn, int quality) {
        this.details = new ItemDetails(name, quality);
        this.sellIn = new SellIn(sellIn);
    }

    public String getName() {
        return details.getName();
    }

    public int getSellInDays() {
        return sellIn.getDays();
    }

    public void decreaseSellInDays() {
        sellIn.addDays(-1);
    }

    public int getQuality() {
        return details.getQuality();
    }

    public void setQuality(int value) {
        details.setQuality(value);
    }

    public void increaseQuality() {
        details.increaseQuality();
    }

    public void decreaseQuality() {
        details.decreaseQuality();
    }

    @Override
    public String toString() {
        return getName() + ", " + getSellInDays() + ", " + getQuality();
    }
}