package team53;

import lejos.nxt.Motor;
import lejos.robotics.navigation.DifferentialPilot;

public class Main {
	public static void main(String[] args) {
	    Robot robot = new Robot();
	    robot.pilot = new DifferentialPilot(2.25f, 5.5f, Motor.A, Motor.C);
	    robot.go();
	  }

}
