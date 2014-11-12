package com.programmingfree.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import com.programmingfree.model.ChangeTracker;
import com.programmingfree.model.ChangeTracker;
import com.programmingfree.utility.DBUtility;

public class ChangeTrackerDao {
	
	private Connection connection;
	
	public ChangeTrackerDao() {
		connection = DBUtility.getConnection();
	}
	public void addChangeTracker(ChangeTracker changetrack) {
		try {
			
			PreparedStatement preparedStatement = connection
					.prepareStatement("insert into changetracker(changeticket,changedate,affectedsystem,affectedsoftware,starttime,endtime,actionforbridge,oots,status) values (?,?, ?, ?,?,?,?,?,? )");
			// Parameters start with 1
			//preparedStatement.setInt(2, changetrack.getHid());
			preparedStatement.setString(1, changetrack.getChangeticket());
			preparedStatement.setString(2, changetrack.getChangedate());			
			preparedStatement.setString(3, changetrack.getAffectedsystem());
			preparedStatement.setString(4, changetrack.getAffectedsoftware());
			preparedStatement.setString(5, changetrack.getStarttime());
			preparedStatement.setString(6, changetrack.getEndtime());
			preparedStatement.setString(7, changetrack.getActionforbridge());
			preparedStatement.setString(8, changetrack.getOots());
			preparedStatement.setString(9, changetrack.getStatus());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void deleteChangeTracker(int changetrackId) {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("delete from changetracker where idchangetracker=?");
			// Parameters start with 1
			preparedStatement.setInt(1, changetrackId);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void updateChangeTracker(ChangeTracker changetrack) throws ParseException {
		try {
			PreparedStatement preparedStatement = connection
					.prepareStatement("update changetracker set changeticket=?,changedate=?,affectedsystem=?,affectedsoftware=?,starttime=?,endtime=?,actionforbridge=?,oots=?,status=? where idchangetracker=?");
			// Parameters start with 1			
			preparedStatement.setString(1, changetrack.getChangeticket());
			preparedStatement.setString(2, changetrack.getChangedate());			
			preparedStatement.setString(3, changetrack.getAffectedsystem());
			preparedStatement.setString(4, changetrack.getAffectedsoftware());
			preparedStatement.setString(5, changetrack.getStarttime());
			preparedStatement.setString(6, changetrack.getEndtime());
			preparedStatement.setString(7, changetrack.getActionforbridge());
			preparedStatement.setString(8, changetrack.getOots());
			preparedStatement.setString(9, changetrack.getStatus());
			preparedStatement.setInt(10, changetrack.getIdchangetracker());
			preparedStatement.executeUpdate();
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public List<ChangeTracker> getAllChangeTrackers(int jtStartIndex, int jtPageSize) {
		
		
		List<ChangeTracker> changetracks = new ArrayList<ChangeTracker>();
		
		String startIndex=Integer.toString(jtStartIndex);
		 String pageSize=Integer.toString(jtPageSize);
		 String query="select * from changetracker where status='active'  limit "+startIndex+","+pageSize;
		try {
			Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery(query);
			while (rs.next()) {
				ChangeTracker changetrack = new ChangeTracker();
				changetrack.setIdchangetracker(rs.getInt("idchangetracker"));
				changetrack.setChangeticket(rs.getString("changeticket"));
				changetrack.setChangedate(rs.getString("changedate"));				
				changetrack.setAffectedsystem(rs.getString("affectedsystem"));
				changetrack.setAffectedsoftware(rs.getString("affectedsoftware"));
				changetrack.setStarttime(rs.getString("starttime"));
				changetrack.setEndtime(rs.getString("endtime"));
				changetrack.setActionforbridge(rs.getString("actionforbridge"));
				changetrack.setOots(rs.getString("oots"));
				changetrack.setStatus(rs.getString("status"));
				changetracks.add(changetrack);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return changetracks;
	}
	
	public ChangeTracker getChangeTrackerById(int changetrackId) {
		ChangeTracker changetrack = new ChangeTracker();
		try {
			PreparedStatement preparedStatement = connection.
					prepareStatement("select * from changetracker where idchangetracker=?");
			preparedStatement.setInt(1, changetrackId);
			ResultSet rs = preparedStatement.executeQuery();
			
			if (rs.next()) {
				
				changetrack.setIdchangetracker(rs.getInt("idchangetracker"));
				changetrack.setChangeticket(rs.getString("changeticket"));
				changetrack.setChangedate(rs.getString("changedate"));				
				changetrack.setAffectedsystem(rs.getString("affectedsystem"));
				changetrack.setAffectedsoftware(rs.getString("affectedsoftware"));
				changetrack.setStarttime(rs.getString("starttime"));
				changetrack.setEndtime(rs.getString("endtime"));
				changetrack.setActionforbridge(rs.getString("actionforbridge"));
				changetrack.setOots(rs.getString("oots"));
				changetrack.setStatus(rs.getString("status"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return changetrack;
	}
	
	public int getChangeTrackerCount(){
		 int count=0;
		 try {
		                Statement statement =                     
		                  connection. createStatement();
		  ResultSet rs = 
		                  statement.executeQuery("select count(*) as count from changetracker")  ; 
		                  while (rs.next()) {
		   count=rs.getInt("count");
		  }
		 } catch (SQLException e) {
		  e.printStackTrace();
		 }
		 return count;
		}


}
