/**
 * 
 */
package com.anil.passengerws.exception;

import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;

import org.springframework.context.PayloadApplicationEvent;

/**
 * @author Anil_Ramesh
 *
 */
public class PassangerBusinessExceptionMapper implements ExceptionMapper<RuntimeException> {

	@Override
	public Response toResponse(RuntimeException exception) {
		// TODO Auto-generated method stub
		StringBuilder sb = new StringBuilder();
		if (exception instanceof PassangerNotFoundException) {

			sb.append("{");
			sb.append("\"Status\" : \"error\"");
			sb.append(",");
			sb.append("\"Message\" : \"Id Not Found\"");
			sb.append("}");
		} else if (exception instanceof invalidAgentException) {
			sb.append("{");
			sb.append("\"Status\" : \"error\"");
			sb.append(",");
			sb.append("\"Message\" : \"Invalid Agent\"");
			sb.append("}");
		}
		return Response.serverError().entity(sb.toString()).type(MediaType.APPLICATION_XML).build();
	}

}
