package frc.lib.sensor.absolute;

import java.util.Set;
import java.util.function.Supplier;

import frc.lib.CAN;

public class AbsoluteEncoderCANcoder extends AbsoluteEncoder {

  // Encoder reference
  private final CANcoder encoder;

  // Set of status signals
  private Set<StatusSignal> signals;
  
  public AbsoluteEncoderCANcoder(CAN sensorCAN) {
    encoder = new CANcoder(sensorCAN.id(), sensorCAN.bus());
  }

  @Override
  public void configure() {

  }

  @Override
  public Supplier<Double> getPosRotations() {
    StatusSignal<Angle> posRotations = encoder.getPosition;
    signals.add(posRottaions) // codingon school laptop is awful i give up for now

    return () -> {
      
    }
  }
}
