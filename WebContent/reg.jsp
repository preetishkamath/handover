<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Registration</title>
         <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="css/AdminLTE.css" rel="stylesheet" type="text/css" />
<!-- Optional theme -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap-theme.min.css">

<!-- Latest compiled and minified JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </head>
    <body class="bg-black">

        <div class="form-box" id="login-box">
            <div class="header">Register New Membership</div>
            <form action="registration.jsp" method="post">
                <div class="body bg-gray">
                    <div class="form-group">
                    	
                        <input type="text" name="fname" class="form-control" placeholder="First Name "/>
                    </div>
                    <div class="form-group">
                    	
                        <input type="text" name="lname" class="form-control" placeholder="Lname"/>
                    </div>
                    <div class="form-group">
                        
                        <input type="text" name="email" class="form-control" placeholder="EmailId"/>
                    </div>
                    <div class="form-group">
                        
                        <input type="text" name="uname" class="form-control" placeholder="Username"/>
                    </div>
                    <div class="form-group">
                        
                        <input type="password" name="pass" class="form-control" placeholder="Password"/>
                    </div>
                    <div class="form-group">
                        
                        <input type="text" name="profile" class="form-control" placeholder="Pic Url"/>
                    </div>
                </div>
                <div class="footer">                    

                    <button type="submit" class="btn bg-blue btn-block">Sign me up</button>

                    <a href="Login.jsp" class="text-center">I already have a Login</a>
                </div>
            </form>
 <div class="margin text-center">
                
                <br/>
                

            </div>
            
        </div>


        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="js/bootstrap.min.js" type="text/javascript"></script>  

    </body>
</html>
