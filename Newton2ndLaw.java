/** Program Name: Newton's 2nd Law */
/** Created by: Derek and Kelvin */
/** Version number: 1.0 */

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;

public class Newton2ndLaw implements ActionListener, ChangeListener{
    /**properties*/
    double dblForce = 375;
    double dblMass = 50;
    double dblAcceleration = 7.5;
    double dblTime = 0;
    double dblScore = 0;
    int intQ1 = 0;
    int intQ2 = 0;
    int intQ3 = 0;
    int intQ4 = 0;
    int intSubmit = 0;
        /**frames and panels*/
    JFrame theframe = new JFrame("Newton's 2nd Law Simulator");
    JPanel thepanel = new JPanel();
    simulatorpanel thesimulator = new simulatorpanel();
    homepanel thehome = new homepanel();
    aboutpanel theabout = new aboutpanel();
    helppanel thehelp = new helppanel();
    testpanel thetest = new testpanel();
        /**menus*/
    JMenuBar menubar = new JMenuBar();
    JMenu SwitchScreen = new JMenu("Menu");
    JMenuItem home = new JMenuItem("Home");
	JMenuItem simulator = new JMenuItem("Simulator");
    JMenuItem about = new JMenuItem("About");
    JMenuItem help = new JMenuItem("Help");
	JMenuItem test = new JMenuItem("Test");
        /**sliders*/
    JSlider forceSlider = new JSlider(250,500);
    JSlider massSlider = new JSlider(1,100);
        /**labels*/
    JLabel forceLabel = new JLabel("Force: "+dblForce+"N");
    JLabel massLabel = new JLabel("Mass: "+dblMass+" kg");
    JLabel accelerationLabel = new JLabel("Acceleration: "+dblAcceleration+"m/s^2");
    JLabel timeLabel = new JLabel("Time: "+dblTime+"s");
    JLabel scoreLabel = new JLabel("Score:");
        /**buttons*/
    JButton start = new JButton("Start");
    JButton true1 = new JButton("True");
    JButton false1 = new JButton("False");
    JButton true2 = new JButton("True");
    JButton false2 = new JButton("False");
    JButton true3 = new JButton("True");
    JButton false3 = new JButton("False");
    JButton submit = new JButton("Submit");
        /**text fields*/
    JTextField question4 = new JTextField();
    JTextField name = new JTextField("");
        /**fonts*/
    Font fntAerialLarge = new Font("Arial",Font.PLAIN,20);
    Font fntAerialSmall = new Font("Arial",Font.PLAIN,15);
        /**timer*/
    Timer theTimer = new Timer(1000/48,this);

