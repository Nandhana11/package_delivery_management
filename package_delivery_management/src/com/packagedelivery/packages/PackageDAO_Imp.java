package com.packagedelivery.packages;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.packagedelivery.util.DatabaseUtil;


public class PackageDAO_Imp implements packageDAO {
	private Connection con=DatabaseUtil.getConnection();
	private static final String INSERT_QUERY= "INSERT INTO package (description, weight, destination, status, delivery_date) VALUES (?, ?, ?, ?, ?)";
	private static final String SELECT_ALL="select * from package";
	 private static final String UPDATE_QUERY = "UPDATE package SET description = ?, weight = ?, destination = ?, status = ?, delivery_date = ? WHERE package_id = ?";
	 private static final String DELETE_QUERY = "DELETE FROM package WHERE package_id = ?";

	public  void addPackage(Package pkg) {
		PreparedStatement stmt=null;
		try {
		  stmt = con.prepareStatement(INSERT_QUERY);
          stmt.setString(1, pkg.getDescription());
          stmt.setInt(2, pkg.getWeight());
          stmt.setString(3, pkg.getDestination());
          stmt.setString(4, pkg.getStatus());
          stmt.setDate(5, new java.sql.Date(pkg.getDeliveryDate().getTime()));
          stmt.executeUpdate();
		  }
		  catch (SQLException e) {
				System.out.println("Insert Error : " + e);
				e.printStackTrace();
			}finally {
				try {
					stmt.close();
				} catch (SQLException e) {			
					e.printStackTrace();
				}
			}	 
	 }
	public List<Package> findAll() {
		Statement st=null;
		ResultSet rs=null;
		List<Package> list=new ArrayList<>();
		try {
			st=con.createStatement();
			 rs = st.executeQuery(SELECT_ALL);
			while(rs.next()) {
			Package p=new Package(
				     	rs.getInt("package_id"),
						rs.getString("description"), 
						rs.getInt("weight"),
						rs.getString("destination"),
			            rs.getString("status"),
			            rs.getDate("delivery_date"));
				        list.add(p);
			}
		} catch (SQLException e) {
			list=null;
			System.out.println("Select error : " +e);
		}finally {
			try {
				rs.close();
				st.close();
			} catch (SQLException e) {
			
				e.printStackTrace();
			}
		}
		return list;
	}
	public void updatePackage(Package pkg) {
		PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(UPDATE_QUERY);
            stmt.setString(1, pkg.getDescription());
            stmt.setInt(2, pkg.getWeight());
            stmt.setString(3, pkg.getDestination());
            stmt.setString(4, pkg.getStatus());
            stmt.setDate(5, new java.sql.Date(pkg.getDeliveryDate().getTime()));
            stmt.executeUpdate();
            System.out.println("Package updated successfully.");
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
	public void deletePackage(int packageId) {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(DELETE_QUERY);
            stmt.setInt(1, packageId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Package with package_id " + packageId + " deleted successfully.");
            } else {
                System.out.println("Package with package_id " + packageId + " not found.");
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
	

