package io.swagger.server.api.verticle;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.json.Json;
import io.vertx.core.json.JsonArray;
import io.vertx.core.json.JsonObject;
import io.vertx.core.logging.Logger;
import io.vertx.core.logging.LoggerFactory;

import io.swagger.server.api.model.Vehicle;

import java.util.List;
import java.util.Map;

public class DefaultApiVerticle extends AbstractVerticle {
    final static Logger LOGGER = LoggerFactory.getLogger(DefaultApiVerticle.class); 
    
    final static String GET_VEHICLES_SERVICE_ID = "GET_vehicles";
    final static String POST_VEHICLES_SERVICE_ID = "POST_vehicles";
    
    //TODO : create Implementation
    DefaultApi service = new DefaultApiImpl();

    @Override
    public void start() throws Exception {
        
        //Consumer for GET_vehicles
        vertx.eventBus().<JsonObject> consumer(GET_VEHICLES_SERVICE_ID).handler(message -> {
            try {
                
                Vehicle result = service.vehiclesGet();
                message.reply(new JsonObject(Json.encode(result)).encodePrettily());
            } catch (Exception e) {
                //TODO : replace magic number (101)
                message.fail(101, e.getLocalizedMessage());
            }
        });
        
        //Consumer for POST_vehicles
        vertx.eventBus().<JsonObject> consumer(POST_VEHICLES_SERVICE_ID).handler(message -> {
            try {
                Vehicle body = Json.mapper.readValue(message.body().getJsonObject("body").encode(), Vehicle.class);
                
                Vehicle result = service.vehiclesPost(body);
                message.reply(new JsonObject(Json.encode(result)).encodePrettily());
            } catch (Exception e) {
                //TODO : replace magic number (101)
                message.fail(101, e.getLocalizedMessage());
            }
        });
        
    }
}