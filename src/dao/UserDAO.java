package dao;

import beans.models.User;

import java.util.List;

public interface UserDAO {

    List<User> getUsers();
    void addUser(User user);
    User getUserByUsername(String username);
    User getUserByEmail(String email);
}
