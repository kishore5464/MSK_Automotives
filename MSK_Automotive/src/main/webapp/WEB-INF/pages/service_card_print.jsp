<!DOCTYPE html>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en"><head>
  <meta charset="utf-8">
  <title>MSK Automotive</title>
  <base href="/">

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="icon" type="image/x-icon" href="favicon.ico">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="icon" type="image/x-icon" href="favicon.ico">
  <link rel="stylesheet" href="../css/carbrands.css">
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

</head>
<style>
p {
    margin: 0 0 3px;
    font-size: 12px;
}

.form-control {
	    border: 1px solid #fff;
	    height:15px;
}


th{
padding: 4px 6px;
}
</style>
<body>
<%@include file="/WEB-INF/common/header.jsp"%>

<h5>${it.data}</h5>

<div class="">
	<h3 style="color:blue;" align="center"><span style="padding-left: 232px;">Job Card - MSK Automotive </span><span style="padding-right: 33px;font-size: 20px;" class="pull-right">Service No: ${it.data.customer_detail.invoice_no}</span></h3>
	<h1 align="right"></h1>


<div class= "col-lg-12 col-xs-12" style="border: 1px solid #5757e8; border-radius: 10px;">


<div class="col-lg-12 col-xs-12" style="border-bottom:1px solid blue;padding-bottom: 12px;">

<div class="col-lg-6 col-xs-6">
	<p>#215, Mambakkam Main Road,</p>
	<p>Sithalapakkam Housing Board, Chennai - 600 073 (Near Indian Oil Petrol Bunk)</p>
	<p>Cell : +91 880 777 8808 / +91 9944 111 771</p>
	<p>email: mskautomotives@gmail.com</p>

</div>

<div class="col-lg-6 col-xs-6" style="border-left:1px solid blue">
<p>Customer Detail :</p>

<p>${it.data.customer_detail.name}, +91 ${it.data.customer_detail.mobile}</p>
<p>${it.data.customer_detail.address_line}, ${it.data.customer_detail.city} - ${it.data.customer_detail.pincode}</p>	
<p>Reg No: ${it.data.customer_detail.registration_no}</p>
<p>Engine No: <span class="engNo">${it.data.customer_detail.engine_no}</span></p>
<p>Kms: <input type="text" name="kms"></p>

</div>
</div>






<div class="col-lg-12 col-xs-12" style="border-bottom:1px solid blue">
<h5>Service Details</h5>

<table class="table-striped table-bordered" width="100%" style="margin-bottom: 2%">
	<thead>
<tr>
	<th width="50%">Service Name</th>
	<th width="15%">Quantity</th>
	<th width="15%">Price per Unit</th>
	<th width="15%">Amount</th>
</tr>
</thead>

<tbody>
	<tr>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
	</tr>
	<tr>
			<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
	</tr>
	<tr>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
	</tr>


	<tr>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
	</tr>
		<tr>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
	</tr>
		<tr>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
	</tr>
		<tr>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
	</tr>
		<tr>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
	</tr>
		<tr>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
	</tr>
		<tr>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
	</tr>
		<tr>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
	</tr>
		<tr>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
	</tr>

			<tr>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
	</tr>


			<tr>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
	</tr>


			<tr>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
	</tr>

			<tr>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
	</tr>

			<tr>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
	</tr>

			<tr>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
		<td><input class="form-control" type="text"></td>
	</tr>



	<tr>
		<td></td>
		<td></td>
		<td>Total Amount</td>
		<td>Rs. 2000/-</td>
	</tr>

</tbody>

	</table>


</div>



<div class="col-lg-12 col-xs-12" style="border-bottom: 1px solid blue ">


<div class="col-lg-4  col-xs-4" style="border-right:1px solid blue">
<h5>Estimations</h5>
<p>Service Date: 23-05-1290</p>
<p>Delivery Date: 23-05-1290</p>
<p>Estimated Amount: Rs. 2332/-</p>
<p>Service Adviser: Viswa</p>
<p>Mobile No.: 989838398</p>


</div>

<div class="col-lg-4  col-xs-4">
	
<img src="../images/car1.png" style="padding-top: 12px;">
</div>

<div class="col-lg-4   col-xs-4" style="border-left:1px solid blue">


	
<table class="col-lg-12  col-xs-12">

<tr>
<td>Tool Kit</td>
<td><input type="radio">Yes <input type="radio">No</td>
</tr>

<tr>
<td><div>Spare wheel</div></td>
<td><input type="radio">Yes <input type="radio">No</td>
</tr>

<tr>
<td><div>Jack</div></td>
<td><input type="radio">Yes <input type="radio">No</td>
</tr>

<tr>
<td><div>Jack Handle</div></td>
<td><input type="radio">Yes <input type="radio">No</td>
</tr>

<tr>
<td><div>C.D Player</div></td>
<td><input type="radio">Yes <input type="radio">No</td>
</tr>

<tr>
<td><div>Mats</div></td>
<td><input type="radio">Yes <input type="radio">No</td>
</table>

<div align="center" style="position: relative; top: 7px; right: 18px;"><img src="../images/fuel.png" width="47%"></div>

</div>
</div>

<div class="col-lg col-xs-12" style="border-bottom:1px solid blue;padding-top: 8px;">
<p class="col-lg-12  col-xs-12"> I hereby authorize for the above repairs to be executed using necessary materials and I am affixing signature below in evidence of agreeing to the terms & conditions given in the reverse side of the repair order absolutely and unconditionally.</p>

<p class="pull-right" style="padding-top:1%">Customer Signature</p>
</div>


<div class="col-lg-12  col-xs-12">

<div class="col-lg-4  col-xs-4" style="border-right:1px solid blue;padding-top: 12px;">
	<p align="center">Delivered By:</p>

<p>Name : </p>
<p style="padding-bottom: 36px;">Date : </p>
</div>

<div class="col-lg-4  col-xs-4"  style="padding-top: 12px;">
	
<p align="center">Final Inspection: Ok/ Not Ok</p>

<p>Name : </p>
<p style="">Signature : </p>
</div>


<div class="col-lg-4  col-xs-4" style="padding-top: 12px;border-left:1px solid blue;">
	<p>I hereby certify that the repairs have been carried out to my entire satisfaction</p>

	<p>Date : </p>


<div class="pull-right" style="padding-top:1%">Customer Signature</div>

</div>


</div>

</div>
</div>

<button type="button" class="choose">Close</button>
<button type="button" class="choose">Submit</button>
<button type="button" class="choose">Print</button>
<script>
$(document).ready(function(){
	
	if($(".engNo").text() == "not available"){
		$(".engNo").text('');
		$(".engNo").append('<input type="text" name="engineNo">');
	}
});

</script>
</body>
</html>
