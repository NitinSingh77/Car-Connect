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
		return null;
	}

	@Override
	public Customer getCustomerByUsername(String username) {
		// TODO Auto-generated method stub
		return null;
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
		
	}

	@Override
	public void deleteCustomer(int customerId) {
		// TODO Auto-generated method stub
		
	}
	

}
