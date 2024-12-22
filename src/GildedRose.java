public class GildedRose {
    private final Items items;

    public GildedRose(Items items) {
        this.items = items;
    }

    public void updateQuality() {
        items.updateQuality();
    }
}