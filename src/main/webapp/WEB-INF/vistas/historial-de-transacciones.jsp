<%@ include file = "header.jsp" %>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>
<link href="/css/style_historial-de-transacciones.css" rel="stylesheet">

<!--Main layout-->
<main class="mt-5 pt-4 container">
    <div class="card mb-3 card-historial">
        <div class="card-body">
            <h3 class="card-title px-4 pt-4">Historial de transacciones</h3>
            <div class="row">
                <div class="column columnas-historial">
                    <h5>Compras</h5>
                    <c:forEach var="compra" items="${compras}">
                        <div class="mb-4">
                            <p style="color:grey">Fecha de compra:
                                <fmt:formatDate type="both" value="${compra.fecha_compra}" />
                            </p>
                            <p style="color:grey">Libro: ${compra.publicacion.libro.nombre}</p>
                            <p style="color:grey">Vendedor: ${compra.publicacion.propietario.nombre}</p>
                            <p style="color:grey">Precio: $${compra.publicacion.precio}</p>
                        </div>
                    </c:forEach>
                </div>
                <div class="column columnas-historial">
                    <h5>Ventas</h5>
                    <c:forEach var="venta" items="${ventas}">
                        <div class="mb-4">
                            <p style="color:grey">Publicacion: ${venta[0].libro.nombre}</p>
                            <p style="color:grey">Cantidad de ventas: ${venta[1]}</p>
                            <p style="color:grey">Total acumulado: $${venta[0].precio * venta[1]}</p>
                        </div>
                    </c:forEach>
                </div>
            </div>
        </div>
    </div>
</main>
<!--Main layout-->

<%@ include file = "footer.jsp" %>