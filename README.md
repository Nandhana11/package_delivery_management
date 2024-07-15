# package_delivery_management
This project is a Java-based console application designed for managing various aspects of package delivery operations. It includes functionality for managing packages, personnel, routes, and vehicles through a user-friendly command-line interface. The project uses JDBC for database connectivity and follows a structured object-oriented design.

Project Structure
The project is organized into the following structure:
src/
└── com/
    └── delivery/
        ├── Main.java
        ├── package/
        │   ├── Package.java
        │   ├── PackageDAO.java
        │   └── PackageDAO_imp.java
        ├── personnel/
        │   ├── Personnel.java
        │   ├── PersonnelDAO.java
        │   └── PersonnelDAO_imp.java
        ├── route/
        │   ├── Route.java
        │   ├── RouteDAO.java
        │   └── RouteDAO_imp.java
        ├── vehicle/
        │   ├── Vehicle.java
        │   ├── VehicleDAO.java
        │   └── VehicleDAO_imp.java
        └── util/
            └── DatabaseUtil.java


Description

Main.java: Entry point of the application.
Package.java: Represents package details including package Id,description,weight,destination,status (in-transit/delivered),delivery_date
Personnel.java: Represents personnel details such as personnel_id ,name, email, phone number, and vehicle ID.
Route.java: Represents route details such as route_id,start_location,end_location,distance,estimated_time
Vehicle.java: Represents vehicle details used for vehicle_id,vehicle_model
dao/: Contains DAO (Data Access Object) interfaces for CRUD operations on packages, personnel, routes, and vehicles.
util/: Contains DatabaseUtil.java for managing database connections.

Functionality
The application provides the following functionalities:
Manage Package
  Provides functionality to add, view, update, and delete package involved in package delivery.
Manage Personnel
  Provides functionality to add, view, update, and delete personnel involved in package delivery.
Manage Routes
  Enables management of delivery routes, including adding, viewing, updating, and deleting route information.
 Manage Vehicles
  Provides operations to manage delivery vehicles, including adding, viewing, updating, and deleting vehicle details.

Setup and Usage:
Prerequisites
JDK installed
MySQL 
JDBC driver for database connectivity

Setup:
Clone the repository: git clone <repository-url>
Import the project into your preferred Java IDE.
Configure database credentials in DatabaseUtil.java.
Set up the database schema using the provided SQL scripts.
Running the Application
Compile and run Main.java to start the application.
Follow the prompts to perform various management tasks (adding, viewing, updating, deleting).

Dependencies
JDBC driver for MySQL 
Java SE Development Kit (JDK)
