package com.projectone.projectone.controllers;

import com.projectone.projectone.DAO.UserDAO;
import com.projectone.projectone.models.User;
import com.projectone.projectone.utils.JWTUtil;
import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class UserController {

    @Autowired
    private UserDAO userDAO;
    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value ="api/users")
    public List <User> getUsers(@RequestHeader(value= "Authorization") String token){
        return verifyToken(token)? userDAO.getUsers() : null;
    }

    private boolean verifyToken(String token){
        String idUser = jwtUtil.getKey(token);
            return idUser != null;
    }

    @RequestMapping(value ="api/users", method = RequestMethod.POST)
    public void registerUser(@RequestBody User user){

        Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
        String hash = argon2.hash(1, 1024, 1, user.getPassword());
        user.setPassword(hash);

        userDAO.register(user);
    }

    @RequestMapping(value ="api/users/{id}", method = RequestMethod.DELETE)
    public void deleteUser(@RequestHeader(value= "Authorization") String token,
                           @PathVariable int id){
        if(!verifyToken(token)){
            return;
        }
        userDAO.delete(id);
    }
}