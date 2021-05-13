<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
  <!DOCTYPE html>
  <html>

  <head>
    <meta charset="utf-8">
    <meta content="width=device-width, initial-scale=1.0" name="viewport">

    <title>Multi Bootstrap Template - Index</title>
    <meta content="" name="description">
    <meta content="" name="keywords">

    <!-- Favicons -->
    <link href="assets/img/favicon.png" rel="icon">
    <link href="assets/img/apple-touch-icon.png" rel="apple-touch-icon">

    <!-- Google Fonts -->
    <link
      href="https://fonts.googleapis.com/css?family=Open+Sans:300,300i,400,400i,600,600i,700,700i|Raleway:300,300i,400,400i,500,500i,600,600i,700,700i|Poppins:300,300i,400,400i,500,500i,600,600i,700,700i"
      rel="stylesheet">

    <!-- Vendor CSS Files -->
    <link href="assets/vendor/bootstrap/css/bootstrap.min.css" rel="stylesheet">
    <link href="assets/vendor/icofont/icofont.min.css" rel="stylesheet">
    <link href="assets/vendor/boxicons/css/boxicons.min.css" rel="stylesheet">
    <link href="assets/vendor/animate.css/animate.min.css" rel="stylesheet">
    <link href="assets/vendor/remixicon/remixicon.css" rel="stylesheet">
    <link href="assets/vendor/venobox/venobox.css" rel="stylesheet">
    <link href="assets/vendor/owl.carousel/assets/owl.carousel.min.css" rel="stylesheet">
    <link href="assets/vendor/aos/aos.css" rel="stylesheet">

    <!-- Template Main CSS File -->
    <link href="assets/css/style.css" rel="stylesheet">

    <!-- =======================================================
  * Template Name: Multi - v2.2.1
  * Template URL: https://bootstrapmade.com/multi-responsive-bootstrap-template/
  * Author: BootstrapMade.com
  * License: https://bootstrapmade.com/license/
  ======================================================== -->
  </head>

  <body>

    <%@ include file="Header.jsp" %>
      <!-- ======= Contact Section ======= -->
      <section id="contact" class="contact section-bg">
        <form action="write" method="POST" enctype="multipart/form-data" role="form" class="php-email-form">

        <div class="container">

            <div class="row">
              <div class="col-lg-6" style="height: 100%">
                <div class="row">
                  <div class="col-md-12">
                    <div class="info-box">
                      <!-- 이미지 뿌려 줄 위치  -->
                      <div>
                        <img src="assets/img/portfolio/file_up.jpg" class="img-thumbnail ri-image-2-fill"
                          alt="이미지 업로드영역">
                      </div>
                      <div style="margin-top: 10px;">
                        <input type="file" name="photo"><br />
                      </div>
                    </div>
                  </div>
                </div>
              </div>
              <!-- 1번 문제 -->
              <div class="col-lg-6" style="height: 100%">
                <div class="form-row">
                  <div class="col form-group">
                    <select class="form-control" name="genre">
                      <option value="음악(영화)">음악(영화)</option>
                      <option value="공포/스릴러">공포/스릴러</option>
                      <option value="다큐멘터리">다큐멘터리</option>
                      <option value="sf판타지">SF판타지</option>
                      <option value="로맨스(영화)">로맨스(영화)</option>
                      <option value="액션(영화)">액션(영화)</option>
                      <div class="validate"></div>
                    </select>
                  </div>
                  <div class="col form-group">
                    <input type="text" class="form-control" name="movieTitle" id="movieTitle" placeholder="영화 이름" />
                    <div class="validate"></div>
                  </div>
                  <div class="col form-group">
                    <input type="text" class="form-control" name="director" id="director" placeholder="영화 감독" />
                    <div class="validate"></div>
                  </div>
                </div>
                <div class="form-group">
                  <div>
                    <input type="text" class="form-control" name="title" id="title" placeholder="제목"
                      data-rule="minlen:4" data-msg="Please enter at least 8 chars of subject" />
                  </div>
                  <div class="validate"></div>
                </div>
                <div class="form-group">
                  <textarea class="form-control" name="content" rows="10" data-rule="required"
                    data-msg="Please write something for us" placeholder="글을 작성해주세요"></textarea>
                  <div class="validate"></div>
                </div>
                <div class="mb-3">
                  <div class="loading">Loading</div>
                  <div class="error-message"></div>
                  <div class="sent-message">Your message has been sent. Thank you!</div>
                </div>
                <div class="text-center"><button type="submit">글쓰기</button></div>

              </div>

            </div>
        </div>
        </form>

      </section><!-- End Contact Section -->

      </main><!-- End #main -->

      <%@ include file="footer.jsp" %>

        <div id="preloader"></div>
        <a href="#" class="back-to-top"><i class="icofont-simple-up"></i></a>

        <!-- Vendor JS Files -->
        <script src="assets/vendor/jquery/jquery.min.js"></script>
        <script src="assets/vendor/bootstrap/js/bootstrap.bundle.min.js"></script>
        <script src="assets/vendor/jquery.easing/jquery.easing.min.js"></script>
        <script src="assets/vendor/waypoints/jquery.waypoints.min.js"></script>
        <script src="assets/vendor/counterup/counterup.min.js"></script>
        <script src="assets/vendor/venobox/venobox.min.js"></script>
        <script src="assets/vendor/owl.carousel/owl.carousel.min.js"></script>
        <script src="assets/vendor/isotope-layout/isotope.pkgd.min.js"></script>
        <script src="assets/vendor/aos/aos.js"></script>

        <!-- Template Main JS File -->
        <script src="assets/js/main.js"></script>

  </body>

  </html>