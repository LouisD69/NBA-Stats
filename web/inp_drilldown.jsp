<%@page import="java.util.ArrayList"%>
<%@page import="CCINFOM.Teams"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>NBA - Drilldown</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <!--=== Favicon ===-->
        <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />

        <!--=== Bootstrap CSS ===-->
        <link href="assets/css/bootstrap.min.css" rel="stylesheet">
        <!--=== Slicknav CSS ===-->
        <link href="assets/css/plugins/slicknav.min.css" rel="stylesheet">
        <!--=== Magnific Popup CSS ===-->
        <link href="assets/css/plugins/magnific-popup.css" rel="stylesheet">
        <!--=== Owl Carousel CSS ===-->
        <link href="assets/css/plugins/owl.carousel.min.css" rel="stylesheet">
        <!--=== Gijgo CSS ===-->
        <link href="assets/css/plugins/gijgo.css" rel="stylesheet">
        <!--=== FontAwesome CSS ===-->
        <link href="assets/css/font-awesome.css" rel="stylesheet">
        <!--=== Theme Reset CSS ===-->
        <link href="assets/css/reset.css" rel="stylesheet">
        <!--=== Main Style CSS ===-->
        <link href="style.css" rel="stylesheet">
        <!--=== Responsive CSS ===-->
        <link href="assets/css/responsive.css" rel="stylesheet">
    </head>
    <body class="loader-active" style="background-image: url(assets/img/blackredcar.jpg); background-size: 100% ;">

        <!--== Preloader Area Start ==-->
        <div class="preloader">
            <div class="preloader-spinner">
                <div class="loader-content">
                    <img src="assets/img/preloader.gif" alt="JSOFT">
                </div>
            </div>
        </div>
        <!--== Preloader Area End ==-->
    
        <!--== Header Area Start ==-->
        <header id="header-area" class=" ">
    
            <!--== Header Bottom Start ==-->
            <div id="header-bottom">
                <div class="container">
                    <div class="row">
                        <!--== Logo Start ==-->
                        <div class="col-lg-4">
                            <a href="index.jsp" class="logo">
                                <img src = "assets/img/zero_logo.png">            
                            </a>
                        </div>
                        <!--== Logo End ==-->
    
                    <!--== Logo End ==-->

                    <!--== Main Menu Start ==-->
                    
                    <div class="col-lg-8 d-none d-xl-block">
                        <nav class="mainmenu alignright">
                            <ul>
                                <li><a href="index.jsp">Slice</a> </li>
                                <li><a href="inp_rollup.jsp">Roll Up</a></li>
                                <li><a href="inp_drilldown.jsp">Drill Down</a></li>
                                <li><a href="inp_dice.jsp">Dice</a></li>
                            </ul>
                        </nav>
                    </div>
                   
                    <!--== Main Menu End ==-->
                </div>
            </div>
        </div>
        <!--== Header Bottom End ==-->
    </header>
    <!--== Header Area End ==-->
    <br>
    <br>
    <!--== Login Page Content Start ==-->
    <section id="lgoin-page-wrap" class="  ">
        <div class="container">
            <div class="row">
                <div class="col-lg-5 col-md-8 m-auto">
                	<div class="login-page-content">
                		<div class="login-form">
                                <h1>DRILLDOWN</h1>
                                <br>
                                    <div class="log-btn">
                                        <!--==Put member links here==-->
                                        <form action="process_drilldown.jsp">                      
                                            <div class="username">
                                                <label for="bn"><label>Player Name</label></label>
                                                <input type='text' placeholder='Enter Player Name' name="player" id="pn"/>
                                            </div>
                                            <br>
                                            <div class="log-btn">
                                                    <button type="submit"><i class="fa fa-check-square"></i>Submit</button>
                                            </div>
                                            <br>
                                        </form>
                                    </div>
                		</div>
                	</div>
                </div>
        	</div>
        </div>
    </section>
    <!--== Login Page Content End ==-->

    <!--== Scroll Top Area Start ==-->
    <div class="scroll-top">
        <img src="assets/img/scroll-top.png" alt="JSOFT">
    </div>
    <!--== Scroll Top Area End ==-->

    <!--=======================Javascript============================-->
    <!--=== Jquery Min Js ===-->
    <script src="assets/js/jquery-3.2.1.min.js"></script>
    <!--=== Jquery Migrate Min Js ===-->
    <script src="assets/js/jquery-migrate.min.js"></script>
    <!--=== Popper Min Js ===-->
    <script src="assets/js/popper.min.js"></script>
    <!--=== Bootstrap Min Js ===-->
    <script src="assets/js/bootstrap.min.js"></script>
    <!--=== Gijgo Min Js ===-->
    <script src="assets/js/plugins/gijgo.js"></script>
    <!--=== Vegas Min Js ===-->
    <script src="assets/js/plugins/vegas.min.js"></script>
    <!--=== Isotope Min Js ===-->
    <script src="assets/js/plugins/isotope.min.js"></script>
    <!--=== Owl Caousel Min Js ===-->
    <script src="assets/js/plugins/owl.carousel.min.js"></script>
    <!--=== Waypoint Min Js ===-->
    <script src="assets/js/plugins/waypoints.min.js"></script>
    <!--=== CounTotop Min Js ===-->
    <script src="assets/js/plugins/counterup.min.js"></script>
    <!--=== YtPlayer Min Js ===-->
    <script src="assets/js/plugins/mb.YTPlayer.js"></script>
    <!--=== Magnific Popup Min Js ===-->
    <script src="assets/js/plugins/magnific-popup.min.js"></script>
    <!--=== Slicknav Min Js ===-->
    <script src="assets/js/plugins/slicknav.min.js"></script>

    <!--=== Mian Js ===-->
    <script src="assets/js/main.js"></script>
    
</body>
</html> 