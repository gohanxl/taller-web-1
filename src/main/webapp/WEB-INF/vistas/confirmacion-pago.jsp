<%@ include file = "header.jsp" %>

<!--Main layout-->
<div class = "container card col-3" style="margin-top: 100px">
    <div class="card-body">
        <h4 class="mb-4">
            <span class="mr-2">Confirmacion de pago</span>
            <c:choose>
                <c:when test="${estadoDePago == 'approved'}">
                    <i class="fas fa-check-circle" style="color: #36af3a;"></i>
                </c:when>
                <c:otherwise>
                    <i class="fas fa-times-circle" style="color: #ef5656;}"></i></i>
                </c:otherwise>
            </c:choose>
        </h4>
        <c:choose>
            <c:when test="${precio != null}">
                <p>Descripcion: ${descripcion}</p>
                <p>Precio: $${precio}</p>
                <p>Metodo de pago: ${metodoDePago} ****${numeroDeTarjeta}</p>
            </c:when>
            <c:otherwise>
                <p>Descripcion: ${descripcion.libro.nombre}</p>
                <p>Puntos canjeados: ${puntosRestantes == null ? 0 : puntos}</p>
                <p>Puntos restantes: ${puntosRestantes == null ? "-" : puntosRestantes}</p>
            </c:otherwise>
        </c:choose>
        <a class="btn btn btn-primary float-right" href="/">Home</a>

    </div>
</div>
<!--Main layout-->

<%@ include file = "footer.jsp" %>