<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
   <head>
        <meta charset="UTF-8">
        <title>Eplus Handover | Log in</title>
        
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="css/AdminLTE.css" rel="stylesheet" type="text/css" />

        
    </head>
 <body class="">

        <div class="form-box" id="login-box">
            <div class="header">Sign In</div>
            <form method="post" action="logincheck.jsp">
                <div class="body bg-gray">
                    <div class="form-group">
                        <input type="text" name="uname"  class="form-control" placeholder="User ID"/>
                    </div>
                    <div class="form-group">
                        <input type="password" name="pass" class="form-control" placeholder="Password"/>
                    </div>          
                    <div class="form-group">
                        <input type="checkbox" name="remember_me"/> Remember me
                    </div>
                </div>
                <div class="footer">                                                               
                    <button type="submit" class="btn bg-blue btn-block">Sign me in</button>  
                    </form>
                   
                    
                    
                </div>
           
            <a href="reg.jsp"> <button type="" class="btn bg-blue btn-block">Register Here</button> </a>
             <div class="margin text-center">
               
				
                
            </div>

           
        </div>


        <!-- jQuery 2.0.2 -->
        <!-- jQuery 2.0.2 -->
        <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script>
        <!-- Bootstrap -->
        <script src="js/bootstrap.min.js" type="text/javascript"></script>          

    </body>
</html>
