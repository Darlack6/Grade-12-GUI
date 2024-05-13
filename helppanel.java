import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

public class helppanel extends JPanel{
    //Properties
    BufferedImage imgHelp = null;

    //Methods
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //background
        g.drawImage(imgHelp,0,0,null);
    }

    //Constructor
    public helppanel(){
        super();
        try{
            imgHelp=ImageIO.read(new File("help.png"));
        }catch(IOException e){
            System.out.println("Unable to load file");
        }
    }
}
