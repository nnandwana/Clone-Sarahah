package sarahah.bean;

import java.sql.Date;
import java.sql.Time;
import java.sql.Timestamp;

public class Message {
	@Override
	public String toString() {
		return getMessage() + getDateTime();
	}
	int mid;
	String message;
	String userName;
	String dateTime;
	public String getDateTime() {
		return dateTime;
	}
	public void setDateTime(String string) {
		this.dateTime = string;
	}
	public int getMid() {
		return mid;
	}
	public void setMid(int mid) {
		this.mid = mid;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	
}
