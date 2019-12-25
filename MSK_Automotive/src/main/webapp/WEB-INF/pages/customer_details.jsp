<!doctype html>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<script src="https://cdn.datatables.net/1.10.16/css/dataTables.bootstrap.min.css"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"></script>  
	<script src="../js/view_customer_details.js"></script>
	<link href="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">   
	<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.7.1/jquery.min.js"></script>
	<link rel="stylesheet" href="http://cdn.datatables.net/1.10.2/css/jquery.dataTables.min.css"></style>
	<script type="text/javascript" src="http://cdn.datatables.net/1.10.2/js/jquery.dataTables.min.js"></script>
	<script type="text/javascript" src="http://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.min.js"></script>
	<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/1.10.16/css/jquery.dataTables.css">
  	<script type="text/javascript" charset="utf8" src="https://cdn.datatables.net/1.10.16/js/jquery.dataTables.js"></script>
	

	<link rel="stylesheet" href="../css/bootstrapValidator.css">
	<script src="../js/bootstrapValidator.js"></script>


</head>
<script>
	$(document).ready(function(){
		$('#myTable').dataTable();
	});
	$(document).ready( function () {
	    $('#table_id').DataTable();
	} );
	$(document).ready(function(){

		$('.add_cust').click(function(){
		   $('.service_add').toggle();
		   $(".add_cust").hide();
		});
		
		$(".service_add_close").click(function(){
			$(".service_add").hide();
			$(".add_cust").show();
		});
	
		$(".service_add_close").click(function(){
			$(".service_add").hide();
		});
	
	$('#add_details').bootstrapValidator(
					{
						framework : 'bootstrap',
						feedbackIcons : {
							
							validating : 'glyphicon glyphicon-refresh'
						},
						fields : {
										cus_name : {
										validators : {
											notEmpty : {
												message : 'Name is required'
											},
										}
									},
									mobile_no: {
						                 validators: {
						                     digits: {
						                         message: 'The phone number can contain digits only'
						                     },
						                     notEmpty: {
						                         message: 'The phone number is required / You might have entered an existing mobile number'
						                     },
						                     stringLength: {
						                         min: 10,
						                         max: 10,
						                         message: 'The phone number must have 10 digits'
						                     },
						                     regexp: {
						                         regexp: /^[789]\d{9}$/i,
						                         message: 'Enter a valid phone number'
						                     }
						                 }
						             },
								    email_id: {
								    	validators: {
						                     notEmpty: 
						                     {
						                         message: 'The email address is empty/not valid or is already registered with us '
						                     },
						                  regexp:{              	 
						                 		regexp: /^(([^<>()[\]\\.,;:\s@\"]+(\.[^<>()[\]\\.,;:\s@\"]+)*)|(\".+\"))@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\])|(([a-zA-Z\-0-9]+\.)+[a-zA-Z]{2,}))$/i,
						                 		message: 'The email address is not a valid'
						                  },
						      			}
						             },
						             service_type: {
						                 validators: {
						                     
						                     notEmpty: {
						                         message: 'The service type is Empty'
						                     },
						                     
						                 }
						             },
						             from_date: {
						                 validators: {
						                     
						                     notEmpty: {
						                         message: 'Pleasea choose the from-date'
						                     },
						                     
						                 }
						             },
						             to_date: {
						                 validators: {
						                     
						                     notEmpty: {
						                         message: 'please choose the to-date'
						                     },
						                     
						                 }
						             },
						             
				        	}
					});     
				            
	
	
		$(".service_details_close").click(function(){
			$(".service_add").hide();
			$(".add").show();
		});

		$(".service_add_close").click(function(){
			$(".service_add").hide();
		});
		$(".service_details_btn").click(function(){
			$(".view_service_details").show();
			//$(".service_details_btn").hide();
			$(".close_btn").show();
		});	
		$(".close_btn").click(function(){
			$(".view_service_details").hide();
			$(".close_btn").hide();
			$(".service_details_btn").show();
		});
		$('#myTable').dataTable( 
				{
				destroy:true,
				"bSort" : false
				} );
	});
	

</script>
<style>
	
	.navbar {
		overflow: hidden;
		background-color: #333;
		position: fixed;
		z-index:1;
		top: 0;
		width: 100%;
	}

	
	.navbar-brand {
		float: left;
		height: auto;
		padding: 25px;
		padding-left:50px;
		font-size: 18px;
		line-height: 20px;
	}
	.main{
		padding: 16px;
		margin-top: 5%;
		height:auto;
		width:90%;
		background-image: url("car-bg.jpg");

	}
	#myTable_filter{
		margin-right:3%;
	}
	#myTable_length{
		margin-left:1%;
	}
	#myTable_wrapper{
		margin-top:3%;
	}
	.thead{
		background-color:#333333;
		color:white;
	}
	
	.navbar-inverse{
		border-radius:0px;
	}
	.t_data{
		margin-left:20%;
		font-size:1.2em;
	}
	.name{
		width:14%;
	}
	.email{
		width:23%;
	}
	.service_details{
		width:12%;
	}
	.btn{

		padding:3px 10px;
		border-radius:0px;
		font-weight:bol;
	}
	.btn:hover{
		background-color:transparent;
		border-radius:0px;
		border:1px solid #31b0d5;
		font-weight:bold;
		color:black;

	}
	input[type=date]{
		border-radius:5px;
		line-height:25px;
		text-align:center;
		
	}
	.save_btn{
		margin-left:41%;	
		margin-top:2%;
		padding:3px 18px;
		font-weight:bold;
		font-size:16;
	}
	.form-control{
		width:75%;
	}
	.vl{
		border-left:1.5px solid #ACACAC;
		height:300px;
		margin-left:2%;
		width:14%;
	}


	.glyphicon-remove-circle{
		cursor:pointer;
		float:right;
		margin-right:4%;
		margin-top:2%;
		font-size:1.5em;
	}


	.glyphicon-plus-sign,.add{
		opacity:0.2;
		font-size:40px;
		
	}
	.glyphicon-plus-sign{
		margin-top:10px;
	
	}
	.add_cust{
		cursor:pointer;
	}
	.has-success .form-control{
		border-color:#3c763d;
	}
	


