<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Handover</title>
<link href="css/bootstrap.min.css" rel="stylesheet" type="text/css" />

<!-- Include one of jTable styles. -->
<link href="css/metro/blue/jtable.css" rel="stylesheet" type="text/css" />
<link href="css/jquery-ui-1.10.3.custom.css" rel="stylesheet" type="text/css" />
<!-- Include jTable script file. -->
<script src="js/jquery-1.8.2.js" type="text/javascript"></script>
<script src="js/jquery-ui-1.10.3.custom.js" type="text/javascript"></script>
<script src="js/bootstrap.min.js" type="text/javascript"></script>
<script src="js/jquery.jtable.js" type="text/javascript"></script>
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
            type:'GET',
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
</head>
<body>
<%
    if ((session.getAttribute("userid") == null) || (session.getAttribute("userid") == "")) {
    	response.sendRedirect("Login.jsp");
    }
%>

<ul class="nav nav-pills nav-tabs" role="tablist">
  <li ><a href="#">Home</a></li>
  <li><a href="ChangeTracker.jsp">Change Tracker</a></li>
  <li><a href="#">MOM</a></li>
  <li class="dropdown pull-right" style="">
    <a class="dropdown-toggle" data-toggle="dropdown" href="#">
      Welcome <%=session.getAttribute("userid")%> <span class="caret"></span>
    </a>
    <ul class="dropdown-menu " role="menu" >
      <li><a href="logout.jsp" >LogOut</a></li>
    </ul>
  </li>
  
</ul>
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
</body>
</html>