/**
 * Task 2 – Builder Pattern: SmartDevice with inner Builder class.
 *
 * Replaces the telescoping constructors from the original naïve version.
 * The three required fields are enforced at Builder construction time;
 * optional fields are set through fluent setter methods, making call
 * sites self-documenting and immune to parameter-ordering mistakes.
 */
public class SmartDevice {
    private final String  deviceId;           // required
    private final String  type;               // "LOCK" | "CAMERA" | "THERMOSTAT"
    private final String  location;           // required
    private final int     firmwareVersion;    // optional, default 1
    private final boolean isEncrypted;        // optional, default false
    private final int     pollingIntervalMs;  // optional, default 5000

    private SmartDevice(Builder builder) {
        this.deviceId          = builder.deviceId;
        this.type              = builder.type;
        this.location          = builder.location;
        this.firmwareVersion   = builder.firmwareVersion;
        this.isEncrypted       = builder.isEncrypted;
        this.pollingIntervalMs = builder.pollingIntervalMs;
    }

    @Override public String toString() {
        return String.format("[%s] %s @ %s | fw=%d enc=%b poll=%dms",
            deviceId, type, location, firmwareVersion, isEncrypted, pollingIntervalMs);
    }

    // -----------------------------------------------------------------------
    // Inner Builder
    // -----------------------------------------------------------------------
    public static class Builder {
        // Required fields
        private final String deviceId;
        private final String type;
        private final String location;

        // Optional fields with defaults
        private int     firmwareVersion   = 1;
        private boolean isEncrypted       = false;
        private int     pollingIntervalMs = 5000;

        /**
         * Initializes the builder with the three mandatory fields.
         */
        public Builder(String deviceId, String type, String location) {
            this.deviceId  = deviceId;
            this.type      = type;
            this.location  = location;
        }

        /** Sets the firmware version (optional). */
        public Builder firmwareVersion(int fw) {
            this.firmwareVersion = fw;
            return this;
        }

        /** Sets the encryption flag (optional). */
        public Builder encrypted(boolean enc) {
            this.isEncrypted = enc;
            return this;
        }

        /** Sets the polling interval in milliseconds (optional, must be >= 100). */
        public Builder pollingInterval(int ms) {
            this.pollingIntervalMs = ms;
            return this;
        }

        /**
         * Validates configuration and returns a new SmartDevice.
         *
         * @throws IllegalStateException if pollingIntervalMs is less than 100
         */
        public SmartDevice build() {
            if (pollingIntervalMs < 100) {
                throw new IllegalStateException(
                    "pollingIntervalMs must be >= 100; got " + pollingIntervalMs);
            }
            return new SmartDevice(this);
        }
    }
}
