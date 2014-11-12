package com.programmingfree.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.programmingfree.model.Member;
import com.programmingfree.model.User;
import com.programmingfree.utility.DBUtility;
public class MemberDao {
	
	private Connection connection;

	public MemberDao() {
		connection = DBUtility.getConnection();
	}

	
	
	public void deleteMember(int memid) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from members where id=?");
			// Parameters start with 1
			preparedStatement.setInt(1, memid);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateMember(Member mem) throws ParseException {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update members set first_name=?,last_name=?,email=?,uname=?,pass=?,status=?,type=?,admin=? where id=?");
			// Parameters start with 1			
			preparedStatement.setString(1, mem.getFirst_name());
			preparedStatement.setString(2, mem.getLast_name());			
			preparedStatement.setString(3, mem.getEmail());
			preparedStatement.setString(4, mem.getUname());
			preparedStatement.setString(5, mem.getPass());
			preparedStatement.setString(6, mem.getStatus());
			preparedStatement.setString(7, mem.getType());
			preparedStatement.setString(8, mem.getAdmin());
			preparedStatement.setInt(9, mem.getId());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<Member> getAllMembers(int jtStartIndex, int jtPageSize) {
		
		
		List<Member> mems = new ArrayList<Member>();
		
		String startIndex=Integer.toString(jtStartIndex);
		 String pageSize=Integer.toString(jtPageSize);
		 String query="select * from members    ";
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			
			while (rs.next()) {
				Member mem = new Member();
				mem.setId(rs.getInt("id"));
				mem.setFirst_name(rs.getString("first_name"));
				mem.setLast_name(rs.getString("last_name"));				
				mem.setEmail(rs.getString("email"));
				mem.setUname(rs.getString("uname"));
				mem.setPass(rs.getString("pass"));
				mem.setStatus(rs.getString("status"));
				mem.setType(rs.getString("type"));
				mem.setAdmin(rs.getString("admin"));
				//System.out.println(rs.getString("first_name"));
				mems.add(mem);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return mems;
	}
	
	public Member getUserById(int memid) {
		Member mem = new Member();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from members where id=?");
			preparedStatement.setInt(1, memid);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				mem.setId(rs.getInt("id"));
				mem.setFirst_name(rs.getString("first_name"));
				mem.setLast_name(rs.getString("last_name"));				
				mem.setEmail(rs.getString("email"));
				mem.setUname(rs.getString("uname"));
				mem.setPass(rs.getString("pass"));
				mem.setStatus(rs.getString("status"));
				mem.setType(rs.getString("type"));
				mem.setAdmin(rs.getString("admin"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return mem;
	}
	
	public int getUserCount(){
		 int count=0;
		 try {
		                Statement statement =                     
		                  connection. createStatement();
		  ResultSet rs = 
		                  statement.executeQuery("select count(*) as count from members")  ; 
		                  while (rs.next()) {
		   count=rs.getInt("count");
		  }
		 } catch (SQLException e) {
		  e.printStackTrace();
		 }
		 return count;
		}

}
