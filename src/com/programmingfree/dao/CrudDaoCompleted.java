package com.programmingfree.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.programmingfree.model.User;
import com.programmingfree.model.UserCompleted;
import com.programmingfree.utility.DBUtility;
public class CrudDaoCompleted {
	
	private Connection connection;

	public CrudDaoCompleted() {
		connection = DBUtility.getConnection();
	}

	public void addUser(UserCompleted user) {
		try {
			
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into tblUser(datere,mailfrom,subject,summary,response,oots,status) values (?,?, ?, ?,?,?,? )");
			// Parameters start with 1
			//preparedStatement.setInt(2, user.getHid());
			preparedStatement.setString(1, user.getDatere());
			preparedStatement.setString(2, user.getMailfrom());			
			preparedStatement.setString(3, user.getSubject());
			preparedStatement.setString(4, user.getSummary());
			preparedStatement.setString(5, user.getResponse());
			preparedStatement.setString(6, user.getOots());
			preparedStatement.setString(7, user.getStatus());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteUser(int userId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from tblUser where hid=? and status='completed'");
			// Parameters start with 1
			preparedStatement.setInt(1, userId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateUser(UserCompleted user) throws ParseException {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update tblUser set datere=?,mailfrom=?,subject=?,summary=?,response=?,oots=?,status=? where hid=?");
			// Parameters start with 1			
			preparedStatement.setString(1, user.getDatere());
			preparedStatement.setString(2, user.getMailfrom());			
			preparedStatement.setString(3, user.getSubject());
			preparedStatement.setString(4, user.getSummary());
			preparedStatement.setString(5, user.getResponse());
			preparedStatement.setString(6, user.getOots());
			preparedStatement.setString(7, user.getStatus());
			preparedStatement.setInt(8, user.getHid());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<UserCompleted> getAllUsers(int jtStartIndex, int jtPageSize) {
		
		
		List<UserCompleted> users = new ArrayList<UserCompleted>();
		
		String startIndex=Integer.toString(jtStartIndex);
		 String pageSize=Integer.toString(jtPageSize);
		 String query="select * from tblUser  where status='completed' limit "+startIndex+","+pageSize;
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				UserCompleted user = new UserCompleted();
				user.setHid(rs.getInt("hid"));
				user.setDatere(rs.getString("datere"));
				user.setMailfrom(rs.getString("mailfrom"));				
				user.setSubject(rs.getString("subject"));
				user.setSummary(rs.getString("summary"));
				user.setResponse(rs.getString("response"));
				user.setOots(rs.getString("oots"));
				user.setStatus(rs.getString("status"));
				users.add(user);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return users;
	}
	
	public UserCompleted getUserById(int userId) {
		UserCompleted user = new UserCompleted();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from tblUser where hid=?");
			preparedStatement.setInt(1, userId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				user.setHid(rs.getInt("hid"));
				user.setDatere(rs.getString("datere"));
				user.setMailfrom(rs.getString("mailfrom"));				
				user.setSubject(rs.getString("subject"));
				user.setSummary(rs.getString("summary"));
				user.setResponse(rs.getString("response"));
				user.setOots(rs.getString("oots"));
				user.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return user;
	}
	
	public int getUserCount(){
		 int count=0;
		 try {
		                Statement statement =                     
		                  connection. createStatement();
		  ResultSet rs = 
		                  statement.executeQuery("select count(*) as count from tblUser")  ; 
		                  while (rs.next()) {
		   count=rs.getInt("count");
		  }
		 } catch (SQLException e) {
		  e.printStackTrace();
		 }
		 return count;
		}

}
