package controllers;

import beans.models.DirectMessage;
import beans.models.User;
import com.google.gson.Gson;
import dto.MessageDTO;
import services.ChatService;
import services.UserService;
import spark.Request;
import spark.Response;
import spark.Route;
import utils.AuthUtils;

public class ChatController {

    private static ChatService chatService;

    public ChatController(ChatService cS) {
        chatService = cS;
    }

    public static Route addMessage = (Request request, Response response) -> {
        response.type("application/json");
        MessageDTO messageDTO = new Gson().fromJson(request.body(), MessageDTO.class);
        DirectMessage message = new DirectMessage(messageDTO);
        chatService.addDirectMessage(message);
        return new Gson().toJson(message);
    };

    public static Route getChats = (Request request, Response response) -> {
        response.type("application/json");
        String loggedInUser = AuthUtils.getUsernameFromToken(request);
        return new Gson().toJson(chatService.getChats(loggedInUser));
    };

    public static Route getMessages = (Request request, Response response) -> {
        response.type("application/json");
        String sender = request.queryParams("sender");
        String receiver = request.queryParams("receiver");
        return new Gson().toJson(chatService.getMessages(sender, receiver));
    };
}
