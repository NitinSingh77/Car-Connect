package carConnect.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import carConnect.entity.Customer;
import carConnect.util.*;

public class CustomerService implements ICustomerService{
	static Connection connection;
	private static void getConnection() {
		if(connection==null)
		connection = DBConnUtil.getConnection(DBPropertyUtil.getConnectionString("db.properties"));
	}
	
	
	//-------------------- Get Customer Details Using Customer ID --------------------
	@Override
	public Customer getCustomerByID(int customerID) {
		getConnection();
	    Customer c = null;
	    PreparedStatement pstmt = null;
	    try {
	        pstmt = connection.prepareStatement("Select * from Customer where customerID=?");
	        pstmt.setInt(1, customerID);
	        ResultSet r = pstmt.executeQuery();
	        if (r.next()) {
	            c = new Customer(
	                r.getInt("customerID"), 
	                r.getString("FirstName"), 
	                r.getString("LastName"), 
	                r.getString("Email"), 
	                r.getString("PhoneNumber"), 
	                r.getString("Address"), 
	                r.getString("Username"), 
	                r.getString("Password"), 
	                r.getDate("RegistrationDate"));
	        }
	    } catch (SQLException err) {
	        err.printStackTrace();
	        System.out.println("Error while finding Customer details!");
	    }
	    return c;
	}

	
	//-------------------- Get Customer Details Using Username --------------------
	@Override
	public Customer getCustomerByUsername(String username) {
		getConnection();
	    Customer c = null;
	    PreparedStatement pstmt = null;
	    try {
	        pstmt = connection.prepareStatement("Select * from Customer where username=?");
	        pstmt.setString(1, username);
	        ResultSet r = pstmt.executeQuery();
	        if (r.next()) {
	            c = new Customer(
	                r.getInt("customerId"),  
	                r.getString("FirstName"), 
	                r.getString("LastName"), 
	                r.getString("Email"), 
	                r.getString("PhoneNumber"), 
	                r.getString("Address"), 
	                r.getString("Username"), 
	                r.getString("Password"), 
	                r.getDate("RegistrationDate"));
	        }
	    } catch (Exception err) {
	        err.printStackTrace();
	        System.out.println("Error while finding Customer details!");
	    }
	    return c;
	}

	
	//-------------------- Register New Customer --------------------
	@Override
	public void registerCustomer(Customer customerData) {
		getConnection();
		PreparedStatement pstmt= null;
		try {
			pstmt= connection.prepareStatement("insert into Customer(FirstName, LastName, Email, PhoneNumber, Address, Username, Password) values(?,?,?,?,?,?,?)");
			pstmt.setString(1, customerData.getFirstName()); 
		    pstmt.setString(2, customerData.getLastName());
		    pstmt.setString(3, customerData.getEmail());
		    pstmt.setString(4, customerData.getPhoneNumber());
		    pstmt.setString(5, customerData.getAddress());
		    pstmt.setString(6, customerData.getUsername());
		    pstmt.setString(7, customerData.getPassword());
		    int r= pstmt.executeUpdate();
		    if(r==0){
		    	System.out.println("Row Inserted Successfully.");
		    }
		}catch(Exception err){
			err.printStackTrace();
		}
	}

	
	//-------------------- Update Customer Details Using Customer ID --------------------
	@Override
	public void updateCustomer(Customer customerData) {
		getConnection();
		PreparedStatement pstmt= null;
		try {
			pstmt= connection.prepareStatement("update Customer set FirstName=?, LastName=?, Email=?, PhoneNumber=?, Address=?, Username=?, Password=? where CustomerID=?");
			pstmt.setString(1, customerData.getFirstName()); 
		    pstmt.setString(2, customerData.getLastName());
		    pstmt.setString(3, customerData.getEmail());
		    pstmt.setString(4, customerData.getPhoneNumber());
		    pstmt.setString(5, customerData.getAddress());
		    pstmt.setString(6, customerData.getUsername());
		    pstmt.setString(7, customerData.getPassword());
		    pstmt.setInt(8, customerData.getCustomerID());
		    int r= pstmt.executeUpdate();
		    if(r==1){
		    	System.out.println("Row updated successfully!");
		    }			
	}catch(SQLException err)
		{
		err.printStackTrace();
		System.out.println("Error while Updating in Customer table!");
		}
		
	}

	//-------------------- Delete Customer Details Using Customer ID --------------------
	@Override
	public void deleteCustomer(int customerID) {
		getConnection();
		PreparedStatement pstmt= null;
		try {
			pstmt= connection.prepareStatement("delete from Customer where CustomerID=?");
			pstmt.setInt(1, customerID); 		    
		    int r= pstmt.executeUpdate();
		    if(r==1){
		    	System.out.println("Row Deleted successfully!");
		    }
	}catch(SQLException err){
		err.printStackTrace();
		System.out.println("Error while deleting in Customer table!");
		}
	}

}