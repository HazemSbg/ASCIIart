import marvin.image.MarvinImage;
import marvin.io.MarvinImageIO;

public class Main {
    public static void main(String[] args) {

        MarvinImage image = MarvinImageIO.loadImage("ascii-pineapple.jpg");

        int width = image.getWidth();
        int height = image.getHeight();

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

        // Declaring the matrix of brightness
        int[][] brightness = new  int[height][width];
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                brightness[y][x] = ((tuples[y][x].getRed() + tuples[y][x].getGreen() + tuples[y][x].getBlue()) / 3);
            }
        }

        String allAsciiOptions = "`^\",:;Il!i~+_-?][}{1)(|\\/tfjrxnuvczXYUJCLQ0OZmwqpdbkhao*#MW&8%B@$";

        char[][] ascii = new char[height][width];
        double ConvertedValue;
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                ConvertedValue = brightness[y][x] * (allAsciiOptions.length() - 1) / 255.0;
                int element = (int) Math.round(ConvertedValue);
                ascii[y][x] = allAsciiOptions.charAt(element);
            }
        }

        // Displaying the image
        for (int y = 0; y < height; y++) {
            System.out.println();
            for (int x = 0; x < width; x++) {
                System.out.print(ascii[y][x]);
            }
        }

    }
}