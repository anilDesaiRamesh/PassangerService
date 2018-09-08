/**
 * 
 */
package com.anil.passengerws;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.HeaderParam;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.HttpHeaders;
import javax.ws.rs.core.Response;

import com.anil.passengerws.model.Passanger;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * @author Anil_Ramesh
 *
 */
@Path("/passangerservice")
@Produces("application/xml")
@Consumes("application/xml,application/x-www-form-urlencoded")
public interface IPassangerService {

	@Path("/passangers")
	@GET
	public List<Passanger> getPassanger(@QueryParam("start") int start, @QueryParam("size") int size)
			throws JsonProcessingException;

	@Path("/passangers")
	@POST
	public Passanger addPassanger(Passanger passanger);

	@Path("/passangers/{id}")
	@GET
	public Response getPassangerByid(@PathParam(value = "id") int id);

	@Path("/passangers")
	@POST
	public Response addPassanger(@FormParam("firstName") String firstName, @FormParam("lastName") String lastName,
			@HeaderParam("agent") String agent, @Context HttpHeaders httpHeader);

}
