package data;

import beans.models.User;
import beans.models.UserRole;

import java.util.*;

public interface UserDatabase extends Database {

    void Save();

    User getById(UUID id);

    User getByUsername(String username);

    User getByEmail(String email);

    List<User> getDeleted();

    List<User> getActive();

    List<User> getByName(String name);

    List<User> getBySurname(String surname);

    List<User> getByRole(UserRole role);

}
