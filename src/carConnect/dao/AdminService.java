package carConnect.dao;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import carConnect.entity.Admin;
import carConnect.util.DBConnUtil;
import carConnect.util.DBPropertyUtil;

public class AdminService implements IAdminService {
	static Connection con;
	private static void getCon()
	{
		if(con==null)
		con= DBConnUtil.getConnection(DBPropertyUtil.getConnString("D:/Eclipse-workspace/Car-Connect-main/db.properties"));
	}

	@Override
	public Admin getAdminById(int adminId) {
		// TODO Auto-generated method stub
		getCon();
		Admin obj= null;
		PreparedStatement pstmt= null;
		try {
			pstmt= con.prepareStatement("Select * from Customer where customerId=?");
			pstmt.setInt(1, adminId);
			ResultSet res= pstmt.executeQuery();
			
			if(res.next())
			{
				 obj= new Admin(res.getString("FirstName"), 
						 res.getString("LastName"), 
						 res.getString("Email"), 
						 res.getString("PhoneNumber"),  
						 res.getString("Username"), 
						 res.getString("Password"),
						 res.getString("Role"));
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println("Error while finding Admin details!");
		}
		return obj;
	}

	@Override
	public Admin getAdminByUsername(String username) {
		// TODO Auto-generated method stub
		getCon();
		Admin obj= null;
		PreparedStatement pstmt= null;
		try {
			pstmt= con.prepareStatement("Select * from Customer where Username=?");
			pstmt.setString(1, username);
			ResultSet res= pstmt.executeQuery();
			
			if(res.next())
			{
				 obj= new Admin(res.getString("FirstName"), 
						 res.getString("LastName"), 
						 res.getString("Email"), 
						 res.getString("PhoneNumber"),  
						 res.getString("Username"), 
						 res.getString("Password"),
						 res.getString("Role"));
			}
		}catch(Exception ex)
		{
			ex.printStackTrace();
			System.out.println("Error while finding Admin details!");
		}
		return obj;
	}

	@Override
	public void registerAdmin(Admin admin) {
		// TODO Auto-generated method stub
		getCon();
		
		PreparedStatement pstmt= null;
		try {
			pstmt= con.prepareStatement("insert into Customer(FirstName, LastName, Email, PhoneNumber, Username, Password, Role) values(?,?,?,?,?,?,?)");
			pstmt.setString(1, admin.getFirstName()); 
		    pstmt.setString(2, admin.getLastName());
		    pstmt.setString(3, admin.getEmail());
		    pstmt.setString(4, admin.getPhoneNumber() );
		    pstmt.setString(5, admin.getUsername());
		    pstmt.setString(6, admin.getPassword());
		    pstmt.setString(7, admin.getRole());
		    
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
	public void updateAdmin(Admin admin) {
		// TODO Auto-generated method stub
		getCon();
		
		PreparedStatement pstmt= null;
		try {
			pstmt= con.prepareStatement("update Customer set FirstName=?, LastName=?, Email=?, PhoneNumber=?, Username=?, Password=?, Role=?");
			pstmt.setString(1, admin.getFirstName()); 
		    pstmt.setString(2, admin.getLastName());
		    pstmt.setString(3, admin.getEmail());
		    pstmt.setString(4, admin.getPhoneNumber() );
		    pstmt.setString(5, admin.getUsername());
		    pstmt.setString(6, admin.getPassword());
		    pstmt.setString(7, admin.getRole());
		    
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
	public void deleteAdmin(int adminId) {
		// TODO Auto-generated method stub
		getCon();
		
		PreparedStatement pstmt= null;
		try {
			pstmt= con.prepareStatement("delete from Customer where adminId=?");
			pstmt.setInt(1, adminId); 		    
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
