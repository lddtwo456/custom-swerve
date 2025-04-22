package frc.lib.sensor.absolute;

import java.util.function.Supplier;

/** General interface for absolute encoders */
public interface AbsoluteEncoder {

  /** Initialize and configure the absolute encoder */
  public void configure();

  /** Set encoder position in rotations */
  public void setPosRotations(double posRotations);
  
  // suppliers for getting readings from the encoder

  /**
   * Returns angle supplier for absolute encoder
   * @return angle supplier for absolute encoder
   */
  public Supplier<Double> getPosRotations();

  /**
   * Returns velocity supplier for absolute encoder
   * @return velocity supplier for absolute encoder
   */
  public Supplier<Double> getVelRotationsPerSec();

  /**
   * Returns acceleration supplier for absolute encoder
   * @return acceleration supplier for absolute encoder
   */
  public Supplier<Double> getAccRotationsPerSecPerSec();

  /** Overridable periodic function for extra functionality run every periodic loop */
  default void peroidic() {}
}
