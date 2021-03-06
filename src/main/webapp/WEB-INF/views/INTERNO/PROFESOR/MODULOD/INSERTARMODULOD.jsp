
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%> 
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<!DOCTYPE html>
<html>
  <head>
 		 <%@ include file = "../../GENERAL/css.jsp" %>
  </head>
  <body class="skin-blue">
 
  
    <div class="wrapper">
      
      <%@ include file = "../GENERAL/panel.jsp" %>

      <!-- Right side column. Contains the navbar and content of the page -->
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            REGISTRAR MODULO D
          
          </h1>
          

        </section>

        <!-- Main content -->
        <section class="content">
          <div class="row">
            <!-- left column -->
            <div class="col-md-12">

            </div><!--/.col (left) -->
                      
            <div class="col-md-12">
              <!-- general form elements disabled -->
              <div class="box box-warning">
                <div class="box-header">
                  <h3 class="box-title">A continuación puede registar un modulo D.</h3>
                </div><!-- /.box-header -->
                <div class="box-body">


					
                <form:form id="formRMD" action="guardarModuloD" modelAttribute="moduloD" >
                    <!-- text input -->

                    
                    
                    <div class="form-group">
                      <label class="form-control-label">Actividad</label>
                      <form:input id="actividad" path="actividad" class="form-control" placeholder="Estudiar,etc..." required = "true"/>
                    </div>


                    <div class="form-group">
                      <label class="form-control-label">Localidad</label>
                      <form:input id="localidad" path="localidad" class="form-control" placeholder="Cucuta,etc.." required = "true"/>
                    </div>

                   <div class="form-group">
                      <label class="form-control-label">Sabor</label>
                      <form:input id="sabor" path="sabor" class="form-control" placeholder="Fresa,etc..." required = "true"/>
                    </div>
                    


                    <div class="box-footer">
                    <button id="submit" type="submit" class="btn btn-primary">Registrar</button>
                  </div>

                 </form:form>
                




                </div><!-- /.box-body -->
              </div><!-- /.box -->
            </div><!--/.col (right) -->
          </div>   <!-- /.row -->
        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->
      
    </div><!-- ./wrapper -->

	<!-- Carga de los archivos Javascript -->
	<%@ include file = "../../GENERAL/scripts.jsp" %>
  
  </body>
</html>
