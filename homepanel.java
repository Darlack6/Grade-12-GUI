import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

public class homepanel extends JPanel{
    //Properties
    BufferedImage imgHome = null;

    //Methods
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //background
        g.drawImage(imgHome,0,0,null);
    }

    //Constructor
    public homepanel(){
        super();
        try{
            imgHome=ImageIO.read(new File("home.png"));
        }catch(IOException e){
            System.out.println("Unable to load file");
        }
    }
}
