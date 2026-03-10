// Internal interface -- do not modify
public interface AlertService {
    void sendAlert(String message, int priorityLevel);  // 1=low, 5=critical
}
