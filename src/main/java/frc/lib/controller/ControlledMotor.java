package frc.lib.controller;

import java.util.function.Supplier;

import edu.wpi.first.wpilibj.DriverStation;
import frc.lib.configs.ControlledMotorConfig;
import frc.lib.configs.ControlledMotorConfig.ControlledMotorBuilder;;

// over abstracting is fun

/** General interface for kinds of motor controllers */
public abstract class ControlledMotor {
  
  /** Motor config */
  private ControlledMotorConfig config = ControlledMotorBuilder.defaults().build();

  /**
   * Update motor controller config
   * 
   * @param config new motor controller config
   */
  public void setConfig(ControlledMotorConfig config) {
    this.config = config;
  }

  /**
   * Update motor controller config and call configure() method again
   * 
   * @param newConfig new motor controller config
   */
  public void reconfigure(ControlledMotorConfig newConfig) {
    this.config = newConfig;
    configure();
  }

  /**
   * Get current motor controller config
   * 
   * @return current motor controller config
   */
  public ControlledMotorConfig getConfig() {
    return config;
  }

  /** Configure the motor controller */
  public abstract void configure();

  // Motor controller inputs

  /**
   * Gives the position controller a new position supplier
   * (for using an absolute encoder or some other more accurate measurement)
   * 
   * @param posRotationsSupplier position supplier
   */
  public void setInputPosRotations(Supplier<Double> posRotationsSupplier) {
    DriverStation.reportWarning("Motor controller does not support external position input", true);
  }

  /**
   * Gives the position controller a new velocity supplier
   * (for using an absolute encoder or some other more accurate measurement)
   * 
   * @param velRotationsPerSecSupplier velocity supplier
   */
  public void setInputVelRotationsPerSec(Supplier<Double> velRotationsPerSecSupplier) {
    DriverStation.reportWarning("Motor controller does not support external velocity input", true);
  }

  /**
   * Gives the position controller a new acceleration supplier
   * (for using an absolute encoder or some other more accurate measurement)
   * 
   * @param accRotationsPerSecPerSecSupplier acceleration supplier
   */
  public void setInputAccRotationsPerSecPerSec(Supplier<Double> accRotationsPerSecPerSecSupplier) {
    DriverStation.reportWarning("Motor controller does not support external acceleration input", true);
  }

  // Motor controller outputs

  /**
   * Returns angle getter for motor controller
   * 
   * @return angle getter for motor controller
   */
  public Supplier<Double> getPosRotations() {
    DriverStation.reportWarning("Motor conroller position suppplier not defined", true);
    return () -> 0.0;
  }

  /**
   * Returns velocity getter for motor controller
   * 
   * @return velocity getter for motor controller
   */
  public Supplier<Double> getVelRotationsPerSec() {
    DriverStation.reportWarning("Motor conroller velocity suppplier not defined", true);
    return () -> 0.0;
  }

  /**
   * Returns acceleration getter for motor controller
   * 
   * @return acceleration getter for motor controller
   */
  public Supplier<Double> getAccRotationsPerSecPerSec() {
    DriverStation.reportWarning("Motor conroller acceleration suppplier not defined", true);
    return () -> 0.0;
  }

  /**
   * Returns voltage getter for motor controller
   * 
   * @return voltage getter for motor controller
   */
  public Supplier<Double> getVoltage() {
    DriverStation.reportWarning("Motor conroller voltage suppplier not defined", true);
    return () -> 0.0;
  } 

  /**
   * Returns stator current getter for motor controller
   * 
   * @return stator current getter for motor controller
   */
  public Supplier<Double> getStatorCurrent() {
    DriverStation.reportWarning("Motor conroller stator current suppplier not defined", true);
    return () -> 0.0;
  }

  /**
   * Returns supply current getter for motor controller
   * 
   * @return supply current getter for motor controller
   */
  public Supplier<Double> getSupplyCurrent() {
    DriverStation.reportWarning("Motor conroller supply current suppplier not defined", true);
    return () -> 0.0;
  }

  // Setters for temporary reconfiguration

  /**
   * Set new neutral brake configuration and reconfigure
   * 
   * @param neutralBrake new neutral brake configuration
   */
  public void setNeutralBrake(boolean neutralBrake) {
    reconfigure(
      ControlledMotorBuilder.edit(getConfig())
        .neutralBrake(neutralBrake)
        .build());
  }

