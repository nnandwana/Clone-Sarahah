package sarahah.dao;

import java.sql.SQLException;

import sarahah.bean.User;
import sarahah.bean.UserLogin;

public interface UserDao {
	public void saveUser(User user);
	public void updateUser(User user);
	public void deleteUser(User user);
	public boolean isUserLogin(UserLogin userLogin) throws SQLException;
	public User showUser(String userName);
}
