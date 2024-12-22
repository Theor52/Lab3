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
            decreaseSellIn(item);
            if (item.sellIn.getDays() < 0) {
                increaseQuality(item);
            }
            return;
        }

        decreaseQuality(item);
        decreaseSellIn(item);
        if (item.sellIn.getDays() >= 0) {
            return;
        }

        if (item.name.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality.setQuality(0);
            return;
        }

        decreaseQuality(item);
    }

    private boolean isLegendary(Item item) {
        return item.name.getName().equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isSpecialItem(Item item) {
        return item.name.getName().equals("Aged Brie") || item.name.getName().equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private void updateSpecialItem(Item item) {
        increaseQuality(item);

        if (item.name.getName().equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.sellIn.getDays() < 11) {
                increaseQuality(item);
            }

            if (item.sellIn.getDays() < 6) {
                increaseQuality(item);
            }
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality.getQuality() < 50) {
            item.quality.setQuality(item.quality.getQuality() + 1);
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality.getQuality() > 0) {
            item.quality.setQuality(item.quality.getQuality() - 1);
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn.setDays(item.sellIn.getDays() - 1);
    }
}