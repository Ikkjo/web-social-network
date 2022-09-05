package data;

import beans.models.User;
import beans.models.UserRole;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.BufferedReader;
import java.io.File;

import java.io.FileReader;
import java.io.FileWriter;
import java.lang.reflect.Type;
import java.util.*;

public class UserJSONDatabase extends JsonDatabase implements UserDatabase{

    private Map<UUID, User> users;

    private final File jsonFile = new File("data" + File.separator + "users.json");

    public UserJSONDatabase() {
    }

    public void initDB() {
        try (BufferedReader br = new BufferedReader(new FileReader(this.jsonFile))) {

            Gson json = new Gson();
            Type userMapType = new TypeToken<Map<UUID, User>>() {}.getType();
            this.users = json.fromJson(br, userMapType);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void saveDB() {
        Object data = this.users;
        this.Save();
    }

    @Override
    public void Save() {

    }

    @Override
    public User getById(UUID id) {
        return users.get(id);
    }

    @Override
    public User getByUsername(String username) {
        for(User u : this.users.values()){
            if (u.getUsername().equals(username)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public User getByEmail(String email) {
        for(User u : this.users.values()){
            if (u.getEmail().equals(email)) {
                return u;
            }
        }
        return null;
    }

    @Override
    public List<User> getDeleted() {
        LinkedList<User> deleted = new LinkedList<>();

        for(User u : this.users.values()){
            if (u.getDeleted()) {
                deleted.add(u);
            }
        }
        return deleted;
    }

    @Override
    public List<User> getActive() {
        LinkedList<User> active = new LinkedList<>();

        for(User u : this.users.values()){
            if (!u.getDeleted()) {
                active.add(u);
            }
        }
        return active;
    }

    @Override
    public List<User> getByName(String name) {
        LinkedList<User> sameName = new LinkedList<>();

        for(User u : this.users.values()){
            if (u.getName().equals(name)) {
                sameName.add(u);
            }
        }
        return sameName;
    }

    @Override
    public List<User> getBySurname(String surname) {
        LinkedList<User> sameSurname = new LinkedList<>();

        for(User u : this.users.values()){
            if (u.getSurname().equals(surname)) {
                sameSurname.add(u);
            }
        }
        return sameSurname;
    }

    @Override
    public List<User> getByRole(UserRole role) {
        LinkedList<User> sameRole = new LinkedList<>();

        for(User u : this.users.values()){
            if (u.getRole().equals(role)) {
                sameRole.add(u);
            }
        }
        return sameRole;
    }

    @Override
    public Object Load() {
        return null;
    }
}
