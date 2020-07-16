<%@ include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!--Main layout-->
<main style="margin-top: 100px !important;">
    <div class="container mt-5">
        <section class="text-center mb-4">
            <div class="row wow fadeIn m-0">
                <c:choose>
                    <c:when test="${empty compras}">
                        <div class="col-12 justify-content-center" style="padding-top: 20%; opacity: .3;">
                            <img class="mb-5" src="https://img.icons8.com/cotton/64/000000/book.png"/>
                            <h5>Cuando compres libros, podrás verlos aquí</h5>
                        </div>
                    </c:when>
                </c:choose>
                <c:forEach var="compra" items="${compras}">
                    <div class="col-lg-3 col-md-6 mb-4">
                        <a href="/publicacion/${compra.publicacion.id}">
                            <div class="card">
                                <div class="view overlay" style="cursor: pointer">
                                    <img src="${compra.publicacion.libro.imagen}" class="card-img-top portada-libro" alt="">
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
                                    <form action="/leer" method="post">
                                        <input type="hidden" name="url" value="${compra.publicacion.libro.ruta}"/>
                                        <button type="sumbit" class="btn btn-light"
                                           style="padding: 5px 20px; margin-top: 20px">
                                            <i class="fas fa-book mr-3"></i>
                                            <span>Leer</span>
                                        </button>
                                    </form>

                                    <div class="container mt-3">
                                        <c:if test="${not empty comprasConPuntaje}">
                                            <c:forEach var="puntaje" items="${comprasConPuntaje}">
                                                <c:if test="${puntaje.publicacion.id == compra.publicacion.id}">
                                                    <span class="badge badge-pill" style="background-color: #652194!important">
                                                        Calificado
                                                    </span>
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
    </div>
</main>
<!--Main layout-->

<%@ include file="footer.jsp" %>