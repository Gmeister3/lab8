/**
 * Task 2 – Builder Pattern: SmartDeviceDirector
 *
 * The Director encodes reusable, domain-specific construction recipes on
 * top of the generic SmartDevice.Builder.  Client code simply calls a
 * single named method rather than remembering every option for each device
 * class, keeping configuration knowledge in one place.
 */
public class SmartDeviceDirector {

    /**
     * Builds a standard hallway/room camera:
     * firmware v3, encryption enabled, 2-second polling.
     */
    public SmartDevice buildDefaultCamera(String id, String location) {
        return new SmartDevice.Builder(id, "CAMERA", location)
                .firmwareVersion(3)
                .encrypted(true)
                .pollingInterval(2000)
                .build();
    }

    /**
     * Builds a secure door lock:
     * firmware v2, encryption enabled, 1-second polling for rapid response.
     */
    public SmartDevice buildSecureLock(String id, String location) {
        return new SmartDevice.Builder(id, "LOCK", location)
                .firmwareVersion(2)
                .encrypted(true)
                .pollingInterval(1000)
                .build();
    }
}
