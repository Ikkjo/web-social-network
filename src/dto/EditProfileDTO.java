package dto;

import beans.models.Gender;
import beans.models.UserRole;

public class EditProfileDTO {

    private String password;
    private String newPassword;
    private String email;
    private String name;
    private String surname;
    private Gender gender;
    private boolean isPrivate;
    private String username;

    public EditProfileDTO() {
    }

    public EditProfileDTO(String password, String newPassword, String email, String name, String surname, Gender gender, String username, boolean isPrivate) {
        this.password = password;
        this.newPassword = newPassword;
        this.email = email;
        this.name = name;
        this.surname = surname;
        this.gender = gender;
        this.username = username;
        this.isPrivate = isPrivate;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getNewPassword() {
        return newPassword;
    }

    public void setNewPassword(String newPassword) {
        this.newPassword = newPassword;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public boolean isPrivate() {
        return isPrivate;
    }

    public void setPrivate(boolean aPrivate) {
        isPrivate = aPrivate;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
