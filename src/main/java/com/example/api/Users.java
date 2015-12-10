package com.example.api;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
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

}
