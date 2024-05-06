//Program Name: Newton's 2nd Law 
//Created by: Derek
//Version number: 0.1

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import javax.imageio.*;
import java.awt.image.*;
import java.awt.Font;

public class Newton2ndLaw implements ActionListener, ChangeListener{
    //properties
    double dblForce = 375;
    double dblMass = 50;
    double dblAcceleration = 7.5;
    double dblTime = 0;
    
    JFrame theframe = new JFrame("Newton's 2nd Law Simulator");
    JPanel thepanel = new JPanel();
    simulatorpanel thesimulator = new simulatorpanel();
    homepanel thehome = new homepanel();
    aboutpanel theabout = new aboutpanel();
        //menus
    JMenuBar menubar = new JMenuBar();
    JMenu SwitchScreen = new JMenu("Menu");
    JMenuItem home = new JMenuItem("Home");
	JMenuItem simulator = new JMenuItem("Simulator");
    JMenuItem about = new JMenuItem("About");
    JMenuItem help = new JMenuItem("Help");
	JMenuItem test = new JMenuItem("Test");
	JMenuItem scores = new JMenuItem("Scores");
        //sliders
    JSlider forceSlider = new JSlider(250,500);
    JSlider massSlider = new JSlider(1,100);
        //labels
    JLabel forceLabel = new JLabel("Force: "+dblForce+"N");
    JLabel massLabel = new JLabel("Mass: "+dblMass+" kg");
    JLabel accelerationLabel = new JLabel("Acceleration: "+dblAcceleration+"m/s^2");
    JLabel timeLabel = new JLabel("Time: "+dblTime+"s");
        //Buttons
    JButton start = new JButton("Start");
        //fonts
    Font Dfont = new Font("Arial",Font.PLAIN,20);
    Font SmallFont = new Font("Arial",Font.PLAIN,15);
        //timer
    Timer theTimer = new Timer(1000/48,this);

