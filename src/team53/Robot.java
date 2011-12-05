package team53;

import lejos.nxt.*;
import lejos.nxt.ColorSensor.Color;
import lejos.nxt.addon.ColorSensorHT;
import lejos.robotics.navigation.DifferentialPilot;

/**
 * Robot that stops if it hits something before it completes its travel.
 */
public class Robot {
	DifferentialPilot pilot;
	ColorSensorHT sensor;

	// TouchSensor bump = new TouchSensor(SensorPort.S1);

	public Robot() {
		//sensor = new ColorSensorHT(SensorPort.S1);		
	}
	
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
		
		pilot.setTravelSpeed(40);
		pilot.travel(num);
		
		
	}
}