package io.swagger.server.api.verticle;

import io.swagger.server.api.model.Vehicle;

import java.util.List;
import java.util.Map;

public interface DefaultApi  {
    //GET_vehicles
    public Vehicle vehiclesGet();
    
    //POST_vehicles
    public Vehicle vehiclesPost(Vehicle body);
    
}
