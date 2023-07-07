package com.example.demo.SampleCombine.resource;

import com.example.demo.SampleCombine.model.Memo;
import com.example.demo.SampleCombine.model.User;
import com.example.demo.SampleCombine.model.UserManager;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.springframework.stereotype.Component;

import java.util.Collection;

@Component
@Path("/user")
public class UserRest {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<User> getUsers() {
        UserManager um = UserManager.getInstance();
        return um.getAllUsers();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public User createUSer(@FormParam("name") String name) {
        return UserManager.getInstance().createUser(name);
    }

    @GET
    @Path("/{uid}")
    @Produces(MediaType.APPLICATION_JSON)
    public User getUser(@PathParam("uid") String uid) {
        return UserManager.getInstance().getUser(uid);
    }

    @PUT
    @Path("/{uid}")
    @Produces(MediaType.APPLICATION_JSON)
    public User changeName(@PathParam("uid") String uid, @FormParam("name") String name) {
        UserManager um = UserManager.getInstance();
        User user = um.getUser(uid);
        user.setName(name);
        um.setUserHashMap(uid, user);
        return user;
    }

    @DELETE
    @Path("/{uid}")
    public void deleteUser(@PathParam("uid") String uid) {
        UserManager.getInstance().deleteUser(uid);
    }

    @GET
    @Path("/{uid}/memo")
    @Produces(MediaType.APPLICATION_JSON)
    public Collection<Memo> getMemos(@PathParam("uid") String uid) {
        return UserManager.getInstance().getUser(uid).getMemos();
    }

    @POST
    @Path("/{uid}/memo")
    @Produces(MediaType.APPLICATION_JSON)
    public Memo postMemo(@PathParam("uid") String uid, @FormParam("title") String title, @FormParam("description") String description) {
        User user = UserManager.getInstance().getUser(uid);
        System.out.println(user.getMemos());
        return user.createMemo(title, description);
    }

    @DELETE
    @Path("/{uid}/memo/{mid}")
    public void getMemo(@PathParam("uid") String uid, @PathParam("mid") String mid) {
        UserManager.getInstance().getUser(uid).deleteMemo(mid);
    }
}
