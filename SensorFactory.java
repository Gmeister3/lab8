/**
 * Task 1 – Factory Method: SensorFactory
 *
 * Eliminates the scattered if/else chains in client code by centralizing
 * sensor creation logic here.  Adding a new sensor type only requires
 * adding a new subclass and a new case in this factory; existing client
 * code is unaffected.
 */
public class SensorFactory {

    /**
     * Creates and returns the appropriate Sensor subclass.
     *
     * @param type     "MOTION" | "DOOR" | "THERM" | "FLOOD"
     * @param location physical location string
     * @return         a fully initialised Sensor instance
     * @throws IllegalArgumentException for unrecognised type strings
     */
    public static Sensor createSensor(String type, String location) {
        switch (type) {
            case "MOTION": return new MotionSensor(location);
            case "DOOR":   return new DoorSensor(location);
            case "THERM":  return new ThermostatSensor(location);
            case "FLOOD":  return new FloodSensor(location);
            default:
                throw new IllegalArgumentException("Unknown sensor type: " + type);
        }
    }
}
