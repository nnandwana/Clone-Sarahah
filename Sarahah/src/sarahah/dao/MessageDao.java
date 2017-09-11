package sarahah.dao;

import java.util.List;

import sarahah.bean.Message;

public interface MessageDao {
	public void saveMessage(Message message);
	public List<Message> viewMessage(String userName);

}
