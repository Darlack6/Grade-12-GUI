import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

public class aboutpanel extends JPanel{
    //Properties
    BufferedImage imgAbout = null;

    //Methods
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //background
        g.drawImage(imgAbout,0,0,null);
    }

    //Constructor
    public aboutpanel(){
        super();
        try{
            imgAbout=ImageIO.read(new File("about.png"));
        }catch(IOException e){
            System.out.println("Unable to load file");
        }
    }
}
