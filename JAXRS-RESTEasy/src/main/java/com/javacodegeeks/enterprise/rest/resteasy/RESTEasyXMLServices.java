package com.javacodegeeks.enterprise.rest.resteasy;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@Path("/xmlServices")
public class RESTEasyXMLServices {

	@POST
	@Path("/send")
	@Consumes("application/xml")
	public Response comsumeXML(Student student) {

		String output = student.toString();

		return Response.status(200).entity(output).build();
	}

}
