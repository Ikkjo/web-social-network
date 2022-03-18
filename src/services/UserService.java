package services;

import beans.models.User;
import dao.UserDAO;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UserService {

    private UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }


    public boolean isValidUser(User user) {
         return userDAO.getUserByUsername(user.getUsername()).getPassword().equals(user.getPassword());
    }

    public beans.models.User getUser(String username) {
        return userDAO.getUserByUsername(username);
    }

    public boolean isValidUsername(String username) {
        return userDAO.getUserByUsername(username) == null;
    }

    public boolean isValidEmail(String email) {
        return userDAO.getUserByEmail(email) == null;
    }

    public void addUser(beans.models.User user) {
        userDAO.addUser(user);
    }

    public HashMap<String, User> userSearch(Map<String, String[]> params) {
        HashMap<String, User> map = new HashMap<>();
        if (params.containsKey("name") && !Objects.equals(params.get("name")[0], ""))
            map = this.userDAO.getUsersByName(params.get("name")[0]);
        if (params.containsKey("surname") && !Objects.equals(params.get("surname")[0], "")) {
            if (map.isEmpty())
                map = this.userDAO.getUsersBySurname(params.get("surname")[0]);
            else
                map.keySet().retainAll(this.userDAO.getUsersBySurname(params.get("surname")[0]).keySet());
        }
        if (params.containsKey("dateRange") && !Objects.equals(params.get("dateRange")[0], "")) {
            if (map.isEmpty())
                map = this.userDAO.getUsersByDateRange(params.get("dateRange")[0]);
            else
                map.keySet().retainAll(this.userDAO.getUsersByDateRange(params.get("dateRange")[0]).keySet());
        }
        return map;
    }
}
