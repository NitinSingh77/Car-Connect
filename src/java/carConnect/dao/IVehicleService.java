package java.carConnect.dao;

import java.carConnect.entity.Vehicle;
import java.util.List;

public interface IVehicleService {
	Vehicle getVehicleById(int vehicleId);
    List<Vehicle> getAvailableVehicles();
    void addVehicle(Vehicle vehicleData);
    void updateVehicle(Vehicle vehicleData);
    void removeVehicle(int vehicleId);
}
