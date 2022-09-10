package dao;

import beans.models.Gender;
import beans.models.User;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import data.JsonDatabase;
import dto.EditProfileDTO;
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

    @Override
    public void editUser(String username, EditProfileDTO newDetails) {
        if(this.users.containsKey(username)) {
            User u = this.users.get(username);
            u.setName(newDetails.getName());
            u.setSurname(newDetails.getSurname());
            u.setEmail(newDetails.getEmail());
            u.setGender(newDetails.getGender());
            if (!newDetails.getNewPassword().isEmpty())
                u.setPassword(newDetails.getNewPassword());
//            u.setPrivate(newDetails.isPrivate());
            saveChanges();
        }
    }

    @Override
    public void blockUser(String username) {
        this.users.get(username).setBlocked(true);
        saveChanges();
    }

    @Override
    public void unblockUser(String username) {
        this.users.get(username).setBlocked(false);
        saveChanges();
    }
}
