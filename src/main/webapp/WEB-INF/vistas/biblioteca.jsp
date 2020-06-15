<%@ include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!--Main layout-->
<main style="margin-top: 100px !important;">
    <div class="container mt-5">
        <nav class="navbar navbar-expand-lg navbar-dark mdb-color lighten-3 mt-5 mb-5">
            <span class="navbar-brand">Categorías:</span>

            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#basicExampleNav"
                    aria-controls="basicExampleNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>

            <div class="collapse navbar-collapse" id="basicExampleNav">
                <ul class="navbar-nav mr-auto">
                    <li class="nav-item active">
                        <a class="nav-link" href="#">Todas
                            <span class="sr-only">(current)</span>
                        </a>
                    </li>
                </ul>
            </div>
        </nav>

        <section class="text-center mb-4">
            <div class="row wow fadeIn">
                <c:forEach var="compra" items="${compras}">
                    <div class="col-lg-3 col-md-6 mb-4">
                        <a href="/publicacion/${compra.publicacion.id}">
                            <div class="card">
                                <div class="view overlay" style="cursor: pointer">
                                    <img src="${compra.publicacion.libro.imagen}" class="card-img-top"
                                         style="height:200px"
                                         alt="">
                                </div>
                                <div class="card-body text-center">
                                    <h5>
                                        <strong>
                                            <span class="dark-grey-text"><c:out
                                                    value="${compra.publicacion.libro.nombre}"/></span>
                                        </strong>
                                    </h5>
                                    <div class="contenedor-etiquetas">
                                        <c:forEach var="etiqueta" items="${compra.publicacion.etiquetas}">
                                            <span class="badge badge-pill primary-color">${etiqueta.descripcion}</span>
                                        </c:forEach>
                                    </div>
                                    <a type="button" class="btn btn-light"
                                       href="<c:out value="${compra.publicacion.libro.ruta}"/>" target="_blank"
                                       style="padding: 5px 20px; margin-top: 20px">
                                        <i class="fas fa-book mr-3"></i>
                                        <span>Leer</span>
                                    </a>
                                    <div class="container p-3">
                                        <c:if test="${not empty comprasConPuntaje}">
                                            <c:forEach var="puntaje" items="${comprasConPuntaje}">
                                                <c:if test="${puntaje.publicacion.id == compra.publicacion.id}">
                                                    <c:choose>
                                                        <c:when test="${not empty puntaje.comentario}">
                                                            <span class="badge badge-pill badge-dark p-3">Comentario: ${puntaje.comentario}</span>
                                                        </c:when>
                                                        <c:otherwise>
                                                            <span class="badge badge-pill badge-dark p-3">Puntuacion: ${puntaje.valor}</span>
                                                        </c:otherwise>
                                                    </c:choose>
                                                </c:if>
                                            </c:forEach>
                                        </c:if>
                                    </div>
                                </div>
                            </div>
                        </a>
                    </div>
                </c:forEach>
            </div>
        </section>

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

<%@ include file="footer.jsp" %>