    /**methods*/
    public void actionPerformed(ActionEvent evt){
        /**Switches to simulator screen*/
        if(evt.getSource() == simulator){
            theframe.setContentPane(thesimulator);
            theframe.pack();
            theframe.repaint();
        /**Switches to home  screen*/
        }else if(evt.getSource() == home){
            theframe.setContentPane(thehome);
            theframe.pack();
            theframe.repaint();
        /**Switches to about screen*/
        }else if(evt.getSource() == about){
            theframe.setContentPane(theabout);
            theframe.pack();
            theframe.repaint();
        /**Switches to help screen*/
        }else if(evt.getSource() == help){
            theframe.setContentPane(thehelp);
            theframe.pack();
            theframe.repaint();
        /**Switches to test screen*/
        }else if(evt.getSource() == test){
            theframe.setContentPane(thetest);
            theframe.pack();
            theframe.repaint();
        /**Starts timer*/
        }else if(evt.getSource() == start){
            theTimer.start();
        }else if(evt.getSource() == theTimer){
            dblTime = dblTime + 1;
            /**calculates total time elapsed for 25m*/
            double dblTimeOutput = Math.round((dblTime/48.0)*10000.0)/10000.0;
            /**increases the x value of the box according to the acceleration method calculation*/
            thesimulator.intX=thesimulator.intX+acceleration(dblForce,dblMass,dblTimeOutput);
            theframe.repaint();
            /**If box moves out of frame, stop the timer, update the time label and reset the position*/
            if(thesimulator.intX>800){
                timeLabel.setText("Time: "+time(dblForce, dblMass)+"s");
                theTimer.stop();
                dblTime = 0;
                thesimulator.intX=-300;
                
            }
        /**Question 1, sets intQ1 = 1 if false*/
        }else if(evt.getSource() == true1){
            true1.setForeground(Color.BLUE);
            false1.setForeground(Color.BLACK);
            intQ1=0;
        }else if(evt.getSource() == false1){
            false1.setForeground(Color.BLUE);
            true1.setForeground(Color.BLACK);
            intQ1=1;
        /**Question 2, sets intQ2 = 1 if true*/
        }else if(evt.getSource() == true2){
            true2.setForeground(Color.BLUE);
            false2.setForeground(Color.BLACK);
            intQ2=1;
        }else if(evt.getSource() == false2){
            false2.setForeground(Color.BLUE);
            true2.setForeground(Color.BLACK);
            intQ2=0;
        /**Question 3, sets intQ3 = 1 if true*/
        }else if(evt.getSource() == true3){
            true3.setForeground(Color.BLUE);
            false3.setForeground(Color.BLACK);
            intQ3=1;
        }else if(evt.getSource() == false3){
            false3.setForeground(Color.BLUE);
            true3.setForeground(Color.BLACK);
            intQ3=0;
        }
        else if(evt.getSource() == submit){
            /**If statement that prevents test from being submitted again*/
            if(intSubmit==0){
                /**Question 4, sets intQ4 = 1 if user inputted 0.5*/
                if(question4.getText().equals("0.5")){
                    intQ4=1;
                }else{
                    intQ4=0;
                }
                /**Sums user's score*/
                dblScore = intQ1+intQ2+intQ3+intQ4;
                dblScore = (dblScore / 4)*100;
                /**If no name is inputted, use "Unknown", else use inputted name*/
                if(name.getText().equals("")){
                    scoreLabel.setText("Unknown's Score: "+dblScore+"%");
                }else{
                    scoreLabel.setText(name.getText()+"'s Score: "+dblScore+"%");
                }
                /**Hides submit button so test cannot be submitted again*/
                submit.setLocation(1000,540);
                intSubmit=1;
            }
        }
    }
    public void stateChanged(ChangeEvent evt){
        /**Force slider, reads adjusted value and adjusts acceleration value*/
        if(evt.getSource() == forceSlider){
            dblForce = forceSlider.getValue();
            forceLabel.setText("Force: "+dblForce+"N");
            dblAcceleration=dblForce/dblMass;
            dblAcceleration=dblAcceleration*1000;
            dblAcceleration = Math.round(dblAcceleration);
            dblAcceleration=dblAcceleration/1000;
            accelerationLabel.setText("Acceleration: "+dblAcceleration+" m/s^2");
        /**Mass slider, reads adjusted value and adjusts acceleration value*/
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
    /**constructor*/
    public Newton2ndLaw(){
        /**Initializes panels*/
        thepanel.setPreferredSize(new Dimension(960,540));
        thepanel.setLayout(null);
        thesimulator.setPreferredSize(new Dimension(960,540));
        thesimulator.setLayout(null);
        thehome.setPreferredSize(new Dimension(960,540));
        thehome.setLayout(null);
        theabout.setPreferredSize(new Dimension(960,540));
        theabout.setLayout(null);
        thehelp.setPreferredSize(new Dimension(960,540));
        thehelp.setLayout(null);
        thetest.setPreferredSize(new Dimension(960,540));
        thetest.setLayout(null);
        /**adds action listeners to menus*/
        home.addActionListener(this);
        simulator.addActionListener(this);
		about.addActionListener(this);
		help.addActionListener(this);
		test.addActionListener(this);
        /**add menus to SwitchScreen*/
        SwitchScreen.add(home);
		SwitchScreen.add(simulator);
        SwitchScreen.add(about);
        SwitchScreen.add(help);
        SwitchScreen.add(test);
        menubar.add(SwitchScreen);
        theframe.setJMenuBar(menubar);

        /**simulator*/
            /**sizes*/
        forceSlider.setSize(230, 50);
        forceLabel.setSize(500,50);
        massSlider.setSize(230,50);
        massLabel.setSize(500,50);
        accelerationLabel.setSize(500,60);
        timeLabel.setSize(500,60);
        start.setSize(170,30);
            /**fonts*/
        forceLabel.setFont(fntAerialLarge);
        massLabel.setFont(fntAerialLarge);
        accelerationLabel.setFont(fntAerialSmall);
        timeLabel.setFont(fntAerialSmall);
        start.setFont(fntAerialLarge);
            /**locations*/
        forceSlider.setLocation(25,50);
        forceLabel.setLocation(80,0);
        massSlider.setLocation(300,50);
        massLabel.setLocation(360,0);
        accelerationLabel.setLocation(775,-10);
        timeLabel.setLocation(775,10);
        start.setLocation(775,60);
            /**sliders*/
        forceSlider.setPaintLabels(true);
		forceSlider.setPaintTicks(true);
		forceSlider.setMajorTickSpacing(250);
        massSlider.setPaintLabels(true);
		massSlider.setPaintTicks(true);
		massSlider.setMajorTickSpacing(99);
            /**color*/
        start.setBackground(Color.WHITE);
        start.setForeground(Color.RED);
        forceSlider.setBackground(Color.WHITE);
        forceSlider.setForeground(Color.BLACK);
        massSlider.setBackground(Color.WHITE);
        massSlider.setForeground(Color.BLACK);
            /**adding Listeners*/
        forceSlider.addChangeListener(this);
        massSlider.addChangeListener(this);
        start.addActionListener(this);
            /**add to the simulator panel*/
        thesimulator.add(forceSlider);
        thesimulator.add(forceLabel);
        thesimulator.add(massSlider);
        thesimulator.add(massLabel);
        thesimulator.add(accelerationLabel);
        thesimulator.add(timeLabel);
        thesimulator.add(start);

        /**test page*/
            /**sizes*/
        true1.setSize(170,30);
        false1.setSize(170,30);
        true2.setSize(170,30);
        false2.setSize(170,30);
        true3.setSize(170,30);
        false3.setSize(170,30);
        question4.setSize(170,30);
        name.setSize(170,25);
        submit.setSize(90,30);
        scoreLabel.setSize(230,50);
            /**fonts*/
        true1.setFont(fntAerialSmall);
        false1.setFont(fntAerialSmall);
        true2.setFont(fntAerialSmall);
        false2.setFont(fntAerialSmall);
        true3.setFont(fntAerialSmall);
        false3.setFont(fntAerialSmall);
        question4.setFont(fntAerialSmall);
        name.setFont(fntAerialSmall);
        submit.setFont(fntAerialSmall);
        scoreLabel.setFont(fntAerialLarge);
            /**locations*/
        true1.setLocation(60,90);
        false1.setLocation(260,90);
        true2.setLocation(60,180);
        false2.setLocation(260,180);
        true3.setLocation(60,300);
        false3.setLocation(260,300);
        question4.setLocation(60,420);
        name.setLocation(120,472);
        submit.setLocation(825,472);
        scoreLabel.setLocation(350,460);
            /**color*/
        true1.setBackground(Color.WHITE);
        false1.setBackground(Color.WHITE);
        true2.setBackground(Color.WHITE);
        false2.setBackground(Color.WHITE);
        true3.setBackground(Color.WHITE);
        false3.setBackground(Color.WHITE);
        submit.setBackground(Color.WHITE);
        scoreLabel.setBackground(Color.BLACK);
            /**adding Listeners*/
        true1.addActionListener(this);
        false1.addActionListener(this);
        true2.addActionListener(this);
        false2.addActionListener(this);
        true3.addActionListener(this);
        false3.addActionListener(this);
        submit.addActionListener(this);
             /**add to the test panel*/
        thetest.add(true1);
        thetest.add(false1);
        thetest.add(true2);
        thetest.add(false2);
        thetest.add(true3);
        thetest.add(false3);
        thetest.add(question4);
        thetest.add(name);
        thetest.add(submit);
        thetest.add(scoreLabel);
         /**sets default frame, packs the pane and forces theFrame to be unsizeable, exit on close and visible*/
        theframe.setContentPane(thehome);
		theframe.pack();
        theframe.setResizable(false);
		theframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		theframe.setVisible(true);
    }
    
     /**Main Method*/
    public static void main(String[] args){
        new Newton2ndLaw();
    }

    /**Acceleration Calculation Method*/
    public static int acceleration(double dblForce,double dblMass,double dblTime){
        double dblDisplacement;
        int intDisplacement = 0;
        double dblA;
        /**Distance Equation based off of: D = ?, v1=0, a= f/m, t=dblTime 
        d=at^2/2*/ 
        
        dblA = dblForce/dblMass;
        dblDisplacement = (dblA*Math.pow(dblTime,2))/2;
        intDisplacement = (int) Math.round(dblDisplacement);
        return intDisplacement;
    }
    /**Time Calculation Method*/
    public static double time(double dblForce,double dblMass){
        double dblT, dblA;
        /**Time Equation based off of: D = 25, v1=0, a= f/m, t=?; 
        d = v1t - at^2/2
        t = sqrt(2d/a)*/

        dblA = dblForce/dblMass;
        dblT = Math.round(Math.sqrt(50/dblA)*10000.0)/10000.0;
        return dblT;
    }
}