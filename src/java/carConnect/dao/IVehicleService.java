<<<<<<< HEAD
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
=======
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
>>>>>>> cf09df744e197d6953e9e83a50eb81514f430173
