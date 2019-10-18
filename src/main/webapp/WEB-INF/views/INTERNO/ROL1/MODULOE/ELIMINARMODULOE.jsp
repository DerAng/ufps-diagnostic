
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
            ELIMINAR MODULO E
          
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
                  <h3 class="box-title">A continuación puede eliminar un modulo E.</h3>
                </div><!-- /.box-header -->
                <div class="box-body">


					
                <form:form id="formRMA" action="borrarModuloE" modelAttribute="moduloE" >
                    <!-- text input -->

                    
                    
                     <form:hidden id="id" path="id" class="form-control" aria-invalid="false" required = "true" value="${moduloECargado.id}"/>                            		
                            		
                      <!-- Campo para digitar el nombre -->
                      <div class="form-group">
                         <label for="text-input" class=" form-control-label">¿Estás seguro de eliminar el moduloA llamado "${moduloECargado.nombre}"?</label>                                		
                       </div> 	
                                	
                     <!-- Boton para Eliminar los datos -->
                      <button type="submit" class="btn btn-danger">Eliminar</button>

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
