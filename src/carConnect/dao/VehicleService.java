package carConnect.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import carConnect.entity.Vehicle;
import carConnect.exception.VehicleNotFoundException;

import java.util.ArrayList;
import java.util.List;
import carConnect.util.*;


public class VehicleService implements IVehicleService{
	static Connection connection;
	
	private static void getConnection() throws SQLException{
		if(connection ==null)
			connection = DBConnUtil.getConnection(DBPropertyUtil.getConnectionString("db.properties"));
	}
	
	
	//-------------------- Get Vehicle Details Using Vehicle ID --------------------
	@Override
	public Vehicle getVehicleByID(int vehicleID) throws VehicleNotFoundException, SQLException {
		getConnection();
		Vehicle v=null;
		PreparedStatement pstmt=null;
		try {
			pstmt=connection.prepareStatement("select * from Vehicle where VehicleID=?");
			pstmt.setInt(1, vehicleID);
			ResultSet r=pstmt.executeQuery();
			if(r.next())
			{
				 v = new Vehicle(r.getInt("VehicleID"), 
				            r.getString("Model"), 
				            r.getString("Make"), 
				            r.getInt("Year"), 
				            r.getString("Color"),
				            r.getString("Registration Number"),
				            r.getBoolean("Availability"),
				            r.getDouble("Daily Rate"));
			}
		}catch(Exception err)
		{
			err.printStackTrace();
			System.out.println("Error while finding Vehicle details");
		}
		return v;
	}

	
	//-------------------- Get List of All Available Vehicles --------------------
	@Override
	public List<Vehicle> getAvailableVehicles() throws SQLException {
		List<Vehicle> vehicle =new ArrayList<Vehicle>();
		Vehicle v=null;
		getConnection();
		Statement stmt=null;
		try {
			stmt=connection.createStatement();
			ResultSet r=stmt.executeQuery("select * from Vehicle where  Availability=true");
			while(r.next())
			{
				v = new Vehicle(r.getInt("VehicleID"), 
			            r.getString("Model"), 
			            r.getString("Make"), 
			            r.getInt("Year"), 
			            r.getString("Color"),
			            r.getString("Registration Number"),
			            r.getBoolean("Availability"),
			            r.getDouble("Daily Rate"));
				vehicle.add(v);
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println("Error while finding Emp details");
		}
		return vehicle;
	}

	
	//-------------------- Add New Vehicle --------------------
	@Override
	public void addVehicle(Vehicle vehicleData) throws SQLException {
		getConnection();
		PreparedStatement pstmt=null;
		try {
			
			pstmt=connection.prepareStatement("insert into Vehicle values(?,?,?,?,?,?,?,?)");
			pstmt.setInt(1, vehicleData.getVehicleID());
			pstmt.setString(2, vehicleData.getModel());
			pstmt.setString(3, vehicleData.getMake());
			pstmt.setInt(4, vehicleData.getYear());
			pstmt.setString(5, vehicleData.getColor());
			pstmt.setString(6, vehicleData.getRegistrationNumber());
			pstmt.setBoolean(7,vehicleData.getAvailability());
			pstmt.setDouble(8,vehicleData.getDailyRate());
			int r=pstmt.executeUpdate();
			if(r==1)
				System.out.println("New Vehicle Added");
			
		}catch(SQLException err)
		{
			err.printStackTrace();
			System.out.println("Error while inserting Vehicle details.....");
		}
		
	}

	
	//-------------------- Update Vehicle Details Using Vehicle ID --------------------
	@Override
	public void updateVehicle(Vehicle vehicleData) throws SQLException, VehicleNotFoundException{
		getConnection();
		PreparedStatement pstmt=null;
		try {
			pstmt=connection.prepareStatement("update Vehicle set Model=?,Make=?,Year=?,Color=?,RegistrationNumber=?,Availability=? where VehicleID=?");
			pstmt.setString(1, vehicleData.getModel());
			pstmt.setString(2, vehicleData.getMake());
			pstmt.setInt(3, vehicleData.getYear());
			pstmt.setString(4, vehicleData.getColor());
			pstmt.setString(5, vehicleData.getRegistrationNumber());
			pstmt.setBoolean(6, vehicleData.getAvailability());
			pstmt.setDouble(7, vehicleData.getDailyRate());
			pstmt.setInt(8, vehicleData.getVehicleID());
			int r=pstmt.executeUpdate();
			if(r==1)
				System.out.println("Vehicle Details are Successfully Updated");
			
		}catch(SQLException err)
		{
			err.printStackTrace();
			System.out.println("Error while Updating Vehicle details.....");
		}
		
	}
	
	
	//-------------------- Remove Vehicle Details Using Vehicle ID --------------------
	@Override
	public void removeVehicle(int vehicleID) throws SQLException, VehicleNotFoundException {
		getConnection();
		PreparedStatement pstmt=null;
		try {
			pstmt=connection.prepareStatement("delete from Vehicle where VehicleID=?");
			pstmt.setInt(1, vehicleID);
			int r=pstmt.executeUpdate();
			if(r==1)
				System.out.println("Vehicle Details Successfully Deleted");
			
		}catch(SQLException ex)
		{
			ex.printStackTrace();
			System.out.println("Error while Deleting Vehicle details.....");
		}
		
	}

}
