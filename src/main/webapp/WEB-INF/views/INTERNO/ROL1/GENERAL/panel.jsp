     <%
        response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate"); // HTTP 1.1.
        response.setHeader("Pragma", "no-cache"); // HTTP 1.0.
        String t =String.valueOf(request.getAttribute("token"));
        String nombre = (String)request.getSession().getAttribute("user");
    %>

  <c:set var="contextPath" value="${pageContext.request.contextPath}"/>
 <header class="main-header">
        <a href="${contextPath}/ufps-feria/indexAdmin?t=<%=t%>" class="logo"><b>Feria De Proyectos</b></a>
        <!-- Header Navbar: style can be found in header.less -->
        <nav class="navbar navbar-static-top" role="navigation">
          <!-- Sidebar toggle button-->

          <a href="#" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </a>


        </nav>
      </header>
      
            <!-- Left side column. contains the logo and sidebar -->
      <aside class="main-sidebar">
        <!-- sidebar: style can be found in sidebar.less -->
        <section class="sidebar">
          <!-- Sidebar user panel -->
          <div class="user-panel">
            <div class="pull-left image">
              <img src="resources/img/administrador.jpg" class="img-circle" alt="User Image" />
            </div>
            <div class="pull-left info">
              <p><%=nombre%></p>

              <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
          </div>
          <!-- search form -->
          

          <!-- /.search form -->
          <!-- sidebar menu: : style can be found in sidebar.less -->
          <ul class="sidebar-menu">
            <li class="header">Opciones Del ROL1</li>

            <li class="treeview">
            
              <a href="${contextPath}/ufps-diagnostic/listarModuloA">
                <i class="fa fa-pencil"></i><span> MODULO A</span>
              </a>
              <a href="${contextPath}/ufps-diagnostic/listarModuloB">
                <i class="fa fa-share-square-o"></i> <span> MODULO B</span>
                
              </a>
              <a href="${contextPath}/ufps-diagnostic/listarModuloC">
                <i class="fa fa-check-square-o"></i> <span> MODULO C</span>
              </a>
                     
            </li>

          </ul>
        </section>
        <!-- /.sidebar -->
      </aside>
      