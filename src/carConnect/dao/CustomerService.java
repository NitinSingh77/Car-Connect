package carConnect.dao;
import java.sql.*;

import carConnect.entity.Customer;
import carConnect.util.DBConnUtil;
import carConnect.util.DBPropertyUtil;

public class CustomerService implements ICustomerService{
	
	static Connection con;
	private static void getCon()
	{
		if(con==null)
		con= DBConnUtil.getConnection(DBPropertyUtil.getConnString("D:/Eclipse-workspace/Car-Connect-main/db.properties"));
	}

	@Override
	public Customer getCustomerById(int customerId) {
		// TODO Auto-generated method stub
		getCon();
		Customer obj= null;
		PreparedStatement pstmt= null;
		try {
			pstmt= con.prepareStatement("Select * from Customer where customerId=?");
			pstmt.setInt(1, customerId);
			ResultSet res= pstmt.executeQuery();
			
			if(res.next())
			{
				 obj= new Customer(res.getString("FirstName"), res.getString("LastName"), res.getString("Email"), res.getString("PhoneNumber"), res.getString("Address"), res.getString("Username"), res.getString("Password"));
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println("Error while finding Customer details!");
		}
		return obj;
	}

	@Override
	public Customer getCustomerByUsername(String username) {
		// TODO Auto-generated method stub
		getCon();
		Customer obj= null;
		PreparedStatement pstmt= null;
		try {
			pstmt= con.prepareStatement("Select * from Customer where username=?");
			pstmt.setString(1, username);
			ResultSet res= pstmt.executeQuery();
			
			if(res.next())
			{
				 obj= new Customer(res.getString("FirstName"), res.getString("LastName"), res.getString("Email"), res.getString("PhoneNumber"), res.getString("Address"), res.getString("Username"), res.getString("Password"));
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println("Error while finding Customer details!");
		}
		return obj;
		
	}

	@Override
	public void registerCustomer(Customer customerData) {
		// TODO Auto-generated method stub
		getCon();
		
		PreparedStatement pstmt= null;
		try {
			pstmt= con.prepareStatement("insert into Customer(FirstName, LastName, Email, PhoneNumber, Address, Username, Password) values(?,?,?,?,?,?,?)");
			pstmt.setString(1, customerData.getFirstName()); 
		    pstmt.setString(2, customerData.getLastName());
		    pstmt.setString(3, customerData.getEmail());
		    pstmt.setString(4, customerData.getPhoneNumber());
		    pstmt.setString(5, customerData.getAddress());
		    pstmt.setString(6, customerData.getUsername());
		    pstmt.setString(7, customerData.getPassword());
		    
		    int roweffected= pstmt.executeUpdate();
		    if(roweffected>0)
		    {
		    	System.out.println("Row Inserted Successfully.");
		    }
			
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public void updateCustomer(Customer customerData) {
		// TODO Auto-generated method stub
		getCon();
		
		PreparedStatement pstmt= null;
		try {
			pstmt= con.prepareStatement("update Customer set FirstName=?, LastName=?, Email=?, PhoneNumber=?, Address=?, Username=?, Password=?");
			pstmt.setString(1, customerData.getFirstName()); 
		    pstmt.setString(2, customerData.getLastName());
		    pstmt.setString(3, customerData.getEmail());
		    pstmt.setString(4, customerData.getPhoneNumber());
		    pstmt.setString(5, customerData.getAddress());
		    pstmt.setString(6, customerData.getUsername());
		    pstmt.setString(7, customerData.getPassword());
		    
		    int roweffected= pstmt.executeUpdate();
		    if(roweffected>0)
		    {
		    	System.out.println("Row updated successfully!");
		    }
		    
			
	}catch(SQLException e)
		{
		e.printStackTrace();
		System.out.println("Error while Updating in Customer table!");
		}
	}

	@Override
	public void deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		getCon();
		
		PreparedStatement pstmt= null;
		try {
			pstmt= con.prepareStatement("delete from Customer where customerId=?");
			pstmt.setInt(1, customerId); 		    
		    int roweffected= pstmt.executeUpdate();
		    if(roweffected>0)
		    {
		    	System.out.println("Row Deleted successfully!");
		    }
		    
			
	}catch(SQLException e)
		{
		e.printStackTrace();
		System.out.println("Error while deleting in Customer table!");
		}
		
	}
	

}
