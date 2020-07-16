<%@ include file="header.jsp" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!--Main layout-->
<main class="mt-5 pt-4">
    <div class="container dark-grey-text mt-5">
        <div>
            <!--Grid row-->
            <div class="row wow fadeIn">

                <!--Grid column-->
                <div class="col-md-6 mb-4">

                    <img src="${publicacion.libro.imagen}" class="img-fluid" alt="" style="width: 75%">

                </div>
                <!--Grid column-->

                <!--Grid column-->
                <div class="col-md-6 mb-4">

                    <!--Content-->
                    <div class="">

                        <div class="mb-3">
                            <c:forEach var="etiqueta" items="${publicacion.etiquetas}">
                                <span class="badge purple mr-1">${etiqueta.descripcion}</span>
                            </c:forEach>
                        </div>
                        <c:if test="${not empty promedio}">
                            ${promedio}
                            <c:forEach var="contador" begin="1" end="5">
                                <c:set var="contadorMitad" value="${contador - 0.5}"/>
                                <c:choose>
                                    <c:when test="${contador le promedio}">
                                        <span style="color: #f3cb06" class="fa fa-star"></span>
                                    </c:when>
                                    <c:when test="${contador gt promedio}">
                                        <c:choose>
                                            <c:when test="${contadorMitad le promedio}">
                                                <span style="color: #f3cb06" class="fa fa-star-half-alt"></span>
                                            </c:when>
                                            <c:otherwise>
                                                <span class="fa fa-star empty-stars"></span>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:when>
                                </c:choose>
                            </c:forEach>
                        </c:if>

                        <h3 class="mt-5 mb-3">${publicacion.libro.nombre}</h3>
                        <!--
                    <p>${publicacion.propietario.nombre}</p>
                    -->
                        <c:choose>
                        <c:when test="${!comprado && !usuarioEsPropietario}">
                            <p class="lead">
                                <span id="price">$ ${publicacion.precio}</span>
                            </p>
                            <form action="/checkout" class="d-flex justify-content-left">
                                <!-- Default input -->
                                <input type="hidden" name="publicacionId" value="${publicacion.id}"/>
                                <button class="btn btn-primary btn-md mx-0 my-3" type="submit">Comprar
                                    <i class="fas fa-shopping-cart ml-1"></i>
                                </button>
                            </form>
                            <form action="/checkout" class="d-flex justify-content-left">
                                <!-- Default input -->
                                <input type="hidden" name="publicacionId" value="${publicacion.id}"/>
                                <input type="hidden" name="regalo" value="true">
                                <button class="btn btn-primary btn-md mx-0 my-3" type="submit">Comprar como regalo
                                </button>
                            </form>
                            <form action="/canjear-puntos" class="d-flex justify-content-left" id="canjear-puntos">
                                <!-- Default input -->
                                <input type="hidden" name="publicacionId" value="${publicacion.id}"/>
                                <input type="hidden" name="puntosACanjear" value="${puntosACanjear}">
                                <button class="btn btn-primary btn-md mx-0 my-3" type="submit">
                                    Canjear por <b>${puntosACanjear}</b> puntos
                                </button>
                            </form>

                            <button value="Cancelar Envio" class="hidden" id="deliveryBtn">Cancelar Envio</button>
                        </c:when>
                        <c:when test="${comprado && puntuado}">
                            <form action="/checkout" class="d-flex justify-content-left">
                                <!-- Default input -->
                                <input type="hidden" name="publicacionId" value="${publicacion.id}"/>
                                <input type="hidden" name="regalo" value="true">
                                <button class="btn btn-primary btn-md mx-0 my-3" type="submit">Comprar como regalo
                                </button>
                            </form>
                            <h4 class="mt-3">Gracias por puntuar este libro.</h4>
                        </c:when>
                        <c:when test="${comprado && !puntuado}">
                        <form:form action="/puntuar" method="POST" modelAttribute="puntaje">
                        <div style="margin: 0 !important; padding: 0 !important; display: inline !important;">
                            <span id="rateMe" class="mdb-rating empty-stars"></span>
                        </div>
                        <div class="md-form mb-4 info-textarea active-info-textarea">
                            <form:textarea path="comentario" id="comentario" class="md-textarea form-control pb-2"
                                           name="comentario" cssStyle="height: 20px;"/>
                            <label for="comentario" class="mb-0">Comentario</label>
                        </div>
                        <form:input path="valor" type="hidden" name="valor" id="valor" required="" value="1"/>
                        <form:input path="usuario.id" type="hidden" id="usuario" value="${USUARIO_ID}"/>
                        <form:input path="publicacion.id" type="hidden" id="publicacion" value="${publicacion.id}"/>
                        <button class="btn btn-primary my-0" type="submit">Enviar
                            </form:form>
                            </c:when>
                            <c:when test="${usuarioEsPropietario}">
                            <form action="/checkout" class="d-flex justify-content-left">
                                <input type="hidden" name="publicacionId" value="${publicacion.id}"/>
                                <input type="hidden" name="regalo" value="true">
                                <button class="btn btn-primary btn-md mx-0 my-3" type="submit">Comprar como regalo
                                </button>
                            </form>
                            <h5 class="mt-5">Cantidad de ventas: ${cantidadDeVentas}</h5>
                            </c:when>
                            </c:choose>
                    </div>
                    <!--Grid column-->

                </div>
                <hr>
                <!--Grid column-->
                <c:if test="${!comprado}">
                    <div class="col-12 d-flex flex-row">
                        <div id="directionsInputContainer">
                        </div>
                        <div id="myMap" style="width: 100%; height: 500px" class="flex"></div>
                    </div>
                    <div class="col-12 d-flex flex-row">
                        <div id="routeInfoPanel" style="padding: 15px"></div>
                    </div>
                </c:if>
            </div>
            <!--Grid row-->
            <!--Grid row-->
            <div class="row d-flex wow fadeIn">
                <div class="col-md-6 text-left">
                    <h4 class="my-4 h4">Valoración del libro</h4>
                </div>
            </div>
            <c:choose>
                <c:when test="${empty puntajes}">
                    <span class="glyphicon glyphicon-book"></span>
                    <p>Aún no hay valoraciones</p>
                </c:when>
            </c:choose>
            <c:forEach var="puntaje" items="${puntajes}">

                <div class="card mb-4">
                    <!--Grid row-->
                    <div class="card-body row wow fadeIn">

                        <!--Grid column-->
                        <div class="col-lg-4 col-md-12">
                            <p>${puntaje.usuario.nombre}</p>
                            <p class="mb-0"><fmt:formatDate value="${puntaje.fecha}" pattern="dd/MM/yyyy"/></p>
                        </div>
                        <!--Grid column-->

                        <!--Grid column-->
                        <div class="col-lg-4 col-md-6">
                            <div class="mb-3">
                                <c:forEach var="contador" begin="1" end="5">
                                    <c:choose>
                                        <c:when test="${contador le puntaje.valor}">
                                            <span style="color: #f3cb06" class="fa fa-star"></span>
                                        </c:when>
                                        <c:otherwise>
                                            <span class="fa fa-star empty-stars"></span>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>
                            </div>
                            <p class="mb-0">${puntaje.comentario}</p>
                        </div>
                        <!--Grid column-->

                    </div>
                    <!--Grid row-->
                </div>
            </c:forEach>
        </div>
        <c:choose>
            <c:when test="${not empty publicacionesRelacionadas}">
                <div class="mt-5">
                    <section class="text-center mb-4">
                        <div class="row d-flex wow fadeIn">
                            <div class="col-md-6 text-left">
                                <h4 class="my-4 h4">Relacionados</h4>
                            </div>
                        </div>
                        <!--Grid row-->
                        <div class="row wow fadeIn">
                            <c:forEach var="publicacion" items="${publicacionesRelacionadas}">
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
                                                        <span class="dark-grey-text"><c:out
                                                                value="${publicacion.libro.nombre}"/></span>
                                                    </strong>
                                                </h5>
                                                <c:forEach var="etiqueta" items="${publicacion.etiquetas}">
                                                    <span class="badge badge-pill primary-color">${etiqueta.descripcion}</span>
                                                </c:forEach>
                                                <h4 class="font-weight-bold blue-text mt-2">
                                                    <strong>$ <c:out value="${publicacion.precio}"/></strong>
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
                </div>
            </c:when>
        </c:choose>
    </div>
</main>
<!--Main layout-->
<script src="/js/mapaAPI.js"></script>
<script type='text/javascript'
        src='http://www.bing.com/api/maps/mapcontrol?key=Ai_KF8afanFf4bWmXjsFzj0tBgWAYKPyyLqjCyYRKzLUcVr1AmjdElPKAQ2_ednr&setLang=es&callback=GetMap'
        async defer></script>
<%@ include file="footer.jsp" %>