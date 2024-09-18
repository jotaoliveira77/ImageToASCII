
import java.awt.image.*;
import java.io.File;
import java.io.IOException;
import javax.imageio.*;
import java.awt.Graphics2D;

public class dontknow{

public static void main(String[]args){
String filepath = "c:\\Users\\55819\\Downloads\\xedou.jpg";
File file = new File(filepath);

try {
    BufferedImage img = ImageIO.read(new File(filepath));
    int largura = 100;
    int altura = 100;

    BufferedImage imgRedimensionada = new BufferedImage( largura,altura, BufferedImage.TYPE_INT_RGB);
    Graphics2D d = imgRedimensionada.createGraphics();
    
    d.drawImage(img, 0, 0,largura,altura,null);

    String asciiChars = "@#%*+=-:. ";
    StringBuilder asciiArt = new StringBuilder();

    for(int i=0;i< altura;i++){
        for(int j=0;j < largura;j++){
        int rgb = imgRedimensionada.getRGB(j, i);
        int r = (rgb >> 16) & 0xFF;
        int g = (rgb >> 8) & 0xFF;
        int b = rgb & 0xFF;
    
        int gray = (r + g + b) / 3; // Média dos valores RGB
        char asciiChar = asciiChars.charAt(gray * (asciiChars.length() - 1) / 255);
        asciiArt.append(asciiChar);}

        asciiArt.append("\n");


    }

    System.out.println(asciiArt.toString());


    
    
    

} catch (IOException e) {
    e.printStackTrace();
}

}

}
