package frc.lib;

/**
 * CAN identifier for a device
 * 
 * @param id CAN id
 * @param bus CAN bus
 */
public record CAN(int id, String bus) {
  
  /**
   * Creates a CAN identifier for a device with the default CAN bus
   * 
   * @param id CAN id
   */
  public CAN(int id) {
    this(id, "");
  }
}
