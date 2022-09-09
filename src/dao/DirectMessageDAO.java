package dao;

import beans.models.DirectMessage;

import java.util.List;

public interface DirectMessageDAO {
    public void addMessage(DirectMessage m);

    public List<String>  getChats();

    public List<DirectMessage> getMessages();

    void saveChanges();
    void load();
}
