<%@ include file="header.jsp" %>

<!--Main layout-->
<main class="mt-5 pt-4">
    <div class="container wow fadeIn">

        <!-- Heading -->
        <h2 class="my-5 h2 text-center">Checkout</h2>

        <!--Grid row-->
        <div class="row">

            <!--Grid column-->
            <div class="col-md-8 mb-4">

                <!--Card-->
                <div class="card">

                    <!--Card content-->
                    <form class="card-body" action="/procesar_pago/<c:out value="${publicacion.id}"/>"
                          method="post" id="pay" name="pay">
                        <fieldset>
                            <p class="md-form">
                                <input class="form-control" type="hidden" name="description" id="description"
                                       value="<c:out value="${publicacion.libro.nombre}"/>"/>
                            </p>
                            <p class="md-form">
                                <input class="form-control" type="hidden" name="transaction_amount"
                                       id="transaction_amount" value="<c:out value="${publicacion.precio}"/>"/>
                            </p>
                            <p class="md-form">
                                <label for="cardNumber">N&uacute;mero de la tarjeta</label>
                                <input class="form-control" type="text" id="cardNumber" data-checkout="cardNumber"
                                       onselectstart="return false" onpaste="return true" onCopy="return false"
                                       onCut="return false" onDrag="return false" onDrop="return false"
                                       autocomplete=off
                                        value="4509 9535 6623 3704"/>
                            </p>
                            <p class="md-form">
                                <label for="cardholderName">Nombre y apellido</label>
                                <input class="form-control" type="text" id="cardholderName"
                                       data-checkout="cardholderName" required/>
                            </p>
                            <p class="md-form">
                                <label for="cardExpirationMonth">Mes de vencimiento</label>
                                <input class="form-control" type="text" id="cardExpirationMonth"
                                       data-checkout="cardExpirationMonth"
                                       onselectstart="return false" onpaste="return false" onCopy="return false"
                                       onCut="return false" onDrag="return false" onDrop="return false"
                                       value="11"
                                       autocomplete=off/>
                            </p>
                            <p class="md-form">
                                <label for="cardExpirationYear">A&ntilde;o de vencimiento</label>
                                <input class="form-control" type="text" id="cardExpirationYear"
                                       data-checkout="cardExpirationYear"
                                       onselectstart="return false" onpaste="return false" onCopy="return false"
                                       onCut="return false" onDrag="return false" onDrop="return false"
                                       value="25"
                                       autocomplete=off/>
                            </p>
                            <p class="md-form">
                                <label for="securityCode">C&oacute;digo de seguridad</label>
                                <input class="form-control" type="password" id="securityCode" data-checkout="securityCode"
                                       onselectstart="return false" onpaste="return false" onCopy="return false"
                                       onCut="return false" onDrag="return false" onDrop="return false"
                                       value="123"
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
                                <input class="form-control" type="email" id="email" name="email"
                                value="test_user_53646357@testuser.com"/>
                            </p>
                            <input type="hidden" name="payment_method_id" id="payment_method_id"/>
                            <span class="float-right">
                            <input id="btnsubmit" class="btn btn-secondary btn-md waves-effect m-0" type="submit" value="Pagar"/>
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
                    <span class="text-muted">Producto</span>
                    <!--<span class="badge badge-secondary badge-pill">1</span>-->
                </h4>

                <!-- Cart -->
                <ul class="list-group mb-3 z-depth-1">
                    <li class="list-group-item d-flex justify-content-between lh-condensed">
                        <div>
                            <h6 class="my-0">${publicacion.libro.nombre}</h6>
                            <small class="text-muted">Vendedor: ${publicacion.propietario.nombre}</small>
                        </div>
                        <span class="text-muted">$${publicacion.precio}</span>
                    </li>
                    <li class="list-group-item d-flex justify-content-between">
                        <span>Total</span>
                        <strong>$${publicacion.precio}</strong>
                    </li>
                </ul>
                <!-- Cart -->

                <!-- Promo code -->
                <!--<form class="card p-2">
                    <div class="input-group">
                        <input type="text" class="form-control" placeholder="Promo code"
                               aria-label="Recipient's username" aria-describedby="basic-addon2">
                        <div class="input-group-append">
                            <button class="btn btn-secondary btn-md waves-effect m-0" type="button">Redeem</button>
                        </div>
                    </div>
                </form>-->
                <!-- Promo code -->

            </div>
            <!--Grid column-->

        </div>
        <!--Grid row-->

    </div>
</main>
<!--Main layout-->

<%@ include file="footer.jsp" %>