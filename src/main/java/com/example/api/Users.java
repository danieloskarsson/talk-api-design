package com.example.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Daniel Oskarsson <daniel.oskarsson@gmail.com>
 */
@Path("/users")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public final class Users {

    private static List<User> list = new ArrayList<>();

    @GET
    public List<User> listUsers() {
        // Jersey will automatically set the response code to 200 and transform List<User> to JSON
        return list;
    }

    @POST
    public User postUser(final User user) {
        list.add(user);

        // Return the user, including the Server generated UUID
        return user;
    }

    @DELETE
    @Path("/{id}")
    public void deleteUser(@PathParam("id") final String id) {
        int index = -1;

        for (int i = 0; i < list.size(); i++) {
            final User user = list.get(i);
            if (user.getId().toString().equals(id)) {
                index = i;
                break;
            }
        }

        if (index == -1) {
            // This will throw a Jersey exception that Jersey will use to create a response with the response code 412
            throw new WebApplicationException(Response.Status.PRECONDITION_FAILED);
        }

        // Since this method returns void, Jersey will set the response code to 204.
        list.remove(index);
    }

}
