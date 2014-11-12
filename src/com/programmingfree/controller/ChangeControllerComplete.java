package com.programmingfree.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.programmingfree.dao.ChangeTrackerCompleteDao;
import com.programmingfree.dao.ChangeTrackerDao;
import com.programmingfree.model.ChangeTracker;
import com.programmingfree.model.ChangeTrackerCompleted;

/**
 * Servlet implementation class ChangeControllerComplete
 */
@WebServlet("/ChangeControllerComplete")
public class ChangeControllerComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ChangeTrackerCompleteDao dao;  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ChangeControllerComplete() {
    	dao=new ChangeTrackerCompleteDao();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if(request.getParameter("action")!=null){
			List<ChangeTrackerCompleted> lstChange=new ArrayList<ChangeTrackerCompleted>();
			String action=(String)request.getParameter("action");
			Gson gson = new Gson();
			response.setContentType("application/json");
			
			if(action.equals("list")){
				try{						
				//Fetch Data from User Table
					int startPageIndex=
					          Integer.parseInt(request.getParameter("jtStartIndex"));
					       int numRecordsPerPage=
					          Integer.parseInt(request.getParameter("jtPageSize"));
					       lstChange=dao.getAllChangeTrackersComplete(startPageIndex, numRecordsPerPage);
					       //Get Total Record Count for Pagination
					       int userCount=dao.getChangeTrackerCount();			
				//Convert Java Object to Json				
				JsonElement element = gson.toJsonTree(lstChange, new TypeToken<List<ChangeTrackerCompleteDao>>() {}.getType());
				JsonArray jsonArray = element.getAsJsonArray();
				String listData=jsonArray.toString();				
				//Return Json in the format required by jTable plugin
				listData=          " {\"Result\":\"OK\",\"Records\":"+listData+",\"TotalRecordCount\":"+userCount+"}";   			
				response.getWriter().print(listData);
				}catch(Exception ex){
					String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getMessage()+"}";
					response.getWriter().print(error);
					ex.printStackTrace();
				}				
			}
			else if(action.equals("create") || action.equals("update")){
				ChangeTrackerCompleted change=new ChangeTrackerCompleted();
				if(request.getParameter("idchangetracker")!=null){				   
				   int idchangetracker=Integer.parseInt(request.getParameter("idchangetracker"));
				   change.setIdchangetracker(idchangetracker);
				}
				if(request.getParameter("changeticket")!=null){
					String changeticket=(String)request.getParameter("changeticket");
					change.setChangeticket(changeticket);
				}
				if(request.getParameter("changedate")!=null){
				   String changedate=(String)request.getParameter("changedate");
				   change.setChangedate(changedate);
				}
				if(request.getParameter("affectedsystem")!=null){
				   String affectedsystem=(String)request.getParameter("affectedsystem");
				   change.setAffectedsystem(affectedsystem);
				}
				if(request.getParameter("affectedsoftware")!=null){
					   String affectedsoftware=(String)request.getParameter("affectedsoftware");
					   change.setAffectedsoftware(affectedsoftware);
					}
				if(request.getParameter("starttime")!=null){
					   String starttime=(String)request.getParameter("starttime");
					   change.setStarttime(starttime);
					}
				if(request.getParameter("endtime")!=null){
					   String endtime=(String)request.getParameter("endtime");
					   change.setEndtime(endtime);
					}
				if(request.getParameter("actionforbridge")!=null){
					   String actionforbridge=(String)request.getParameter("actionforbridge");
					   change.setActionforbridge(actionforbridge);
					}
				if(request.getParameter("oots")!=null){
						   String oots=(String)request.getParameter("oots");
						   change.setOots(oots);
						}
					if(request.getParameter("status")!=null){
						   String status=(String)request.getParameter("status");
						   change.setStatus(status);
						}
				
				try{											
					if(action.equals("create")){//Create new record
						dao.addChangeTrackerComplete(change);					
						lstChange.add(change);
						//Convert Java Object to Json				
						String json=gson.toJson(change);					
						//Return Json in the format required by jTable plugin
						String listData="{\"Result\":\"OK\",\"Record\":"+json+"}";											
						response.getWriter().print(listData);
					}else if(action.equals("update")){//Update existing record
						dao.updateChangeTrackerComplete(change);
						String listData="{\"Result\":\"OK\"}";									
						response.getWriter().print(listData);
					}
				}catch(Exception ex){
						String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
						response.getWriter().print(error);
				}
			}else if(action.equals("delete")){//Delete record
				try{
					if(request.getParameter("idchangetracker")!=null){
						String idchangetracker=(String)request.getParameter("idchangetracker");
						dao.deleteChangeTrackerComplete(Integer.parseInt(idchangetracker));
						String listData="{\"Result\":\"OK\"}";								
						response.getWriter().print(listData);
					}
				}catch(Exception ex){
				String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
				response.getWriter().print(error);
			}				
		}
	 }
	}

}
