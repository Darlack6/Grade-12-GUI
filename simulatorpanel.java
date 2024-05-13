import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

public class simulatorpanel extends JPanel{
    //Properties
    BufferedImage imgBox = null;
    int intX=-300;

    //Methods
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //background
        g.setColor(Color.WHITE);
        g.fillRect(0,0, 960, 540);
        g.drawImage(imgBox,intX,100,null);
    }
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
    //Constructor
    public simulatorpanel(){
        super();
        imgBox = loadImage("box.png");
    }
}
