
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


					
                <form:form id="formRMA" action="guardarModuloE" modelAttribute="moduloE" >
                    <!-- text input -->

                    
                    
                    <div class="form-group">
                      <label class="form-control-label">NOMBRE</label>
                      <form:input id="nombre" path="nombre" class="form-control" placeholder="Papa" required = "true"/>
                    </div>


                    <div class="form-group">
                      <label class="form-control-label">GRAMAJE</label>
                      <form:input id="gramaje" path="gramaje" class="form-control" placeholder="128" required = "true"/>
                    </div>

                   <div class="form-group">
                      <label class="form-control-label">DESCRIPCIÓN</label>
                      <form:input id="descripcion" path="descripcion" class="form-control" placeholder="Producto de Excelente calidad" required = "true"/>
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
