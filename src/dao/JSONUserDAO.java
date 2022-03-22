package dao;

import beans.models.Gender;
import beans.models.User;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class JSONUserDAO implements UserDAO{

    private Map<String, User> users;

    public JSONUserDAO() {
        users = new HashMap<>();
    }

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

    @Override
    public HashMap<String, User> getUsersByName(String name) {
        HashMap<String, User> usersMap = new HashMap<>();
        for (User u: users.values()) {
            if (u.getName().equals(name))
                usersMap.put(u.getUsername(), u);
        }
        return usersMap;
    }

    @Override
    public HashMap<String, User> getUsersBySurname(String surname) {
        HashMap<String, User> usersMap = new HashMap<>();
        for (User u: users.values()) {
            if (u.getSurname().equals(surname))
                usersMap.put(u.getUsername(), u);
        }
        return usersMap;
    }

    @Override
    public HashMap<String, User> getUsersByDateRange(String dateRange) {
        return null;
    }

    public void generateTestData() {
        User u1 = new User("test1", "test1", "test1@gmail.com", "Test1", "Testic1", Gender.MALE);
        User u2 = new User("test2", "test2", "test2@gmail.com", "Test2", "Testic2", Gender.FEMALE);
        User u3 = new User("test3", "test3", "test3@gmail.com", "Test3", "Testic1", Gender.FEMALE);
        User u4 = new User("test4", "test4", "test4@gmail.com", "Testnoime", "Testic1", Gender.FEMALE);
        User u5 = new User("test5", "test5", "test5@gmail.com", "Testesteron", "Testic1", Gender.FEMALE);

        u1.setProfilePic("./img/male_avatar.svg");
        u2.setProfilePic("./img/female_avatar.svg");
        u3.setProfilePic("./img/female_avatar.svg");
        u4.setProfilePic("./img/female_avatar.svg");
        u5.setProfilePic("./img/female_avatar.svg");

        u1.setDateOfBirth(LocalDate.of(1996, 2, 12));
        u2.setDateOfBirth(LocalDate.of(1997, 2, 12));
        u3.setDateOfBirth(LocalDate.of(1998, 2, 12));
        u4.setDateOfBirth(LocalDate.of(1999, 2, 12));
        u5.setDateOfBirth(LocalDate.of(2000, 10, 20));

        users.put(u1.getUsername(), u1);
        users.put(u2.getUsername(), u2);
        users.put(u3.getUsername(), u3);
        users.put(u4.getUsername(), u4);
        users.put(u5.getUsername(), u5);
    }
}
