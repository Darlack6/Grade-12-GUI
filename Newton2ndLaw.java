//Program Name: Newton's 2nd Law 
//Created by: Derek
//Version number: 0.1

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.event.*;
import java.awt.Font;

public class Newton2ndLaw implements ActionListener, ChangeListener{
    //properties
    double dblForce = 375;
    double dblMass = 50;
    double dblAcceleration = 7.5;
    double dblTime = 0;
    int intScore = 0;
    int intQ1 = 0;
    int intQ2 = 0;
    int intQ3 = 0;
    int intQ4 = 0;
    int intSubmit = 0;

    JFrame theframe = new JFrame("Newton's 2nd Law Simulator");
    JPanel thepanel = new JPanel();
    simulatorpanel thesimulator = new simulatorpanel();
    homepanel thehome = new homepanel();
    aboutpanel theabout = new aboutpanel();
    helppanel thehelp = new helppanel();
    testpanel thetest = new testpanel();
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
    JLabel scoreLabel = new JLabel("Score:");
        //Buttons
    JButton start = new JButton("Start");
    JButton true1 = new JButton("True");
    JButton false1 = new JButton("False");
    JButton true2 = new JButton("True");
    JButton false2 = new JButton("False");
    JButton true3 = new JButton("True");
    JButton false3 = new JButton("False");
    JButton submit = new JButton("Submit");
        //textfields
    JTextField question4 = new JTextField();
    JTextField name = new JTextField();
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
        }else if(evt.getSource() == help){
            theframe.setContentPane(thehelp);
            theframe.pack();
            theframe.repaint();
        }else if(evt.getSource() == test){
            theframe.setContentPane(thetest);
            theframe.pack();
            theframe.repaint();
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
        }else if(evt.getSource() == true1){
            true1.setBackground(Color.GREEN);
            false1.setBackground(Color.WHITE);
            intQ1=0;
        }else if(evt.getSource() == false1){
            false1.setBackground(Color.GREEN);
            true1.setBackground(Color.WHITE);
            intQ1=1;
        }else if(evt.getSource() == true2){
            true2.setBackground(Color.GREEN);
            false2.setBackground(Color.WHITE);
            intQ2=1;
        }else if(evt.getSource() == false2){
            false2.setBackground(Color.GREEN);
            true2.setBackground(Color.WHITE);
            intQ2=0;
        }else if(evt.getSource() == true3){
            true3.setBackground(Color.GREEN);
            false3.setBackground(Color.WHITE);
            intQ3=1;
        }else if(evt.getSource() == false3){
            false3.setBackground(Color.GREEN);
            true3.setBackground(Color.WHITE);
            intQ3=0;
        }
        else if(evt.getSource() == submit){
            if(intSubmit==0){
                if(question4.getText().equals("0.5")){
                    intQ4=1;
                }else{
                    intQ4=0;
                }
                intScore = intQ1+intQ2+intQ3+intQ4;
                System.out.println(intScore);
                intScore = (intScore / 4)*100;
                scoreLabel.setText("Score: "+intScore+"%");
                intSubmit=1;
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
        thehelp.setPreferredSize(new Dimension(960,540));
        thehelp.setLayout(null);
        thetest.setPreferredSize(new Dimension(960,540));
        thetest.setLayout(null);

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
        start.setForeground(Color.WHITE);
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

        //test page
            //sizes
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
            //fonts
            true1.setFont(SmallFont);
            false1.setFont(SmallFont);
            true2.setFont(SmallFont);
            false2.setFont(SmallFont);
            true3.setFont(SmallFont);
            false3.setFont(SmallFont);
            question4.setFont(SmallFont);
            name.setFont(SmallFont);
            submit.setFont(SmallFont);
            scoreLabel.setFont(Dfont);
            //locations
            true1.setLocation(60,90);
            false1.setLocation(260,90);
            true2.setLocation(60,180);
            false2.setLocation(260,180);
            true3.setLocation(60,300);
            false3.setLocation(260,300);
            question4.setLocation(60,420);
            name.setLocation(120,472);
            submit.setLocation(825,472);
            scoreLabel.setLocation(800,60);
            //color
            true1.setBackground(Color.WHITE);
            false1.setBackground(Color.WHITE);
            true2.setBackground(Color.WHITE);
            false2.setBackground(Color.WHITE);
            true3.setBackground(Color.WHITE);
            false3.setBackground(Color.WHITE);
            submit.setBackground(Color.WHITE);
            scoreLabel.setBackground(Color.BLACK);
            //adding listenners
            true1.addActionListener(this);
            false1.addActionListener(this);
            true2.addActionListener(this);
            false2.addActionListener(this);
            true3.addActionListener(this);
            false3.addActionListener(this);
            submit.addActionListener(this);
            //adding to panel
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