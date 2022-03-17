package beans.models;

import java.time.LocalDate;
import java.util.List;

public class User {

    private String username;
    private String password;
    private String email;
    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private Gender gender;
    private UserRole role;
    private String profilePic;
    private List<Post> posts;
    private List<FriendRequest> friendRequests;
    private List<User> friends;
    private Boolean isPrivate;
    private Boolean deleted;
	private String jwt;

	public User() {
    	
    }
    
	public User(String username, String password, String email, String name, String surname, LocalDate dateOfBirth,
			Gender gender, UserRole role, String profilePic, List<Post> posts, List<FriendRequest> friendRequests,
			List<User> friends, Boolean isPrivate) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.dateOfBirth = dateOfBirth;
		this.gender = gender;
		this.role = role;
		this.profilePic = profilePic;
		this.posts = posts;
		this.friendRequests = friendRequests;
		this.friends = friends;
		this.isPrivate = isPrivate;
	}
	
	public User(String username, String password, String email, String name, String surname, Gender gender) {
		super();
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
	}


	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setPassword(String password) {
		this.password = password;
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
	
	public LocalDate getDateOfBirth() {
		return dateOfBirth;
	}
	
	public void setDateOfBirth(LocalDate dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public UserRole getRole() {
		return role;
	}
	
	public void setRole(UserRole role) {
		this.role = role;
	}
	
	public String getProfilePic() {
		return profilePic;
	}
	
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	
	public List<Post> getPosts() {
		return posts;
	}
	
	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}
	
	public List<FriendRequest> getFriendRequests() {
		return friendRequests;
	}
	
	public void setFriendRequests(List<FriendRequest> friendRequests) {
		this.friendRequests = friendRequests;
	}
	
	public List<User> getFriends() {
		return friends;
	}
	
	public void setFriends(List<User> friends) {
		this.friends = friends;
	}
	
	public Boolean isPrivate() {
	
		return isPrivate;
	}
	
	public void setPrivate(Boolean isPrivate) {
		this.isPrivate = isPrivate;
	}

	public Boolean getDeleted() {
		return deleted;
	}

	public void setDeleted(Boolean deleted) {
		this.deleted = deleted;
	}

	public void setJwt(String jwt) {
		this.jwt = jwt;
	}

	public String getJwt() {
		return jwt;
	}
}