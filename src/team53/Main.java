package team53;

import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;

public class Main {
	public static void main(String[] args) {
	    Robot robot = new Robot();
	    robot.pilot = new DifferentialPilot(1.70078f, 17f, Motor.C, Motor.B);	    
	    robot.forward(30);
	    robot.turnRight();
	    robot.forward(30);
	    robot.turnRight();
	    robot.forward(30);
	    robot.turnRight();
	    robot.forward(30);
	    robot.turnRight();
	    
	    
	  }

}
