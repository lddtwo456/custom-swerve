package frc.lib.controller.position;

import com.ctre.phoenix6.configs.CurrentLimitsConfigs;
import com.ctre.phoenix6.configs.FeedbackConfigs;
import com.ctre.phoenix6.configs.MotorOutputConfigs;
import com.ctre.phoenix6.configs.Slot0Configs;
import com.ctre.phoenix6.configs.TalonFXConfiguration;
import com.ctre.phoenix6.controls.PositionVoltage;
import com.ctre.phoenix6.hardware.TalonFX;
import com.ctre.phoenix6.signals.FeedbackSensorSourceValue;
import com.ctre.phoenix6.signals.InvertedValue;
import com.ctre.phoenix6.signals.NeutralModeValue;

import edu.wpi.first.math.trajectory.TrapezoidProfile;
import frc.lib.CAN;
import frc.lib.configs.ControlledMotorConfig;

/** TalonFX used as a position controller */
public class PositionControllerTalonFXSteer extends PositionController {

  /** Hardware reference */
  private final TalonFX motor;
  
  public PositionControllerTalonFXSteer(
      CAN motorCan,
      ControlledMotorConfig config) {
    
    setConfig(config);

    motor = new TalonFX(motorCan.id(), motorCan.bus());

    configure();
  }

  @Override
  public void configure() {
    ControlledMotorConfig config = getConfig();

    var tfxConfig = new TalonFXConfiguration();

    tfxConfig.Slot0.kP = config.kP();
    tfxConfig.Slot0.kI = config.kI();
    tfxConfig.Slot0.kD = config.kD();
    tfxConfig.Slot0.kS = config.kS();
    tfxConfig.Slot0.kV = config.kV();
    tfxConfig.Slot0.kA = config.kA();

    tfxConfig.CurrentLimits.StatorCurrentLimit = config.statorCurrentLimit();
    tfxConfig.CurrentLimits.StatorCurrentLimitEnable = true;
    tfxConfig.CurrentLimits.SupplyCurrentLimit = config.supplyCurrentLimit();
    tfxConfig.CurrentLimits.SupplyCurrentLimitEnable = true;

    tfxConfig.MotorOutput.Inverted = config.ccwPositive()
      ? InvertedValue.CounterClockwise_Positive
      : InvertedValue.Clockwise_Positive;
    tfxConfig.MotorOutput.NeutralMode = config.neutralBrake() 
      ? NeutralModeValue.Brake 
      : NeutralModeValue.Coast;

    
  }

  @Override
  public void setPos(double posRotations) {

  }

  @Override
  public void setSetpoint(double posRotations, double velRotationsPerSec) {

  }
}