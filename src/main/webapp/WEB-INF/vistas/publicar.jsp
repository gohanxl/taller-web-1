<%@ include file = "header.jsp" %>

<!--Main layout-->
<main class="mt-5 pt-4">
    <div class="card border-success mb-3 card-publicar">
        <div class="card-body">
            <h3 class="card-title success-title">Publicacion exitosa!</h3>
            <h5 style="color:grey">Su libro ya se encuentra disponible para la venta</h5>
            <h6 class="card-text">Titulo: ${nombre}.</h6>
            <h6 class="card-text">Precio: ${precio}.</h6>
            <a style="float: right" href="#" class="btn btn-success">Go home</a>
        </div>
    </div>
</main>
<!--Main layout-->

<%@ include file = "footer.jsp" %>