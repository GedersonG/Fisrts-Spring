package com.projectone.projectone.controllers;

import com.projectone.projectone.models.User;
import com.projectone.projectone.DAO.UserDAO;
import com.projectone.projectone.utils.JWTUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    @Autowired
    private UserDAO userDAO;

    @Autowired
    private JWTUtil jwtUtil;

    @RequestMapping(value ="api/login", method = RequestMethod.POST)
    public String login(@RequestBody User user){

        User userVerify = userDAO.verify(user);
        if (userVerify != null){

            String tokenJWT = jwtUtil.create(String.valueOf(userVerify.getId()), userVerify.getEmail());
            return tokenJWT;
        }
        return "FAIL";
    }
}