package dto;

public class LoginDetailsDTO {
    private final String username;
    private final String password;

    public LoginDetailsDTO(String username, String password) {
        this.username = username;
        this.password = password;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
