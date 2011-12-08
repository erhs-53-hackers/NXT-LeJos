package team53;

import lejos.nxt.*;
import lejos.nxt.addon.ColorSensorHT;
import lejos.util.PIDController;

public class Robot {
	LightSensor sensor;
	PIDController pid;
	int speed = 600;

	public Robot() {
		sensor = new LightSensor(SensorPort.S1);
	}

	public void calibrate(int target, int kp, int ki, int kd) {
		pid = new PIDController(target);
		pid.setPIDParam(PIDController.PID_KP, kp);
		pid.setPIDParam(PIDController.PID_KI, ki);
		pid.setPIDParam(PIDController.PID_KD, kd);
	}

	public void calibrate(int target, float kp, float ki, float kd) {
		pid = new PIDController(target);
		pid.setPIDParam(PIDController.PID_KP, kp);
		pid.setPIDParam(PIDController.PID_KI, ki);
		pid.setPIDParam(PIDController.PID_KD, kd);
	}

	private team53.Color getColor(ColorSensorHT sensor) {

		team53.Color c = null;
		int result = 0;
		for (int i = 0; i < 50; i++) {
			result += sensor.getColorID();
		}
		result /= 50;
		System.out.println(result);

		switch (sensor.getColorID()) {
		case 6:
			c = team53.Color.White;
			break;
		case 3:
			c = team53.Color.Yellow;
			break;
		case 5:
			c = team53.Color.Red;
			break;
		case 0:
			c = team53.Color.Red;
			break;
		case 2:
			c = team53.Color.Blue;
			break;
		case 8:
			c = team53.Color.Black;
			break;
		case 1:
			c = team53.Color.Green;
			break;

		}

		return c;
	}

	public void turnLeft() {

	}

	public void turnRight() {

	}

	public void forward(double num) {
		int value = pid.doPID(sensor.getLightValue());

		Motor.B.setSpeed(speed + value);
		Motor.B.forward();
		Motor.C.setSpeed(speed - value);
		Motor.C.forward();
	}
}