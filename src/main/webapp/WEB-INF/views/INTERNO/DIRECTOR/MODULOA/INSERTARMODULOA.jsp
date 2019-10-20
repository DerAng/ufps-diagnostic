
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
            REGISTRAR MODULO A
          
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
                  <h3 class="box-title">A continuación puede registar un modulo A.</h3>
                </div><!-- /.box-header -->
                <div class="box-body">


					
                <form:form id="formRMA" action="guardarModuloA" modelAttribute="moduloA" >
                    <!-- text input -->

                    
                    
                    <div class="form-group">
                      <label class="form-control-label">Nombre</label>
                      <form:input id="nombre" path="nombre" class="form-control" placeholder="juan Andres" required = "true"/>
                    </div>


                    <div class="form-group">
                      <label class="form-control-label">Apellidos</label>
                      <form:input id="apellido" path="apellido" class="form-control" placeholder="Pineda Jaimes" required = "true"/>
                    </div>

                   <div class="form-group">
                      <label class="form-control-label">Email</label>
                      <form:input id="email" path="email" class="form-control" placeholder="juan.pineda@gmail.com" required = "true"/>
                    </div>
                    
                      <div class="form-group">
						<label class="form-control-label">Genero</label>
	                      <form:select path="genero" id="genero" class="form-control">
	                        <form:option value="" label="Seleccione el genero" />
	                        <form:options items="${generos}"/>
	                      </form:select>

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