    //Methods
    public void actionPerformed(ActionEvent evt){
        if(evt.getSource() == simulator){
            theframe.setContentPane(thesimulator);
            theframe.pack();
            theframe.repaint();
        }else if(evt.getSource() == home){
            theframe.setContentPane(thehome);
            theframe.pack();
            theframe.repaint();
        }else if(evt.getSource() == about){
            theframe.setContentPane(theabout);
            theframe.pack();
            theframe.repaint();
            System.out.println("about");
        }else if(evt.getSource() == help){
            System.out.println("help");
        }else if(evt.getSource() == test){
            System.out.println("test");
        }else if(evt.getSource() == scores){
            System.out.println("scores");
        }else if(evt.getSource() == start){
            theTimer.start();
        }else if(evt.getSource() == theTimer){
            dblTime = dblTime + 1;
            double dblTimeOutput = Math.round((dblTime/48.0)*10000.0)/10000.0;
            thesimulator.intX=thesimulator.intX+acceleration(dblForce,dblMass,dblTimeOutput);
            theframe.repaint();
            if(thesimulator.intX>800){
                timeLabel.setText("Time: "+time(dblForce, dblMass)+"s");
                theTimer.stop();
                dblTime = 0;
                thesimulator.intX=-300;
                
            }
        }
    }
    public void stateChanged(ChangeEvent evt){
        if(evt.getSource() == forceSlider){
            dblForce = forceSlider.getValue();
            forceLabel.setText("Force: "+dblForce+"N");
            dblAcceleration=dblForce/dblMass;
            dblAcceleration=dblAcceleration*1000;
            dblAcceleration = Math.round(dblAcceleration);
            dblAcceleration=dblAcceleration/1000;
            accelerationLabel.setText("Acceleration: "+dblAcceleration+" m/s^2");
        }if(evt.getSource() == massSlider){
            dblMass = massSlider.getValue();
            massLabel.setText("Mass: "+dblMass+" kg");
            dblAcceleration = dblForce/dblMass;
            dblAcceleration = dblAcceleration*1000;
            dblAcceleration = Math.round(dblAcceleration);
            dblAcceleration = dblAcceleration/1000;
            accelerationLabel.setText("Acceleration: "+dblAcceleration+" m/s^2");
        }
    }
    //Constructor
    public Newton2ndLaw(){
        thepanel.setPreferredSize(new Dimension(960,540));
        thepanel.setLayout(null);
        thesimulator.setPreferredSize(new Dimension(960,540));
        thesimulator.setLayout(null);
        thehome.setPreferredSize(new Dimension(960,540));
        thehome.setLayout(null);
        theabout.setPreferredSize(new Dimension(960,540));
        theabout.setLayout(null);

        home.addActionListener(this);
        simulator.addActionListener(this);
		about.addActionListener(this);
		help.addActionListener(this);
		test.addActionListener(this);
		scores.addActionListener(this);
	
        SwitchScreen.add(home);
		SwitchScreen.add(simulator);
        SwitchScreen.add(about);
        SwitchScreen.add(help);
        SwitchScreen.add(test);
        SwitchScreen.add(scores);
        menubar.add(SwitchScreen);
        theframe.setJMenuBar(menubar);

        //simulator

            //sizes
        forceSlider.setSize(230, 50);
        forceLabel.setSize(500,50);
        massSlider.setSize(230,50);
        massLabel.setSize(500,50);
        accelerationLabel.setSize(500,60);
        timeLabel.setSize(500,60);
        start.setSize(170,30);
            //fonts
        forceLabel.setFont(Dfont);
        massLabel.setFont(Dfont);
        accelerationLabel.setFont(SmallFont);
        timeLabel.setFont(SmallFont);
        start.setFont(Dfont);

            //locations
        forceSlider.setLocation(25,50);
        forceLabel.setLocation(80,0);
        massSlider.setLocation(300,50);
        massLabel.setLocation(360,0);
        accelerationLabel.setLocation(775,-10);
        timeLabel.setLocation(775,10);
        start.setLocation(775,60);

            //sliders
        forceSlider.setPaintLabels(true);
		forceSlider.setPaintTicks(true);
		forceSlider.setMajorTickSpacing(250);
        massSlider.setPaintLabels(true);
		massSlider.setPaintTicks(true);
		massSlider.setMajorTickSpacing(99);
            //color
        start.setBackground(Color.RED);
        //start.setForeground(Color.WHITE);
        forceSlider.setBackground(Color.WHITE);
        forceSlider.setForeground(Color.BLACK);
        massSlider.setBackground(Color.WHITE);
        massSlider.setForeground(Color.BLACK);
            //adding listenners
        forceSlider.addChangeListener(this);
        massSlider.addChangeListener(this);
        start.addActionListener(this);

            //adding to panel
        thesimulator.add(forceSlider);
        thesimulator.add(forceLabel);
        thesimulator.add(massSlider);
        thesimulator.add(massLabel);
        thesimulator.add(accelerationLabel);
        thesimulator.add(timeLabel);
        thesimulator.add(start);

        theframe.setContentPane(thehome);
		theframe.pack();
        theframe.setResizable(false);
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theframe.setVisible(true);
    }
    
    //Main Method
    public static void main(String[] args){
        new Newton2ndLaw();
    }

    //Acceleration Method
    public static int acceleration(double dblForce,double dblMass,double dblTime){
        double dblDisplacement;
        int intDisplacement = 0;
        double dblT, dblA;
        //D = 300, v1=0, a= f/m, t=?; 
        
        dblA = dblForce/dblMass;

        //d=at^2/2
        //2(d-v1t)/a
        dblT = Math.round(Math.sqrt(50/dblA)*10000.0)/10000.0;
        System.out.println(dblT);

        dblDisplacement = (dblA*Math.pow(dblTime,2))/2;
        intDisplacement = (int) Math.round(dblDisplacement);
        return intDisplacement;
    }
    public static double time(double dblForce,double dblMass){
        double dblT, dblA;
        //D = 300, v1=0, a= f/m, t=?; 
        
        dblA = dblForce/dblMass;

        //d=at^2/2
        //2(d-v1t)/a
        dblT = Math.round(Math.sqrt(50/dblA)*10000.0)/10000.0;
        return dblT;
    }
}