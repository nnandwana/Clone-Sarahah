package sarahah.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import sarahah.bean.User;
import sarahah.bean.UserLogin;

public class UserDaoImpl implements UserDao {
	@Autowired
	  DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;
	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(
		NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public void saveUser(User user) {
		String saveQuery="insert into users (email,username,name,link) values(?,?,?,?)";
		String link=user.getUserName() + ".sarahah.com"; 
		 jdbcTemplate.update(saveQuery, user.getEmail(),user.getUserName(),user.getName(),link);
		 String saveLogin="insert into login (username,password) values (?,?)";
		 jdbcTemplate.update(saveLogin,user.getUserName(),user.getPassword());
		}
		
	
	@Override
	public boolean isUserLogin(UserLogin userLogin) throws SQLException {
		String login="select count(1) from login where username=? and password=?";
		 PreparedStatement pstmt = datasource.getConnection().prepareStatement(login);
		 pstmt.setString(1, userLogin.getUserName());
		 pstmt.setString(2, userLogin.getPassword());
		 ResultSet rs=pstmt.executeQuery();
		 if(rs.next()) 
			 return (rs.getInt(1) > 0);
		 else 
			 return false;
		 }
     
	@Override
	public User showUser(String userName) {
		Map<String, Object> users = new HashMap<String, Object>();
		users.put("userName",userName);
		String fetchUser="select * from users where username=:userName";
		User user=null;
		
		user=namedParameterJdbcTemplate.queryForObject(fetchUser, users, new UserMapper());
		return user;
	}
	
	@Override
	public void updateUser(User user) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteUser(User user) {
		// TODO Auto-generated method stub
		
	}
	
	

} 

final class UserMapper implements RowMapper<User> {
	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		User user=new User();
		user.setUid(rs.getInt("uid"));
		user.setEmail(rs.getString("email"));
		user.setName(rs.getString("name"));
		user.setUserName(rs.getString("username"));
		return user;
		
		
	}
}