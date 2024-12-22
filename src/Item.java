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

class ItemName {
    private String name;

    public ItemName(String name) {
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

class ItemQuality {
    private int quality;

    public ItemQuality(int quality) {
        this.quality = quality;
    }

    public int getQuality() {
        return this.quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }
}

class SellIn {
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
}