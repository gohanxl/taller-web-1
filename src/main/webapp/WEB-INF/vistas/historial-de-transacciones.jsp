<%@ include file = "header.jsp" %>
<link href="/css/style_historial-de-transacciones.css" rel="stylesheet">

<!--Main layout-->
<main class="mt-5 pt-4 container">
    <div class="card mb-3 card-historial">
        <div class="card-body">
            <h3 class="card-title success-title">Historial de transacciones</h3>
            <h5 style="color:grey">Libros comprados</h5>
            <c:forEach var="compra" items="${compras}">
                <div>
                    <h5 style="color:grey">Fecha de compra: ${compra.fecha_compra}</h5>
                </div>
            </c:forEach>
            <a style="float: right" href="/" class="btn btn-success">Home</a>
        </div>
    </div>
</main>
<!--Main layout-->

<%@ include file = "footer.jsp" %>