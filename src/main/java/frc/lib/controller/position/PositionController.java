package frc.lib.controller.position;

import frc.lib.configs.PositionControllerConfig;
import frc.lib.configs.PositionControllerConfig.PositionControllerBuilder;

/** General interface for position controllers */
public abstract class PositionController {
  
  /** Motor config */
  private PositionControllerConfig config = PositionControllerBuilder.defaults().build();

  /**
   * Update position controller config
   * 
   * @param config new position controller config
   */
  public void setConfig(PositionControllerConfig config) {
    this.config = config;
  }

  /**
   * Update position controller config and call configure() method again
   * 
   * @param newConfig new position controller config
   */
  public void reconfigure(PositionControllerConfig newConfig) {
    this.config = newConfig;
    configure();
  }

  /**
   * Get current position controller config
   * 
   * @return current position controller config
   */
  public PositionControllerConfig getConfig() {
    return config;
  }

  /** Configure the position controller */
  public abstract void configure();






  
  // Setters for temporary reconfiguration

  /**
   * Set new neutral brake configuration and reconfigure
   * 
   * @param neutralBrake new neutral brake configuration
   */
  public void setNeutralBrake(boolean neutralBrake) {
    reconfigure(
      PositionControllerBuilder.edit(getConfig())
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
      PositionControllerBuilder.edit(getConfig())
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
      PositionControllerBuilder.edit(getConfig())
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
      PositionControllerBuilder.edit(getConfig())
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
      PositionControllerBuilder.edit(getConfig())
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
      PositionControllerBuilder.edit(getConfig())
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
      PositionControllerBuilder.edit(getConfig())
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
      PositionControllerBuilder.edit(getConfig())
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
      PositionControllerBuilder.edit(getConfig())
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
      PositionControllerBuilder.edit(getConfig())
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
      PositionControllerBuilder.edit(getConfig())
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
      PositionControllerBuilder.edit(getConfig())
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
      PositionControllerBuilder.edit(getConfig())
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
      PositionControllerBuilder.edit(getConfig())
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
      PositionControllerBuilder.edit(getConfig())
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
      PositionControllerBuilder.edit(getConfig())
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
      PositionControllerBuilder.edit(getConfig())
        .velTolerance(velTolerance)
        .build());
  }
}
