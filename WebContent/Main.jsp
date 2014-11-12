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
    if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
    	response.sendRedirect("Login.jsp");
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
                        <small>Global Information</small>
                    </h1>
                    <ol class="breadcrumb">
                        <li><a href="Main.jsp"><i class="fa fa-dashboard"></i> Home</a></li>
                        
                    </ol>
                </section>

                <!-- Main content -->
                <section class="content">
                   <div class="container" >
						  <div class="row-fluid">
							<div id="HandOverTableContainer"></div>
						</div>
				  </div>
				 <div class="container" >
						
						<div class="row-fluid">
						<div id="HandOverTableContainerCompleted"></div>
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
        $('#HandOverTableContainer').jtable({
        	
        	paging: true, //Enable paging
            pageSize: 1, //Set page size (default: 10)
            sorting: true,
            defaultSorting: 'hid ASC',
            title: 'Global & Internal',
            actions: {
                listAction: 'CRUDController?action=list',
                createAction:'CRUDController?action=create',
                updateAction: 'CRUDController?action=update',
                deleteAction: 'CRUDController?action=delete'
            },
            fields: {
                hid: {
                	title:'hid',
                    key: true,
                    hidden:true,
                    create:false,
                    edit:false,
                    visibility:'hidden'
                },
                datere: {
                    title: 'Date Recived',
                    width: '5%',
                    edit:true,
                  	type:'date'
                },
                mailfrom: {
                    title: 'Mail From',
                    width: '5%',
                    edit:true
                },
                subject: {
                    title: 'Subject',
                    width: '20%',
                    edit: true
                },
                summary: {
                    title: 'Summary',
                    width: '50%',
                    edit: true,
                    type:'textarea'
                },
                response: {
                    title: 'Action',
                    width: '20%',
                    edit: true
                },
                oots: {
                    title: 'OOTS',
                    width: '5%',
                    edit: true,
                    
                    input:function () {
                        
                            return '<input type="text"   name="oots" value="<%=session.getAttribute("userid")%>" readonly/>';
                            }

                },
                 status: {
                    title: 'Status',
                  width: '5%',
                    edit: true,
                    options: { 'active': 'active', 'completed': 'completed'},
                    list: true
                }
            }
        });
        $('#HandOverTableContainer').jtable('load');
    });
</script>
<script type="text/javascript">
    $(document).ready(function () {
        $('#HandOverTableContainerCompleted').jtable({
        	
        	paging: true, //Enable paging
            pageSize: 1, //Set page size (default: 10)
            sorting: true,
            defaultSorting: 'hid ASC',
            
            title: 'Global & Internal Completed',
            
            actions: {
                listAction: 'CRUDControllercompleted?action=list',
                createAction:'CRUDController?action=create',
                updateAction: 'CRUDControllercompleted?action=update',
                deleteAction: 'CRUDControllercompleted?action=delete'
            },
            fields: {
                hid: {
                	title:'hid',
                    key: true,
                    
                    create:false,
                    edit:false,
                    visibility:'hidden'
                },
                datere: {
                    title: 'Date Recived',
                    width: '5%',
                    edit:true,
                  	type:'date'
                },
                mailfrom: {
                    title: 'Mail From',
                    width: '5%',
                    edit:true
                },
                subject: {
                    title: 'Subject',
                    width: '20%',
                    edit: true
                },
                summary: {
                    title: 'Summary',
                    width: '50%',
                    edit: true,
                    type:'textarea'
                },
                response: {
                    title: 'Action',
                    width: '20%',
                    edit: true
                },
                oots: {
                    title: 'OOTS',
                    width: '5%',
                    edit: true,
                    
                    input:function () {
                        
                            return '<input type="text"   name="oots" value="<%=session.getAttribute("userid")%>" readonly/>';
                            }

                },
                 status: {
                    title: 'Status',
                  width: '5%',
                    edit: true,
                    options: { 'active': 'active', 'completed': 'completed'},
                    list: true
                }
            }
        });
        $('#HandOverTableContainerCompleted').jtable('load');
    });
</script>
    </body>
</html>
