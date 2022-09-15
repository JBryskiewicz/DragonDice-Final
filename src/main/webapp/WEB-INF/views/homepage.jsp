<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="utf-8">
  <title>DragonDice - Home Page</title>
  <meta content="width=device-width, initial-scale=1.0" name="viewport">
  <meta content="" name="keywords">
  <meta content="" name="description">

  <!-- Favicon -->
  <link href="/resources/img/favicon.ico" rel="icon">

  <!-- Google Web Fonts -->
  <link rel="preconnect" href="https://fonts.googleapis.com">
  <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
  <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Roboto:wght@500;700&display=swap" rel="stylesheet">

  <!-- Icon Font Stylesheet -->
  <link href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.0/css/all.min.css" rel="stylesheet">
  <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

  <!-- Libraries Stylesheet -->
  <link href="<c:url value="/resources/lib/owlcarousel/assets/owl.carousel.min.css" />" rel="stylesheet">
  <link href="<c:url value="/resources/lib/tempusdominus/css/tempusdominus-bootstrap-4.min.css" />" rel="stylesheet">
  <!-- Customized Bootstrap Stylesheet -->
  <link href="<c:url value="/resources/css/bootstrap.min.css" />" rel="stylesheet">
  <!-- Template Stylesheet -->
  <link href="<c:url value="/resources/css/style.css" />" rel="stylesheet">
</head>

<body>
<div class="container-fluid position-relative d-flex p-0">
  <!-- Spinner Start -->
  <div id="spinner" class="show bg-dark position-fixed translate-middle w-100 vh-100 top-50 start-50 d-flex align-items-center justify-content-center">
    <div class="spinner-border text-primary" style="width: 3rem; height: 3rem;" role="status">
      <span class="sr-only">Loading...</span>
    </div>
  </div>
  <!-- Spinner End -->


  <!-- Sidebar Start -->
  <div class="sidebar pe-4 pb-3">
    <nav class="navbar bg-secondary navbar-dark">
      <a href="/homepage" class="navbar-brand mx-4 mb-3">
        <h3 class="text-primary"><i class="fa fa-user-edit me-2"></i>DragonDice</h3>
      </a>
      <div class="navbar-nav w-100">
        <a href="/login-section/login" class="nav-item nav-link"><i class="fa fa-keyboard me-2"></i>Sign in</a>
        <a href="/register-section/register" class="nav-item nav-link"><i class="fa fa-keyboard me-2"></i>Sign up</a>
      </div>
    </nav>
  </div>
  <!-- Sidebar End -->

  <!-- Content Start -->
  <div class="content">

    <!-- News Panel -->
    <div class="container-fluid pt-4 px-4">

      <div class="bg-secondary text-center rounded p-4">
        <h3>Description:</h3>
        <h6>
          Project DragonDice is yet another Dungeons & Dragons interactive app for your character's
          sheet. Main goal of this project is to give players more freedom with their creations by
          introducing tools to create and browse everything they need.
          <br/>
          Demo version is planned to be finished before 18th of August 2022
        </h6>
      </div>
    </div>
    <!-- News Panel End -->

    <!-- Footer Start -->
    <div class="container-fluid pt-4 px-4">
      <div class="bg-secondary rounded-top p-4">
        <div class="row">
          <div class="col-12 col-sm-6 text-center text-sm-start">
            &copy; <a href="#">DragonDice</a>, All Right Reserved.
          </div>
          <div class="col-12 col-sm-6 text-center text-sm-end">
            <!--/*** This template is free as long as you keep the footer author’s credit link/attribution link/backlink. If you'd like to use the template without the footer author’s credit link/attribution link/backlink, you can purchase the Credit Removal License from "https://htmlcodex.com/credit-removal". Thank you for your support. ***/-->
            Designed By <a href="https://htmlcodex.com">HTML Codex</a>
            <br>Distributed By: <a href="https://themewagon.com" target="_blank">ThemeWagon</a>
          </div>
        </div>
      </div>
    </div>
    <!-- Footer End -->
  </div>
  <!-- Content End -->


  <!-- Back to Top -->
  <a href="#" class="btn btn-lg btn-primary btn-lg-square back-to-top"><i class="bi bi-arrow-up"></i></a>
</div>

<!-- JavaScript Libraries -->
<script src="https://code.jquery.com/jquery-3.4.1.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0/dist/js/bootstrap.bundle.min.js"></script>
<script src="resources/lib/chart/chart.min.js"></script>
<script src="resources/lib/easing/easing.min.js"></script>
<script src="resources/lib/waypoints/waypoints.min.js"></script>
<script src="resources/lib/owlcarousel/owl.carousel.min.js"></script>
<script src="resources/lib/tempusdominus/js/moment.min.js"></script>
<script src="resources/lib/tempusdominus/js/moment-timezone.min.js"></script>
<script src="resources/lib/tempusdominus/js/tempusdominus-bootstrap-4.min.js"></script>

<!-- Template Javascript -->
<script src="/resources/js/main.js"></script>
</body>

</html>
