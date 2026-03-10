/**
 * SmartHomeDemo – Integration demonstration of all four design patterns.
 *
 * Exercises:
 *   Task 1 – Factory Method  (SensorFactory)
 *   Task 2 – Builder         (SmartDevice.Builder / SmartDeviceDirector)
 *   Task 3 – Object Adapter  (PushNotificationAdapter)
 *   Task 4 – Façade          (SecurityFacade)
 */
public class SmartHomeDemo {

    public static void main(String[] args) {

        // ----------------------------------------------------------------
        // Task 1: SensorFactory – Factory Method
        // ----------------------------------------------------------------
        System.out.println("=== Task 1: SensorFactory ===");

        Sensor motion = SensorFactory.createSensor("MOTION", "Front Door");
        Sensor door   = SensorFactory.createSensor("DOOR",   "Garage");
        Sensor therm  = SensorFactory.createSensor("THERM",  "Living Room");
        Sensor flood  = SensorFactory.createSensor("FLOOD",  "Basement");

        motion.detect();
        door.detect();
        therm.detect();
        flood.detect();

        // ----------------------------------------------------------------
        // Task 2: SmartDeviceBuilder – Builder + Director
        // ----------------------------------------------------------------
        System.out.println();
        System.out.println("=== Task 2: SmartDeviceBuilder ===");

        SmartDeviceDirector director = new SmartDeviceDirector();

        SmartDevice camera = director.buildDefaultCamera("CAM-01", "Hallway");
        SmartDevice lock   = director.buildSecureLock("LK-01", "Front Door");
        System.out.println(camera);
        System.out.println(lock);

        // Demonstrate validation: pollingIntervalMs < 100 must throw
        try {
            new SmartDevice.Builder("BAD-01", "LOCK", "Back Door")
                    .pollingInterval(50)
                    .build();
        } catch (IllegalStateException e) {
            System.out.println("IllegalStateException: " + e.getMessage());
        }

        // ----------------------------------------------------------------
        // Task 3: PushNotificationAdapter – Object Adapter
        // ----------------------------------------------------------------
        System.out.println();
        System.out.println("=== Task 3: PushNotificationAdapter ===");

        AlertService alertService = new PushNotificationAdapter(new PushVendorSDK());

        alertService.sendAlert("Window sensor offline", 1);   // LOW
        alertService.sendAlert("Door left open",         3);   // MEDIUM
        alertService.sendAlert("Smoke alarm",            5);   // HIGH

        // ----------------------------------------------------------------
        // Task 4: SecurityFacade – Façade Pattern
        // ----------------------------------------------------------------
        System.out.println();
        System.out.println("=== Task 4: SecurityFacade ===");

        SecurityFacade security = new SecurityFacade();

        System.out.println("-- armHome() --");
        security.armHome();

        System.out.println("-- triggerIntruderAlert() --");
        security.triggerIntruderAlert();

        System.out.println("-- disarmHome() --");
        security.disarmHome();
    }
}
