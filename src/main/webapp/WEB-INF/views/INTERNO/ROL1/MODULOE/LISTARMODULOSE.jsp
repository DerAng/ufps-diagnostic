
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
            LISTA DE MODULOS E
          
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
                  <h3 class="box-title">A continuación puede Visualizar todos los modulos E.</h3>
                </div><!-- /.box-header -->
                <div class="box-body">

 							<!-- Si hubo un registro exitoso muestra el mensaje-->
							   <c:if test="${not empty result}">
					                <div class="alert alert-success alert-dismissable">
					                      <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
					                      
					                      <c:out value='${result}' />
					                </div>
					             </c:if>
							    <c:if test="${not empty wrong}">		            
		                        	<div class="sufee-alert alert with-close alert-danger alert-dismissible fade show">				                   	
				                    		<c:out value='${wrong}' />
				                    	<button type="button" class="close" data-dismiss="alert" aria-label="Close">
											<span aria-hidden="true">&times;</span>
				                    	</button>
				                   </div>
							    </c:if>  


				<!-- Boton que indica la accion para registrar una actividad -->
				<a href="${contextPath}/registrarModuloE" class="btn btn-success">Registrar MODULO E</a> <br> <br>
				
				<!-- Tabla con las modulos A -->
              <table class="table table-hover">  
                  <tr>
                      <!-- <th>Id</th>-->
                      <th>ID</th>
                      <th>NOMBRE</th>
                      <th>GRAMAJE</th>
                      <th>DESCRIPCIÓN</th>
                      <th style="width: 14%">Accion</th>
                      
                  </tr>  
                 <c:forEach var="itemModuloE" items="${modulosE}">   
                 
                   <tr>  
                       <!-- <td>${itemModuloA.id}</td>-->  
                       
                       <td>${itemModuloE.id}</td>  
                       <td>${itemModuloE.nombre}</td>  
                       <td>${itemModuloE.gramaje}</td>
                       <td>${itemModuloE.descripcion}</td>
                                             
                      <td>
								<a href="${contextPath}/actualizarModuloE?id=${itemModuloE.id}">
		                          	<button type="button" class="btn btn-success">
		                          		<i class="fa fa-pencil"></i>&nbsp;
		                        	</button>
		                        </a>
	                         	<a href="${contextPath}/eliminarModuloE?id=${itemModuloE.id}">
	                         		<button type="button" class="btn btn-danger">
									<i class="fa fa-trash-o"></i>&nbsp;
	                         		</button>
								</a>
                        </td>
                   </tr>  
                 </c:forEach>  
                 
              </table>  





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