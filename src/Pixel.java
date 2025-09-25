public class Pixel {

    // Attributes
    private int red;
    private int green;
    private int blue;

    Pixel(int red, int green, int blue) {
        this.setRed(red);
        this.setGreen(green);
        this.setBlue(blue);
    }

    // Getters
    public int  getRed() {
        return this.red;
    }
    public int getGreen() {
        return this.green;
    }
    public int getBlue() {
        return this.blue;
    }

    // Setters
    public void setRed(int red) {
        this.red = red;
    }
    public void setGreen(int green) {
        this.green = green;
    }
    public void setBlue(int blue) {
        this.blue = blue;
    }

    @Override
    public String toString() {
        return "(" + this.getRed() + " ," + this.getGreen() + " ," + this.getBlue() + ")";
    }






}
