<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
	<!-- Bootstrap core CSS -->
	    <link href="css/bootstrap.min.css" rel="stylesheet" >
	    <!-- Bootstrap theme -->
	    <link href="css/bootstrap-theme.min.css" rel="stylesheet">
		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
		<meta http-equiv="x-ua-compatible" content="ie=edge">
		<title>Material Design Bootstrap</title>
		<!-- Font Awesome -->
		<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.11.2/css/all.css">
		<!-- Material Design Bootstrap -->
		<link href="/css/mdb.min.css" rel="stylesheet">
		<!-- Your custom styles (optional) -->
		<link href="/css/style.min.css" rel="stylesheet">
		<link href="/css/style.css" rel="stylesheet">
	</head>
	<body>

		<div class="container">
			<div class="row justify-content-md-center">
				<div class="col-md-8 mt-5">
					<!-- Material form login -->
					<div class="card">

					<h5 class="card-header info-color white-text text-center py-4">
						<strong>Inicio de sesion</strong>
					</h5>

					<!--Card content-->
					<div class="card-body px-lg-5 pt-0">

						<!-- Form -->
							<c:choose>
								<c:when test="${not empty next}">
									<form:form class="text-center" style="color: #757575;" action="validar-login?next=${next}" method="POST" modelAttribute="usuario">
										<!-- Email -->
										<div class="md-form">
											<form:input path="email" type="email" id="materialLoginFormEmail" class="form-control" />
											<label for="materialLoginFormEmail">E-mail</label>
										</div>

										<!-- Password -->
										<div class="md-form">
											<form:input path="password" type="password" id="materialLoginFormPassword" class="form-control"/>
											<label for="materialLoginFormPassword">Password</label>
										</div>

										<div class="d-flex justify-content-around">
											<div>
												<!-- Remember me -->
												<div class="form-check">
													<input type="checkbox" class="form-check-input" id="materialLoginFormRemember">
													<label class="form-check-label" for="materialLoginFormRemember">Remember me</label>
												</div>
											</div>
											<div>
												<!-- Forgot password -->
												<a href="">Forgot password?</a>
											</div>
										</div>

										<!-- Sign in button -->
										<button class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0" type="submit">Sign in</button>

										<!-- Register -->
										<p>Not a member?
											<a href="">Register</a>
										</p>

										<!-- Social login -->
										<p>or sign in with:</p>
										<a type="button" class="btn-floating btn-fb btn-sm">
											<i class="fab fa-facebook-f"></i>
										</a>
										<a type="button" class="btn-floating btn-tw btn-sm">
											<i class="fab fa-twitter"></i>
										</a>
										<a type="button" class="btn-floating btn-li btn-sm">
											<i class="fab fa-linkedin-in"></i>
										</a>
										<a type="button" class="btn-floating btn-git btn-sm">
											<i class="fab fa-github"></i>
										</a>

									</form:form>
								</c:when>
								<c:otherwise>
									<form:form class="text-center" style="color: #757575;" action="validar-login" method="POST" modelAttribute="usuario">
										<!-- Email -->
										<div class="md-form">
											<form:input path="email" type="email" id="materialLoginFormEmail" class="form-control" />
											<label for="materialLoginFormEmail">E-mail</label>
										</div>

										<!-- Password -->
										<div class="md-form">
											<form:input path="password" type="password" id="materialLoginFormPassword" class="form-control"/>
											<label for="materialLoginFormPassword">Password</label>
										</div>

										<div class="d-flex justify-content-around">
											<div>
												<!-- Remember me -->
												<div class="form-check">
													<input type="checkbox" class="form-check-input" id="materialLoginFormRemember">
													<label class="form-check-label" for="materialLoginFormRemember">Recordarme</label>
												</div>
											</div>
											<div>
												<!-- Forgot password -->
												<a href="">olvidaste la contraseña?</a>
											</div>
										</div>

										<!-- Sign in button -->
										<button class="btn btn-outline-info btn-rounded btn-block my-4 waves-effect z-depth-0" type="submit">Iniciar sessión</button>

										<!-- Register -->
										<p>No estas registrado?
											<a href="">Reistrar</a>
										</p>

										<!-- Social login -->
										<p>o inciar con:</p>
										<a type="button" class="btn-floating btn-fb btn-sm">
											<i class="fab fa-facebook-f"></i>
										</a>
										<a type="button" class="btn-floating btn-tw btn-sm">
											<i class="fab fa-twitter"></i>
										</a>
										<a type="button" class="btn-floating btn-li btn-sm">
											<i class="fab fa-linkedin-in"></i>
										</a>
										<a type="button" class="btn-floating btn-git btn-sm">
											<i class="fab fa-github"></i>
										</a>
									</form:form>
								</c:otherwise>
							</c:choose>

						<!-- Form -->

					</div>

				</div>
					<!-- Material form login -->
				</div>
			</div>
		</div>
		
		<!-- Placed at the end of the document so the pages load faster -->
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js" ></script>
		<script>window.jQuery || document.write('<script src="../../assets/js/vendor/jquery.min.js"><\/script>')</script>
		<script src="js/bootstrap.min.js" type="text/javascript"></script>
		<script type="text/javascript" src="/js/jquery-3.4.1.min.js"></script>
		<!-- Bootstrap tooltips -->
		<script type="text/javascript" src="/js/popper.min.js"></script>
		<!-- MDB core JavaScript -->
		<script type="text/javascript" src="/js/mdb.min.js"></script>
		<!-- Initializations -->
		<script type="text/javascript">
			// Animations initialization
			new WOW().init();

		</script>
	</body>
</html>