</style>  
<body>
<%@include file="/WEB-INF/common/header.jsp"%>

<div>
	
	<div>
		<h3>Customer Details</h3>
	</div>
<div class="table-responsive container main">

<!-- Table Starts 
	<table id="myTable" class="display table" width="100%"  >
		<!-- Table header starts

		<thead class="thead" >  
			<tr>  
				<th><h4><center>Customer Service Details</center></h4></th>  
			</tr>  
		</thead>  

		<!-- Table header Ends 
		
		<!-- Table Body starts 
		<tbody>

			<tr class="add_cust">
				<td class="add_cust_details">
					<h4><center><span class="glyphicon glyphicon-plus-sign" style="font-size:36px;"></span><span class="add"><b>ADD</b> </span></center></h4>
				</td>
			</tr>
			
			<tr class="service_add" style="display:none">
				<td>
					<form action="" id="add_details" method="post">	
						<div class="service_add_close "><span class="glyphicon glyphicon-remove-circle"></span></div><br><br>
							<div class="container service_type form-group">
								<div class="row" style="margin-top:2%">
									<div class="col-lg-5" tyle="background-color:red">
										<div class="form-group">
											Enter Customer Name :<input type="text" class="form-control" name="cus_name" id="cus_name" value="">
											<small class="help-block invalid-name" style="color:#a94442"></small>  
										</div><br>
										<div class="form-group">
											Mobile Number : <input type="text" class="form-control" name="mobile_no" id="mobile_no" >	
											<small class="help-block invalid-mob" style="display:none;color:#a94442" data-bv-validator="notEmpty" data-bv-for="email" data-bv-result="VALID" ></small> 
										</div><br>
										<div class="form-group">
											Email Id: <input type="email" class="form-control" name="email_id" id="email_id" >
											<small class="help-block invalid-mail" style="color:#a94442"></small> 
										</div>
									</div>	

									<div class="col-lg-2 vl" tyle="background-color:yellow">
									
									</div>
									<div class="col-lg-5 " tyle="background-color:blue">
										<div class="form-group">										
											Service Type : <input type="email" class="form-control" id="email_id" name="service_type" >
										</div><br>
										<div class="form-group">
											From Date :<input type="date" class="form-control" name="from_date">
										</div><br>
										<div class="form-group">
											To Date :<input type="date" class="form-control" name="to_date">
										</div><br>
										<div class="form-group">
											Details :	<textarea class="form-control" rows="4" id="comment" name="comment"></textarea>
										</div>
									</div>
								</div>
							
										<div class="form-group">
											<div class="col-md-9 col-md-offset-3">
												<div id="messages"></div>
											</div>
										</div>		
							<div class=" ">
								<div class="form-group">
									<button class="btn btn-info save_btn" name="action"> SAVE </button>
								</div>
							</div>
						</form>			
					</td>  
				</tr> 			
							
				<tr>  
					<td >
						<div class="container-fluid "style="display:n">
							<div class="row">
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 name" tyle="border:2px solid red">
									NAME : <label> MANI </label>
								</div>	
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2"  tyle="border:2px solid red">	
									Mobile: <label> 8870134052 </label>
								</div>
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2" tyle="border:2px solid red">
									Customer Id : <label> ID00001 </label>
								</div>
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 email" tyle="border:2px solid blue">
									Email : <label> sankarmani110@gmail.com </label>
								</div>
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2" tyle="border:2px solid red">
									Expires : <label> 15/04/2018 </label>
								</div>
								<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 service_details" tyle="border:2px solid yellow">
									<center>
									<button class="btn btn-info service_details_btn" > View Service Details </button>
									</center>
								</div>
								 <div class="col-lg-2 col-md-2 col-sm-2 col-xs-2 service_details" tyle="border:2px solid yellow;">
									<center>
										<button class="btn btn-info close_btn"style="display:none" > Close</button>
									</center>
								</div>
							</div>
						</div>
					</td>  
				</tr>
				
			</tbody> 
		 </table> -->
		 <table id="table_id" class="display">
    		<thead>
		        <tr>
		            <th>Customer Id</th>
		            <th>Name</th>
		            <th>Mobile no</th>
		            <th>Registration No</th>
		            <th>Last Service</th>
		            <th>GST</th>
		            <th>View</th>
		        </tr>
		    </thead>
		    <tbody>
		    	<c:forEach var="customer" varStatus="counter"  items="${it.data.customer}">
		        <tr>
		            <td>${customer.customer_id}</td>
		            <td>${customer.first_name}</td>
		            <td>${customer.mobile}</td>
		            <td>${customer.registration_no}</td>
		            <td>${customer.expire_service_date}</td>
		            <td>${customer.gst_no}</td>
		            <td>
						<center>
						<button class="btn btn-info service_details_btn" >Next Service</button>
						</center>
					</td>
				</tr>
				</c:forEach>
		        
		    </tbody>
		</table>
		 
	</div>
</div>	
<form action="msk/service-card" method="post">
<input type="hidden" name="customer_id" value="" class="cusId">
<input type="submit" class="serviceCard" style="display: none;">

</form>
<script>
$(document).ready(function(){
	
	$(".service_details_btn").click(function(){
		var id=$(this).closest("tr").find("td:eq(0)").text();
		$(".cusId").val(id);
		$(".serviceCard").trigger("click");
	});
	
});

</script>

</body>    
</html>