


package org.com.RoutePlanner;

import java.util.Arrays;

public class RouteServiceImplementation implements RouteServices {
    RouteDAOImplementation obj;
    private int index=0;
    private Route routeArray[];
    private Route temp[];
    private int i=0;
    RouteServiceImplementation x;
   public RouteServiceImplementation(int size)
    {
        obj= new RouteDAOImplementation(size);
        routeArray =obj.findAll();
        
    }
    public void addFlight(String from, String to, int fare, String distance, String travelTime)
    {
     routeArray[index]=new Route(from,to,fare,distance,travelTime);
     index++;
    }
    @Override
    public Route[] findDirectFlightFromLocation(String from) throws NoRouteFoundException
    {
        int size= routeArray.length;
     Route tempFlights[]=new Route[size];
     int index=0;
     for(Route flight: routeArray)
     {
         if(flight.getFrom().equalsIgnoreCase(from)) {
             tempFlights[index]=flight;
         index++;
         }
     }
     tempFlights=Arrays.copyOfRange(tempFlights, 0, index);
     //System.out.println(tempFlights+"11111"+tempFlights.length);
     Arrays.sort(tempFlights);
     if(tempFlights==null)
    	 throw new NoRouteFoundException("No Route Found");
     if(tempFlights!=null) {
    	 //Arrays.sort(tempFlights);
         return tempFlights;
     }
     
     throw new NoRouteFoundException("No Route Found");
    
    }
    
    public boolean isAvailable(String from,String to)
    {
    	for(Route flight: routeArray)
        {
            if(flight.getFrom().equalsIgnoreCase(from) && flight.getTo().equalsIgnoreCase(to))
            {
                return true;
            }
        }
    	return false;
    }
    public Route interFlight(String from,String to)
    {
    	for(Route flight: routeArray)
        {
            if(flight.getFrom().equalsIgnoreCase(from) && flight.getTo().equalsIgnoreCase(to))
            {
                return flight;
            }
        }
    	return null;
    }
    public Route[] findDirectFlights(String from,String to)
    {
    	Route tempFlights[]=new Route[90];
        int index=0;
        for(Route flight: routeArray)
        {
        	if(flight.getFrom().equalsIgnoreCase(from) && flight.getTo().equalsIgnoreCase(to))
            {
                tempFlights[index] = flight;
                index++;
            }
        }
        if(tempFlights!=null) {
            return tempFlights;
        }
        return null;
    }
    
    public Route[] findInterFlights(String from,String to)
    {
    	Route tempFlights[]=new Route[90];
        int index=0;
        for(Route flight: routeArray)
        {
            if(flight.getFrom().equalsIgnoreCase(from) && isAvailable(flight.getTo(),to))
            {
            	
            	tempFlights[index] = flight;
                index++;
                tempFlights[index]=interFlight(flight.getTo(),to);
                index++;
                
            }
        }
        if(tempFlights!=null) {
            return tempFlights;
        }
        return null;
    }
    @Override
    public Route[] findFlights(String from,String to)
    {
        int size= routeArray.length;
        Route tempFlights[]=new Route[90];
        int index=0;
        for(Route flight: routeArray)
        {
        	if(flight.getFrom().equalsIgnoreCase(from) && flight.getTo().equalsIgnoreCase(to))
            {
                tempFlights[index] = flight;
                index++;
            }
            else if(flight.getFrom().equalsIgnoreCase(from) && isAvailable(flight.getTo(),to))
            {
            	
            	tempFlights[index] = flight;
                index++;
                tempFlights[index]=interFlight(flight.getTo(),to);
                index++;
                
            }
        }
        if(tempFlights!=null) {
            return tempFlights;
        }
        return null;

    }
    }

