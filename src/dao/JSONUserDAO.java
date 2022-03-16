package dao;

import beans.models.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class JSONUserDAO implements UserDAO{

    private Map<String, User> users;

    @Override
    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void addUser(User user) {
        users.put(user.getUsername(), user);
    }

    @Override
    public User getUserByUsername(String username) {
        return users.getOrDefault(username, null);
    }

    @Override
    public User getUserByEmail(String email) {
        for (User u : users.values()) {
            if (email.equals(u.getEmail())) {
                return u;
            }
        }
        return null;
    }
}
