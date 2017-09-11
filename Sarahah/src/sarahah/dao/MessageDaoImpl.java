package sarahah.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import sarahah.bean.Message;

public class MessageDaoImpl implements MessageDao {
	@Autowired
	DataSource datasource;
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Autowired
	private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

	@Autowired
	public void setNamedParameterJdbcTemplate(NamedParameterJdbcTemplate namedParameterJdbcTemplate) {
		this.namedParameterJdbcTemplate = namedParameterJdbcTemplate;
	}

	@Override
	public void saveMessage(Message message) {
		String saveMessage = "insert into message (message,username,received_date) values (?,?,?)";
		jdbcTemplate.update(saveMessage, message.getMessage(), message.getUserName(), getCurrentDatetime());

	}

	public String getCurrentDatetime() {
		java.util.Date today = new java.util.Date();
		java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String currentTime = sdf.format(today);
		return currentTime;
	}

	@Override
	public List<Message> viewMessage(String userName) {
		String fetchUserMessages = "select mid,message,username,received_date from message"
				+ " where username= " + "'" + userName + "'"
				+ "order by received_date desc";
		List<Message> messages = jdbcTemplate.query(fetchUserMessages, new RowMapper<Message>() {
			public Message mapRow(ResultSet rs, int rowNum) throws SQLException {
				Message message = new Message();
				message.setMid(rs.getInt("mid"));
				message.setMessage(rs.getString("message"));
				message.setUserName(rs.getString("username"));
				String fmtTimestamp=new java.text.SimpleDateFormat("EEE, dd MMM yy, hh:mm a").format(rs.getTimestamp("received_date"));
				//System.out.println(fmtTimestamp);
				message.setDateTime(fmtTimestamp);
				return message;

			}
		});
		return messages;

	}

}