  /**
   * Set new ccw positive configuration and reconfigure
   * 
   * @param ccwPositive new ccw positive configuration
   */
  public void setCCWPositive(boolean ccwPositive) {
    reconfigure(
      ControlledMotorBuilder.edit(getConfig())
        .ccwPositive(ccwPositive)
        .build());
  }

  /**
   * Set new motor to mechanism ratio and reconfigure
   * 
   * @param motorToMechRatio new motor to mechanism ratio
   */
  public void setMotorToMechRatio(double motorToMechRatio) {
    reconfigure(
      ControlledMotorBuilder.edit(getConfig())
        .motorToMechRatio(motorToMechRatio)
        .build());
  }

  /**
   * Set new stator current limit and reconfigure
   * 
   * @param statorCurrentLimit new stator current limit
   */
  public void setStatorCurrentLimit(double statorCurrentLimit) {
    reconfigure(
      ControlledMotorBuilder.edit(getConfig())
        .statorCurrentLimit(statorCurrentLimit)
        .build());
  }

  /**
   * Set new supply current limit and reconfigure
   * 
   * @param supplyCurrentLimit new supply current limit
   */
  public void setSupplyCurrentLimit(double supplyCurrentLimit) {
    reconfigure(
      ControlledMotorBuilder.edit(getConfig())
        .supplyCurrentLimit(supplyCurrentLimit)
        .build());
  }

  /**
   * Set new max velocity and reconfigure
   * 
   * @param maxVelocity new max velocity
   */
  public void setMaxVelocity(double maxVelocity) {
    reconfigure(
      ControlledMotorBuilder.edit(getConfig())
        .maxVelocity(maxVelocity)
        .build());
  }

  /**
   * Set new max acceleration and reconfigure
   * 
   * @param maxAcceleration new max acceleration
   */
  public void setMaxAcceleration(double maxAcceleration) {
    reconfigure(
      ControlledMotorBuilder.edit(getConfig())
        .maxAcceleration(maxAcceleration)
        .build());
  }

  /**
   * Set new kP and reconfigure
   * 
   * @param kP new kP
   */
  public void setkP(double kP) {
    reconfigure(
      ControlledMotorBuilder.edit(getConfig())
        .kP(kP)
        .build());
  }

  /**
   * Set new kI and reconfigure
   * 
   * @param kI new kI
   */
  public void setkI(double kI) {
    reconfigure(
      ControlledMotorBuilder.edit(getConfig())
        .kI(kI)
        .build());
  }

  /**
   * Set new kD and reconfigure
   * 
   * @param kD new kD
   */
  public void setkD(double kD) {
    reconfigure(
      ControlledMotorBuilder.edit(getConfig())
        .kD(kD)
        .build());
  }

  /**
   * Set new kS and reconfigure
   * 
   * @param kS new kS
   */
  public void setkS(double kS) {
    reconfigure(
      ControlledMotorBuilder.edit(getConfig())
        .kS(kS)
        .build());
  }

  /**
   * Set new kG and reconfigure
   * 
   * @param kG new kG
   */
  public void setkG(double kG) {
    reconfigure(
      ControlledMotorBuilder.edit(getConfig())
        .kG(kG)
        .build());
  }

  /**
   * Set new kV and reconfigure
   * 
   * @param kV new kV
   */
  public void setkV(double kV) {
    reconfigure(
      ControlledMotorBuilder.edit(getConfig())
        .kV(kV)
        .build());
  }

  /**
   * Set new kA and reconfigure
   * 
   * @param kA new kA
   */
  public void setkA(double kA) {
    reconfigure(
      ControlledMotorBuilder.edit(getConfig())
        .kA(kA)
        .build());
  }

  /**
   * Set new continuous configuration and reconfigure
   * 
   * @param continuous new continuous configuration
   */
  public void setContinuous(boolean continuous) {
    reconfigure(
      ControlledMotorBuilder.edit(getConfig())
        .continuous(continuous)
        .build());
  }
  
  /**
   * Set new position tolerance and reconfigure
   * 
   * @param posTolerance new position tolerance
   */
  public void setPosTolerance(double posTolerance) {
    reconfigure(
      ControlledMotorBuilder.edit(getConfig())
        .posTolerance(posTolerance)
        .build());
  }

  /**
   * Set new velocity tolerance and reconfigure
   * 
   * @param velTolerance new velocity tolerance
   */
  public void setVelTolerance(double velTolerance) {
    reconfigure(
      ControlledMotorBuilder.edit(getConfig())
        .velTolerance(velTolerance)
        .build());
  }
}
