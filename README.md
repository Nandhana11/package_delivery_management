# package_delivery_management
This Java-based console application is designed to manage package delivery operations efficiently. It provides functionalities for managing packages, personnel, routes, and vehicles through a user-friendly command-line interface (CLI). The project utilizes JDBC for database connectivity and follows a structured object-oriented design.
 
Project Structure
The project is organized as follows:
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
Main.java
Entry point of the application.

Package.java
Represents package details including package ID, description, weight, destination, status (in-transit/delivered), and delivery date.

Personnel.java
Represents personnel details such as personnel ID, name, email, phone number, and vehicle ID.

Route.java
Represents route details such as route ID, start location, end location, distance, and estimated time.

Vehicle.java
Represents vehicle details including vehicle ID and vehicle model.

dao/ Package
Contains DAO interfaces (PackageDAO.java, PersonnelDAO.java, RouteDAO.java, VehicleDAO.java) for CRUD operations on packages, personnel, routes, and vehicles.

util/ DatabaseUtil.java
Manages database connections.

Functionality
The application provides the following functionalities:

Manage Package: Add, view, update, and delete package details.
Manage Personnel: Add, view, update, and delete personnel details.
Manage Routes: Add, view, update, and delete route information.
Manage Vehicles: Add, view, update, and delete vehicle details.
Setup and Usage
Prerequisites
Java SE Development Kit (JDK)
MySQL JDBC driver for database connectivity
Setup
Clone the repository:
git clone <repository_url>
Import the project into your preferred Java IDE.
Configure database credentials in DatabaseUtil.java.
Set up the database schema using the provided SQL scripts.
Running the Application
Compile and run Main.java to start the application.
Follow the prompts in the CLI to perform various management tasks (adding, viewing, updating, deleting).
Dependencies
JDBC driver for MySQL
Java SE Development Kit (JDK)
