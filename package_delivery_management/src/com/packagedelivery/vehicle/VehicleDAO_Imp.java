package com.packagedelivery.vehicle;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.packagedelivery.util.DatabaseUtil;

public class VehicleDAO_Imp implements VehicleDAO {
    private Connection con = DatabaseUtil.getConnection();
    private static final String INSERT_QUERY = "INSERT INTO vehicle ( vehicle_model) VALUES (	?)";
    private static final String SELECT_ALL = "SELECT * FROM vehicle";
    private static final String UPDATE_QUERY = "UPDATE vehicle SET vehicle_model = ? WHERE vehicle_id = ?";
    private static final String DELETE_QUERY = "DELETE FROM vehicle WHERE vehicle_id = ?";

    @Override
    public void addVehicle(Vehicle vehicle) {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(INSERT_QUERY);
            stmt.setString(1, vehicle.getVehicleModel());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Insert Error : " + e);
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

    @Override
    public List<Vehicle> findAllVehicles() {
        Statement st = null;
        ResultSet rs = null;
        List<Vehicle> list = new ArrayList<>();
        try {
            st = con.createStatement();
            rs = st.executeQuery(SELECT_ALL);
            while (rs.next()) {
                Vehicle vehicle = new Vehicle(
                    rs.getInt("vehicle_id"),
                    rs.getString("vehicle_model")
                );
                list.add(vehicle);
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

    @Override
    public void updateVehicle(Vehicle vehicle) {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(UPDATE_QUERY);
            stmt.setString(1, vehicle.getVehicleModel());
            stmt.setInt(2, vehicle.getVehicleId());
            stmt.executeUpdate();
            System.out.println("Vehicle updated successfully.");
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

    @Override
    public void deleteVehicle(int vehicleId) {
        PreparedStatement stmt = null;
        try {
            stmt = con.prepareStatement(DELETE_QUERY);
            stmt.setInt(1, vehicleId);
            int rowsAffected = stmt.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Vehicle with vehicle_id " + vehicleId + " deleted successfully.");
            } else {
                System.out.println("Vehicle with vehicle_id " + vehicleId + " not found.");
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
