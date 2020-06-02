<%@ include file = "header.jsp" %>
<link href="/css/style_historial-de-transacciones.css" rel="stylesheet">

<!--Main layout-->
<main class="mt-5 pt-4 container">
    <div class="card mb-3 card-historial">
        <div class="card-body">
            <h3 class="card-title px-4 pt-4">Historial de transacciones</h3>
            <div class="row">
                <div class="column p-5">
                    <h4>Compras</h4>
                    <c:forEach var="compra" items="${compras}">
                        <div class="mb-3">
                            <h5 style="color:grey">Fecha de compra: ${compra.fecha_compra}</h5>
                            <h5 style="color:grey">Vendedor: ${compra.publicacion.propietario.nombre}</h5>
                            <h5 style="color:grey">Libro: ${compra.publicacion.libro.nombre}</h5>
                        </div>
                    </c:forEach>
                </div>
                <div class="column p-5">
                    <h4>Ventas</h4>
                    <c:forEach var="venta" items="${ventas}">
                        <div class="mb-3">
                            <h5 style="color:grey">Publicacion: ${venta[0].libro.nombre}</h5>
                            <h5 style="color:grey">Cantidad de ventas: ${venta[1]}</h5>
                            <h5 style="color:grey">Total acumulado: $${venta[0].precio * venta[1]}</h5>
                        </div>
                    </c:forEach>
                </div>
            </div>
            <a style="float: right" href="/" class="btn btn-success">Home</a>
        </div>
    </div>
</main>
<!--Main layout-->

<%@ include file = "footer.jsp" %>