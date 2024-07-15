package com.packagedelivery.vehicle;
import java.util.List;
public interface VehicleDAO {
	  void addVehicle(Vehicle vehicle);
	    public List<Vehicle> findAllVehicles();
	    void updateVehicle(Vehicle vehicle);
	    void deleteVehicle(int vehicleId);
	}

