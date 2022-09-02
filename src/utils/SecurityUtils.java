package utils;

import spark.Filter;
import spark.Request;
import spark.Response;

public class SecurityUtils {

    public static Filter addTrailingSlashes = (Request request, Response response) -> {
        if (!request.pathInfo().endsWith("/")) {
            response.redirect(request.pathInfo() + "/");
        }
    };
}
