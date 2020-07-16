<%@ include file = "header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--Main layout-->
<main style="margin-top: 100px !important;">
	<div class="container mt-5">
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
							<img src="${publicacion.libro.imagen}" class="card-img-top portada-libro"
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
		<c:choose>
			<c:when test="${not empty recomendaciones}">
				<h3 class="mb-4">Recomendados</h3>
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
											<img src="${recomendacion.libro.imagen}" class="card-img-top portada-libro"
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
											</span>
												</strong>
											</h5>
											<c:forEach var="etiqueta" items="${recomendacion.etiquetas}">
												<span class="badge badge-pill primary-color">${etiqueta.descripcion}</span>
											</c:forEach>
											<h4 class="font-weight-bold blue-text mt-2">
												<strong>$ <c:out value="${recomendacion.precio}"/></strong>
											</h4>
										</div>
										<!--Card content-->

									</div>
								</a>
								<!--Card-->
							</div>
							<!--Grid column-->
						</c:forEach>
					</div>
				</section>
			</c:when>
		</c:choose>
	</div>
</main>
<!--Main layout-->

<%@ include file = "footer.jsp" %>