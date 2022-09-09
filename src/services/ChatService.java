package services;

import beans.models.DirectMessage;
import dao.DirectMessageDAO;
import org.eclipse.jetty.websocket.api.Session;
import org.eclipse.jetty.websocket.api.annotations.*;
import org.eclipse.jetty.websocket.server.WebSocketHandler;
import org.eclipse.jetty.websocket.servlet.WebSocketServletFactory;

import java.util.*;
import java.io.IOException;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

public class ChatService {

    private final DirectMessageDAO directMessageDAO;

    public ChatService(DirectMessageDAO directMessageDAO) {
        this.directMessageDAO = directMessageDAO;
    }

    public void addDirectMessage(DirectMessage m){
        directMessageDAO.addMessage(m);
    }

    public List<DirectMessage> getMessages(String sender, String receiver){
        return directMessageDAO.getMessages(sender, receiver);
    }

    public List<String> getChats(String user){
        return directMessageDAO.getChats(user);
    }
}
