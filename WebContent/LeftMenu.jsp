  <aside class="left-side sidebar-offcanvas">
                <!-- sidebar: style can be found in sidebar.less -->
                <section class="sidebar">
                    <!-- Sidebar user panel -->
                    <div class="user-panel">
                        <div class="pull-left image">
                            <img src="<%=session.getAttribute("pic")%>" class="img-polaroid" alt="User Image" />
                            <a href="#"><i class="fa fa-circle text-success"></i>  - Analyst</a>
                        </div>
                        <div class="pull-left info">
                            <p><%=session.getAttribute("userid")%></p>

                            
                        </div>
                    </div>

                    <!-- sidebar menu: : style can be found in sidebar.less -->
                    <ul class="sidebar-menu">
                        <li class="active">
                            <a href="Main.jsp">
                                <i class="fa fa-dashboard"></i> <span>Dashboard</span>
                            </a>
                        </li>
                        <li>
                            <a href="ChangeTracker.jsp">
                                <i class="fa fa-th"></i> <span>Changes</span> <small class="badge pull-right bg-green"></small>
                            </a>
                        </li>
                       
                       
                        <li>
                            <a href="#">
                                <i class="fa fa-calendar"></i> <span>Settings</span>
                                <small class="badge pull-right bg-red"></small>
                            </a>
                        </li>
                        <%
                        	String type="none";
                        if(session.getAttribute("type").equals("admin"))
                        {
                        	type="";
                        }
                        
                        %>
                        <li style="display:<%=type %>;">
                            <a href="member.jsp">
                                <i class="fa fa-envelope"></i> <span>Members</span>
                                <small class="badge pull-right bg-yellow"></small>
                            </a>
                        </li>
                     
                       
                    </ul>
                </section>
                <!-- /.sidebar -->
            </aside>