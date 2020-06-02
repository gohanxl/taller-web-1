
<%@ include file = "header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!--Main layout-->
<main class="mt-5 pt-4">
    <div class="container dark-grey-text mt-5">

        <!--Grid row-->
        <div class="row wow fadeIn">

            <!--Grid column-->
            <div class="col-md-6 mb-4">

                <img src="${publicacion.libro.imagen}" class="img-fluid" alt="">

            </div>
            <!--Grid column-->

            <!--Grid column-->
            <div class="col-md-6 mb-4">

                <!--Content-->
                <div class="">

                    <div class="mb-3">
                        <a href="">
                            <span class="badge purple mr-1">Etiqueta 1</span>
                        </a>
                        <a href="">
                            <span class="badge blue mr-1">Etiqueta 2</span>
                        </a>
                        <a href="">
                            <span class="badge red mr-1">Etiqueta 3</span>
                        </a>
                    </div>
                    <p>${promedio}</p>
                    <p class="lead font-weight-bold">${publicacion.libro.nombre}</p>
                    <!--
                    <p>${publicacion.propietario.nombre}</p>
                    -->
                    <c:choose>
                        <c:when test="${!comprado}">
                            <p class="lead">
                                <span>$ ${publicacion.precio}</span>
                            </p>
                            <form action="/checkout" class="d-flex justify-content-left">
                                <!-- Default input -->
                                <input type="number" value="1" aria-label="Search" class="form-control" style="width: 100px">
                                <input type="hidden" name="publicacionId" value="${publicacion.id}"/>
                                <button class="btn btn-primary btn-md my-0 p" type="submit">Agregar al carrito
                                    <i class="fas fa-shopping-cart ml-1"></i>
                                </button>

                            </form>
                        </c:when>
                        <c:otherwise>
                            <form:form action="/puntuar" method="POST" modelAttribute="puntaje">
                                <div style="margin: 0 !important; padding: 0 !important; display: inline !important;">
                                    <span id="rateMe"  class="mdb-rating empty-stars"></span>
                                </div>
                                <div class="md-form mb-4 info-textarea active-info-textarea">
                                    <form:textarea path="comentario" id="comentario" class="md-textarea form-control" name="comentario" rows="3" />
                                    <label for="comentario">Comentario</label>
                                </div>
                                <form:input path="valor" type="hidden" name="valor" id="valor" required="" />
                                <form:input path="usuario.id" type="hidden" id="usuario" value="${USUARIO_ID}"/>
                                <form:input path="publicacion.id" type="hidden" id="publicacion" value="${publicacion.id}" />
                                <button class="btn btn-primary my-0" type="submit">Enviar
                            </form:form>
                        </c:otherwise>
                    </c:choose>
                </div>
                <!--Content-->

            </div>
            <!--Grid column-->

        </div>
        <!--Grid row-->

        <hr>

        <!--Grid row-->
        <div class="row d-flex wow fadeIn">

            <!--Grid column-->
            <div class="col-md-6 text-left">

                <h4 class="my-4 h4">Valoración del libro</h4>
            </div>
            <!--Grid column-->

        </div>
        <!--Grid row-->

        <c:forEach var="puntaje" items="${puntajes}">
        <!--Grid row-->
        <div class="row wow fadeIn">

            <!--Grid column-->
            <div class="col-lg-4 col-md-12 mb-4">
                <p>${puntaje.usuario.nombre}</p>
                <p><fmt:formatDate value="${puntaje.fecha}" pattern="dd/MM/yyyy" /></p>
            </div>
            <!--Grid column-->

            <!--Grid column-->
            <div class="col-lg-4 col-md-6 mb-4">
                <p>${puntaje.valor}</p>
                <p>${puntaje.comentario}</p>
            </div>
            <!--Grid column-->

        </div>
        <!--Grid row-->
        </c:forEach>
    </div>
</main>
<!--Main layout-->
<%@ include file = "footer.jsp" %>