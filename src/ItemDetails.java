public class ItemDetails {
    private ItemName name;
    private ItemQuality quality;

    public ItemDetails(String name, int quality) {
        this.name = new ItemName(name);
        this.quality = new ItemQuality(quality);
    }

    public String getName() {
        return name.getName();
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
} 