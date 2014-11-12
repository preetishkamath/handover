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
import com.programmingfree.dao.MemberDao;
import com.programmingfree.model.Member;
import com.programmingfree.model.User;

/**
 * Servlet implementation class MemberController
 */
@WebServlet("/MemberController")
public class MemberController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private MemberDao dao;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberController() {
    	dao=new MemberDao();
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
			List<Member> lstmem=new ArrayList<Member>();
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
					       lstmem=dao.getAllMembers(startPageIndex,numRecordsPerPage);
					       //Get Total Record Count for Pagination
					       int userCount=dao.getUserCount();			
				//Convert Java Object to Json				
				JsonElement element = gson.toJsonTree(lstmem, new TypeToken<List<Member>>() {}.getType());
				JsonArray jsonArray = element.getAsJsonArray();
				String listData=jsonArray.toString();	
				System.out.println(listData);
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
				Member mem=new Member();
				if(request.getParameter("id")!=null){				   
				   int id=Integer.parseInt(request.getParameter("id"));
				   mem.setId(id);
				}
				if(request.getParameter("first_name")!=null){
					String first_name=(String)request.getParameter("first_name");
					mem.setFirst_name(first_name);
				}
				if(request.getParameter("last_name")!=null){
				   String last_name=(String)request.getParameter("last_name");
				   mem.setLast_name(last_name);
				}
				if(request.getParameter("email")!=null){
				   String email=(String)request.getParameter("email");
				   mem.setEmail(email);
				}
				if(request.getParameter("uname")!=null){
					   String uname=(String)request.getParameter("uname");
					   mem.setUname(uname);
					}
				if(request.getParameter("pass")!=null){
					   String pass=(String)request.getParameter("pass");
					   mem.setPass(pass);
					}
				if(request.getParameter("status")!=null){
					   String status=(String)request.getParameter("status");
					   mem.setStatus(status);
					}
				if(request.getParameter("type")!=null){
					   String type=(String)request.getParameter("type");
					   mem.setType(type);
					}
				if(request.getParameter("admin")!=null){
					   String admin=(String)request.getParameter("admin");
					   mem.setAdmin(admin);
					}
				try{											
					 if(action.equals("update")){//Update existing record
						dao.updateMember(mem);
						String listData="{\"Result\":\"OK\"}";									
						response.getWriter().print(listData);
					}
				}catch(Exception ex){
						String error="{\"Result\":\"ERROR\",\"Message\":"+ex.getStackTrace().toString()+"}";
						response.getWriter().print(error);
				}
			}else if(action.equals("delete")){//Delete record
				try{
					if(request.getParameter("id")!=null){
						String id=(String)request.getParameter("id");
						dao.deleteMember(Integer.parseInt(id));
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
