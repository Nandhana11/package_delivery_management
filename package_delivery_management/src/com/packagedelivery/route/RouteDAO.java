package com.packagedelivery.route;

import java.util.List;
public interface RouteDAO {
	    void addRoute(Route route);
	    public List<Route> findAll();
	    void updateRoute(Route route);
	    void deleteRoute(int routeId);
	}
	 

