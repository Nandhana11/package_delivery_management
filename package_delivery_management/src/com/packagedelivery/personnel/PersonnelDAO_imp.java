package com.packagedelivery.personnel;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;
import com.packagedelivery.util.DatabaseUtil;

public class PersonnelDAO_imp implements PersonnelDAO {
	 private Connection con = DatabaseUtil.getConnection();
	    private static final String INSERT_QUERY = "INSERT INTO personnel (name, email, phone_number, vehicle_id) VALUES (?, ?, ?, ?)";
	    private static final String SELECT_ALL = "SELECT * FROM personnel";
	    private static final String UPDATE_QUERY = "UPDATE personnel SET name = ?, email = ?, phone_number = ?, vehicle_id = ? WHERE personnel_id = ?";
	    private static final String DELETE_QUERY = "DELETE FROM personnel WHERE personnel_id = ?";

	    public void addPersonnel(Personnel personnel) {
	        PreparedStatement stmt = null;
	        ResultSet generatedKeys = null;
	        try {
	            stmt = con.prepareStatement(INSERT_QUERY);
	            stmt.setString(1, personnel.getName());
	            stmt.setString(2, personnel.getEmail());
	            stmt.setString(3, personnel.getPhoneNumber());
	            stmt.setInt(4, personnel.getVehicleId());
	            stmt.executeUpdate();
	            
	        } catch (SQLException e) {
	            System.out.println("Insert Error : " + e);
	            e.printStackTrace();
	        } finally {
	            try {
	            	 if (generatedKeys != null) {
	                     generatedKeys.close();
	                 }
	                if (stmt != null) {
	                    stmt.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    public List<Personnel> findAll() {
	        Statement st = null;
	        ResultSet rs = null;
	        List<Personnel> list = new ArrayList<>();
	        try {
	            st = con.createStatement();
	            rs = st.executeQuery(SELECT_ALL);
	            while (rs.next()) {
	                Personnel personnel = new Personnel(
	                	    rs.getInt("personnel_id"),
	                        rs.getString("name"),
	                        rs.getString("email"),
	                        rs.getString("phone_number"),
	                        rs.getInt("vehicle_id")
	                );
	                list.add(personnel);
	            }
	        } catch (SQLException e) {
	            list = null;
	            System.out.println("Select error : " + e);
	        } finally {
	            try {
	                if (rs != null) {
	                    rs.close();
	                }
	                if (st != null) {
	                    st.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	        return list;
	    }

	    public void updatePersonnel(Personnel personnel) {
	        PreparedStatement stmt = null;
	        try {
	            stmt = con.prepareStatement(UPDATE_QUERY);
	            stmt.setString(1, personnel.getName());
	            stmt.setString(2, personnel.getEmail());
	            stmt.setString(3, personnel.getPhoneNumber());
	            stmt.setInt(4, personnel.getVehicleId());
	            stmt.setInt(5, personnel.getPersonnelId());
	            stmt.executeUpdate();
	            System.out.println("Personnel updated successfully.");
	        } catch (SQLException e) {
	            System.out.println("Update Error : " + e);
	            e.printStackTrace();
	        } finally {
	            try {
	                if (stmt != null) {
	                    stmt.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }

	    public void deletePersonnel(int personnelId) {
	        PreparedStatement stmt = null;
	        try {
	            stmt = con.prepareStatement(DELETE_QUERY);
	            stmt.setInt(1, personnelId);
	            int rowsAffected = stmt.executeUpdate();
	            if (rowsAffected > 0) {
	                System.out.println("Personnel with personnel_id " + personnelId + " deleted successfully.");
	            } else {
	                System.out.println("Personnel with personnel_id " + personnelId + " not found.");
	            }
	        } catch (SQLException e) {
	            System.out.println("Delete Error: " + e.getMessage());
	            e.printStackTrace();
	        } finally {
	            try {
	                if (stmt != null) {
	                    stmt.close();
	                }
	            } catch (SQLException e) {
	                e.printStackTrace();
	            }
	        }
	    }
	
}
