package team53;

import lejos.nxt.Button;

public class Main {
	public static void main(String[] args) {
		Robot robot = new Robot();
		robot.calibratePilot(2.4f, 6.8f);
		robot.calibratePID(44, 12f, 0.05f, 0.5f);

		Button.ENTER.waitForPressAndRelease();

		while (!Button.ENTER.isPressed())
			robot.forward(10);

	}

}
