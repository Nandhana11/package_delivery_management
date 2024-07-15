package com.packagedelivery.route;
import java.time.LocalTime;

public class Route {
	
	    private int routeId;
	    private String startLocation;
	    private String endLocation;
	    private double distance;
	    private LocalTime estimatedTime;
	    public Route() {
	    }

	    public Route(int routeId, String startLocation, String endLocation, double distance,  LocalTime estimatedTime) {
	        this.routeId = routeId;
	        this.startLocation = startLocation;
	        this.endLocation = endLocation;
	        this.distance = distance;
	        this.estimatedTime = estimatedTime;
	    }
	    public Route( String startLocation, String endLocation, double distance,  LocalTime estimatedTime) {
	        this.startLocation = startLocation;
	        this.endLocation = endLocation;
	        this.distance = distance;
	        this.estimatedTime = estimatedTime;
	    }
	    public int getRouteId() {
	        return routeId;
	    }

	    public void setRouteId(int routeId) {
	        this.routeId = routeId;
	    }

	    public String getStartLocation() {
	        return startLocation;
	    }

	    public void setStartLocation(String startLocation) {
	        this.startLocation = startLocation;
	    }

	    public String getEndLocation() {
	        return endLocation;
	    }

	    public void setEndLocation(String endLocation) {
	        this.endLocation = endLocation;
	    }

	    public double getDistance() {
	        return distance;
	    }

	    public void setDistance(double distance) {
	        this.distance = distance;
	    }

	    public LocalTime getEstimatedTime() {
	        return estimatedTime;
	    }

	    public void setEstimatedTime(LocalTime estimatedTime) {
	        this.estimatedTime = estimatedTime;
	    }
	}



