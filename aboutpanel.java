import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

public class aboutpanel extends JPanel{
    /**properties*/
    BufferedImage imgAbout = null;
    /**methods*/
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        /**draws background*/
        g.drawImage(imgAbout,0,0,null);
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
    public aboutpanel(){
        super();
        imgAbout = loadImage("about.png");
    }
}
