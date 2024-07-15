package com.packagedelivery.personnel;
import java.util.List;
public interface PersonnelDAO {
	    void addPersonnel(Personnel personnel);
	    public List<Personnel> findAll();
	    void updatePersonnel(Personnel personnel);
	    void deletePersonnel(int personnelId);

}
