package carConnect.entity;

public class Vehicle {
	// Properties of Vehicle Class
	private int vehicleID;
    private String model;
    private String make;
    private int year;
    private String color;
    private String registrationNumber;
    private boolean availability;
    private double dailyRate;

    // Default constructor
    public Vehicle() {
    	super();
    }

    // Parameterized constructor
    public Vehicle(int vehicleID, String model, String make, int year, String color, String registrationNumber, boolean availability, double dailyRate) {
        this.vehicleID = vehicleID;
        this.model = model;
        this.make = make;
        this.year = year;
        this.color = color;
        this.registrationNumber = registrationNumber;
        this.availability = availability;
        this.dailyRate = dailyRate;
    }
    
 // Getters and Setters
    
  //--------- VehicleID--------------------------------------
    public int getVehicleID() {
        return vehicleID;
    }
    public void setVehicleID(int vehicleID) {
        this.vehicleID = vehicleID;
    }

  //--------- Model--------------------------------------
    public String getModel() {
        return model;
    }
    public void setModel(String model) {
        this.model = model;
    }

  //--------- Make--------------------------------------
    public String getMake() {
        return make;
    }
    public void setMake(String make) {
        this.make = make;
    }

  //--------- Year--------------------------------------
    public int getYear() {
        return year;
    }
    public void setYear(int year) {
        this.year = year;
    }

  //--------- Color--------------------------------------
    public String getColor() {
        return color;
    }
    public void setColor(String color) {
        this.color = color;
    }

  //--------- RegistrationNumber--------------------------------------
    public String getRegistrationNumber() {
        return registrationNumber;
    }
    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

  //--------- Availability--------------------------------------
    public boolean isAvailability() {
        return availability;
    }
    public void setAvailability(boolean availability) {
        this.availability = availability;
    }

  //--------- DailyRate--------------------------------------
    public double getDailyRate() {
        return dailyRate;
    }
    public void setDailyRate(double dailyRate) {
        this.dailyRate = dailyRate;
    }

	@Override
	public String toString() {
		return "Vehicle [vehicleID=" + vehicleID + ", model=" + model + ", make=" + make + ", year=" + year + ", color="
				+ color + ", registrationNumber=" + registrationNumber + ", availability=" + availability
				+ ", dailyRate=" + dailyRate + "]";
	}
    
    
}
