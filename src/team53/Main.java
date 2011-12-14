package team53;

import lejos.nxt.Button;

public class Main {
	public static void main(String[] args) {
		Robot robot = new Robot();
		robot.calibratePilot(2.4f, 6.8f);
		robot.calibratePID(127, 1f, 0.005f, 0.16f);
		

		

		while (!Button.ESCAPE.isPressed())
			robot.hugLeft();

	}

}
