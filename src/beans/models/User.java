package beans.models;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
    private String username;
    private String password;
    private String email;
    private String name;
    private String surname;
    private Long dateOfBirth;
    private Gender gender;
    private UserRole role;
    private String profilePic;
	private transient List<Post> posts;
    private List<FriendRequest> friendRequests;
    private List<String> friends;
    private Boolean isPrivate;
    private Boolean deleted;
	private Boolean blocked;
	private String jwt;

	public User() {
		this.dateOfBirth = new Date().getTime();
		this.role = UserRole.REGULAR;
		this.isPrivate = false;
		this.deleted = false;
		this.friends = new ArrayList<>();
		this.friendRequests = new ArrayList<>();
		this.posts = new ArrayList<>();
		this.profilePic = "./img/profile_pic.svg";
		this.blocked = false;
    }

	public User(String username, String password, String email, String name, String surname, Long dateOfBirth,
				Gender gender, UserRole role, String profilePic, List<Post> posts, List<FriendRequest> friendRequests,
				List<String> friends, Boolean isPrivate, Boolean deleted, Boolean blocked, String jwt) {
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
		this.deleted = deleted;
		this.blocked = blocked;
		this.jwt = jwt;
	}

	public User(String username, String password, String email, String name, String surname, Long dateOfBirth,
				Gender gender, UserRole role, String profilePic, List<Post> posts, List<FriendRequest> friendRequests,
				List<String> friends, Boolean isPrivate) {
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
		this.dateOfBirth = 0L;
		this.role = UserRole.REGULAR;
		this.isPrivate = false;
		this.deleted = false;
		this.friends = new ArrayList<>();
		this.friendRequests = new ArrayList<>();
		this.posts = new ArrayList<>();
		this.profilePic = "./img/profile_pic.svg";
	}

	public User(String username, String password, String email, String name, String surname, Gender gender,
				UserRole role, String profilePic) {
		this.username = username;
		this.password = password;
		this.email = email;
		this.name = name;
		this.surname = surname;
		this.gender = gender;
		this.role = role;
		this.profilePic = profilePic;
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
	
	public Long getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Long dateOfBirth) {
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
	
	public List<String> getFriends() {
		return friends;
	}
	
	public void setFriends(List<String> friends) {
		this.friends = friends;
	}

	public void addFriend(String newFriend) { this.friends.add(newFriend);}

	public void removeFriend(String friend) {
		this.friends.remove(friend);
	}
	public Boolean getPrivate() {
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

	public Boolean getBlocked() {
		return blocked;
	}

	public void setBlocked(Boolean blocked) {
		this.blocked = blocked;
	}

	public String getJwt() {
		return jwt;
	}
}