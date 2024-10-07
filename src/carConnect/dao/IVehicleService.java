package carConnect.dao;

import java.util.List;

import carConnect.entity.Vehicle;

public interface IVehicleService {
	Vehicle getVehicleByID(int vehicleID);
    List<Vehicle> getAvailableVehicles();
    void addVehicle(Vehicle vehicleData);
    void updateVehicle(Vehicle vehicleData);
    void removeVehicle(int vehicleID);
}
