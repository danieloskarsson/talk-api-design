package com.example.api;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

/**
 * @author Daniel Oskarsson <daniel.oskarsson@gmail.com>
 */
@Path("/")
public final class Hello {

    @GET
    public Response helloWorld() {
        // Manually set the response code to 200 and the response body to "Hello World"
        return Response.status(200).entity("Hello World").build();
    }

    @POST
    public Response postMethod() {
        // https://www.quora.com/What-is-the-story-behind-HTTP-status-code-418-Im-a-Teapot
        return Response.status(418).build();
    }

}
