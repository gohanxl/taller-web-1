<!DOCTYPE html>
<html lang="en">

<head>
    <meta http-equiv="content-type" content="text/html" charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title>Material Design Bootstrap</title>
    <!-- Font Awesome -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
    <!-- Bootstrap core CSS -->
    <link href="/css/bootstrap.min.css" rel="stylesheet">
    <!-- Material Design Bootstrap -->
    <link href="/css/mdb.min.css" rel="stylesheet">
    <!-- Your custom styles (optional) -->
    <link href="/css/style.min.css" rel="stylesheet">
</head>

<body class="grey lighten-3">

<!-- Navbar -->
<nav class="navbar fixed-top navbar-expand-lg navbar-light white scrolling-navbar">
    <div class="container">

        <!-- Brand -->
        <a class="navbar-brand waves-effect" href="https://mdbootstrap.com/docs/jquery/" target="_blank">
            <strong class="blue-text">MDB</strong>
        </a>

        <!-- Collapse -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent"
                aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <!-- Links -->
        <div class="collapse navbar-collapse" id="navbarSupportedContent">

            <!-- Left -->
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link waves-effect" href="#">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link waves-effect" href="https://mdbootstrap.com/docs/jquery/" target="_blank">About
                        MDB</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link waves-effect"
                       href="https://mdbootstrap.com/docs/jquery/getting-started/download/" target="_blank">Free
                        download</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link waves-effect" href="https://mdbootstrap.com/education/bootstrap/"
                       target="_blank">Free tutorials</a>
                </li>
            </ul>

            <!-- Right -->
            <ul class="navbar-nav nav-flex-icons">
                <li class="nav-item">
                    <a class="nav-link waves-effect">
                        <span class="badge red z-depth-1 mr-1"> 1 </span>
                        <i class="fas fa-shopping-cart"></i>
                        <span class="clearfix d-none d-sm-inline-block"> Cart </span>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="https://www.facebook.com/mdbootstrap" class="nav-link waves-effect" target="_blank">
                        <i class="fab fa-facebook-f"></i>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="https://twitter.com/MDBootstrap" class="nav-link waves-effect" target="_blank">
                        <i class="fab fa-twitter"></i>
                    </a>
                </li>
                <li class="nav-item">
                    <a href="https://github.com/mdbootstrap/bootstrap-material-design"
                       class="nav-link border border-light rounded waves-effect"
                       target="_blank">
                        <i class="fab fa-github mr-2"></i>MDB GitHub
                    </a>
                </li>
            </ul>

        </div>

    </div>
</nav>
<!-- Navbar -->

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
                    <form class="card-body" action="procesar_pago" method="post" id="pay" name="pay">
                        <fieldset>
                            <p class="md-form">
                                <label for="description">Descripci&oacute;n</label>
                                <input class="form-control" type="text" name="description" id="description"
                                       value="Item seleccionado"/>
                            </p>
                            <p class="md-form">
                                <label for="transaction_amount">Monto a pagar</label>
                                <input class="form-control" type="text" name="transaction_amount"
                                       id="transaction_amount" value="100"/>
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

<!--Footer-->
<footer class="page-footer text-center font-small mt-4 wow fadeIn">

    <!--Call to action-->
    <div class="pt-4">
        <a class="btn btn-outline-white" href="https://mdbootstrap.com/docs/jquery/getting-started/download/"
           target="_blank" role="button">Download MDB
            <i class="fas fa-download ml-2"></i>
        </a>
        <a class="btn btn-outline-white" href="https://mdbootstrap.com/education/bootstrap/" target="_blank"
           role="button">Start free tutorial
            <i class="fas fa-graduation-cap ml-2"></i>
        </a>
    </div>
    <!--/.Call to action-->

    <hr class="my-4">

    <!-- Social icons -->
    <div class="pb-4">
        <a href="https://www.facebook.com/mdbootstrap" target="_blank">
            <i class="fab fa-facebook-f mr-3"></i>
        </a>

        <a href="https://twitter.com/MDBootstrap" target="_blank">
            <i class="fab fa-twitter mr-3"></i>
        </a>

        <a href="https://www.youtube.com/watch?v=7MUISDJ5ZZ4" target="_blank">
            <i class="fab fa-youtube mr-3"></i>
        </a>

        <a href="https://plus.google.com/u/0/b/107863090883699620484" target="_blank">
            <i class="fab fa-google-plus-g mr-3"></i>
        </a>

        <a href="https://dribbble.com/mdbootstrap" target="_blank">
            <i class="fab fa-dribbble mr-3"></i>
        </a>

        <a href="https://pinterest.com/mdbootstrap" target="_blank">
            <i class="fab fa-pinterest mr-3"></i>
        </a>

        <a href="https://github.com/mdbootstrap/bootstrap-material-design" target="_blank">
            <i class="fab fa-github mr-3"></i>
        </a>

        <a href="http://codepen.io/mdbootstrap/" target="_blank">
            <i class="fab fa-codepen mr-3"></i>
        </a>
    </div>
    <!-- Social icons -->

    <!--Copyright-->
    <div class="footer-copyright py-3">
        © 2019 Copyright:
        <a href="https://mdbootstrap.com/education/bootstrap/" target="_blank"> MDBootstrap.com </a>
    </div>
    <!--/.Copyright-->

</footer>
<!--/.Footer-->

<!-- SCRIPTS -->
<!-- JQuery -->
<script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>
<!-- Bootstrap tooltips -->
<script type="text/javascript" src="/js/popper.min.js"></script>
<!-- Bootstrap core JavaScript -->
<script type="text/javascript" src="/js/bootstrap.min.js"></script>
<!-- MDB core JavaScript -->
<script type="text/javascript" src="/js/mdb.min.js"></script>
<!-- Initializations -->
<script src="https://secure.mlstatic.com/sdk/javascript/v1/mercadopago.js"></script>
<script type="text/javascript" src="/js/mercadoLibre.js"></script>
<script type="text/javascript">
    // Animations initialization
    new WOW().init();
</script>
</body>

</html>