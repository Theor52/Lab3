import java.util.List;

class GildedRose {
    private final Items items;

    public GildedRose(Items items) {
        this.items = items;
    }

    public void updateQuality() {
        items.updateQuality();
    }
}

class Items {
    private final List<Item> itemList;

    public Items(List<Item> itemList) {
        this.itemList = itemList;
    }

    public void updateQuality() {
        for (Item item : itemList) {
            updateItemQuality(item);
        }
    }

    private void updateItemQuality(Item item) {
        if (isLegendary(item)) {
            return;
        }

        if (isSpecialItem(item)) {
            updateSpecialItem(item);
            item.decreaseSellInDays();
            if (item.getSellInDays() < 0) {
                item.increaseQuality();
            }
            return;
        }

        item.decreaseQuality();
        item.decreaseSellInDays();
        if (item.getSellInDays() >= 0) {
            return;
        }

        if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.setQuality(0);
            return;
        }

        item.decreaseQuality();
    }

    private boolean isLegendary(Item item) {
        return item.getName().equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isSpecialItem(Item item) {
        return item.getName().equals("Aged Brie") 
            || item.getName().equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private void updateSpecialItem(Item item) {
        item.increaseQuality();

        if (item.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.getSellInDays() < 11) {
                item.increaseQuality();
            }

            if (item.getSellInDays() < 6) {
                item.increaseQuality();
            }
        }
    }
}