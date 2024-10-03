package java.carConnect.entity;

import java.util.Date;

public class Admin {
	// Properties of Admin Class
	private int adminID;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String username;
	private String password;
	private String role;
	private Date joinDate;
	
	// Default Constructor
	public Admin() {
		super();
	}
	
	// Parameterized Constructor
	public Admin(int adminId, String firstName, String lastName, String email, String phoneNumber, 
			String userName, String password, String role, Date joinDate){
		this.adminID = adminId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		this.username = userName;
		this.password = password;
		this.role = role;
		this.joinDate = joinDate;
	}
	
	// Getters and Setters
	
	//--------- AdminID--------------------------------------
	public int getAdminId() {
        return adminID;
    }
    public void setAdminId(int adminId) {
        this.adminID = adminId;
    }
    
  //--------- FirstName--------------------------------------
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    
  //--------- LastName--------------------------------------
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    
  //--------- Email--------------------------------------
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }

  //--------- PhoneNumber--------------------------------------
    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

  //--------- Username--------------------------------------
    public String getUsername() {
        return username;
    }
    public void setUsername(String username) {
        this.username = username;
    }
    
  //--------- Password--------------------------------------
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }

  //--------- Role--------------------------------------
    public String getRole() {
        return role;
    }
    public void setRole(String role) {
        this.role = role;
    }

  //--------- JoinDate--------------------------------------
    public Date getJoinDate() {
        return joinDate;
    }
    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    //Authenticate Admin
    public boolean authenticate(String inputPassword) {
        return this.password.equals(inputPassword);
    }

	@Override
	public String toString() {
		return "Admin{" +
                "adminId=" + adminID +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", username='" + username + '\'' +
                ", role='" + role + '\'' +
                ", joinDate=" + joinDate +
                '}';
	}
	
}
