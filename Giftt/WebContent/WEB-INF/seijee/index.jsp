<!DOCTYPE html>
<html lang="en">
	<head>
		<meta charset="utf-8">
		<title>Nemaji &amp Guptaji</title>
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<meta name="description" content="">
		<meta name="author" content="">

		<!-- Le styles -->
		<link href="./css/bootstrap.css" rel="stylesheet" />
		<link href="./css/metro.css" rel="stylesheet" />

		<!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
		<!--[if lt IE 9]>
			  <script src="../js/html5shiv.js"></script>
			<![endif]-->

		<!-- Fav and touch icons -->
		<link rel="apple-touch-icon-precomposed" sizes="144x144"
			  href="./ico/apple-touch-icon-144-precomposed.png">
		<link rel="apple-touch-icon-precomposed" sizes="114x114"
			  href="./ico/apple-touch-icon-114-precomposed.png">
		<link rel="apple-touch-icon-precomposed" sizes="72x72"
			  href="./ico/apple-touch-icon-72-precomposed.png">
		<link rel="apple-touch-icon-precomposed"
			  href="./ico/apple-touch-icon-57-precomposed.png">
		<link rel="shortcut icon" href="./ico/favicon.png">
	</head>

	<body>
		<%@include file="_navbar.jsp" %>
		<!-- Carousal -->
		<div class="col-xs-10 col-xs-offset-1">
			<div class="">
				<a href="#TopGifts" class="btn btn-lg btn-info">Top Gifts this Season...</a>

				<div id="myCarousel" class="carousel slide" data-ride="carousel">
					<ol class="carousel-indicators">
						<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
						<li data-target="#myCarousel" data-slide-to="1"></li>
						<li data-target="#myCarousel" data-slide-to="2"></li>
					</ol>
					<!-- Carousel items -->
					<div class="carousel-inner" style="min-height: 400px; background-color: green;">
						<div class="active item" style="background-image: url('https://lh4.googleusercontent.com/-uevlEm7JvTw/TvYpq00uyNI/AAAAAAAAAQY/DrhAdIevyaI/w800-h800/merry_christmas_2012-wide.jpg'); background-size:cover; background-position: center; height: 400px;  ">
						</div>
						<div class="item" style="background-image: url('https://lh6.googleusercontent.com/-ynKvFdrsimc/UOHIjPToqJI/AAAAAAAAAOk/O9Z_Cwi6r5c/w800-h800/2013-happy-new-year-wallpapers-%25287%2529.jpg'); background-size:cover; background-position: center; height: 400px;  ">
						</div>
						<div class="item" style="background-image: url('http://christmasstockimages.com/free/objects/slides/wrapped_gift.jpg'); background-size:cover; background-position: center; height: 400px;  ">
						</div>
					</div>
					<!-- Controls -->
					<a class="left carousel-control" href="#myCarousel" data-slide="prev">
						<span class="glyphicon glyphicon-chevron-left"></span>
					</a>
					<a class="right carousel-control" href="#myCarousel" data-slide="next">
						<span class="glyphicon glyphicon-chevron-right"></span>
					</a>
				</div>
			</div>


			<span id="TopGifts" class="anchor"></span>
			<hr/><h3>TOP GIFTS THIS SEASON</h3>
			<div class="metro row">
				<div class="col-xs-4">
					<div class="tile-padding big">
						<div class="tile" style="background-image: url('http://www.ducttapemarketing.com/blog/wp-content/uploads/2013/06/Gift.jpg'); ">
						</div>
					</div>
				</div>
				<div class="col-xs-4">
					<div class="tile-padding">
						<div class="tile" style="background-image: url('http://www.ducttapemarketing.com/blog/wp-content/uploads/2013/06/Gift.jpg'); ">
						</div>
					</div>
				</div>
				<div class="col-xs-2">
					<div class="tile-padding">
						<div class="tile" style="background-image: url('http://www.ducttapemarketing.com/blog/wp-content/uploads/2013/06/Gift.jpg'); ">
						</div>
					</div>
				</div>
				<div class="col-xs-2">
					<div class="tile-padding">
						<div class="tile" style="background-image: url('http://www.ducttapemarketing.com/blog/wp-content/uploads/2013/06/Gift.jpg'); ">
						</div>
					</div>
				</div>
				<div class="col-xs-2">
					<div class="tile-padding">
						<div class="tile" style="background-image: url('http://www.ducttapemarketing.com/blog/wp-content/uploads/2013/06/Gift.jpg'); ">
						</div>
					</div>
				</div>
				<div class="col-xs-2">
					<div class="tile-padding">
						<div class="tile" style="background-image: url('http://www.ducttapemarketing.com/blog/wp-content/uploads/2013/06/Gift.jpg'); ">
						</div>
					</div>
				</div>
				<div class="col-xs-2">
					<div class="tile-padding">
						<div class="tile" style="background-image: url('http://www.ducttapemarketing.com/blog/wp-content/uploads/2013/06/Gift.jpg'); ">
						</div>
					</div>
				</div>
				<div class="col-xs-2">
					<div class="tile-padding">
						<div class="tile" style="background-image: url('http://www.ducttapemarketing.com/blog/wp-content/uploads/2013/06/Gift.jpg'); ">
						</div>
					</div>
				</div>
				<div class="col-xs-2">
					<div class="tile-padding">
						<div class="tile" style="background-image: url('http://www.ducttapemarketing.com/blog/wp-content/uploads/2013/06/Gift.jpg'); ">
						</div>
					</div>
				</div>
			</div>





			<hr />

			<footer>
				<p>&copy; nemaji-guptaji 2013</p>
			</footer>

		</div>
		<!--/.fluid-container-->

		<!-- Le javascript>
		================================================== 
		<!-- Placed at the end of the document so the pages load faster -->

		<script src="./js/jquery.js"></script>
		<script src="./js/bootstrap.min.js"></script>
		<script src="./js/drophover.js"></script>
		<script>
			$(document).ready(function() {
				if ($('body').width()>768)
					$('.js-activated').dropdownHover().dropdown();
				$menu = $('.dropdown-menu');
				//$menu.css('min-width', ($('body').width()*0.4)+'px');
			});
			$(window).resize(function() {
				$menu = $('.dropdown-menu');
				//$menu.css('min-width', ($('body').width()*0.4)+'px');
			});
			function search(){
				var s = document.getElementById("search");
				if (s.className.indexOf("open")<0){
					$('#search').removeClass('closed');
					$('#search').addClass('open');
				}else{
					$('#search').removeClass('open');
					$('#search').addClass('closed');
				}
			}
		</script>


	</body>
</html>
