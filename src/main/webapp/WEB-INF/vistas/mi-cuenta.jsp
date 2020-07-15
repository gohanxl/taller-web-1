<%@ include file = "header.jsp" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<link href="/css/style_historial-de-transacciones.css" rel="stylesheet">

<main class="mt-5 pt-4 container">
    <nav class="navbar navbar-expand-lg navbar-dark mdb-color lighten-3 mt-5 mb-5">
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#basicExampleNav"
                aria-controls="basicExampleNav" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="basicExampleNav">
            <ul class="nav navbar-nav mr-auto" role="tablist">
                <li class="nav-item">
                    <a class="nav-link active mr-3" id="historial-tab" data-toggle="tab" href="#historial" role="tab" aria-controls="home"
                       aria-selected="true">Historial de Transacciones</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" id="profile-tab" data-toggle="tab" href="#puntos" role="tab" aria-controls="profile"
                       aria-selected="false">Mis Puntos</a>
                </li>
            </ul>
        </div>

    </nav>
    <div class="tab-content" id="myTabContent">
        <div class="tab-pane fade show active" id="historial" role="tabpanel" aria-labelledby="historial-tab">
            <div class="card mb-3 card-historial">
                <div class="card-body">
                    <h3 class="card-title px-4 pt-4">Historial de transacciones</h3>
                    <div class="row">
                        <div class="column columnas-historial">
                            <h5>Compras</h5>
                            <c:choose>
                                <c:when test="${not empty compras}">
                                    <c:forEach var="compra" items="${compras}">
                                        <div class="mb-4">
                                            <p style="color:grey">Fecha de compra:
                                                <fmt:formatDate type="both" value="${compra.fecha_compra}" />
                                            </p>
                                            <p style="color:grey">Libro: ${compra.publicacion.libro.nombre}</p>
                                            <p style="color:grey">Vendedor: ${compra.publicacion.propietario.nombre}</p>
                                            <p style="color:grey">Precio: $${compra.precioDeCompra}</p>
                                        </div>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <p style="color:grey">Aun no hay compras</p>
                                </c:otherwise>
                            </c:choose>
                        </div>
                        <div class="column columnas-historial">
                            <h5>Ventas</h5>
                            <c:choose>
                                <c:when test="${not empty ventas}">
                                    <c:forEach var="venta" items="${ventas}">
                                        <div class="mb-4">
                                            <p style="color:grey">Publicacion: ${venta[0].libro.nombre}</p>
                                            <p style="color:grey">Cantidad de ventas: ${venta[1]}</p>
                                            <p style="color:grey">Total acumulado: $${venta[0].precio * venta[1]}</p>
                                        </div>
                                    </c:forEach>
                                </c:when>
                                <c:otherwise>
                                    <p style="color:grey">Aun no hay ventas</p>
                                </c:otherwise>
                            </c:choose>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <div class="tab-pane fade" id="puntos" role="tabpanel" aria-labelledby="profile-tab">
            <div class="card mb-3 card-historial">
                <div class="card-body">
                    <div class="card-title px-4 pt-4 text-center d-flex justify-content-center">
                        <h1 class="puntos-de-usuario">${puntos}</h1>
                    </div>
                    <h4 class="card-title px-4 text-center">Puntos acumulados</h4>
                    <c:choose>
                        <c:when test="${not empty recomendadosPorPuntos}">
                            <h3 class="text-center my-5">Puedes canjear tus puntos por los siguientes libros</h3>
                            <div class="row mx-0">
                            <c:forEach var="recomendacion" items="${recomendadosPorPuntos}">
                                <div class="col-lg-3 col-md-6 mb-4">
                                    <a href="/publicacion/${recomendacion.id}">
                                        <div class="card">
                                            <div class="view overlay" style="cursor: pointer">
                                                <img src="${recomendacion.libro.imagen}" class="card-img-top portada-libro"
                                                     alt="">
                                            </div>
                                            <div class="card-body text-center">
                                                <h5 class="grey-text"><c:out value="${recomendacion.propietario.nombre}"/></h5>
                                                <h5 class="dark-grey-text font-weight-bold">
                                                    <c:out value="${recomendacion.libro.nombre}"/>
                                                </h5>
                                                <c:forEach var="etiqueta" items="${recomendacion.etiquetas}">
                                                    <span class="badge badge-pill primary-color">${etiqueta.descripcion}</span>
                                                </c:forEach>
                                                <h4 class="font-weight-bold blue-text mt-2">
                                                    <strong><c:out value="${recomendacion.valorEnPuntos}"/> puntos</strong>
                                                </h4>
                                            </div>
                                        </div>
                                    </a>
                                </div>
                            </c:forEach>
                            </div>
                        </c:when>
                    </c:choose>
                </div>
            </div>
        </div>
    </div>
</main>

<style>
    .puntos-de-usuario{
        font-size: 70px;
        padding: 20px;
        border: solid 3px #929fba;
        border-radius: 100px;
        box-shadow: 2px 4px 5px 0px #00000029;
        color: #6b6b6b;
    }
</style>

<%@ include file = "footer.jsp" %>