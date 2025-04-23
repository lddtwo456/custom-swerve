package frc.lib.sensor.absolute;

import java.util.function.Supplier;

/** General interface for absolute encoders */
public abstract class AbsoluteEncoder {

  /** Offset position of the encoder in rotations */
  private double offsetPosRotations = 0.0;

  /** Current position of the encoder in rotations */
  public void setOffsetPosRotations(double posRotations) {
    this.offsetPosRotations = posRotations;
    configure();
  }

  /** Configure the absoulte encoder (apply offsets and other configurations) */
  public abstract void configure();
  
  // suppliers for getting readings from the encoder

  /**
   * Returns angle supplier for absolute encoder
   * @return angle supplier for absolute encoder
   */
  public abstract Supplier<Double> getPosRotations();

  /**
   * Returns velocity supplier for absolute encoder
   * @return velocity supplier for absolute encoder
   */
  public abstract Supplier<Double> getVelRotationsPerSec();

  /**
   * Returns acceleration supplier for absolute encoder
   * @return acceleration supplier for absolute encoder
   */
  public abstract Supplier<Double> getAccRotationsPerSecPerSec();

  /** Overridable periodic function for extra functionality run every periodic loop */
  default abstract void peroidic() {}
}
