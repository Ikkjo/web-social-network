package data;

import beans.models.*;
import dao.*;
import services.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.Arrays;

public class TestData {
    private static final JSONUserDAO userDAO = new JSONUserDAO();
    private static final JSONPostDAO postDAO = new JSONPostDAO();
    private static final JSONFriendRequestDAO friendRequestDAO = new JSONFriendRequestDAO();
    private static final JSONCommentDAO commentDAO = new JSONCommentDAO();
    private static final JSONDirectMessageDAO directMessageDAO = new JSONDirectMessageDAO();

    private static final UserService userService = new UserService(userDAO, friendRequestDAO);
    private static final PostService postService = new PostService(postDAO, userDAO, commentDAO);
    private static final FriendRequestService friendRequestService = new FriendRequestService(friendRequestDAO);
    private static final ChatService chatService = new ChatService(directMessageDAO);

    public static void main(String[] args) {
        User male1 = new User("test1",
                "test1",
                "marez@gmail.com",
                "Marko",
                "Zagorac",
                Gender.MALE,
                UserRole.REGULAR,
                "../img/MALE1.jpeg/"
                );
        User male2 = new User("test2",
                "test2",
                "stanojeg@gmail.com",
                "Stanoje",
                "Glavaš",
                Gender.MALE,
                UserRole.REGULAR,
                "../img/MALE2.jpeg/"
        );
        User male3 = new User("test3",
                "test3",
                "baja.zoro@gmail.com",
                "Zoran",
                "Bajić",
                Gender.MALE,
                UserRole.REGULAR,
                "../img/MALE3.jpeg/"
        );
        User male4 = new User("test4",
                "test4",
                "sildu@gmail.com",
                "Dušan",
                "Silbaš",
                Gender.MALE,
                UserRole.REGULAR,
                "../img/MALE4.jpeg/"
        );
        User male5 = new User("test5",
                "test5",
                "testaKosta@gmail.com",
                "Kosta",
                "Testić",
                Gender.MALE,
                UserRole.REGULAR,
                "../img/MALE5.jpeg/"
        );
        User female1 = new User("test6",
                "test6",
                "fibili@gmail.com",
                "Fibija",
                "Ilić",
                Gender.FEMALE,
                UserRole.REGULAR,
                "../img/FEMALE1.jpeg/"
        );
        User female2 = new User("test7",
                "test7",
                "danam@gmail.com",
                "Dana",
                "Makezić",
                Gender.FEMALE,
                UserRole.REGULAR,
                "../img/FEMALE2.jpeg/"
        );
        User female3 = new User("admin2",
                "admin2",
                "mica.ost@gmail.com",
                "Milica",
                "Ostojić",
                Gender.FEMALE,
                UserRole.ADMIN,
                "../img/FEMALE3.jpeg/"
        );
        User female4 = new User("test8",
                "test8",
                "test8@gmail.com",
                "Dragana",
                "Dušančić",
                Gender.FEMALE,
                UserRole.REGULAR,
                "../img/FEMALE4.jpeg/"
        );
        User female5 = new User("test9",
                "test9",
                "jeli.neper@gmail.com",
                "Jelisaveta",
                "Nepergaća",
                Gender.FEMALE,
                UserRole.REGULAR,
                "../img/FEMALE5.jpeg/"
        );
        User naocare = new User("admin1",
                "admin1",
                "admin1@gmail.com",
                "Nemam",
                "Naocare",
                Gender.MALE,
                UserRole.ADMIN,
                "../img/NO_GLASSES.jpg/");

        male1.setDateOfBirth(LocalDate.of(1996, 1, 12).toEpochSecond(LocalTime.MIDNIGHT, ZoneOffset.MIN));
        male2.setDateOfBirth(LocalDate.of(2000, 4, 1).toEpochSecond(LocalTime.MIDNIGHT, ZoneOffset.MIN));
        male3.setDateOfBirth(LocalDate.of(1995, 7, 2).toEpochSecond(LocalTime.MIDNIGHT, ZoneOffset.MIN));
        male4.setDateOfBirth(LocalDate.of(1993, 12, 6).toEpochSecond(LocalTime.MIDNIGHT, ZoneOffset.MIN));
        male5.setDateOfBirth(LocalDate.of(1997, 6, 6).toEpochSecond(LocalTime.MIDNIGHT, ZoneOffset.MIN));
        female1.setDateOfBirth(LocalDate.of(1998, 10, 17).toEpochSecond(LocalTime.MIDNIGHT, ZoneOffset.MIN));
        female2.setDateOfBirth(LocalDate.of(1998, 3, 9).toEpochSecond(LocalTime.MIDNIGHT, ZoneOffset.MIN));
        female3.setDateOfBirth(LocalDate.of(1996, 7, 14).toEpochSecond(LocalTime.MIDNIGHT, ZoneOffset.MIN));
        female4.setDateOfBirth(LocalDate.of(2003, 5, 15).toEpochSecond(LocalTime.MIDNIGHT, ZoneOffset.MIN));
        female5.setDateOfBirth(LocalDate.of(1989, 8, 20).toEpochSecond(LocalTime.MIDNIGHT, ZoneOffset.MIN));
        naocare.setDateOfBirth(LocalDate.of(2001, 6, 11).toEpochSecond(LocalTime.MIDNIGHT, ZoneOffset.MIN));

        male1.addFriend(male3.getUsername());
        male1.addFriend(female5.getUsername());
        male1.addFriend(male2.getUsername());

        male3.addFriend(male1.getUsername());
        male3.addFriend(male2.getUsername());
        male3.addFriend(female1.getUsername());

        female5.addFriend(male1.getUsername());
        female5.addFriend(female1.getUsername());

        male2.addFriend(male1.getUsername());
        male2.addFriend(female1.getUsername());
        male2.addFriend(male3.getUsername());

        female1.addFriend(male3.getUsername());
        female1.addFriend(female5.getUsername());
        female1.addFriend(male2.getUsername());

        userService.addUser(male1);
        userService.addUser(male2);
        userService.addUser(male3);
        userService.addUser(male4);
        userService.addUser(male5);
        userService.addUser(female1);
        userService.addUser(female2);
        userService.addUser(female3);
        userService.addUser(female4);
        userService.addUser(female5);
        userService.addUser(naocare);

        userService.sendFriendRequest(male1.getUsername(), male4.getUsername());
        userService.sendFriendRequest(male1.getUsername(), female1.getUsername());
        userService.sendFriendRequest(female1.getUsername(), male4.getUsername());

        userService.blockUser(female2.getUsername());

        // postovi, fotografije, komentari, poruke

    }


}
