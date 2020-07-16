<%@ include file = "header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!--Main layout-->
<main style="margin-top: 100px !important;">
	<div class="container mt-5">
		<section class="text-center mb-4">
			<div class="row wow fadeIn">
				<c:choose>
					<c:when test="${empty publicaciones}">
						<div class="col-12 justify-content-center" style="padding-top: 20%;">
							<img class="mb-5 opacity-30" src="https://img.icons8.com/metro/64/000000/upload.png"/>
							<h5 class="mb-5 opacity-30">Aquí podrás ver tus libros publicados</h5>
							<a href="/publicar" class="btn btn-primary opacity-80">Publicar</a>
						</div>
					</c:when>
				</c:choose>
				<c:forEach var="publicacion" items="${publicaciones}">
				<div class="col-lg-3 col-md-6 mb-4">
					<a href="/publicacion/${publicacion.id}">
						<div class="card">
						<div class="view overlay" style="cursor: pointer">
							<img src="${publicacion.libro.imagen}" class="card-img-top portada-libro"
								 alt="">
						</div>
						<div class="card-body text-center">
							<h5>
								<strong>
									<span class="dark-grey-text"><c:out value="${publicacion.libro.nombre}"/></span>
								</strong>
							</h5>
							<div class="contenedor-etiquetas">
								<c:forEach var="etiqueta" items="${publicacion.etiquetas}">
									<span class="badge badge-pill primary-color">${etiqueta.descripcion}</span>
								</c:forEach>
							</div>
							<a type="button" class="btn btn-light" href="<c:out value="${publicacion.libro.ruta}"/>" target="_blank" style="padding: 5px 20px; margin-top: 20px">
								<i class="fas fa-book mr-3"></i>
								<span>Leer</span>
							</a>
						</div>
					</div>
					</a>
				</div>
				</c:forEach>
			</div>
		</section>
	</div>
</main>

<style>
	.opacity-30{
		opacity: .3;
	}
	.opacity-80{
		opacity: .8;
	}
</style>
<!--Main layout-->

<%@ include file = "footer.jsp" %>