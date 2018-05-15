package io.swagger.server.api.verticle;

import io.swagger.server.api.model.Vehicle;

public class DefaultApiImpl implements DefaultApi {

	@Override
	public Vehicle vehiclesGet() {
		// TODO Auto-generated method stub
		Vehicle v =new Vehicle();
		v.setCategory("air");
		v.setId(5);
		v.setName("A real vehicle this time");
		return v;
	}

	@Override
	public Vehicle vehiclesPost(Vehicle body) {
		// TODO Auto-generated method stub
		return null;
	}

}
