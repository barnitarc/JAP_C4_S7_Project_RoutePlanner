

package org.com.RoutePlanner;

public class RouteDAOImplementation implements RouteDAO{
    private Route route[];
    public RouteDAOImplementation(int size)
    {
        route=new Route[size];
    }

    @Override
    public Route[] findAll()
    {
        return route;
    }
}
