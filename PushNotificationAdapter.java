/**
 * Task 3 – Object Adapter: PushNotificationAdapter
 *
 * WHY COMPOSITION OVER INHERITANCE
 * ---------------------------------
 * Java supports only single inheritance, so subclassing PushVendorSDK would
 * consume SmartHome's sole superclass slot and permanently bind the adapter
 * to a concrete vendor implementation.  Using composition (holding a
 * PushVendorSDK reference) decouples the adapter from the class hierarchy,
 * allows the wrapped SDK to be swapped or mocked without rewriting the
 * adapter, and aligns with the principle of "programming to an interface"
 * — only AlertService is visible to callers, never the vendor internals.
 */
public class PushNotificationAdapter implements AlertService {

    private static final String DEMO_TOKEN = "demo-token";

    private final PushVendorSDK sdk;

    public PushNotificationAdapter(PushVendorSDK sdk) {
        this.sdk = sdk;
    }

    /**
     * Translates an AlertService call into the PushVendorSDK format.
     *
     * Priority mapping:
     *   1–2 → "LOW"
     *   3   → "MEDIUM"
     *   4–5 → "HIGH"
     */
    @Override
    public void sendAlert(String message, int priorityLevel) {
        String urgency = toUrgency(priorityLevel);
        String payload = "{\"msg\":\"" + message + "\",\"urgency\":\"" + urgency + "\"}";
        sdk.dispatch(payload, DEMO_TOKEN);
    }

    private String toUrgency(int level) {
        if (level <= 2) return "LOW";
        if (level == 3) return "MEDIUM";
        return "HIGH";
    }
}
