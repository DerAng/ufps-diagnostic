<div class="footer-v1 off-container">
	<div class="footer">
		<div class="container">
			<div class="row">
				<!-- About -->
				<div class="col-md-3 col-sm-4 md-margin-bottom-40">
					<div class="footer-main">
						<a href="${contextPath}/">
							<img id="logo-footer" class="img-responsive" src="resources/ufps/rsc/img/logo_ufps.png" alt="Logo Pie de Página">
						</a>
					</div>
				</div>
				<!--/col-md-3-->
				<!-- End About -->
				<!-- Latest -->
				<div class="col-md-3 col-sm-4 md-margin-bottom-40">
					<div class="posts">
						<div class="headline" style="border-bottom: #272727;">
							<h2>Visitantes</h2>
						</div>
						<ul class="list-unstyled latest-list">
							<li style="color: #fff">Hoy: ${visitasDia}</li>
							<li style="color: #fff">&Uacute;ltimo mes: ${visitasMes}</li>
							<li style="color: #fff">Desde el principio: ${visitasSiempre}</li>
						</ul>
					</div>
				</div>
				<!--/col-md-3-->
				<!-- End Latest -->
				<!-- Link List -->
				<div class="col-md-3 col-sm-4  md-margin-bottom-40">
					<div class="headline" style="border-bottom: #272727;">
						<h2>Enlaces de Inter&eacute;s</h2>
					</div>
					
					<ul class="list-unstyled latest-list">
		                <li><a href="http://gidis.ufps.edu.co/dsiwebsite/public/">Sitio Web-Departamento de Sistemas</a></li>
		                <li><a href="http://biblioteca.ufps.edu.co" target="_blank">Biblioteca Eduardo Cote Lamus</a></li>
		                <li><a href="http://200.93.148.47/bienestar/" target="_blank">Vicerrector&iacute;a de Bienestar Universitario</a></li>
		                <li><a href="./index.php?id=27">Cronograma del Comit&eacute; Curricular</a></li>
		                <li><a href="http://php.net/" target="_blank">Recursos PHP</a></li>
		                <li><a href="https://www.facebook.com/IngSistUFPS/?fref=ts">Facebook</a></li>
		                <li><a href="http://200.93.148.29/ingsistemas_viejo/">Ir a versi&oacute;n Anterior</a></li>
		                <li><a href="http://www.youtube.com" target="_blank">Canal UFPS en YouTube</a></li>
		              </ul>
					
					
				</div>
				<!--/col-md-3-->
				<!-- End Link List -->
				<!-- Address -->
				<div class="col-md-3 col-sm-4  map-img md-margin-bottom-40">
					<div class="headline" style="border-bottom: #272727;">
						<h2>Contactos</h2>
					</div>
					<address class="md-margin-bottom-40">			
						Programa de Ingenier&iacute;a de Sistemas de la Universidad Francisco de Paula Santander
						<br>
						Acreditaci&oacute;n de alta calidad seg&uacute;n resoluci&oacute;n No. 15757 del Ministerio de Educaci&oacute;n Nacional
						<br>
						Avenida Gran Colombia No. 12E-96 Barrio Colsag, C&uacute;cuta, Colombia
						<br>
						Tel&eacute;fono (57) 7 5776655 Extensiones 201 y 203
						<br>
						Correo electr&oacute;nico: ingsistemas@ufps.edu.co						
					</address>
				</div>
				<!--/col-md-3-->
			<!-- End Address -->
			</div>
		</div>
	</div>
		
	<!--/footer-->
	<div class="copyright">
		<div class="container">
			<div class="row">
				<div class="col-md-8">
					<p>
						2019 © All Rights Reserved. Desarrollado por: <a href="#">INGENIERIA DE SISTEMAS DE LA UFPS</a>
					</p>
				</div>
				<!-- Social Links -->
				<div class="col-md-4">
					<ul class="list-inline dark-social pull-right space-bottom-0">
						<c:forEach var="red" items="${redes}">																					
							<li>
								<a data-placement="top" data-toggle="tooltip" class="tooltips" data-original-title="${red.nombre}" href="${red.url}">
									<i class="fa ${red.logo}" style="color: #fff;"></i>
								</a>
							</li>								
						</c:forEach>								
					</ul>
				</div>
				<!-- End Social Links -->
			</div>
		</div>
	</div>
		<!--/copyright-->
