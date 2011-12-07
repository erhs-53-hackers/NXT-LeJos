package team53;

import lejos.nxt.Button;
import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;

public class Main {
	public static void main(String[] args) {
	    Robot robot = new Robot(44);
	    robot.pilot = new DifferentialPilot(2.4f, 6.8f, Motor.B, Motor.C);
	    //robot.pilot.rotate(90);
	    Button.ENTER.waitForPressAndRelease();
		while(!Button.ENTER.isPressed())
		{
	    robot.forward(10);
		}
	    /*
	    robot.forward(30);
	    robot.turnRight();
	    robot.forward(30);
	    robot.turnRight();
	    robot.forward(30);
	    robot.turnRight();
	    robot.forward(30);
	    robot.turnRight();
	    */
	    
	    
	  }

}
