class AlarmPanel {
    public void disarmPanel()  { System.out.println("AlarmPanel: disarmed"); }
    public void armPanel()     { System.out.println("AlarmPanel: armed"); }
    public void triggerSiren() { System.out.println("AlarmPanel: SIREN ON"); }
}

class LockController {
    public void unlockAll() { System.out.println("LockController: all locks open"); }
    public void lockAll()   { System.out.println("LockController: all locks secured"); }
}

class CameraGrid {
    public void startRecording() { System.out.println("CameraGrid: recording"); }
    public void stopRecording()  { System.out.println("CameraGrid: standby"); }
    public void saveClip()       { System.out.println("CameraGrid: clip saved"); }
}

class MotionDetectorArray {
    public void activate()   { System.out.println("MotionDetectors: active"); }
    public void deactivate() { System.out.println("MotionDetectors: inactive"); }
}
