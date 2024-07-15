package com.packagedelivery.personnel;

	public class Personnel {
	    private int personnelId;  
	    private String name;
	    private String email;
	    private String phoneNumber;
	    private int vehicleId;

	    public Personnel() {
	    }

	    public Personnel(int personnelId,String name, String email, String phoneNumber, int vehicleId) {
	    	this.personnelId=personnelId;
	        this.name = name;
	        this.email = email;
	        this.phoneNumber = phoneNumber;
	        this.vehicleId = vehicleId;
	    }

	    public Personnel(String name, String email, String phoneNumber, int vehicleId) {
	        this.name = name;
	        this.email = email;
	        this.phoneNumber = phoneNumber;
	        this.vehicleId = vehicleId;
	    }


	    public int getPersonnelId() {
	        return personnelId;
	    }

          public void setPersonnelId(int personnelId) {
        	  this.personnelId=personnelId;
          }
	    public String getName() {	
	        return name;
	    }

	    public void setName(String name) {
	        if (name.matches("^[a-zA-Z]+$")) {
	            this.name = name;
	        } else {
	            throw new IllegalArgumentException("Invalid name format. Only alphabets are allowed.");
	        }
	    }

	    public String getEmail() {
	        return email;
	    }

	    public void setEmail(String email) {
	        if (email.matches("^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$")) {
	            this.email = email;
	        } else {
	            throw new IllegalArgumentException("Invalid email format.");
	        }
	    }


	    public String getPhoneNumber() {
	        return phoneNumber;
	    }
	    public void setPhoneNumber(String phoneNumber) {
	        if (phoneNumber.matches("^\\d{10}$")) {
	            this.phoneNumber = phoneNumber;
	        } else {
	            throw new IllegalArgumentException("Invalid phone number format. It should be a 10-digit number.");
	        }
	    }

	    public int getVehicleId() {
	        return vehicleId;
	    }

	    public void setVehicleId(int vehicleId) {
	        this.vehicleId = vehicleId;
	    }

	}


