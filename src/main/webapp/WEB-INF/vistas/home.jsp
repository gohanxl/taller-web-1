<%@ include file = "header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--Main layout-->
<main style="margin-top: 100px !important;">
	<div class="container mt-5">

		<!--Navbar-->
		<nav class="navbar navbar-expand-lg navbar-dark mdb-color lighten-3 mt-5 mb-5">

			<!-- Navbar brand -->
			<span class="navbar-brand">Categorías:</span>

			<!-- Collapse button -->
			<button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#basicExampleNav"
					aria-controls="basicExampleNav" aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			</button>

			<!-- Collapsible content -->
			<div class="collapse navbar-collapse" id="basicExampleNav">

				<!-- Links -->
				<ul class="navbar-nav mr-auto">
					<li class="nav-item active">
						<a class="nav-link" href="#">Todas
							<span class="sr-only">(current)</span>
						</a>
					</li>
				</ul>
				<!-- Links -->
			</div>
			<!-- Collapsible content -->

		</nav>
		<!--/.Navbar-->

		<!--Section: Products v.3-->
		<section class="text-center mb-4">

			<!--Grid row-->
			<div class="row wow fadeIn">
				<c:forEach var="publicacion" items="${publicaciones}">
				<!--Grid column-->
				<div class="col-lg-3 col-md-6 mb-4">
					<!--Card-->
					<a href="/publicacion/${publicacion.id}">
						<div class="card">
						<!--Card image-->
						<div class="view overlay" style="cursor: pointer">
							<img src="${publicacion.libro.imagen}" class="card-img-top" style="height:200px"
								 alt="">
						</div>
						<!--Card image-->

						<!--Card content-->
						<div class="card-body text-center">
							<!--Category & Title-->
							<span class="grey-text">
								<h5><c:out value="${publicacion.propietario.nombre}"/></h5>
							</span>
							<h5>
								<strong>
									<span class="dark-grey-text"><c:out value="${publicacion.libro.nombre}"/></span>
								</strong>
							</h5>
							<c:forEach var="etiqueta" items="${publicacion.etiquetas}">
								<span class="badge badge-pill primary-color">${etiqueta.descripcion}</span>
							</c:forEach>
							<h4 class="font-weight-bold blue-text mt-2">
								<strong>$ <c:out value="${publicacion.precio}"/></strong>
							</h4>
							<c:forEach var="etiqueta" items="${publicacion.etiquetas}">
								<h6 class="font-weight-bold blue-text">
									<strong>${etiqueta.descripcion}</strong>
								</h6>
							</c:forEach>
							<!--
							<div class="card-footer" style="background-color: transparent !important;">
								<a data-toggle="tooltip" data-placement="top" title="Agregar al carrito" class="btn-lg" href="/checkout?publicacionId=${publicacion.id}"><i class="fas fa-shopping-cart mr-3 teal-text"></i></a>
								<a data-toggle="tooltip" data-placement="top" title="Leer" class="btn-lg" href="<c:out value="${publicacion.libro.ruta}"/>" target="_blank"><i class="fas fa-book mr-3 text-info"></i></a>
							</div>
							-->
						</div>
						<!--Card content-->

					</div>
					</a>
					<!--Card-->
				</div>
				<!--Grid column-->
				</c:forEach>
			</div>
			<!--Grid row-->

		</section>
		<!--Section: Products v.3-->
<h3>Recomendados:</h3>
		<!-- recomendaciones -->

		<section class="text-center mb-4">

			<!--Grid row-->
			<div class="row wow fadeIn">
				<c:forEach var="recomendacion" items="${recomendaciones}">
					<!--Grid column-->
					<div class="col-lg-3 col-md-6 mb-4">
						<!--Card-->
						<a href="/publicacion/${recomendacion.id}">
							<div class="card">
								<!--Card image-->
								<div class="view overlay" style="cursor: pointer">
									<img src="${recomendacion.libro.imagen}" class="card-img-top" style="height:200px"
										 alt="">
								</div>
								<!--Card image-->

								<!--Card content-->
								<div class="card-body text-center">
									<!--Category & Title-->
									<span class="grey-text">
								<h5><c:out value="${recomendacion.propietario.nombre}"/></h5>
							</span>
									<h5>
										<strong>
									<span class="dark-grey-text"><c:out value="${recomendacion.libro.nombre}"/>
										<span class="badge badge-pill danger-color">NEW</span>
									</span>
										</strong>
									</h5>

									<h4 class="font-weight-bold blue-text">
										<strong>$ <c:out value="${recomendacion.precio}"/></strong>
									</h4>
									<c:forEach var="etiqueta" items="${recomendacion.etiquetas}">
										<h6 class="font-weight-bold blue-text">
											<strong>${etiqueta.descripcion}</strong>
										</h6>
									</c:forEach>
									<!--
							<div class="card-footer" style="background-color: transparent !important;">
								<a data-toggle="tooltip" data-placement="top" title="Agregar al carrito" class="btn-lg" href="/checkout?publicacionId=${publicacion.id}"><i class="fas fa-shopping-cart mr-3 teal-text"></i></a>
								<a data-toggle="tooltip" data-placement="top" title="Leer" class="btn-lg" href="<c:out value="${publicacion.libro.ruta}"/>" target="_blank"><i class="fas fa-book mr-3 text-info"></i></a>
							</div>
							-->
								</div>
								<!--Card content-->

							</div>
						</a>
						<!--Card-->
					</div>
					<!--Grid column-->
				</c:forEach>
			</div>
			<!--Grid row-->

		</section>

		<!-- recomendaciones -->

		<!--Pagination-->
		<nav class="d-flex justify-content-center wow fadeIn">
			<ul class="pagination pg-blue">

				<!--Arrow left-->
				<li class="page-item disabled">
					<a class="page-link" href="#" aria-label="Previous">
						<span aria-hidden="true">&laquo;</span>
						<span class="sr-only">Previous</span>
					</a>
				</li>

				<li class="page-item active">
					<a class="page-link" href="#">1
						<span class="sr-only">(current)</span>
					</a>
				</li>
				<li class="page-item">
					<a class="page-link" href="#">2</a>
				</li>
				<li class="page-item">
					<a class="page-link" href="#">3</a>
				</li>
				<li class="page-item">
					<a class="page-link" href="#">4</a>
				</li>
				<li class="page-item">
					<a class="page-link" href="#">5</a>
				</li>

				<li class="page-item">
					<a class="page-link" href="#" aria-label="Next">
						<span aria-hidden="true">&raquo;</span>
						<span class="sr-only">Next</span>
					</a>
				</li>
			</ul>
		</nav>
		<!--Pagination-->
	</div>
</main>
<!--Main layout-->

<%@ include file = "footer.jsp" %>