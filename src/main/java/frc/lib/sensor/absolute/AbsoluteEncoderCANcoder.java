package frc.lib.sensor.absolute;

import java.util.Set;
import java.util.function.Supplier;

import com.ctre.phoenix6.BaseStatusSignal;
import com.ctre.phoenix6.StatusSignal;
import com.ctre.phoenix6.hardware.CANcoder;
import com.ctre.phoenix6.hardware.ParentDevice;

import edu.wpi.first.units.measure.Angle;
import edu.wpi.first.units.measure.AngularVelocity;
import frc.lib.CAN;
import frc.lib.configs.AbsoluteEncoderConfig;
import frc.lib.configs.appliers.CANcoderConfigApplier;

public class AbsoluteEncoderCANcoder extends AbsoluteEncoder {

  /** Encoder reference */
  private final CANcoder encoder;

  /** Set of tracked status signals */
  private Set<StatusSignal<?>> signals;
  
  /** Initializes and configures hardware */
  public AbsoluteEncoderCANcoder(
      AbsoluteEncoderConfig config, 
      CAN sensorCAN) {
    
    // Set encoder config
    setConfig(config);
    
    // Create hardware
    encoder = new CANcoder(sensorCAN.id(), sensorCAN.bus());

    // Configure hardware
    configure();
  }

  @Override
  public void configure() {
    BaseStatusSignal.setUpdateFrequencyForAll(100, signals.toArray(new StatusSignal<?>[0]));

    ParentDevice.optimizeBusUtilizationForAll(encoder);

    CANcoderConfigApplier.apply(encoder, getConfig());
  }

  @Override
  public Supplier<Double> getPosRotations() {
    StatusSignal<Angle> posRotations = encoder.getAbsolutePosition();
    signals.add(posRotations); // codingon school laptop is awful i give up for now

    return () -> {
      return posRotations.getValueAsDouble();
    };
  }

  @Override
  public Supplier<Double> getVelRotationsPerSec() {
    StatusSignal<AngularVelocity> velRotationsPerSec = encoder.getVelocity();
    signals.add(velRotationsPerSec);

    return () -> {
      return velRotationsPerSec.getValueAsDouble();
    };
  }

  @Override
  public void periodic() {
    BaseStatusSignal.refreshAll(signals.toArray(new StatusSignal<?>[0]));
  }
}
