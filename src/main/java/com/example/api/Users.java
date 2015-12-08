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
public final class Users {

    private static final List<User> USERS = new ArrayList<User>();

    static {
        USERS.add(new User().setName("Daniel Oskarsson").setUsername("danieloskarsson").setPassword("password"));
        USERS.add(new User().setName("Test Testsson").setUsername("testtestsson").setPassword("testing"));
    }

    @GET
    public List<User> getUsers() {
        return USERS;
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addUser(final User user) {
        USERS.add(user);
    }

}
