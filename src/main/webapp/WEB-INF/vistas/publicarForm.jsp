<%@ include file = "header.jsp" %>


<!--Main layout-->
<main class="mt-5 pt-4">
    <div class="container dark-grey-text mt-5">
        <!-- Material form login -->
        <div class="card">

            <h5 class="card-header mdb-color lighten-3 white-text text-center py-4">
                <strong>Publicar libro</strong>
            </h5>

            <!--Card content-->
            <div class="card-body px-lg-5 pt-0">
                <form:form id="form" method="POST" action="publicar" modelAttribute="libro" enctype="multipart/form-data" class="needs-validation">
            <div class="md-form">
                <input type="text" id="nombre" name="nombre" class="form-control" required>
                <label for="nombre">Nombre</label>
            </div>

            <div class="md-form">
                <input type="number" id="precio" name="precio" class="form-control" required>
                <label for="precio">Precio</label>
            </div>

            <div class="custom-file">
                <input type="file"  accept="application/pdf" class="custom-file-input" id="customFile" name="archivo" required>
                <label class="custom-file-label" for="customFile">Cargar PDF</label>
            </div>
            <div style="text-align: right;">
                <a href="/"><input class="btn btn-outline-danger btn-rounded btn-block my-4 waves-effect z-depth-0" type="button" value="Cancelar"></a>
                <input class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0" type="submit" value="Publicar"/>
            </div>
           </form:form>
            </div>
        </div>
    </div>
</main>
<!--Main layout-->


<%@ include file = "footer.jsp" %>