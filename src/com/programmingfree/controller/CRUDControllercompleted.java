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
import com.programmingfree.dao.CrudDao;
import com.programmingfree.dao.CrudDaoCompleted;
import com.programmingfree.model.User;
import com.programmingfree.model.UserCompleted;

/**
 * Servlet implementation class CRUDControllercompleted
 */
@WebServlet("/CRUDControllercompleted")
public class CRUDControllercompleted extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private CrudDaoCompleted dao;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CRUDControllercompleted() {
    	dao=new CrudDaoCompleted();
        // TODO Auto-generated constructor stub
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
			List<UserCompleted> lstUser=new ArrayList<UserCompleted>();
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
					       lstUser=dao.getAllUsers(startPageIndex,numRecordsPerPage);
					       //Get Total Record Count for Pagination
					       int userCount=dao.getUserCount();			
				//Convert Java Object to Json				
				JsonElement element = gson.toJsonTree(lstUser, new TypeToken<List<UserCompleted>>() {}.getType());
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
			}else if(action.equals("create") || action.equals("update")){
				UserCompleted user=new UserCompleted();
				if(request.getParameter("hid")!=null){				   
				   int hid=Integer.parseInt(request.getParameter("hid"));
				   user.setHid(hid);
				}
				if(request.getParameter("datere")!=null){
					String datere=(String)request.getParameter("datere");
					user.setDatere(datere);
				}
				if(request.getParameter("mailfrom")!=null){
				   String mailfrom=(String)request.getParameter("mailfrom");
				   user.setMailfrom(mailfrom);
				}
				if(request.getParameter("subject")!=null){
				   String subject=(String)request.getParameter("subject");
				   user.setSubject(subject);
				}
				if(request.getParameter("summary")!=null){
					   String summary=(String)request.getParameter("summary");
					   user.setSummary(summary);
					}
				if(request.getParameter("response")!=null){
					   String action1=(String)request.getParameter("response");
					   user.setResponse(action1);
					}
				if(request.getParameter("oots")!=null){
					   String oots=(String)request.getParameter("oots");
					   user.setOots(oots);
					}
				if(request.getParameter("status")!=null){
					   String status=(String)request.getParameter("status");
					   user.setStatus(status);
					}
				try{											
					if(action.equals("create")){//Create new record
						dao.addUser(user);					
						lstUser.add(user);
						//Convert Java Object to Json				
						String json=gson.toJson(user);					
						//Return Json in the format required by jTable plugin
						String listData="{\"Result\":\"OK\",\"Record\":"+json+"}";											
						response.getWriter().print(listData);
					}else if(action.equals("update")){//Update existing record
						dao.updateUser(user);
						String listData="{\"Result\":\"OK\"}";									
						response.getWriter().print(listData);
					}
				}catch(Exception ex){
						String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
						response.getWriter().print(error);
				}
			}else if(action.equals("delete")){//Delete record
				try{
					if(request.getParameter("hid")!=null){
						String hid=(String)request.getParameter("hid");
						dao.deleteUser(Integer.parseInt(hid));
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
