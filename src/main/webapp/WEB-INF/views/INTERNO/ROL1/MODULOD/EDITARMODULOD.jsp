
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
            EDITAR MODULO D
          
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
                  <h3 class="box-title">A continuación puede modificar un modulo D.</h3>
                </div><!-- /.box-header -->
                <div class="box-body">


					
                <form:form id="formMMD" action="modificarModuloD" modelAttribute="moduloD" >
                    <!-- text input -->

                    <form:hidden id="id" path="id" class="form-control" aria-invalid="false" required = "true" value="${moduloDCargado.id}"/>
                    
                    <div class="form-group">
                      <label class="form-control-label">Actividad</label>
                      <form:input id="actividad" path="actividad" class="form-control" placeholder="Estudiar,etc..." required = "true" value="${moduloDCargado.actividad}"/>
                    </div>


                    <div class="form-group">
                      <label class="form-control-label">Localidad</label>
                      <form:input id="localidad" path="localidad" class="form-control" placeholder="Cucuta,etc..." required = "true" value="${moduloDCargado.localidad}"/>
                    </div>

                   <div class="form-group">
                      <label class="form-control-label">Sabor</label>
                      <form:input id="sabor" path="sabor" class="form-control" placeholder="Fresa,etc..." required = "true" value="${moduloDCargado.sabor}"/>
                    </div>


                    <div class="box-footer">
                    <button id="submit" type="submit" class="btn btn-primary">Modificar</button>
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
