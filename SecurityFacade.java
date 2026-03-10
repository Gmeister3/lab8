/**
 * Task 4 – Façade Pattern: SecurityFacade
 *
 * Hides the orchestration complexity of four independent subsystems behind
 * three simple, intention-revealing methods.  Clients never need to know
 * about AlarmPanel, LockController, CameraGrid, or MotionDetectorArray;
 * they simply call armHome(), disarmHome(), or triggerIntruderAlert().
 */
public class SecurityFacade {

    private final LockController      locks;
    private final MotionDetectorArray motionDetectors;
    private final CameraGrid          cameras;
    private final AlarmPanel          alarm;

    public SecurityFacade() {
        this.locks           = new LockController();
        this.motionDetectors = new MotionDetectorArray();
        this.cameras         = new CameraGrid();
        this.alarm           = new AlarmPanel();
    }

    /**
     * Arms the home security system in a safe, ordered sequence:
     * 1. Lock all doors first to secure entry points before activating sensors.
     * 2. Activate motion detectors once physical locks are in place.
     * 3. Start camera recording so evidence capture begins before alarm arm.
     * 4. Arm the alarm panel last — the system is now fully secured.
     */
    public void armHome() {
        locks.lockAll();            // 1. secure entry points
        motionDetectors.activate(); // 2. start sensing movement
        cameras.startRecording();   // 3. begin video evidence capture
        alarm.armPanel();           // 4. arm the electronic alarm
    }

    /**
     * Disarms the home security system in a safe, ordered sequence:
     * 1. Disarm the alarm panel first to prevent accidental siren trigger.
     * 2. Deactivate motion detectors so re-entry doesn't cause false alerts.
     * 3. Stop camera recording once sensors are quiet.
     * 4. Unlock doors last — entry is only permitted after everything else is safe.
     */
    public void disarmHome() {
        alarm.disarmPanel();          // 1. silence the alarm first
        motionDetectors.deactivate(); // 2. prevent false-positive triggers on re-entry
        cameras.stopRecording();      // 3. cease recording
        locks.unlockAll();            // 4. allow entry only after alarm is cleared
    }

    /**
     * Responds to a detected intruder:
     * 1. Save a camera clip immediately to preserve evidence.
     * 2. Trigger the siren to deter the intruder and alert neighbours.
     * 3. Lock all doors to contain the intruder and protect occupants.
     */
    public void triggerIntruderAlert() {
        cameras.saveClip();   // 1. preserve evidence first
        alarm.triggerSiren(); // 2. sound the alarm
        locks.lockAll();      // 3. lock down the premises
    }
}
