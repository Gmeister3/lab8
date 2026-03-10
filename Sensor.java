public abstract class Sensor {
    protected String location;
    public Sensor(String location) { this.location = location; }
    public abstract void detect();
    public String getLocation()    { return location; }
}

class MotionSensor extends Sensor {
    public MotionSensor(String location) { super(location); }
    @Override public void detect() {
        System.out.println("Motion detected at " + location);
    }
}

class DoorSensor extends Sensor {
    public DoorSensor(String location) { super(location); }
    @Override public void detect() {
        System.out.println("Door opened at " + location);
    }
}

class ThermostatSensor extends Sensor {
    public ThermostatSensor(String location) { super(location); }
    @Override public void detect() {
        System.out.println("Temperature threshold exceeded at " + location);
    }
}

class FloodSensor extends Sensor {
    public FloodSensor(String location) { super(location); }
    @Override public void detect() {
        System.out.println("Flood detected at " + location);
    }
}
