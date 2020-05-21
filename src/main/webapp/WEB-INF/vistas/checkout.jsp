<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ include file="header.jsp" %>

<!--Main layout-->
<main class="mt-5 pt-4">
    <div class="container wow fadeIn">

        <!-- Heading -->
        <h2 class="my-5 h2 text-center">Checkout form</h2>

        <!--Grid row-->
        <div class="row">

            <!--Grid column-->
            <div class="col-md-8 mb-4">

                <!--Card-->
                <div class="card">

                    <!--Card content-->
                    <form class="card-body" action="/procesar_pago/<c:out value="${publicacion.libro.id}"/>"
                          method="post" id="pay" name="pay">
                        <fieldset>
                            <p class="md-form">
                                <label for="description">Descripci&oacute;n</label>
                                <input class="form-control" type="text" name="description" id="description"
                                       value="<c:out value="${publicacion.libro.nombre}"/>"/>
                            </p>
                            <p class="md-form">
                                <label for="transaction_amount">Monto a pagar</label>
                                <input class="form-control" type="text" name="transaction_amount"
                                       id="transaction_amount" value="<c:out value="${publicacion.precio}"/>"/>
                            </p>
                            <p class="md-form">
                                <label for="cardNumber">N&uacute;mero de la tarjeta</label>
                                <input class="form-control" type="text" id="cardNumber" data-checkout="cardNumber"
                                       onselectstart="return false" onpaste="return true" onCopy="return false"
                                       onCut="return false" onDrag="return false" onDrop="return false"
                                       autocomplete=off/>
                            </p>
                            <p class="md-form">
                                <label for="cardholderName">Nombre y apellido</label>
                                <input class="form-control" type="text" id="cardholderName"
                                       data-checkout="cardholderName"/>
                            </p>
                            <p class="md-form">
                                <label for="cardExpirationMonth">Mes de vencimiento</label>
                                <input class="form-control" type="text" id="cardExpirationMonth"
                                       data-checkout="cardExpirationMonth"
                                       onselectstart="return false" onpaste="return false" onCopy="return false"
                                       onCut="return false" onDrag="return false" onDrop="return false"
                                       autocomplete=off/>
                            </p>
                            <p class="md-form">
                                <label for="cardExpirationYear">A&ntilde;o de vencimiento</label>
                                <input class="form-control" type="text" id="cardExpirationYear"
                                       data-checkout="cardExpirationYear"
                                       onselectstart="return false" onpaste="return false" onCopy="return false"
                                       onCut="return false" onDrag="return false" onDrop="return false"
                                       autocomplete=off/>
                            </p>
                            <p class="md-form">
                                <label for="securityCode">C&oacute;digo de seguridad</label>
                                <input class="form-control" type="text" id="securityCode" data-checkout="securityCode"
                                       onselectstart="return false" onpaste="return false" onCopy="return false"
                                       onCut="return false" onDrag="return false" onDrop="return false"
                                       autocomplete=off/>
                            </p>
                            <p>
                                <label for="installments">Cuotas</label>
                                <select id="installments" class="custom-select d-block w-100" name="installments">
                                    <option>3</option>
                                    <option>6</option>
                                    <option>12</option>
                                </select>
                            </p>
                            <p>
                                <label for="docType">Tipo de documento</label>
                                <select class="custom-select d-block w-100" id="docType" data-checkout="docType">
                                    <option>DNI</option>
                                    <option>Pasaporte</option>
                                    <option>Documento Extranjero (?</option>
                                </select>
                            </p>
                            <p class="md-form">
                                <label for="docNumber">N&uacute;mero de documento</label>
                                <input class="form-control" type="text" id="docNumber" data-checkout="docNumber"/>
                            </p>
                            <p class="md-form">
                                <label for="email">Email</label>
                                <input class="form-control" type="email" id="email" name="email"/>
                            </p>
                            <input type="hidden" name="payment_method_id" id="payment_method_id"/>
                            <span class="float-right">
                            <input class="btn btn-secondary btn-md waves-effect m-0" type="submit" value="Pagar"/>
                            </span>
                        </fieldset>
                    </form>

                </div>
                <!--/.Card-->

            </div>
            <!--Grid column-->

            <!--Grid column-->
            <div class="col-md-4 mb-4">

                <!-- Heading -->
                <h4 class="d-flex justify-content-between align-items-center mb-3">
                    <span class="text-muted">Your cart</span>
                    <span class="badge badge-secondary badge-pill">3</span>
                </h4>

                <!-- Cart -->
                <ul class="list-group mb-3 z-depth-1">
                    <li class="list-group-item d-flex justify-content-between lh-condensed">
                        <div>
                            <h6 class="my-0">Product name</h6>
                            <small class="text-muted">Brief description</small>
                        </div>
                        <span class="text-muted">$12</span>
                    </li>
                    <li class="list-group-item d-flex justify-content-between lh-condensed">
                        <div>
                            <h6 class="my-0">Second product</h6>
                            <small class="text-muted">Brief description</small>
                        </div>
                        <span class="text-muted">$8</span>
                    </li>
                    <li class="list-group-item d-flex justify-content-between lh-condensed">
                        <div>
                            <h6 class="my-0">Third item</h6>
                            <small class="text-muted">Brief description</small>
                        </div>
                        <span class="text-muted">$5</span>
                    </li>
                    <li class="list-group-item d-flex justify-content-between bg-light">
                        <div class="text-success">
                            <h6 class="my-0">Promo code</h6>
                            <small>EXAMPLECODE</small>
                        </div>
                        <span class="text-success">-$5</span>
                    </li>
                    <li class="list-group-item d-flex justify-content-between">
                        <span>Total (USD)</span>
                        <strong>$20</strong>
                    </li>
                </ul>
                <!-- Cart -->

                <!-- Promo code -->
                <form class="card p-2">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Promo code"
                               aria-label="Recipient's username" aria-describedby="basic-addon2">
                        <div class="input-group-append">
                            <button class="btn btn-secondary btn-md waves-effect m-0" type="button">Redeem</button>
                        </div>
                    </div>
                </form>
                <!-- Promo code -->

            </div>
            <!--Grid column-->

        </div>
        <!--Grid row-->

    </div>
</main>
<!--Main layout-->

<%@ include file="footer.jsp" %>