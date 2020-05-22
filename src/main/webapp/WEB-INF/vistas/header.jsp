<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html lang="es-AR">

<head>
    <meta charset="utf-8">
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
    <link href="/css/style.css" rel="stylesheet">
    <style>
        html {
            margin:0 !important;
            padding:0 !important;
            height:100% !important;
        }
        body{
            height: auto !important;
            min-height: 100% !important;
            position: relative !important;
        }

        main{
            padding-bottom:200px !important;
        }
        footer{
            width:100% !important;
            position:absolute !important;
            bottom:0 !important;
            left:0 !important;
        }
    </style>
</head>

<body>

<!-- Navbar -->
<nav class="navbar fixed-top navbar-expand-lg navbar-light white scrolling-navbar">
    <div class="container">

        <!-- Brand -->
        <a class="navbar-brand waves-effect" href="https://mdbootstrap.com/docs/jquery/" target="_blank">
            <strong class="blue-text"></strong>
        </a>

        <!-- Collapse -->
        <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent"
                aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
            <span class="navbar-toggler-icon"></span>
        </button>

        <!-- Links -->
        <div class="collapse navbar-collapse" id="navbarSupportedContent">

            <!-- Left -->
            <ul class="navbar-nav mr-auto">
                <li class="nav-item active">
                    <a class="nav-link waves-effect" href="/">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <c:if test="${not empty USERNAME}">
                <li class="nav-item">
                    <a class="nav-link waves-effect" href="/biblioteca">Biblioteca</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link waves-effect" href="/publicaciones">Publicaciones</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link waves-effect" href="/publicar">Publicar</a>
                </li>
                </c:if>
                <li class="nav-item">
                    <form:form method="GET" action="buscar" class="form-inline d-flex justify-content-center md-form form-sm my-0">
                        <input class="form-control form-control-sm mr-3 w-75" type="text" name="nombre" placeholder="Buscar" aria-label="Search">
                        <i class="fas fa-search" aria-hidden="true"></i>
                    </form:form>
                </li>
            </ul>

            <!-- Right -->
            <ul class="navbar-nav nav-flex-icons">
                <c:choose>
                    <c:when test="${not empty USERNAME}">
                        <li class="nav-item">
                            <a class="nav-link waves-effect">
                                <span class="badge red z-depth-1 mr-1"> 1 </span>
                                <i class="fas fa-shopping-cart"></i>
                                <span class="clearfix d-none d-sm-inline-block"> Cart </span>
                            </a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-4" data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-user"></i> <%= session.getAttribute("USERNAME") %> </a>
                            <div class="dropdown-menu dropdown-menu-right dropdown-info" aria-labelledby="navbarDropdownMenuLink-4">
                                <a class="dropdown-item" href="#">Mi cuenta</a>
                                <a class="dropdown-item" href="#">Cerrar sesion</a>
                            </div>
                        </li>
                    </c:when>
                    <c:otherwise>
                        <a type="button" href="/login" class="btn btn-outline-info waves-effect">Login</a>
                    </c:otherwise>
                </c:choose>
            </ul>

        </div>

    </div>
</nav>