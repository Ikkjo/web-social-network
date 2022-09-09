package dao;

import beans.models.DirectMessage;

import java.util.List;

public interface DirectMessageDAO {
    void addMessage(DirectMessage m);

    List<String>  getChats(String username);

    List<DirectMessage> getMessages(String sender, String receiver);

    void saveChanges();
    void load();
}
