<%@ include file = "header.jsp" %>


<!--Main layout-->
<main class="mt-5 pt-4">
    <div class="container dark-grey-text mt-5">
        <h3 style="color:grey">Resultados para "${buscado}"</h3>
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Nombre</th>
                <th scope="col">Precio</th>
                <th scope="col">Propietario</th>
                <th scope="col">Acciones</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="result" items="${results}">
            <tr>
                <td><c:out value="${result.libro.nombre}"/></td>
                <td><c:out value="${result.precio}"/></td>
                <td><c:out value="${result.propietario.nombre}"/></td>
                <td>
                    <span><a href="#">Comprar</a> |</span>
                    <span><a href="<c:out value="${result.libro.ruta}"/>">Leer</a></span>
                </td>
            </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>
</main>
<!--Main layout-->

<%@ include file = "footer.jsp" %>