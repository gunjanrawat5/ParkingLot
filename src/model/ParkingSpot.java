package model;

import model.constants.ParkingSpotStatus;
import model.constants.ParkingSpotTier;
import model.constants.VehicleType;

public class ParkingSpot {
    private int id;
    private String parkingSportNumber;
    private ParkingSpotStatus parkingSpotStatus;
    private VehicleType vehicleTypeSupported;
    private ParkingSpotTier parkingSpotTier;
    private Vehicle vehicle;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getParkingSportNumber() {
        return parkingSportNumber;
    }

    public void setParkingSportNumber(String parkingSportNumber) {
        this.parkingSportNumber = parkingSportNumber;
    }

    public ParkingSpotStatus getParkingSpotStatus() {
        return parkingSpotStatus;
    }

    public void setParkingSpotStatus(ParkingSpotStatus parkingSpotStatus) {
        this.parkingSpotStatus = parkingSpotStatus;
    }

    public VehicleType getVehicleTypeSupported() {
        return vehicleTypeSupported;
    }

    public void setVehicleTypeSupported(VehicleType vehicleTypeSupported) {
        this.vehicleTypeSupported = vehicleTypeSupported;
    }

    public ParkingSpotTier getParkingSpotTier() {
        return parkingSpotTier;
    }

    public void setParkingSpotTier(ParkingSpotTier parkingSpotTier) {
        this.parkingSpotTier = parkingSpotTier;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
