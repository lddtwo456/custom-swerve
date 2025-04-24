package frc.lib.sensor.absolute;

import java.util.function.Supplier;

import edu.wpi.first.math.geometry.Rotation2d;
import edu.wpi.first.wpilibj.DriverStation;
import frc.lib.configs.AbsoluteEncoderConfig;
import frc.lib.configs.AbsoluteEncoderConfig.AbsoluteEncoderBuilder;

/** General interface for absolute encoders */
public abstract class AbsoluteEncoder {

  /** Encoder config */
  private AbsoluteEncoderConfig config = AbsoluteEncoderBuilder.defaults().build();

  /**
   * Update absolute encoder config
   * 
   * @param config new absolute encoder config
   */
  public void setConfig(AbsoluteEncoderConfig config) {
    this.config = config;
  }

  /** 
   * Update absolute encoder config and rerun configure() function
   * 
   * @param newConfig new absolute encoder config
   */
  public void reconfigure(AbsoluteEncoderConfig newConfig) {
    config = newConfig;
    configure();
  }

  /**
   * Get current absolute encoder config
   * 
   * @return current absolute encoder config
   */
  public AbsoluteEncoderConfig getConfig() {
    return config;
  }

  /** Configure the absoulte encoder */
  public abstract void configure();
  
  // Overridable suppliers for getting readings from the encoder

  /**
   * Returns angle getter for absolute encoder
   * 
   * @return angle getter for absolute encoder
   */
  public Supplier<Double> getPosRotations() {
    DriverStation.reportWarning("Absolute encoder position supplier not defined", true);
    return () -> 0.0;
  }

  /**
   * Returns velocity getter for absolute encoder
   * 
   * @return velocity getter for absolute encoder
   */
  public Supplier<Double> getVelRotationsPerSec() {
    DriverStation.reportWarning("Absolute encoder velocity supplier not defined", true);
    return () -> 0.0;
  }

  /**
   * Returns acceleration getter for absolute encoder
   * 
   * @return acceleration getter for absolute encoder
   */
  public Supplier<Double> getAccRotationsPerSecPerSec() {
    DriverStation.reportWarning("Absolute encoder acceleration supplier not defined", true);
    return () -> 0.0;
  }

  /** Overridable periodic function for extra functionality run every periodic loop */
  public void periodic() {}
  
  // Setters for temporary reonfiguration

  /**
   * Set ccw positive configuration and reconfigure
   * 
   * @param ccwPositive ccw positive configuration
   */
  public void setCCWPositive(boolean ccwPositive) {
    reconfigure(
      AbsoluteEncoderBuilder.edit(getConfig())
        .ccwPositive(ccwPositive)
        .build());
  }

  /**
   * Set new sensor to mechanism ratio and reconfigure
   * 
   * @param sensorToMechRatio new sensor to mechanism ratio
   */
  public void setSensorToMechRatio(double sensorToMechRatio) {
    reconfigure(
      AbsoluteEncoderBuilder.edit(getConfig())
        .sensorToMechRatio(sensorToMechRatio)
        .build());
  }
  
  /**
   * Set new absolute encoder offset and reconfigure
   * 
   * @param offset new absolute encoder offset
   */
  public void setOffsetRotation(Rotation2d offset) {
    reconfigure(
      AbsoluteEncoderBuilder.edit(getConfig())
        .offset(offset)
        .build());
  }
}
