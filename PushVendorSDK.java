// Third-party library -- treat as read-only
public class PushVendorSDK {
    /**
     * Sends a push notification.
     * @param payload  JSON string, e.g. {"msg":"...", "urgency":"HIGH"}
     * @param token    device registration token
     */
    public void dispatch(String payload, String token) {
        System.out.println("PushVendorSDK.dispatch -> token=" + token
            + "  payload=" + payload);
    }
}
