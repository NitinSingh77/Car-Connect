package java.carConnect.entity;

import java.util.Date;

public class Customer {
	// Properties of Customer Class
	private int customerID;
    private String firstName;
    private String lastName;
    private String email;
    private String phoneNumber;
    private String address;
    private String username;
    private String password;
    private Date registrationDate;
    
 // Default constructor
    public Customer() {
    	super();
    }
    
 // Parameterized constructor
    public Customer(int customerID, String firstName, String lastName, String email, String phoneNumber, String address, String username, String password, Date registrationDate) {
        this.customerID = customerID;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.address = address;
        this.username = username;
        this.password = password;
        this.registrationDate = registrationDate;
    }
    
 // Getters and Setters
    
  //--------- CustomerID--------------------------------------
    public int getCustomerID() {
        return customerID;
    }
    public void setCustomerID(int customerID) {
        this.customerID = customerID;
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

  //--------- Address--------------------------------------
    public String getAddress() {
        return address;
    }
    public void setAddress(String address) {
        this.address = address;
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

  //--------- RegistrationDate--------------------------------------
    public Date getRegistrationDate() {
        return registrationDate;
    }
    public void setRegistrationDate(Date registrationDate) {
        this.registrationDate = registrationDate;
    }

    //Authenticate Customer
    public boolean authenticate(String password) {
        return this.password.equals(password);
    }

	@Override
	public String toString() {
		return "Customer [customerId=" + customerID + ", firstName=" + firstName + ", lastName=" + lastName + ", email="
				+ email + ", phoneNumber=" + phoneNumber + ", address=" + address + ", password=" + password
				+ ", userName=" + username + ", registrationDate=" + registrationDate + "]";
	}
    
    
}
