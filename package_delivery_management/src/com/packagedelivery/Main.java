package com.packagedelivery;
import java.util.*;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.text.ParseException;
import java.util.Date;
import java.time.format.DateTimeParseException;

import com.packagedelivery.route.Route;
import com.packagedelivery.route.RouteDAO;
import com.packagedelivery.route.RouteDAO_Imp;

import com.packagedelivery.packages.Package;
import com.packagedelivery.packages.PackageDAO_Imp;
import com.packagedelivery.packages.packageDAO;
import com.packagedelivery.personnel.Personnel;
import com.packagedelivery.personnel.PersonnelDAO;
import com.packagedelivery.personnel.PersonnelDAO_imp;

import com.packagedelivery.vehicle.Vehicle;
import com.packagedelivery.vehicle.VehicleDAO;
import com.packagedelivery.vehicle.VehicleDAO_Imp;
public class Main {

    private static final String USER = "user";
    private static final String USER_PASSWORD = "userpswd";
    private static final SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
	public static void main(String[] args) {
             Scanner sc=new Scanner(System.in);           
             System.out.println("********WELCOME TO PACKAGE DELIVERY MANAGEMENT******");
             System.out.println("*******************************************************************");
             System.out.println("Enter Username");
             String username = sc.nextLine();
             System.out.println("Enter Password");
             String password = sc.nextLine();
             if(username.equals(USER)&& password.equals(USER_PASSWORD)) {
            	 System.out.println("Login successful!");
            	 displayMenu(sc);
            	 
             } else {
                 System.out.println("Invalid username or password. Access denied.");
             }
             }
	private static void displayMenu(Scanner sc) {
		  int choice;
	        do {
	            System.out.println("\n******** MAIN MENU ********");
	            System.out.println("1. Package Management");
	            System.out.println("2. Personnel Management");
	            System.out.println("3. Route Management");
	            System.out.println("4. Vehicle Management");
	            System.out.println("5. Exit");
	            System.out.print("Enter your choice: ");
	            choice = sc.nextInt();
	            sc.nextLine();

	            switch (choice) {
	                case 1:
	                	managePackage(sc);
	                    break;
	                case 2:
	                	managePersonnel(sc);
	                    break;
	                case 3:
	                	manageRoute(sc);
	                    break;
	                case 4:
	                	manageVehicle(sc);
	                    break;
	                case 5:
	                    System.out.println("Exiting application.Goodbye!");
	                    break;
	                default:
	                    System.out.println("Invalid choice.Please enter a number between 1 and 4.");
	            }
	        } while (choice != 4);
	    }
	public static void managePackage(Scanner sc) {
		packageDAO p=new PackageDAO_Imp();
		
		int choice;
		 do {
	            System.out.println("\n******** PACKAGE MANAGEMENT ********");
	            System.out.println("1. Add a new package");
	            System.out.println("2. View package details");
	            System.out.println("3. Update package information");
	            System.out.println("4. Delete a package");
	            System.out.println("5. Back to Main Menu");
	            System.out.print("Enter your choice: ");
	            choice = sc.nextInt();
	            sc.nextLine();

	            switch (choice) {
	                case 1:
	                	System.out.println("Enter description");
	                	String description=sc.next();
	                	sc.nextLine();
	                	System.out.println("Enter Weight");
	                	int weight=sc.nextInt();
	                	System.out.println("Enter Destination");
	                	String destination=sc.next();
	                	sc.nextLine();
	                	System.out.println("Enter Status(intransit/delivered");
	                	String status=sc.nextLine();
	                	System.out.println("Enter Date (yyyy-MM-dd)");
	                	  String inputDate = sc.nextLine();
	                      Date deliveryDate=null;
	                      try {
	                          deliveryDate= dateFormat.parse(inputDate);
	                      } catch (ParseException e) {
	                          System.out.println("Error parsing date: " + e.getMessage());
	                          deliveryDate = null; // Handle parsing error gracefully in your application
	                      }
	                	
	                	
	                	p.addPackage(new Package(description,weight,destination, status,deliveryDate));
	                	
	                    break;
	                case 2:

	                    List<Package> packageList = p.findAll();
                  for (Package pkg : packageList) {
                
                	 	      System.out.println("Package ID: " + pkg.getPackageId());
	                        System.out.println("Description: " + pkg.getDescription());
	                        System.out.println("Weight: " + pkg.getWeight());
	                        System.out.println("Destination: " + pkg.getDestination());
	                        System.out.println("Status: " + pkg.getStatus());
	                        System.out.println("Delivery Date: " + dateFormat.format(pkg.getDeliveryDate()));
	                        System.out.println("-----------------------------------");
	                    }
	                    // Implement viewing package details
	                    break;
	                case 3:
	                	System.out.println("Enter Package id to update");
	                      int updatePackageId = sc.nextInt();
	                      sc.nextLine(); 
	                      if (updatePackageId != 0) {
	                          System.out.println("Enter new description");
	                          String newDescription = sc.nextLine();
	                          System.out.println("Enter new weight");
	                          int newWeight = sc.nextInt();
	                          sc.nextLine();
	                          System.out.println("Enter new destination");
	                          String newDestination = sc.nextLine();
	                          System.out.println("Enter new status");
	                          String newStatus = sc.nextLine();
	                          System.out.println("Enter new delivery date (yyyy-MM-dd)");
	                          String newDate = sc.nextLine();
	                          Date newDeliveryDate = null;
	                           try {
	                                  newDeliveryDate = dateFormat.parse(newDate);
	                              } catch (ParseException e) {
	                                  System.out.println("Error parsing date: " + e.getMessage());
	                                 
	                              }

	                          p.updatePackage(new Package(newDescription, newWeight, newDestination, newStatus, newDeliveryDate));
	                        
	                      } else {
	                          System.out.println("Package with id " + updatePackageId + " not found.");
	                      }
	            
	                    break;
	                case 4:
	                	System.out.println("Enter Package id to delete");
	                    int deletePackageId = sc.nextInt();
	                    sc.nextLine(); 
	                    p.deletePackage(deletePackageId);
	                    break;
	                case 5:
	                    return; // Return to main menu
	                default:
	                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
	            }
	        } while (choice != 5);
	    }
	public static void manageRoute(Scanner sc) {
        RouteDAO r = new RouteDAO_Imp();

        int choice;
        do {
            System.out.println("\n******** ROUTE MANAGEMENT ********");
            System.out.println("1. Add a new route");
            System.out.println("2. View route details");
            System.out.println("3. Update route information");
            System.out.println("4. Delete a route");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                   // Consume newline
                    System.out.println("Enter Start Location");
                    String start_location = sc.nextLine();
                    System.out.println("Enter End Location");
                    String end_location = sc.nextLine();
                    System.out.println("Enter Distance");
                    double distance =sc.nextDouble();
                    System.out.println("Enter new estimated time (HH:MM:SS)");
                    String newEstimatedTimeStr = sc.next();
                    LocalTime newEstimatedTime=null;
                    try {
                     newEstimatedTime = LocalTime.parse(newEstimatedTimeStr);
                    }
                    catch(DateTimeParseException e) {
                    	 System.out.println("Error parsing time: " + e.getMessage());
                    }

                    r.addRoute(new Route( start_location, end_location, distance, newEstimatedTime));
                    break;
                case 2:
                    List<Route> routeList = r.findAll();
                    for (Route route : routeList) {
                        System.out.println(route);
                    }
                    break;
                case 3:
                    System.out.println("Enter Route id to update");
                    int updateRouteId = sc.nextInt();
                    sc.nextLine(); // Consume newline
                    if (updateRouteId != 0) {
                        System.out.println("Enter new start location");
                        String newStartLocation = sc.nextLine();
                        System.out.println("Enter new end location");
                        String newEndLocation = sc.nextLine();
                        System.out.println("Enter new distance");
                        double newDistance = 0;
                        try {
                            newDistance = sc.nextDouble();
                        } catch (InputMismatchException i) {
                            System.out.println("Please enter a valid number for distance");
                            sc.next(); // Consume invalid input
                        }
                        sc.nextLine(); // Consume newline
                        System.out.println("Enter new estimated time");
                        String newEstimatedTimeStr1 = sc.next();
                        LocalTime newEstimatedTime1=null;
                        try {
                         newEstimatedTime1 = LocalTime.parse(newEstimatedTimeStr1);
                        }
                        catch(DateTimeParseException e) {
                        	 System.out.println("Error parsing time: " + e.getMessage());
                        }

                        r.updateRoute(new Route(updateRouteId, newStartLocation, newEndLocation, newDistance, newEstimatedTime1));
                    } else {
                        System.out.println("Route with id " + updateRouteId + " not found.");
                    }
                    break;
                case 4:
                    System.out.println("Enter Route id to delete");
                    int deleteRouteId = sc.nextInt();
                    sc.nextLine();
                    r.deleteRoute(deleteRouteId);
                    break;
                case 5:
                    return; // Return to main menu
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        } while (choice != 5);
    }

