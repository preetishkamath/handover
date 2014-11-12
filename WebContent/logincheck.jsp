<%@ page import ="java.sql.*" %>
<%
    String userid = request.getParameter("uname");    
    String pwd = request.getParameter("pass");
//     Class.forName("com.mysql.jdbc.Driver");
//     Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname",
//             "root", "dbpass");


     Connection con;
    con = com.programmingfree.utility.DBUtility.getConnection();
    Statement st = con.createStatement();
    ResultSet rs;
    rs = st.executeQuery("select * from members where uname='" + userid + "' and pass='" + pwd + "' and status='active'");
    
    if (rs.next()) {
    	
    	  
        	session.setAttribute("userid", userid);
         	session.setAttribute("pic", rs.getString("profilepic"));
         	session.setAttribute("type", rs.getString("type"));
         	response.sendRedirect("Main.jsp");
    	 
         	//out.println("welcome " + userid);
        //out.println("<a href='logout.jsp'>Log out</a>");
        
    } else {
        out.println("Invalid password <a href='Login.jsp'>try again</a>");
    }
%>
