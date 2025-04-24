package frc.lib.configs;

/** 
 * Motor config
 * 
 * @param neutralBrake true means the motor will brake when given no voltage
 * @param ccwPositive true means positive voltage rotates the motor ccw
 * @param motorToMechRatio ratio of motor rotations to mechanism rotations
 * @param statorCurrentLimit current limit in the stator
 * @param supplyCurrentLimit supply current limit
 */
public record PositionControllerConfig (
    boolean neutralBrake,
    boolean ccwPositive,
    double motorToMechRatio,
    double statorCurrentLimit,
    double supplyCurrentLimit,
    double maxVelocity,
    double maxAcceleration,
    double kP,
    double kI,
    double kD,
    double kS,
    double kG,
    double kV,
    double kA,
    boolean continuous,
    double posTolerance,
    double velTolerance) {

  /** Easier and more modular way to construct a motor config */
  public static class PositionControllerBuilder {
    private boolean neutralBrake;
    private boolean ccwPositive;
    private double motorToMechRatio;
    private double statorCurrentLimit;
    private double supplyCurrentLimit;
    private double maxVelocity;
    private double maxAcceleration;
    private double kP;
    private double kI;
    private double kD;
    private double kS;
    private double kG;
    private double kV;
    private double kA;
    private boolean continuous;
    private double posTolerance;
    private double velTolerance;

    private PositionControllerBuilder (
        boolean neutralBrake,
        boolean ccwPositive,
        double motorToMechRatio,
        double statorCurrentLimit,
        double supplyCurrentLimit,
        double maxVelocity,
        double maxAcceleration,
        double kP,
        double kI,
        double kD,
        double kS,
        double kG,
        double kV,
        double kA,
        boolean continuous,
        double posTolerance,
        double velTolerance) {
      this.neutralBrake = neutralBrake;
      this.ccwPositive = ccwPositive;
      this.motorToMechRatio = motorToMechRatio;
      this.statorCurrentLimit = statorCurrentLimit;
      this.supplyCurrentLimit = supplyCurrentLimit;
      this.maxVelocity = maxVelocity;
      this.maxAcceleration = maxAcceleration;
      this.kP = kP;
      this.kI = kI;
      this.kD = kD;
      this.kS = kS;
      this.kG = kG;
      this.kV = kV;
      this.kA = kA;
      this.continuous = continuous;
      this.posTolerance = posTolerance;
      this.velTolerance = velTolerance;
    }

    /**
     * Returns a builder with default values
     * 
     * @return a builder with default values
     */
    public static PositionControllerBuilder defaults() {
      return new PositionControllerBuilder(
        false, 
        true, 
        1.0, 
        80.0, 
        40.0,
        1.0,
        1.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        0.0,
        true,
        0.1,
        0.1);
    }

    /**
     * Returns a builder with values copied from the input config
     * 
     * @param config config to be copied
     * @return a builder with values copied from the input config
     */
    public static PositionControllerBuilder edit(PositionControllerConfig config) {
      return new PositionControllerBuilder(
        config.neutralBrake(), 
        config.ccwPositive(), 
        config.motorToMechRatio(), 
        config.statorCurrentLimit(), 
        config.supplyCurrentLimit(),
        config.maxVelocity(),
        config.maxAcceleration(),
        config.kP(),
        config.kI(),
        config.kD(),
        config.kS(),
        config.kG(),
        config.kV(),
        config.kA(),
        config.continuous(),
        config.posTolerance(),
        config.velTolerance());
    }

    public PositionControllerBuilder neutralBrake(boolean neutralBrake) {
      this.neutralBrake = neutralBrake;
      return this;
    }

    public PositionControllerBuilder ccwPositive(boolean ccwPositive) {
      this.ccwPositive = ccwPositive;
      return this;
    }

    public PositionControllerBuilder motorToMechRatio(double motorToMechRatio) {
      this.motorToMechRatio = motorToMechRatio;
      return this;
    }

    public PositionControllerBuilder statorCurrentLimit(double statorCurrentLimit) {
      this.statorCurrentLimit = statorCurrentLimit;
      return this;
    }

    public PositionControllerBuilder supplyCurrentLimit(double supplyCurrentLimit) {
      this.supplyCurrentLimit = supplyCurrentLimit;
      return this;
    }

    public PositionControllerBuilder maxVelocity(double maxVelocity) {
      this.maxVelocity = maxVelocity;
      return this;
    }

    public PositionControllerBuilder maxAcceleration(double maxAcceleration) {
      this.maxAcceleration = maxAcceleration;
      return this;
    }

    public PositionControllerBuilder kP(double kP) {
      this.kP = kP;
      return this;
    }

    public PositionControllerBuilder kI(double kI) {
      this.kI = kI;
      return this;
    }

    public PositionControllerBuilder kD(double kD) {
      this.kD = kD;
      return this;
    }

    public PositionControllerBuilder kS(double kS) {
      this.kS = kS;
      return this;
    }

    public PositionControllerBuilder kG(double kG) {
      this.kG = kG;
      return this;
    }

    public PositionControllerBuilder kV(double kV) {
      this.kV = kV;
      return this;
    }

    public PositionControllerBuilder kA(double kA) {
      this.kA = kA;
      return this;
    }

    public PositionControllerBuilder continuous(boolean continuous) {
      this.continuous = continuous;
      return this;
    }

    public PositionControllerBuilder posTolerance(double posTolerance) {
      this.posTolerance = posTolerance;
      return this;
    }

    public PositionControllerBuilder velTolerance(double velTolerance) {
      this.velTolerance = velTolerance;
      return this;
    }

    /**
     * Returns the builder as a config with private immutable values
     * 
     * @return the builder as a config with private immutable values
     */
    public PositionControllerConfig build() {
      return new PositionControllerConfig(
        this.neutralBrake,
        this.ccwPositive,
        this.motorToMechRatio,
        this.statorCurrentLimit,
        this.supplyCurrentLimit,
        this.maxVelocity,
        this.maxAcceleration,
        this.kP,
        this.kI,
        this.kD,
        this.kS,
        this.kG,
        this.kV,
        this.kA,
        this.continuous,
        this.posTolerance,
        this.velTolerance);
    }
  }
}
