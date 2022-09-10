package dao;

import beans.models.User;
import dto.EditProfileDTO;

import java.util.HashMap;
import java.util.List;

public interface UserDAO {

    List<User> getUsers();
    void addUser(User user);
    void addFriend(String user, String friend);
    void removeFriend(String user, String friend);
    User getUserByUsername(String username);
    User getUserByEmail(String email);
    HashMap<String, User> getUsersByName(String name);
    HashMap<String, User> getUsersBySurname(String surname);
    HashMap<String, User> getUsersByDateRange(String dateRange);
    void editUser(String username, EditProfileDTO newDetails);
    void blockUser(String username);
    void unblockUser(String username);
    void saveChanges();
    void load();
}
