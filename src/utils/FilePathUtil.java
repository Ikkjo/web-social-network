package utils;

import java.io.File;

public class FilePathUtil {
//    ".." + File.separator +
    public static final String BASE_DATA_FILEPATH =  "data" + File.separator;
    public static final String USER_DATA_FILEPATH = BASE_DATA_FILEPATH + "users.json";
    public static final String POST_DATA_FILEPATH = BASE_DATA_FILEPATH + "posts.json";
}
