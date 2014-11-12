<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>Eplus HandOver</title>
        <meta content='width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no' name='viewport'>
        <!-- bootstrap 3.0.2 -->
        <link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />
        <!-- font Awesome -->
        <link href="css/font-awesome.min.css" rel="stylesheet" type="text/css" />
        <!-- Ionicons -->
        <link href="css/ionicons.min.css" rel="stylesheet" type="text/css" />
        <!-- Theme style -->
        <link href="css/AdminLTE.css" rel="stylesheet" type="text/css" />
        
        


        

<!-- Include one of jTable styles. -->
<link href="css/lightcolor/blue/jtable.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
<!-- Include jTable script file. -->
<script src="js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/jquery.jtable.js" type="text/javascript"></script>
       
    </head>
    <body class="skin-blue">
    
    <%
    if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "") ) {
    	response.sendRedirect("Login.jsp");
    }
    if((session.getAttribute("type").equals("analyst")))
    {
    	response.sendRedirect("Main.jsp");
    }
  
%>
      <!-- header logo: style can be found in header.less -->
        <%@ include file="header.jsp" %>
        <div class="wrapper row-offcanvas row-offcanvas-left">
            <!-- Left side column. contains the logo and sidebar -->
          
              <%@ include file="LeftMenu.jsp" %>
            <!-- Right side column. Contains the navbar and content of the page -->
            <aside class="right-side">
                <!-- Content Header (Page header) -->
                <section class="content-header">
                    <h1>
                        Eplus HandOver
                        <small>Member Information</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="Main.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
                        <li class="active">Member</li>
                    </ol>
                </section>

                <!-- Main content -->
                <section class="content">
                   <div class="container" >
						  <div class="row-fluid">
							<div id="MemberTableContainer"></div>
						</div>
				  </div>
				 

                </section><!-- /.content -->
            </aside><!-- /.right-side -->
        </div><!-- ./wrapper -->


        <!-- jQuery 2.0.2 -->
<!--         <script src="http://ajax.googleapis.com/ajax/libs/jquery/2.0.2/jquery.min.js"></script> -->
        <!-- Bootstrap -->
        
        <!-- AdminLTE App -->
        <script src="js/AdminLTE/app.js" type="text/javascript"></script>
        <!-- AdminLTE for demo purposes -->
        <script src="js/AdminLTE/demo.js" type="text/javascript"></script>
       
        
        
        
<script type="text/javascript">
    $(document).ready(function () {
        $('#MemberTableContainer').jtable({
        	
        	paging: true, //Enable paging
            pageSize: 1, //Set page size (default: 10)
            sorting: true,
            defaultSorting: 'hid ASC',
            title: 'Global & Internal',
            actions: {
                listAction: 'MemberController?action=list',
                createAction:'MemberController?action=create',
                updateAction: 'MemberController?action=update',
                deleteAction: 'MemberController?action=delete'
            },
            fields: {
                id: {
                	title:'id',
                    key: true,
                    hidden:true,
                    create:false,
                    edit:false,
                    visibility:'hidden'
                },
                first_name: {
                    title: 'First Name',
                    width: '12%',
                    edit:'true'
                },
                last_name: {
                    title:'Last Name',
                    width: '12%',
                    edit:true
                },
                email: {
                    title: 'Email',
                    width: '12%',
                    edit: true
                },
                uname: {
                    title: 'Username',
                    width: '12%',
                    edit: true,
                    type:'textarea'
                },
                pass: {
                    title: 'Pass',
                    width: '12%',
                    edit: true
                },
                 status: {
                    title: 'Status',
                  width: '12%',
                    edit: true,
                    options: { 'active': 'active', 'notactive': 'notactive'},
                    list: true
                },
                type: {
                    title: 'TYPE',
                    width: '20%',
                    options: { 'analyst': 'analyst', 'admin': 'admin'},
                    list: true
                },
                admin: {
                    title: 'Admin',
                    width: '12%',
                    edit: true,
                    
                    input:function () {
                        
                            return '<input type="text"   name="admin" value="<%=session.getAttribute("userid")%>" readonly/>';
                            }

                }
            }
        });
        $('#MemberTableContainer').jtable('load');
    });
</script>

    </body>
</html>
