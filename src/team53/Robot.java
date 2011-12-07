package team53;

import lejos.nxt.*;
import lejos.nxt.ColorSensor.Color;
import lejos.nxt.addon.ColorSensorHT;
import lejos.robotics.navigation.DifferentialPilot;
import lejos.util.PIDController;

/**
 * Robot that stops if it hits something before it completes its travel.
 */
public class Robot {
	DifferentialPilot pilot;
	LightSensor sensor;	 
	int setpoint;
	PIDController pid;
	
	// TouchSensor bump = new TouchSensor(SensorPort.S1);

	public Robot(int setpoint) {
		sensor = new LightSensor(SensorPort.S1);	
		pid = new PIDController(setpoint);
		this.setpoint = setpoint;
		
		
		pid.setPIDParam(PIDController.PID_KP, 12);
		pid.setPIDParam(PIDController.PID_KI, 0.05f);
		pid.setPIDParam(PIDController.PID_KD, 0.5f);
		
		
		
		
	    
	}
	/*
	private team53.Color getColor() {
		team53.Color c = null;
		int result = 0;
		for(int i = 0;i<50; i++) {
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
	*/
	public void turnLeft() {
		pilot.setRotateSpeed(30);
		pilot.rotate(90);
		//pilot.rotateLeft();
	
	}
	public void turnRight() {
		pilot.setRotateSpeed(30);
		pilot.rotate(-90);
		//pilot.rotateLeft();
	
	}
	
	
	public void forward(double num) {
		
		int value = pid.doPID(sensor.getLightValue());		
		
		Motor.B.setSpeed(600 + value);
		Motor.B.forward();
		Motor.C.setSpeed(600 - value);
		Motor.C.forward();
		//System.out.println(value*-10);
		
		/*
		Button.ENTER.waitForPressAndRelease();
		while(!Button.ENTER.isPressed())
		{
			System.out.println(sensor.getLightValue());
		}
		*/
		
		
	}
}