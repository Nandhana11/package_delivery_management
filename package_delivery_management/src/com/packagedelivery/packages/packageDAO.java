package com.packagedelivery.packages;

import java.util.List;

public interface packageDAO {

    void addPackage(Package pkg);
    public List<Package> findAll();
    void updatePackage(Package pkg);
    void deletePackage(int packageId);
 
}
