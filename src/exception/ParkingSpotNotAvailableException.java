package exception;

public class ParkingSpotNotAvailableException extends RuntimeException {
    public ParkingSpotNotAvailableException() {
    }

    public ParkingSpotNotAvailableException(String message) {
        super(message);
    }

    public ParkingSpotNotAvailableException(String message, Throwable cause) {
        super(message, cause);
    }

    public ParkingSpotNotAvailableException(Throwable cause) {
        super(cause);
    }
}
