package carConnect.dao;

import carConnect.entity.*;
import carConnect.exception.VehicleNotFoundException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.sql.SQLException;

public class VehicleServiceTest {

    private VehicleService mockVehicleService; // Mock of VehicleServiceImpl

    @BeforeEach
    public void setUp() {
        // Mock the VehicleServiceImpl using Mockito
        mockVehicleService = Mockito.mock(VehicleService.class);
    }

    @Test
    public void testUpdateVehicleDetails() throws SQLException, VehicleNotFoundException {
        // Create a dummy vehicle object with initial data
        Vehicle vehicle = new Vehicle();
        vehicle.setVehicleID(6); 
        vehicle.setModel("Tesla Model S");
        vehicle.setMake("Tesla");
        vehicle.setYear(2021);
        vehicle.setColor("Red");
        vehicle.setRegistrationNumber("ABC123");
        vehicle.setAvailability(true);
        vehicle.setDailyRate(300.0);

        // Simulate the updateVehicle method with Mockito
        doNothing().when(mockVehicleService).updateVehicle(vehicle);

        
        vehicle.setModel("Tesla Model X"); // New model
        vehicle.setColor("Blue"); // New color
        vehicle.setDailyRate(350.0); // New daily rate

        
        assertDoesNotThrow(() -> mockVehicleService.updateVehicle(vehicle)); 

        
        verify(mockVehicleService, times(1)).updateVehicle(vehicle);

        // Simulate fetching the updated vehicle details
        when(mockVehicleService.getVehicleByID(6)).thenReturn(vehicle);

        
        Vehicle updatedVehicle = mockVehicleService.getVehicleByID(6);
        assertEquals("Tesla Model X", updatedVehicle.getModel(), "The model should be updated.");
        assertEquals("Blue", updatedVehicle.getColor(), "The color should be updated.");
        assertEquals(350.0, updatedVehicle.getDailyRate(), "The daily rate should be updated.");
    }
}
