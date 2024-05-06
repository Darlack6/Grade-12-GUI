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

    //Constructor
    public simulatorpanel(){
        super();
        try{
            imgBox=ImageIO.read(new File("box.png"));
        }catch(IOException e){
            System.out.println("Unable to load file");
        }
    }
}
