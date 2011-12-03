package team53;

import lejos.nxt.*;
import lejos.robotics.navigation.DifferentialPilot;

/**
 * Robot that stops if it hits something before it completes its travel.
 */
public class Robot {
  DifferentialPilot pilot;
  TouchSensor bump = new TouchSensor(SensorPort.S1);

  public void go() {
    pilot.travel(20, true);    
    while (pilot.isMoving()) {
      if (bump.isPressed()) pilot.stop();
    }
    System.out.println(" " + pilot.getMovement().getDistanceTraveled());
    Button.waitForPress();
  }  
}