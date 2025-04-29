package frc.lib.controller.swerve;

import edu.wpi.first.math.kinematics.SwerveModuleState;

/** Interface that lays out all functionality any implementations of a swerve module will have */
public interface SwerveModule {

  /**
   * Set swerve module setpoint to some swerve module state
   * 
   * @param moduleState target swerve module state
   */
  public void setSetpoint(SwerveModuleState moduleState);

  
}