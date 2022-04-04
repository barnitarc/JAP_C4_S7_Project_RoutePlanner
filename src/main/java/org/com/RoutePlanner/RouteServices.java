package org.com.RoutePlanner;

public interface RouteServices {
     Route[] findDirectFlightFromLocation(String from) throws NoRouteFoundException;
    Route[] findFlights(String from,String to);

}
