package services;

import beans.models.User;
import dao.UserDAO;
import jdk.jshell.spi.ExecutionControl;

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
}
