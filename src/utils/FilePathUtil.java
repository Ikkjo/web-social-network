package utils;

import java.io.File;

public class FilePathUtil {
//    ".." + File.separator +
    public static final String BASE_DATA_FILEPATH =  "data" + File.separator;

    public static final String USER_DATA_FILEPATH = BASE_DATA_FILEPATH + "users.json";
    public static final String POST_DATA_FILEPATH = BASE_DATA_FILEPATH + "posts.json";
    public static final String FRIEND_REQUEST_DATA_FILEPATH = BASE_DATA_FILEPATH + "friend_requests.json";
    public static final String COMMENT_DATA_FILEPATH = BASE_DATA_FILEPATH + "comments.json";
    public static final String DIRECT_MESSAGE_DATA_FILEPATH = BASE_DATA_FILEPATH + "direct_messages.json";

}
