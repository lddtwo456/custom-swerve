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
public record ControlledMotorConfig (
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
  public static class ControlledMotorBuilder {
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

    private ControlledMotorBuilder (
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
    public static ControlledMotorBuilder defaults() {
      return new ControlledMotorBuilder(
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
    public static ControlledMotorBuilder edit(ControlledMotorConfig config) {
      return new ControlledMotorBuilder(
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

    public ControlledMotorBuilder neutralBrake(boolean neutralBrake) {
      this.neutralBrake = neutralBrake;
      return this;
    }

    public ControlledMotorBuilder ccwPositive(boolean ccwPositive) {
      this.ccwPositive = ccwPositive;
      return this;
    }

    public ControlledMotorBuilder motorToMechRatio(double motorToMechRatio) {
      this.motorToMechRatio = motorToMechRatio;
      return this;
    }

    public ControlledMotorBuilder statorCurrentLimit(double statorCurrentLimit) {
      this.statorCurrentLimit = statorCurrentLimit;
      return this;
    }

    public ControlledMotorBuilder supplyCurrentLimit(double supplyCurrentLimit) {
      this.supplyCurrentLimit = supplyCurrentLimit;
      return this;
    }

    public ControlledMotorBuilder maxVelocity(double maxVelocity) {
      this.maxVelocity = maxVelocity;
      return this;
    }

    public ControlledMotorBuilder maxAcceleration(double maxAcceleration) {
      this.maxAcceleration = maxAcceleration;
      return this;
    }

    public ControlledMotorBuilder kP(double kP) {
      this.kP = kP;
      return this;
    }

    public ControlledMotorBuilder kI(double kI) {
      this.kI = kI;
      return this;
    }

    public ControlledMotorBuilder kD(double kD) {
      this.kD = kD;
      return this;
    }

    public ControlledMotorBuilder kS(double kS) {
      this.kS = kS;
      return this;
    }

    public ControlledMotorBuilder kG(double kG) {
      this.kG = kG;
      return this;
    }

    public ControlledMotorBuilder kV(double kV) {
      this.kV = kV;
      return this;
    }

    public ControlledMotorBuilder kA(double kA) {
      this.kA = kA;
      return this;
    }

    public ControlledMotorBuilder continuous(boolean continuous) {
      this.continuous = continuous;
      return this;
    }

    public ControlledMotorBuilder posTolerance(double posTolerance) {
      this.posTolerance = posTolerance;
      return this;
    }

    public ControlledMotorBuilder velTolerance(double velTolerance) {
      this.velTolerance = velTolerance;
      return this;
    }

    /**
     * Returns the builder as a config with private immutable values
     * 
     * @return the builder as a config with private immutable values
     */
    public ControlledMotorConfig build() {
      return new ControlledMotorConfig(
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
