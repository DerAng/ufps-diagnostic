<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<div id="menu-principal" class="header-v6 header-white-transparent header-sticky" style="position: relative;">
			
	<%@ include file="../General/TopPanel.jsp"%>
	
	<div class="header-v8 img-logo-superior" style="background-color: #aa1916;">
		<!--=== Parallax Quote ===-->
		<div class="parallax-quote parallaxBg" style="padding: 30px 30px;">
			<div class="parallax-quote-in" style="padding: 0px;">
				<div class="row">
					<div class="col-md-4 col-sm-4 col-xs-5">
						<a href="${contextPath}/"> 
							<img id="logo-header" src="resources/ufps/rsc/img/logo_ufps.png" alt="" style="max-height: 180px;">
						</a>
					</div>
					<div class="col-md-5 col-sm-4 col-xs-5">
						
					</div>
					<div class="col-md-3 col-ms-8 col-xs-8">
						<a href="http://www.ufps.edu.co/">
							<img class="header-banner" src="resources/ufps/rsc/img/logo_ufps2.png" style="max-height: 160px;" alt="Escudo de la Universidad Francisco de Paula Santander">
						</a>
					</div>
				</div>
			</div>
		</div>
		<!--=== End Parallax Quote ===-->
	</div>
			
	<!-- Collect the nav links, forms, and other content for toggling -->
	<div class="collapse navbar-collapse mega-menu navbar-responsive-collapse">
		<div class="containermenu">
			<ul class="nav navbar-nav" style="float: left;">
				<!-- PRIMERA PESTAÑA -->
				<li class="nodropdown">
					<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown">
							BLOQUE 1							
					</a>
				</li>
				
				<!-- SEGUNDA PESTAÑA -->
				<li class="dropdown">
					<a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown">
							BLOQUE 2
							<ul class="dropdown-menu">
								<!-- PRIMERA SUBPESTAÑA -->
								<li>
									<a href="https://www.facebook.com">
										FACEBOOK
									</a>
								</li>
								
								<!-- SEGUNDA SUBPESTAÑA -->
								<li>																	
									<a href="${contextPath}/">
										LOCALMENTE
									</a>
								</li>
							</ul>
					</a>
				</li>
				
				<!-- TERCERA PESTAÑA -->
				<li class="nodropdown">
					<a id="gogo" class="dropdown-toggle" data-toggle="dropdown">
							LOGIN				
					</a>
				</li>
				         
			</ul>
		</div>
	</div>
	
	
	<!--/navbar-collapse-->
</div>
<script type="text/javascript">
				    document.getElementById("gogo").onclick = function () {
				        location.href = "http://localhost:8080/ufps-diagnostic/login";
				    };
				</script>
		