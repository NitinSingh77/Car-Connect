create database car_connect;
use car_connect;

CREATE TABLE Customer (
    CustomerID INT PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    Email VARCHAR(100) UNIQUE,
    PhoneNumber VARCHAR(15),
    Address VARCHAR(255),
    Username VARCHAR(50) UNIQUE,
    Password VARCHAR(255),
    RegistrationDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE Vehicle (
    VehicleID INT PRIMARY KEY AUTO_INCREMENT,
    Model VARCHAR(50),
    Make VARCHAR(50),
    Year INT,
    Color VARCHAR(20),
    RegistrationNumber VARCHAR(50) UNIQUE,
    Availability BOOLEAN DEFAULT TRUE,
    DailyRate DECIMAL(10 , 2 )
);

CREATE TABLE Reservation (
    ReservationID INT PRIMARY KEY AUTO_INCREMENT,
    CustomerID INT,
    VehicleID INT,
    StartDate DATETIME,
    EndDate DATETIME,
    TotalCost DECIMAL(10 , 2 ),
    Status VARCHAR(20),
    FOREIGN KEY (CustomerID)
        REFERENCES Customer (CustomerID),
    FOREIGN KEY (VehicleID)
        REFERENCES Vehicle (VehicleID)
);

CREATE TABLE Admin (
    AdminID INT PRIMARY KEY AUTO_INCREMENT,
    FirstName VARCHAR(50),
    LastName VARCHAR(50),
    Email VARCHAR(100) UNIQUE,
    PhoneNumber VARCHAR(15),
    Username VARCHAR(50) UNIQUE,
    Password VARCHAR(255),
    Role VARCHAR(50),
    JoinDate TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);



