import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

public class simulatorpanel extends JPanel{
    /**properties*/
    BufferedImage imgBox = null;
    int intX=-300;
    /**methods*/
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        /**draws background*/
        g.setColor(Color.WHITE);
        g.fillRect(0,0, 960, 540);
        /**draws box at position intX which is calculated using the acceleration method*/
        g.drawImage(imgBox,intX,100,null);
    }
    /**gets image from jar file, if not found, uses from local file*/
    public BufferedImage loadImage(String strFileName){
        InputStream imageclass = null;
        imageclass = this.getClass().getResourceAsStream(strFileName);
        if(imageclass == null){

        }else{
            try{
                return ImageIO.read(imageclass);
            }catch(IOException e){
                System.out.println("Unable to load file");
            }
        }
        try{
            System.out.println("loading from file");
            BufferedImage theimage = ImageIO.read(new File(strFileName));
            return theimage;
        }catch(IOException e){
            System.out.println("Unable to load local image file: \""+strFileName+"\"");
            return null;
        }
    }
    /**constructor*/
    public simulatorpanel(){
        super();
        imgBox = loadImage("box.png");
    }
}
