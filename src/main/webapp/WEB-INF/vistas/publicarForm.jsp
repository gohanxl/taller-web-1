<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file = "header.jsp" %>


<!--Main layout-->
<main class="mt-5 pt-4">
    <div class="container dark-grey-text mt-5">
        <h2>Publicar libro</h2>
        <form:form method="POST" action="publicar" modelAttribute="libro" enctype="multipart/form-data" class="needs-validation">
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
            <button class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0" type="submit">Publicar</button>
        </form:form>

        <script>
            // Add the following code if you want the name of the file appear on select
            $(".custom-file-input").on("change", function() {
                var fileName = $(this).val().split("\\").pop();
                $(this).siblings(".custom-file-label").addClass("selected").html(fileName);
            });
        </script>

    </div>
</main>
<!--Main layout-->


<%@ include file = "footer.jsp" %>