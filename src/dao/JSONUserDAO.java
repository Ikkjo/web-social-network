package dao;

import beans.models.Gender;
import beans.models.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import data.JsonDatabase;
import utils.DateUtils;
import utils.FilePathUtil;

import java.io.*;
import java.lang.reflect.Type;
import java.time.LocalDate;
import java.util.*;

public class JSONUserDAO implements UserDAO{

    private Map<String, User> users;

    public JSONUserDAO() {
        load();
    }

    @Override
    public void saveChanges() {
        JsonDatabase.save(new File(FilePathUtil.USER_DATA_FILEPATH), this.users);
    }

    @Override
    public void load() {
        File f = new File(FilePathUtil.USER_DATA_FILEPATH);

        if (!f.exists()){
            try {
                f.createNewFile();
                this.users = new HashMap<>();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(f))) {

            Type usersTypeToken = new TypeToken<HashMap<String, User>>() {}.getType();

                this.users = new Gson().fromJson(br, usersTypeToken);

        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            this.users = new HashMap<>();
        }

    }
    @Override
    public List<User> getUsers() {
        return new ArrayList<>(users.values());
    }

    @Override
    public void addUser(User user) {
        users.put(user.getUsername(), user);
        saveChanges();
    }

    @Override
    public void addFriend(String user, String friend) {
        users.get(user).addFriend(friend);
        users.get(friend).addFriend(user);
        saveChanges();
    }

    @Override
    public void removeFriend(String user, String friend) {
        users.get(user).removeFriend(friend);
        users.get(friend).removeFriend(user);
        saveChanges();
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
        HashMap<String, User> usersMap = new HashMap<>();
        List<Long> dates = DateUtils.toDateList(dateRange);
        for (User u: users.values()) {
                if (DateUtils.isWithinRange(u.getDateOfBirth(), dates.get(0), dates.get(1)))
                    usersMap.put(u.getUsername(), u);
        }
        return usersMap;
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

        u1.setDateOfBirth(LocalDate.of(1996, 2, 12).toEpochDay());
        u2.setDateOfBirth(LocalDate.of(1997, 2, 12).toEpochDay());
        u3.setDateOfBirth(LocalDate.of(1998, 2, 12).toEpochDay());
        u4.setDateOfBirth(LocalDate.of(1999, 2, 12).toEpochDay());
        u5.setDateOfBirth(LocalDate.of(2000, 10, 20).toEpochDay());

        u1.setFriends(Arrays.asList(u2.getUsername()));
        u2.setFriends(Arrays.asList(u1.getUsername()));

        users.put(u1.getUsername(), u1);
        users.put(u2.getUsername(), u2);
        users.put(u3.getUsername(), u3);
        users.put(u4.getUsername(), u4);
        users.put(u5.getUsername(), u5);
    }
}