    public static void managePersonnel(Scanner sc) {
        PersonnelDAO p = new PersonnelDAO_imp();

        int choice;
        do {
            System.out.println("\n******** PERSONNEL MANAGEMENT ********");
            System.out.println("1. Add a new personnel");
            System.out.println("2. View personnel details");
            System.out.println("3. Update personnel information");
            System.out.println("4. Delete a personnel");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Enter Name");
                    String name = sc.nextLine();
                    System.out.println("Enter Email");
                    String email = sc.nextLine();
                    System.out.println("Enter Phone Number");
                    String phoneNumber = sc.nextLine();
                    System.out.println("Enter Vehicle ID");
                    int vehicleId = sc.nextInt();
                    sc.nextLine();

                        p.addPersonnel(new Personnel(name, email, phoneNumber, vehicleId));
                        System.out.println("Personnel added successfully.");
                 
                    break;
                case 2:
                    List<Personnel> personnelList = p.findAll();
                    for (Personnel personnel : personnelList) {
                        System.out.println("Personnel ID: " + personnel.getPersonnelId());
                        System.out.println("Name: " + personnel.getName());
                        System.out.println("Email: " + personnel.getEmail());
                        System.out.println("Phone Number: " + personnel.getPhoneNumber());
                        System.out.println("Vehicle ID: " + personnel.getVehicleId());
                        System.out.println("-----------------------------------");
                    }
                    break;
                case 3:
                    System.out.println("Enter Personnel ID to update");
                    int updatePersonnelId = sc.nextInt();
                    sc.nextLine();
                    if (updatePersonnelId != 0) {
                        System.out.println("Enter new name");
                        String newName = sc.nextLine();
                        System.out.println("Enter new email");
                        String newEmail = sc.nextLine();
                        System.out.println("Enter new phone number");
                        String newPhoneNumber = sc.nextLine();
                        System.out.println("Enter new vehicle ID");
                        int newVehicleId = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Enter new password");
                        String newPassword = sc.nextLine();

                        try {
                            p.updatePersonnel(new Personnel( newName, newEmail, newPhoneNumber, newVehicleId));
                            System.out.println("Personnel updated successfully.");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Error updating personnel: " + e.getMessage());
                        }
                    } else {
                        System.out.println("Personnel with ID " + updatePersonnelId + " not found.");
                    }
                    break;
                case 4:
                    System.out.println("Enter Personnel ID to delete");
                    int deletePersonnelId = sc.nextInt();
                    sc.nextLine();
                    p.deletePersonnel(deletePersonnelId);
                    break;
                case 5:
                    return; 
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        } while (choice != 5);
    }
    public static void manageVehicle(Scanner sc) {
        VehicleDAO vehicleDAO = new VehicleDAO_Imp();

        int choice;
        do {
            System.out.println("\n******** VEHICLE MANAGEMENT ********");
            System.out.println("1. Add a new vehicle");
            System.out.println("2. View vehicle details");
            System.out.println("3. Update vehicle information");
            System.out.println("4. Delete a vehicle");
            System.out.println("5. Back to Main Menu");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    
                    System.out.println("Enter Vehicle Model");
                    String vehicleModel = sc.nextLine();

                    vehicleDAO.addVehicle(new Vehicle( vehicleModel));
                    System.out.println("Vehicle added successfully.");
                    break;
                case 2:
                    List<Vehicle> vehicleList = vehicleDAO.findAllVehicles();
                    for (Vehicle vehicle : vehicleList) {
                        System.out.println("Vehicle ID: " + vehicle.getVehicleId());
                        System.out.println("Model: " + vehicle.getVehicleModel());
                        System.out.println("-----------------------------------");
                    }
                    break;
                case 3:
                    System.out.println("Enter Vehicle ID to update");
                    int updateVehicleId = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Enter new model");
                    String newModel = sc.nextLine();

                    try {
                        vehicleDAO.updateVehicle(new Vehicle(updateVehicleId, newModel));
                        System.out.println("Vehicle updated successfully.");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error updating vehicle: " + e.getMessage());
                    }
                    break;
                case 4:
                    System.out.println("Enter Vehicle ID to delete");
                    int deleteVehicleId = sc.nextInt();
                    sc.nextLine();
                    vehicleDAO.deleteVehicle(deleteVehicleId);
                    break;
                case 5:
                    return; // Return to main menu
                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 5.");
            }
        } while (choice != 5);

	}
}
             
             
	


