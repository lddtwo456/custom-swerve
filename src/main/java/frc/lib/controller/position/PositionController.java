package frc.lib.controller.position;

import frc.lib.controller.ControlledMotor;

public abstract class PositionController extends ControlledMotor {

  // Position controller inputs

  /**
   * Set position controller setpoint (target position and velocity)
   * 
   * @param posRotations target position
   * @param velRotationsPerSec target velocity
   */
  public abstract void setSetpoint(double posRotations, double velRotationsPerSec);

  /**
   * Set current position of position controller in rotations
   * 
   * @param posRotations new position in rotatinos
   */
  public abstract void setPos(double posRotations);
}