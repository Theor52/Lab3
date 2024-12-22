public class Item {
    private ItemName name;
    private SellIn sellIn;
    private ItemQuality quality;

    public Item(String name, int sellIn, int quality) {
        this.name = new ItemName(name);
        this.sellIn = new SellIn(sellIn);
        this.quality = new ItemQuality(quality);
    }

    public String getName() {
        return name.getName();
    }

    public int getSellInDays() {
        return sellIn.getDays();
    }

    public void decreaseSellInDays() {
        sellIn.setDays(sellIn.getDays() - 1);
    }

    public int getQuality() {
        return quality.getQuality();
    }

    public void setQuality(int value) {
        quality.setQuality(value);
    }

    public void increaseQuality() {
        if (quality.getQuality() < 50) {
            quality.setQuality(quality.getQuality() + 1);
        }
    }

    public void decreaseQuality() {
        if (quality.getQuality() > 0) {
            quality.setQuality(quality.getQuality() - 1);
        }
    }

    @Override
    public String toString() {
        return getName() + ", " + getSellInDays() + ", " + getQuality();
    }
}