import java.awt.*;
import javax.swing.*;
import java.io.*;
import javax.imageio.*;
import java.awt.image.*;

public class testpanel extends JPanel{
    //Properties
    BufferedImage imgTest = null;

    //Methods
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        //background
        g.drawImage(imgTest,0,0,null);
    }

    //Constructor
    public testpanel(){
        super();
        try{
            imgTest=ImageIO.read(new File("test.png"));
        }catch(IOException e){
            System.out.println("Unable to load file");
        }
    }
}
