package dao;

import beans.models.User;

import java.util.HashMap;
import java.util.List;

public interface UserDAO {

    List<User> getUsers();
    void addUser(User user);
    User getUserByUsername(String username);
    User getUserByEmail(String email);
    HashMap<String, User> getUsersByName(String name);
    HashMap<String, User> getUsersBySurname(String surname);
    HashMap<String, User> getUsersByDateRange(String dateRange);
    void saveChanges();
    void load();
}
