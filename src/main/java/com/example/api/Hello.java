package com.example.api;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * @author Daniel Oskarsson <daniel.oskarsson@gmail.com>
 */
@Path("/")
public final class Hello {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response helloWorld() {
        return Response.status(200).entity("Hello World").build();
    }

}
