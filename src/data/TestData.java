package data;

import beans.models.*;
import dao.*;
import services.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

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
                "../img/MALE1.jpeg"
                );
        User male2 = new User("test2",
                "test2",
                "stanojeg@gmail.com",
                "Stanoje",
                "Glavaš",
                Gender.MALE,
                UserRole.REGULAR,
                "../img/MALE2.jpeg"
        );
        User male3 = new User("test3",
                "test3",
                "baja.zoro@gmail.com",
                "Zoran",
                "Bajić",
                Gender.MALE,
                UserRole.REGULAR,
                "../img/MALE3.jpeg"
        );
        User male4 = new User("test4",
                "test4",
                "sildu@gmail.com",
                "Dušan",
                "Silbaš",
                Gender.MALE,
                UserRole.REGULAR,
                "../img/MALE4.jpeg"
        );
        User male5 = new User("test5",
                "test5",
                "testaKosta@gmail.com",
                "Kosta",
                "Testić",
                Gender.MALE,
                UserRole.REGULAR,
                "../img/MALE5.jpeg"
        );
        User female1 = new User("test6",
                "test6",
                "fibili@gmail.com",
                "Fibija",
                "Ilić",
                Gender.FEMALE,
                UserRole.REGULAR,
                "../img/FEMALE1.jpeg"
        );
        User female2 = new User("test7",
                "test7",
                "danam@gmail.com",
                "Dana",
                "Makezić",
                Gender.FEMALE,
                UserRole.REGULAR,
                "../img/FEMALE2.jpeg"
        );
        User female3 = new User("admin2",
                "admin2",
                "mica.ost@gmail.com",
                "Milica",
                "Ostojić",
                Gender.FEMALE,
                UserRole.ADMIN,
                "../img/FEMALE3.jpeg"
        );
        User female4 = new User("test8",
                "test8",
                "test8@gmail.com",
                "Dragana",
                "Dušančić",
                Gender.FEMALE,
                UserRole.REGULAR,
                "../img/FEMALE4.jpeg"
        );
        User female5 = new User("test9",
                "test9",
                "jeli.neper@gmail.com",
                "Jelisaveta",
                "Nepergaća",
                Gender.FEMALE,
                UserRole.REGULAR,
                "../img/FEMALE5.jpeg"
        );
        User naocare = new User("admin1",
                "admin1",
                "admin1@gmail.com",
                "Nemam",
                "Naocare",
                Gender.MALE,
                UserRole.ADMIN,
                "../img/NO_GLASSES.jpg");

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

        male1.setFriends(new ArrayList<>());
        male2.setFriends(new ArrayList<>());
        male3.setFriends(new ArrayList<>());
        male4.setFriends(new ArrayList<>());
        male5.setFriends(new ArrayList<>());
        female1.setFriends(new ArrayList<>());
        female2.setFriends(new ArrayList<>());
        female3.setFriends(new ArrayList<>());
        female4.setFriends(new ArrayList<>());
        female5.setFriends(new ArrayList<>());
        naocare.setFriends(new ArrayList<>());

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

        // postovi, fotografije, komentari

        Post p1 = new Post(
                UUID.randomUUID(),
                male1.getUsername(),
                male1,
                "",
                "Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae.",
                new ArrayList<>(),
                null,
                false,
                PostType.TEXT);

        Post p2 = new Post(
                UUID.randomUUID(),
                female1.getUsername(),
                female1,
                "../img/photo1.jpeg",
                "Praesent elementum turpis ac nunc tempus, ut tincidunt metus porta. Suspendisse vitae lectus nulla.",
                new ArrayList<>(),
                null,
                false,
                PostType.TEXT);

        Post p3 = new Post(
                UUID.randomUUID(),
                male1.getUsername(),
                male1,
                "../img/photo2.png",
                "Ut lobortis ultrices erat sit amet euismod.",
                new ArrayList<>(),
                null,
                false,
                PostType.PHOTO);

        Post p4 = new Post(
                UUID.randomUUID(),
                female2.getUsername(),
                female2,
                "../img/photo3.jpg",
                "",
                new ArrayList<>(),
                null,
                false,
                PostType.PHOTO);

        Post p5 = new Post(
                UUID.randomUUID(),
                male4.getUsername(),
                male4,
                "",
                "Mauris ullamcorper consectetur enim, eget volutpat nunc pharetra quis.",
                new ArrayList<>(),
                null,
                false,
                PostType.TEXT);

        Post p6 = new Post(
                UUID.randomUUID(),
                female2.getUsername(),
                female2,
                "../img/photo4.jpeg",
                "In et ex id lorem suscipit hendrerit eu nec dolor. Duis semper dolor feugiat tortor ornare, nec varius urna blandit.",
                new ArrayList<>(),
                null,
                false,
                PostType.TEXT);

        Post p7 = new Post(
                UUID.randomUUID(),
                female4.getUsername(),
                female4,
                "../img/photo5.jpg",
                "Cras dignissim mauris a bibendum sagittis. Mauris iaculis mauris vel convallis varius.",
                new ArrayList<>(),
                null,
                false,
                PostType.TEXT);

        Post p8 = new Post(
                UUID.randomUUID(),
                male3.getUsername(),
                male3,
                "",
                "Phasellus placerat, magna in hendrerit varius, purus purus vehicula sem, ut volutpat quam metus nec sapien.",
                new ArrayList<>(),
                null,
                false,
                PostType.TEXT);

        Post p9 = new Post(
                UUID.randomUUID(),
                female1.getUsername(),
                female1,
                "",
                "Vestibulum imperdiet, augue id pulvinar ultricies, quam ipsum interdum risus, at sagittis enim nibh quis odio. Mauris auctor elit dui, ac fringilla lacus dictum in.",
                new ArrayList<>(),
                null,
                false,
                PostType.TEXT);

        Post p10 = new Post(
                UUID.randomUUID(),
                male1.getUsername(),
                male1,
                "../img/photo6.png",
                "Nulla facilisi. Proin a elit eu diam blandit mollis.",
                new ArrayList<>(),
                null,
                false,
                PostType.TEXT);

        Post p11 = new Post(
                UUID.randomUUID(),
                female2.getUsername(),
                female2,
                "",
                "Nunc sagittis massa id ipsum vestibulum, quis dapibus nibh bibendum.",
                new ArrayList<>(),
                null,
                false,
                PostType.TEXT);

        Post p12 = new Post(
                UUID.randomUUID(),
                female3.getUsername(),
                female3,
                "../img/MALE3.jpeg",
                "",
                new ArrayList<>(),
                null,
                false,
                PostType.PHOTO);

        Comment c1 = new Comment(
                UUID.randomUUID(),
                p12.getId(),
                male1.getUsername(),
                "Fusce tincidunt sed neque sollicitudin varius.",
                LocalDateTime.now().toEpochSecond(ZoneOffset.MIN),
                null,
                false);

        Comment c2 = new Comment(
                UUID.randomUUID(),
                p1.getId(),
                male3.getUsername(),
                "Phasellus tempus leo in venenatis eleifend. Duis faucibus sapien eros, ut malesuada tellus rhoncus et.",
                LocalDateTime.now().toEpochSecond(ZoneOffset.MIN)+1,
                null,
                false);

        Comment c3 = new Comment(
                UUID.randomUUID(),
                p1.getId(),
                female2.getUsername(),
                "Nullam imperdiet scelerisque ex eget lacinia. Vivamus faucibus lorem congue sapien ornare consequat.",
                LocalDateTime.now().toEpochSecond(ZoneOffset.MIN)+1,
                null,
                false);

        Comment c4 = new Comment(
                UUID.randomUUID(),
                p1.getId(),
                male1.getUsername(),
                "Cras vestibulum magna dignissim turpis imperdiet, a tincidunt tellus venenatis.",
                LocalDateTime.now().toEpochSecond(ZoneOffset.MIN)+1,
                null,
                false);

        Comment c5 = new Comment(
                UUID.randomUUID(),
                p3.getId(),
                male1.getUsername(),
                "Etiam sodales eros sit amet consequat vehicula.",
                LocalDateTime.now().toEpochSecond(ZoneOffset.MIN)+1,
                null,
                false);

        Comment c6 = new Comment(
                UUID.randomUUID(),
                p3.getId(),
                male2.getUsername(),
                "Donec ac justo iaculis, commodo eros sed, mollis quam.",
                LocalDateTime.now().toEpochSecond(ZoneOffset.MIN)+1,
                null,
                false);



        postService.addPost(p1);
        postService.addPost(p2);
        postService.addPost(p3);
        postService.addPost(p4);
        postService.addPost(p5);
        postService.addPost(p6);
        postService.addPost(p7);
        postService.addPost(p8);
        postService.addPost(p9);
        postService.addPost(p10);
        postService.addPost(p11);
        postService.addPost(p12);

        postService.addComment(c1);
        postService.addComment(c2);
        postService.addComment(c3);
        postService.addComment(c4);
        postService.addComment(c5);
        postService.addComment(c6);

        // Poruke

    }
}
