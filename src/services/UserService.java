package services;

import beans.models.FriendRequest;
import beans.models.User;
import com.google.gson.Gson;
import dao.UserDAO;
import utils.AuthUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class UserService {

    private final UserDAO userDAO;

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    public String logIn(String username, String password){
        if(isValidUser(username, password)) {
            User user = getUser(username);
            String jws = AuthUtils.createJWT(user.getUsername(), 800000);
            user.setJwt(jws);
            return new Gson().toJson(user);
        }
        return null;
    }

    public boolean isValidUser(String username, String password) {
        User u = userDAO.getUserByUsername(username);
        if (u != null){
            if (!u.getDeleted()){
                return u.getPassword().equals(password);
            }
        }
        return false;
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

    public ArrayList<User> userSearch(Map<String, String[]> params) {
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
        return new ArrayList<>(map.values());
    }

    public boolean areFriends(Map<String, String[]> params) {
        String username1 = params.get("username1")[0];
        String username2 = params.get("username2")[0];

        User u1 = getUser(username1);
        User u2 = getUser(username2);

        return u1.getFriends().contains(u2.getUsername()) &&
                u2.getFriends().contains(u1.getUsername());
    }

    public void acceptFriendRequest(FriendRequest request) {
        User sender = getUser(request.getFrom());
    }
}
