import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;

public class Main {
    public static void main(String[] args) {

        MarvinImage image = MarvinImageIO.loadImage("yesh.jpg");

        int width = image.getWidth();
        int height = image.getHeight();
        /*  // Display the width and height
        System.out.println("Height: " + image.getHeight() + "\nWidth: " + image.getWidth() );
        */

        // Loading image's rgb into the matrix
        Pixel[][] tuples =  new Pixel[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                int r = image.getIntComponent0(x, y);
                int g = image.getIntComponent1(x, y);
                int b = image.getIntComponent2(x, y);
                tuples[y][x] = new Pixel(r, g, b);
            }
        }

        /*  // Display the matrix
        for  (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.println(tuples[y][x].toString());
            }
        }
         */

        // Declaring the matrix of brightness
        Brightness[][] brightness = new  Brightness[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                brightness[y][x] = new Brightness(tuples[y][x].getRed(), tuples[y][x].getGreen(), tuples[y][x].getBlue());
            }
        }

        /*  Display brightness matrix
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.println(brightness[x][y]);
            }
        }
        */

        String allAsciiOptions = "`^\",:;Il!i~+_-?][}{1)(|\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$";

        Ascii[][] ascii = new Ascii[height][width];
        double ConvertedValue;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                ConvertedValue = brightness[y][x].getBrightness() * (allAsciiOptions.length() - 1) / 255;
                int element = (int) Math.round(ConvertedValue);
                ascii[y][x] = new Ascii(allAsciiOptions.charAt(element));
            }
        }

        // Displaying the image
        for (int y = 0; y < height; y++) {
            System.out.println();
            for (int x = 0; x < width; x++) {
                System.out.print(ascii[y][x].getSymbol());
            }
        }



    }
}