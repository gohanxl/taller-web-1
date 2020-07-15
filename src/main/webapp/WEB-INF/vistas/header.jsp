<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page session="true" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

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
    <link href="/css/style-general.css" rel="stylesheet">
    <link href="/css/addons/rating.css" rel="stylesheet">
    <style>
        html {
            margin: 0 !important;
            padding: 0 !important;
            height: 100% !important;
        }

        body {
            height: auto !important;
            min-height: 100% !important;
            position: relative !important;
        }

        main {
            padding-bottom: 200px !important;
        }

        footer {
            width: 100% !important;
            position: absolute !important;
            bottom: 0 !important;
            left: 0 !important;
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
                <li class="nav-item" id="home">
                    <a class="nav-link waves-effect" href="/">Home
                        <span class="sr-only">(current)</span>
                    </a>
                </li>
                <c:if test="${not empty USERNAME}">
                    <li class="nav-item" id="biblioteca">
                        <a class="nav-link waves-effect" href="/biblioteca">Biblioteca</a>
                    </li>
                    <li class="nav-item" id="publicaciones">
                        <a class="nav-link waves-effect" href="/publicaciones">Publicaciones</a>
                    </li>
                    <li class="nav-item" id="publicar">
                        <a class="nav-link waves-effect" href="/publicar">Publicar</a>
                    </li>
                </c:if>
                <li class="nav-item">
                    <form:form method="GET" action="/buscar"
                               class="form-inline d-flex justify-content-center md-form form-sm my-0 ml-3">
                        <input class="form-control form-control-sm mr-3 w-75" type="text" name="nombre"
                               placeholder="Buscar" aria-label="Search">
                        <i class="fas fa-search" aria-hidden="true"></i>
                    </form:form>
                </li>
            </ul>

            <!-- Right -->
            <ul class="navbar-nav nav-flex-icons">
                <c:choose>
                    <c:when test="${not empty USERNAME}">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" id="navbarDropdownMenuLink-4" data-toggle="dropdown"
                               aria-haspopup="true" aria-expanded="false">
                                <i class="fas fa-user"></i> <%= session.getAttribute("USERNAME") %>
                            </a>
                            <div class="dropdown-menu dropdown-menu-right dropdown-info"
                                 aria-labelledby="navbarDropdownMenuLink-4">
                                <a class="dropdown-item" href="/mi-cuenta">Mi cuenta</a>
                                <a class="dropdown-item" href="/cerrar-sesion">Cerrar sesion</a>
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
<script>
    window.addEventListener('load', function () {
        // const navItems = document.getElementsByClassName('nav-item');
        //
        // for (let i = 0; i < navItems.length; i++) {
        //     navItems[i].addEventListener('click', function () {
        //         const current = document.getElementsByClassName("active");
        //         console.log('current', current)
        //         if (current.length > 0) {
        //             current[0].className = current[0].className.replace(" active", "");
        //         }
        //         console.log('s', this)
        //         this.className += " active";
        //     })
        // }

        const pathName = window.location.pathname;

        const parsedPathname = pathName.replace("/", "");

        switch (parsedPathname) {
            case '':
                document.getElementById("home").className += " active"
                break;
            case 'biblioteca':
                document.getElementById("biblioteca").className += " active"
                break;
            case 'publicaciones':
                document.getElementById("publicaciones").className += " active"
                break;
            case 'publicar':
                document.getElementById("publicar").className += " active"
                break;
            default:
                break;
        }
    })

</script>