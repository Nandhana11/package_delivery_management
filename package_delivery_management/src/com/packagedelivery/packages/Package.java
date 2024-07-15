package com.packagedelivery.packages;
import java.util.Date;
public class Package {
	  private int packageId;
	private String description;
	private int weight;
	private String destination;
	private String Status;
	private Date deliveryDate;	
	public Package() {
    }
	  public Package(int packageId, String description, int weight,String destination,String Status, Date deliveryDate) {
	        this.packageId=packageId;
	        this.description = description;
	        this.weight = weight;
	        this.destination = destination;
	        this.Status = Status;
	        this.deliveryDate = deliveryDate;
	    }

    public Package(String description, int weight, String destination, String Status, Date deliveryDate) {
       
        this.description = description;
        this.weight = weight;
        this.destination = destination;
        this.Status = Status;
        this.deliveryDate = deliveryDate;
    }
  
    public int getPackageId() {
        return packageId;
    }

   
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String Status) {
        this.Status = Status;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }
}