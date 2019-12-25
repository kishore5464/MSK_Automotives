
<html><head><title>MSK Automotive</title>
<meta charset="utf-8">
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script>
</script>
<style>
.nav{
margin-top:0px;
margin-bottom:4px;
}
h1{
color: #fff;
    font-size: 42px;
    font-weight: bold;
}
.carousel-caption-box{

    margin: 0 auto;
	
	text-shadow:none;
	color:black;
	bottom:38%;
	font-family:Helvetica;
	}

.btn1,.btn2{
	background-color:#1FABE3;
	color:white;
	font-weight:bold;
	border-radius:0px;
	padding:10px 30px 10px 30px;
	border:1px solid #1FABE3;
	margin:0 2.5%;
	margin-top:2%;
}
.btn2{
	background-color:#B4B4B4;
	border:1px solid #B4B4B4;
}	
.btn1:hover,.btn2:hover,.btn1:focus,.btn2:focus,.btn1:active,.btn2:active{
	background-color:#fff;
	border:0px solid #fff;
	color:black;
}
.carousel-inner>.item>a>img, .carousel-inner>.item>img, .img-responsive, .thumbnail a>img, .thumbnail>img {
    display: block;
    max-width: 100%;
    height: 662px;
}
.bg-img img{
	width:100%;
}
@media only screen and (min-width:750px) and (max-width:1020px)
{
.carousel-caption-box{
    max-width: 450px;
    margin: 0 auto;
	bottom:25%;
	}
	
}
@media only screen and (min-width:600px) and (max-width:750px)
{
.carousel-inner>.item>a>img, .carousel-inner>.item>img, .img-responsive, .thumbnail a>img, .thumbnail>img {
    display: block;
    max-width: 100%;
    height: auto;
}
.carousel-caption-box{
    max-width: 350px;
    margin: 0 auto;
	bottom:20%;
	
	}
h1{
	font-size:2em;
	}
h4{
	font-size:16px;
	}
.btn-lg{
	font-size:14px;
	}
}
@media only screen and (min-width:300px) and (max-width:425px)
{
.carousel-inner>.item>a>img, .carousel-inner>.item>img, .img-responsive, .thumbnail a>img, .thumbnail>img {
    display: block;
    max-width: 100%;
    height: auto;
}
.carousel-caption-box{
    max-width: 200px;
    margin: 0 auto;
	bottom:15%;
	padding-top:0px;
	padding-bottom:10px;
	}
	.btn1, .btn2{
	padding:10px;
	}
h1{
	font-size:1.2em;
	text-align:center;
	}
h4{
	font-size:8px;
	}
.btn-lg{
	font-size:10px;
	}

}
@media only screen and (min-width:425px) and (max-width:600px)
{
.carousel-inner>.item>a>img, .carousel-inner>.item>img, .img-responsive, .thumbnail a>img, .thumbnail>img {
    display: block;
    max-width: 100%;
    height: 662px;
}
.carousel-caption-box{
    max-width: 230px;
    margin: 0 auto;
	bottom:20%;
	padding-top:0px;
	padding-bottom:10px;
	}
	.btn1, .btn2{
	padding:10px;
	}
h1{
	font-size:1.3em;
	}
h4{
	font-size:10px;
	}
.btn-lg{
	font-size:12px;
	}
.bg_img{
	height:1000px;
	}
}
@media only screen and (min-width:1445px) and (max-width:2575px)
{

.carousel-inner>.item>a>img, .carousel-inner>.item>img, .img-responsive, .thumbnail a>img, .thumbnail>img {
    display: block;
    max-width: 100%;
    height: auto;
}
.carousel-caption-box{
    max-width: 1000px;
    margin: 0 auto;
	bottom:40%;
	
	}
	.btn1, .btn2{
	padding:15px 40px 15px 40px;
	}
h1{
	font-size:5em;
	}
h4{
	font-size:2.5em;
	}
.btn-lg{
	font-size:2.5em;
	}
.bg_img{
	height:1000px;
	}

}


</style>
</head>

<body>
<div>
	<!-- <div class="container-fluid">
		 <h1 class="nav"><img class="logo" src="http://talentex.in/images/MAINLOGO.png" width="200px" style="margin-left:7%"></h1>
	</div> -->
	<div id="carousel-company-bg" class="carousel slide">
		<center>
		<div class="carousel-caption carousel-caption-box carousel-width">
			<div class="carousel-title">
				<h1>We take care of your CAR</h1>
				

			<button type="button" class="btn btn-primary btn-lg btn1 chk_btn_status" id="invoice">Invoice</button>
			
		 	<button type="button" class="btn btn-primary btn-lg btn1" id="spare">Spare Parts</button>

			<!-- <button type="button" class="btn btn-primary btn-lg btn1 chk_btn_status" id="spare">Spare Partsss</button>&nbsp;&nbsp;&nbsp; -->

				
			</div>
		</div></center>
		<div class="carousel-inner ">
			<div class="item active bg-img">
				<img src="../images/RR.jpg" style="" alt=""/>										
			</div>
		</div>
	</div>
	
</div>

<form action="service-invoice" method="post" style="display:none">
<input type="hidden" name="invoice_status" value="open"> 
<input type="submit" class="invoicebtn">
</form>

<form action="spare-parts" method="post" style="display:none">
<input type="hidden" name="stock_status" value="instock"> 
<input type="submit" class="sparebtn">
</form>

<script>
$(document).ready(function(){
	$('#spare').click(function(){
		$('.sparebtn').trigger('click');	
	});
	
	$('#invoice').click(function(){
		$('.invoicebtn').trigger('click');	
	});
	
})
</script>
</body></html>