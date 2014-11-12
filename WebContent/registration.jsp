<%@ page import ="java.sql.*" %>
<%
    String user = request.getParameter("uname");    
    String pwd = request.getParameter("pass");
    String fname = request.getParameter("fname");
    String lname = request.getParameter("lname");
    String email = request.getParameter("email");
    String profile = request.getParameter("profile");
    Connection con;
    con = com.programmingfree.utility.DBUtility.getConnection();
    Statement st = con.createStatement();
    //ResultSet rs;
    int i = st.executeUpdate("insert into members(first_name, last_name, email, uname, pass, regdate,profilepic) values ('" + fname + "','" + lname + "','" + email + "','" + user + "','" + pwd + "', CURDATE(),'" + profile + "') ");
    if (i > 0) {
        //session.setAttribute("userid", user);
        response.sendRedirect("welcome.jsp");
       out.print("Registration Successfull!"+"<a href='Login.jsp'>Go to Login</a>");
    } else {
        response.sendRedirect("reg.jsp");
    }
%>