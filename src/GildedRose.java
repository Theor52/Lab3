class GildedRose {
    Item[] items;

    public GildedRose(Item[] items) {
        this.items = items;
    }

    public void updateQuality() {
        for (int i = 0; i < items.length; i++) {
            updateItemQuality(items[i]);
        }
    }

    private void updateItemQuality(Item item) {
        if (isLegendary(item)) {
            return;
        }

        if (isSpecialItem(item)) {
            updateSpecialItem(item);
        } else {
            decreaseQuality(item);
        }

        decreaseSellIn(item);

        if (item.sellIn < 0) {
            handleExpiredItem(item);
        }
    }

    private boolean isLegendary(Item item) {
        return item.name.equals("Sulfuras, Hand of Ragnaros");
    }

    private boolean isSpecialItem(Item item) {
        return item.name.equals("Aged Brie") || item.name.equals("Backstage passes to a TAFKAL80ETC concert");
    }

    private void updateSpecialItem(Item item) {
        increaseQuality(item);

        if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            if (item.sellIn < 11) {
                increaseQuality(item);
            }

            if (item.sellIn < 6) {
                increaseQuality(item);
            }
        }
    }

    private void handleExpiredItem(Item item) {
        if (item.name.equals("Aged Brie")) {
            increaseQuality(item);
        } else if (item.name.equals("Backstage passes to a TAFKAL80ETC concert")) {
            item.quality = 0;
        } else {
            decreaseQuality(item);
        }
    }

    private void increaseQuality(Item item) {
        if (item.quality < 50) {
            item.quality++;
        }
    }

    private void decreaseQuality(Item item) {
        if (item.quality > 0) {
            item.quality--;
        }
    }

    private void decreaseSellIn(Item item) {
        item.sellIn--;
    }
}