</div>

<div class="owl-clients-v1" style="background-color: #EEE; padding: 5px;">
	<div class="item">
		<a href="http://www.mineducacion.gov.co/" target="_blank"><img
			src="resources/ufps/rsc/img/mineducacion.png" class="hover-shadow" alt="">
		</a>
	</div>
	<div class="item">
		<a href="http://www.gobiernoenlinea.gov.co/" target="_blank">
			<img src="resources/ufps/rsc/img/gobiernoenlinea.png" class="hover-shadow" alt="">
		</a>
	</div>
	<div class="item">
		<a href="http://www.contraloriagen.gov.co/" target="_blank">
			<img src="resources/ufps/rsc/img/contraloria.png" class="hover-shadow" alt="">
		</a>
	</div>
	<div class="item">
		<a href="http://www.procuraduria.gov.co/" target="_blank">
			<img src="resources/ufps/rsc/img/procuraduriageneraldelanacion.png" class="hover-shadow" alt="">
		</a>
	</div>
	<div class="item">
		<a href="http://www.urnadecristal.gov.co/" target="_blank">
			<img src="resources/ufps/rsc/img/urnadecristal.png" class="hover-shadow" alt="">
		</a>
	</div>
	<div class="item">
		<a href="http://www.icfes.gov.co/" target="_blank">
			<img src="resources/ufps/rsc/img/icfes.png" class="hover-shadow" alt=""></a>
	</div>
	<div class="item">
		<a href="http://www.icetex.gov.co/" target="_blank">
			<img src="resources/ufps/rsc/img/icetex.png" class="hover-shadow" alt="">
		</a>
	</div>
	<div class="item">
		<a href="http://www.universia.net.co/" target="_blank">
			<img src="resources/ufps/rsc/img/universia.png" class="hover-shadow" alt="">
		</a>
	</div>
	<div class="item">
		<a href="http://www.colombiaaprende.edu.co/" target="_blank">
			<img src="resources/ufps/rsc/img/colombiaaprende.png" class="hover-shadow" alt="">
		</a>
	</div>
	<div class="item">
		<a href="http://www.renata.edu.co/" target="_blank"><img
			src="resources/ufps/rsc/img/renata-logo.png" class="hover-shadow" alt=""></a>
	</div>
	<div class="item">
		<a href="http://www.colciencias.gov.co/" target="_blank"><img
			src="resources/ufps/rsc/img/COLCIENCIAS.png" class="hover-shadow" alt=""></a>
	</div>
	<div class="item">
		<a href="http://www.cna.gov.co/" target="_blank"><img
			src="resources/ufps/rsc/img/cna.png" class="hover-shadow" alt=""></a>
	</div>
	<div class="item">
		<a href="http://www.mineducacion.gov.co/sistemasdeinformacion/1735/propertyvalue-41698.html" target="_blank"><img src="resources/ufps/rsc/img/SACES.png" class="hover-shadow" alt="">
		</a>
	</div>
	<div class="item">
		<a href="http://www.mineducacion.gov.co/sistemasdeinformacion/1735/w3-propertyname-2672.html" target="_blank">
			<img src="resources/ufps/rsc/img/SNIES.png" class="hover-shadow" alt="">
		</a>
	</div>
	<div class="item">
		<a href="http://www.mineducacion.gov.co/sistemasdeinformacion/1735/w3-propertyname-2895.html" target="_blank">
			<img src="resources/ufps/rsc/img/SPADIES.png" class="hover-shadow" alt="">
		</a>
	</div>
</div>
	