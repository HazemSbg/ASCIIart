public class Brightness {

    // Attributes
    private int brightness;

    // Constructor
    Brightness(int r, int g, int b) {
        this.brightness = (r + g + b) / 3;
    }

    // Getters
    public int getBrightness() {
        return this.brightness;
    }

    // Setters
    public void setBrightness(int brightness) {
        this.brightness = brightness;
    }

    @Override
    public String toString() {
        return "(" + this.brightness + ")";
    }
}
