<%@ include file = "header.jsp" %>

<!--Main layout-->
<main class="mt-5 pt-4">
    <div class="container">
        <h3 style="color:grey">Resultados para "${buscado}"</h3>
        <table class="table table-striped">
            <thead>
            <tr>
                <th scope="col">Nombre</th>
                <th scope="col">Precio</th>
                <th scope="col">Propietario</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>${nombre}</td>
                <td>123</td>
                <td>pepe</td>
            </tr>

            </tbody>
        </table>
    </div>
</main>
<!--Main layout-->

<%@ include file = "footer.jsp" %>