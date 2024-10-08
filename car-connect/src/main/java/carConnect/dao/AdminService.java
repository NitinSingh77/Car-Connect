package carConnect.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import carConnect.entity.Admin;
import carConnect.util.*;

public class AdminService implements IAdminService{
	static Connection conn;
	private static void getConnection(){
		if(conn==null)
			conn= DBConnUtil.getConnection(DBPropertyUtil.getConnectionString("db.properties"));
	}
	
	
	//-------------------- Get Admin Details Using Admin ID --------------------
	@Override
	public Admin getAdminByID(int adminID){
		getConnection();
		Admin a= null;
		PreparedStatement pstmt= null;
		try {
			pstmt= conn.prepareStatement("Select * from Admin where AdminID=?");
			pstmt.setInt(1, adminID);
			ResultSet r= pstmt.executeQuery();
			if(r.next()){
				 a= new Admin(
						 r.getInt("AdminID"), 
						 r.getString("FirstName"), 
						 r.getString("LastName"), 
						 r.getString("Email"), 
						 r.getString("PhoneNumber"),  
						 r.getString("Username"), 
						 r.getString("Password"),
						 r.getString("Role"), 
						 r.getDate("JoinDate"));
			}
		}catch(Exception err){
			err.printStackTrace();
			System.out.println("Error while finding Admin details!");
		}
		return a;
	}

	
	//-------------------- Get Admin Details Using Username --------------------
	@Override
	public Admin getAdminByUsername(String username)  {
		getConnection();
		Admin a= null;
		PreparedStatement pstmt= null;
		try {
			pstmt= conn.prepareStatement("Select * from Admin where Username=?");
			pstmt.setString(1, username);
			ResultSet r= pstmt.executeQuery();
			if(r.next()){
				 a= new Admin(r.getInt("AdminID"),
						 r.getString("FirstName"), 
						 r.getString("LastName"), 
						 r.getString("Email"), 
						 r.getString("PhoneNumber"),  
						 r.getString("Username"), 
						 r.getString("Password"),
						 r.getString("Role"), 
						 r.getDate("JoinDate"));
			}
		}catch(Exception err){
			err.printStackTrace();
			System.out.println("Error while finding Admin details!");
		}
		return a;
	}

	
	//-------------------- Register New Admin --------------------
	@Override
	public void registerAdmin(Admin admin) {
	    getConnection();
	    PreparedStatement pstmt = null;
	    try {
	        // Updated SQL query to include the role
	    	pstmt= conn.prepareStatement("insert into Admin(FirstName, LastName, Email, PhoneNumber, Username, Password, Role) values(?,?,?,?,?,?,?)");
			pstmt.setString(1, admin.getFirstName()); 
		    pstmt.setString(2, admin.getLastName());
		    pstmt.setString(3, admin.getEmail());
		    pstmt.setString(4, admin.getPhoneNumber() );
		    pstmt.setString(5, admin.getUsername());
		    pstmt.setString(6, admin.getPassword());
		    pstmt.setString(7, admin.getRole());	
	        int r = pstmt.executeUpdate();
	        if (r == 1) {
	            System.out.println("Row Inserted Successfully.");
	        }
	    } catch (SQLException err) {
	        err.printStackTrace();
	    }    
	}

	
	//-------------------- Update Admin Details Using Admin ID--------------------
	@Override
	public void updateAdmin(Admin admin) {
		getConnection();
		PreparedStatement pstmt= null;
		try {
			pstmt= conn.prepareStatement("update Admin set FirstName=?, LastName=?, Email=?, PhoneNumber=?, Username=?, Password=?, Role=? where AdminID=?");
			pstmt.setString(1, admin.getFirstName()); 
		    pstmt.setString(2, admin.getLastName());
		    pstmt.setString(3, admin.getEmail());
		    pstmt.setString(4, admin.getPhoneNumber() );
		    pstmt.setString(5, admin.getUsername());
		    pstmt.setString(6, admin.getPassword());
		    pstmt.setString(7, admin.getRole());
		    pstmt.setInt(8, admin.getAdminID());
		    int r= pstmt.executeUpdate();
		    if(r==1){
		    	System.out.println("Row updated successfully!");
		    }
		    }catch(SQLException err){
		    	err.printStackTrace();
		    	System.out.println("Error while Updating in Customer table!");
		    	}
		}

	
	//-------------------- Delete Admin Using Admin ID --------------------
	@Override
	public void deleteAdmin(int adminID) {
		getConnection();
		PreparedStatement pstmt= null;
		try {
			pstmt= conn.prepareStatement("delete from Admin where adminId=?");
			pstmt.setInt(1, adminID); 		    
		    int r= pstmt.executeUpdate();
		    if(r==1){
		    	System.out.println("Row Deleted successfully!");
		    } 
	}catch(SQLException err){
		err.printStackTrace();
		System.out.println("Error while deleting in Admin table!");
		}
	}
}