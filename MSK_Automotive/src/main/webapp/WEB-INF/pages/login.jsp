<!doctype html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Bike</title>
  <base href="/">

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="icon" type="image/x-icon" href="favicon.ico">
   <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>


<style>
.form-signin
{
    max-width: 330px;
    padding: 15px;
    margin: 0 auto;
}
.form-signin .form-signin-heading, .form-signin .checkbox
{
    margin-bottom: 10px;
}
.form-signin .checkbox
{
    font-weight: normal;
}
.form-signin .form-control
{
    position: relative;
    font-size: 16px;
    height: auto;
    padding: 10px;
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
}
.form-signin .form-control:focus
{
    z-index: 2;
}
.form-signin input[type="text"]
{
    margin-bottom: -1px;
    border-bottom-left-radius: 0;
    border-bottom-right-radius: 0;
}
.form-signin input[type="password"]
{
    margin-bottom: 10px;
    border-top-left-radius: 0;
    border-top-right-radius: 0;
}
.account-wall
{
    margin-top: 20px;
    padding: 40px 0px 20px 0px;
    background-color: #f7f7f7;
    -moz-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    -webkit-box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
    box-shadow: 0px 2px 2px rgba(0, 0, 0, 0.3);
}
.login-title
{
    color: #fff;
    font-size: 18px;
    font-weight: 400;
    display: block;
}
.profile-img
{
    width: 96px;
    height: 96px;
    margin: 0 auto 10px;
    display: block;
    -moz-border-radius: 50%;
    -webkit-border-radius: 50%;
    border-radius: 50%;
}
.need-help
{
    margin-top: 10px;
}
.new-account
{
    display: block;
    margin-top: 10px;
    color:#fff;
}

.banner{
    background: url('https://www.desktop-background.com/p/2010/12/25/131557_import-tuner-car-wallpaper-images_1680x1050_h.jpg');
    background-repeat: no-repeat;
    background-size: 100% auto;
    background-position: center top;
    background-attachment: fixed;
    height:700px;
    text-align: center;
    }
</style>
</head>
<body>

  <div class="banner">
<div class="container">
    <div class="row">
        <div class="col-sm-6 col-md-4 col-md-offset-4">
            <h1 class="text-center login-title">Sign in to continue</h1>
            <div class="account-wall">
                <img class="profile-img" src="https://lh5.googleusercontent.com/-b0-k99FZlyE/AAAAAAAAAAI/AAAAAAAAAAA/eu7opA4byxI/photo.jpg?sz=120"
                    alt="">
                <form class="form-signin" action="msk/login" method="POST"> 
                        <div class="alert alert-danger" style="display:none" [ngStyle]="{display: status == false ? 'block':'none'}">
                                <strong>Invalid!</strong> User name and password 
                        </div>
                        <div class="alert alert-success" style="display:none" [ngStyle]="{display: status == true ? 'block':'none'}">
                                <img src="../assets/loading.gif" width="30px"><br/>
                                <strong> You Successfully Logged Now !</strong>
                        </div>
               
               <div class="form-group">
                <input type="text" class="form-control" name="username"  placeholder="Email" required autofocus>
                </div>
                
                <div class="form-group">
                <input type="password" class="form-control" name="password"  placeholder="Password" required>
               </div>
               
<!--                <div class="form-group" align="left">
               <input type="radio" name="page_type" class="invoice" style="margin-right: 9px" value="invoice"><span class="invoice">Invoice</span>
               <input type="radio" name="page_type" class="spare" style="margin: 0px 9px 0px 42px;" value="spare_parts"><span class="spare">Spare Parts</span>
               </div> -->
               
                <button class="btn btn-lg btn-primary btn-block" type="submit" (click)="login(username,password)">
                    Sign in</button>
                <label class="checkbox pull-left">
                    <input type="checkbox" value="remember-me">
                    Remember me
                </label>
                <a href="#" class="pull-right need-help">Need help? </a><span class="clearfix"></span>
                </form>
            </div>
            <a href="#" class="text-center new-account">Create an account </a>
        </div>
    </div>
</div>
</div>

<script>

$(document).ready(function(){
/* 	$(".invoice").click(function(){
		$(".invoice").trigger("click");
	});
	
	$(".spare").click(function(){
		$(".spare").trigger("click");
	}); */

});
</script>

</body>
</html>
