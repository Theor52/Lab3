public class ItemQuality {
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

    public void addQuality(int value) {
        this.quality += value;
    }
}
