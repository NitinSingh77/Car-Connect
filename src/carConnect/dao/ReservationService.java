package carConnect.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import carConnect.entity.Reservation;
import carConnect.exception.ReservationException;
import carConnect.util.DBConnUtil;
import carConnect.util.DBPropertyUtil;

public class ReservationService implements IReservationService{
	static Connection connection;
	
	private static void getConnection() throws SQLException{
		if(connection ==null)
			connection = DBConnUtil.getConnection(DBPropertyUtil.getConnectionString("db.properties"));
	}
	
	
	//-------------------- Get Reservation Details Using Reservation ID --------------------
	@Override
	public Reservation getReservationByID(int reservationID) throws SQLException, ReservationException {
		getConnection();
		Reservation r=null;
		PreparedStatement pstmt=null;
		try {
			pstmt = connection.prepareStatement("select & from Reservation where ReservationID =?");
			pstmt.setInt(1, reservationID);
			ResultSet rs= pstmt.executeQuery();
			if(rs.next()) {
				r = new Reservation(rs.getInt("ReservationID"),
						rs.getInt("CustomerID"),
						rs.getInt("VehicleID"),
						rs.getDate("Start Date"),
						rs.getDate("End Date"),
						rs.getDouble("Total Cost"),
						rs.getString("Status")
						);
			}
		}catch(Exception err) {
			err.printStackTrace();
			System.out.println("Error while finding Reservation details");
		}
		return r;
	}

	
	//-------------------- Get Reservation Details Using Customer ID --------------------
	@Override
	public List<Reservation> getReservationsByCustomerID(int customerID) throws SQLException, ReservationException {
		getConnection();
		List<Reservation> reservation =new ArrayList<Reservation>();
		Reservation r=null;
		PreparedStatement pstmt=null;
		try {
			pstmt = connection.prepareStatement("select * from Reservation where CustomerID =?");
			pstmt.setInt(1, customerID);
			ResultSet rs= pstmt.executeQuery();
			if(rs.next()) {
				r = new Reservation(rs.getInt("ReservationID"),
						rs.getInt("CustomerID"),
						rs.getInt("VehicleID"),
						rs.getDate("Start Date"),
						rs.getDate("End Date"),
						rs.getDouble("Total Cost"),
						rs.getString("Status")
						);
				reservation.add(r);
			}
		}catch(Exception err) {
			err.printStackTrace();
			System.out.println("Error while finding Reservation details");
		}
		return reservation;
	}
	
	
	//-------------------- Add New Reservation --------------------
	@Override
	public void createReservation(Reservation reservationData) throws SQLException, ReservationException{
		getConnection();
		PreparedStatement pstmt=null;
		try {
			pstmt=connection.prepareStatement("insert into Reservation values(?,?,?,?,?,?,?)");
			pstmt.setInt(1, reservationData.getReservationID());
			pstmt.setInt(2, reservationData.getCustomerID());
			pstmt.setInt(3, reservationData.getVehicleID());
			pstmt.setDate(4, (java.sql.Date) reservationData.getStartDate());
			pstmt.setDate(5, (java.sql.Date) reservationData.getEndDate());
			pstmt.setDouble(6, reservationData.getTotalCost());
			pstmt.setString(7,reservationData.getStatus());
			int r=pstmt.executeUpdate();
			if(r==1)
				System.out.println("New Resevation Created");
			
		}catch(SQLException err)
		{
			err.printStackTrace();
			System.out.println("Error while inserting Reservation details.....");
		}
	}
	

	//-------------------- Update Reservation Details --------------------
	@Override
	public void updateReservation(Reservation reservationData) throws SQLException {
		getConnection();
		PreparedStatement pstmt=null;
		try {
			pstmt=connection.prepareStatement("update Reservation set CustomerID=?, VehicleID=?, StartDate=?, EndDate=?, TotalCost=?, Status=? where ReservationID=?");
			pstmt.setInt(1, reservationData.getReservationID());
			pstmt.setInt(2, reservationData.getCustomerID());
			pstmt.setInt(3, reservationData.getVehicleID());
			pstmt.setDate(4, (java.sql.Date) reservationData.getStartDate());
			pstmt.setDate(5, (java.sql.Date) reservationData.getEndDate());
			pstmt.setDouble(6, reservationData.getTotalCost());
			pstmt.setString(7,reservationData.getStatus());
			int r=pstmt.executeUpdate();
			if(r==1)
				System.out.println("Reservation Details are Successfully Updated");
			
		}catch(SQLException err)
		{
			err.printStackTrace();
			System.out.println("Error while inserting Reservation details.....");
		}
		
	}

	
	//-------------------- Cancel Reservation Details Using Reservation ID --------------------
	@Override
	public void cancelReservation(int reservationID) throws SQLException, ReservationException {
		getConnection();
		PreparedStatement pstmt=null;
		try {
			pstmt=connection.prepareStatement("delete from Reservation where ReservationID=?");
			pstmt.setInt(1,reservationID);
			int r=pstmt.executeUpdate();
			if(r==1)
				System.out.println("Reservation Details Successfully Deleted");
			
		}catch(SQLException err)
		{
			err.printStackTrace();
			System.out.println("Error while deleting Reservation details.....");
		}
	}

}
