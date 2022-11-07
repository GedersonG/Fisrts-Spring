package com.projectone.projectone.DAO;

import com.projectone.projectone.models.User;

import java.util.List;

public interface UserDAO {

    List<User> getUsers();

    void delete(int id);

    void register(User user);

    User verify(User user);
}
