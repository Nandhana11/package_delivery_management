package com.packagedelivery.vehicle;

public class Vehicle {
	
	    private int vehicleId;
	    private String vehicleModel;

	    public Vehicle() {
	    }

	    public Vehicle(int vehicleId, String vehicleModel) {
	        this.vehicleId = vehicleId;
	        this.vehicleModel = vehicleModel;
	    }
	    public Vehicle( String vehicleModel) {
	        this.vehicleId = vehicleId;
	        this.vehicleModel = vehicleModel;
	    }

	    public int getVehicleId() {
	        return vehicleId;
	    }

	    public void setVehicleId(int vehicleId) {
	        this.vehicleId = vehicleId;
	    }

	    public String getVehicleModel() {
	        return vehicleModel;
	    }

	    public void setVehicleModel(String vehicleModel) {
	        this.vehicleModel = vehicleModel;
	    }
	}


