package carConnect.dao;

import carConnect.entity.Vehicle;
import carConnect.exception.VehicleNotFoundException;

import java.sql.SQLException;
import java.util.List;

public interface IVehicleService {
	Vehicle getVehicleByID(int vehicleID) throws SQLException, VehicleNotFoundException;
    List<Vehicle> getAvailableVehicles() throws SQLException;
    void addVehicle(Vehicle vehicleData) throws SQLException;
    void updateVehicle(Vehicle vehicleData) throws SQLException, VehicleNotFoundException;
    void removeVehicle(int vehicleID) throws SQLException, VehicleNotFoundException;
}
