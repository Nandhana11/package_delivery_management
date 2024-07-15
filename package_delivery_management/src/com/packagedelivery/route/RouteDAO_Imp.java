package com.packagedelivery.route;


import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalTime;
import com.packagedelivery.util.DatabaseUtil;

public class RouteDAO_Imp implements RouteDAO{
	    private Connection con = DatabaseUtil.getConnection();
	    private static final String INSERT_QUERY = "INSERT INTO route ( start_location, end_location, distance, estimated_time) VALUES ( ?, ?, ?, ?)";
	    private static final String SELECT_ALL = "SELECT * FROM route";
	    private static final String UPDATE_QUERY = "UPDATE route SET start_location = ?, end_location = ?, distance = ?, estimated_time = ? WHERE route_id = ?";
	    private static final String DELETE_QUERY = "DELETE FROM route WHERE route_id = ?";

	    @Override
	    public void addRoute(Route route) {
	        PreparedStatement stmt = null;
	        try {
	            stmt = con.prepareStatement(INSERT_QUERY);
	            stmt.setString(1, route.getStartLocation());
	            stmt.setString(2, route.getEndLocation());
	            stmt.setDouble(3, route.getDistance());
	            // Convert LocalTime to java.sql.Time
	            java.sql.Time sqlTime = java.sql.Time.valueOf(route.getEstimatedTime());
	            stmt.setTime(4, sqlTime);
	            stmt.executeUpdate();
	            System.out.println("Route added successfully");
	        } catch (SQLException e) {
	            System.out.println("Insert Error: " + e);
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
	    public List<Route> findAll() {
	        Statement st = null;
	        ResultSet rs = null;
	        List<Route> list = new ArrayList<>();
	        try {
	            st = con.createStatement();
	            rs = st.executeQuery(SELECT_ALL);
	            while (rs.next()) {
	                Route route = new Route(
	                    rs.getInt("route_id"),
	                    rs.getString("start_location"),
	                    rs.getString("end_location"),
	                    rs.getDouble("distance"),
	                    rs.getTime("estimated_time").toLocalTime()
	                );
	                list.add(route);
	            }
	        } catch (SQLException e) {
	            list = null;
	            System.out.println("Select error: " + e);
	            e.printStackTrace();
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
	    public void updateRoute(Route route) {
	        PreparedStatement stmt = null;
	        try {
	            stmt = con.prepareStatement(UPDATE_QUERY);
	            stmt.setString(1, route.getStartLocation());
	            stmt.setString(2, route.getEndLocation());
	            stmt.setDouble(3, route.getDistance());
	            java.sql.Time sqlTime = java.sql.Time.valueOf(route.getEstimatedTime());
	            stmt.setTime(4, sqlTime);
	            stmt.setInt(5, route.getRouteId());
	            stmt.executeUpdate();
	            System.out.println("Route updated successfully.");
	        } catch (SQLException e) {
	            System.out.println("Update Error: " + e);
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
	    public void deleteRoute(int routeId) {
	        PreparedStatement stmt = null;
	        try {
	            stmt = con.prepareStatement(DELETE_QUERY);
	            stmt.setInt(1, routeId);
	            int rowsAffected = stmt.executeUpdate();
	            if (rowsAffected > 0) {
	                System.out.println("Route with route_id " + routeId + " deleted successfully.");
	            } else {
	                System.out.println("Route with route_id " + routeId + " not found.");
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

	   

