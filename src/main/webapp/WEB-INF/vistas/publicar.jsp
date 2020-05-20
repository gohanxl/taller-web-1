<%@ include file = "header.jsp" %>

<!--Main layout-->
<main class="mt-5 pt-4">
    <div class="card border-success mb-3 card-publicar">
        <div class="card-body">
            <h3 class="card-title success-title">Publicacion exitosa!</h3>
            <h5 style="color:grey">Su libro ya se encuentra disponible para la venta</h5>
            <br>
            <h5 style="color:grey">Titulo: ${nombre}</h5>
            <h5 style="color:grey">Precio: ${precio}</h5>
            <a style="float: right" href="/home" class="btn btn-success">Go home</a>
        </div>
    </div>
</main>
<!--Main layout-->

<%@ include file = "footer.jsp" %>