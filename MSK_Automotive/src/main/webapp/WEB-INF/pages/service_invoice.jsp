<!DOCTYPE html>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en"><head>
  <meta charset="utf-8">
  <title>Car</title>
  <base href="/">

  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="icon" type="image/x-icon" href="favicon.ico">
<link rel="stylesheet" href="../css/bootstrap.css">
<meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="icon" type="image/x-icon" href="favicon.ico">
  <link rel="stylesheet" href="../css/carbrands.css">
<link rel="stylesheet" href="../css/bootstrap.min.css">
<link rel="stylesheet" href="../css/bootstrap-select.min.css">
 <link rel="stylesheet" href="http://code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
<link rel="stylesheet" href="../css/carbrands.css">
<link rel="stylesheet" href="../css/spareparts.css">
  <script src="../js/jquery-3.2.1.min.js"></script>
  <script src="../js/bootstrap.min.js"></script>
   <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
<style>


</style>

</head>
   
<body>
<%@include file="/WEB-INF/common/header.jsp"%>

<div class="col-lg-12">
<div class="container">
<%-- 
<h6>${it.data}</h6> --%>
<%--  <c:forEach var="models" varStatus="counter"  items="${it.data.spare_parts}">

</c:forEach>  --%>

<!-- <table id="customers">
  <tr>
    <th>Brand</th>
    <th>Modal</th>
    <th>Part</th>
    <th>Quality</th>
     <th>Price</th>
  </tr>
  
  <tr class="customershead">
    <td>
    <div class="form-group group group1 form-feilds inputstyle" style="max-width:126px">


     <select class="selectpicker brandlist" data-show-subtext="true" data-live-search="true" id="car_brands" name="notice" required>
      <option value="" selected disabled>Select Brand</option>
     
      </select>

    </div>
    </td>
    
    <td>
    <div class="form-group group group1 form-feilds inputstyle ui-widget" style="max-width:126px">
   
      <select class="selectpicker modallist" data-show-subtext="true" data-live-search="true" id="car_modals" name="notice" required>
      <option value="" selected disabled>Select Modal</option>     
      </select>
      
    </div>
    </td>
    <td>
    <div class="form-group group group1 form-feilds inputstyle ui-widget" style="max-width:180px">
    <input name="location" value="" required="" class="parts_name" autocomplete="off" placeholder="Part Name" style="width:322px">
    <span class="highlight"></span> <span class="bar barpass"></span>
    </div>
    
    <button class="btn btn-success chk_stock" value="check" style="float:right">check stock</button>
    <img src="../images/loading.gif" id="loading" width="30px" style="float:right;display:none">
    </td>
     <td>
     <div class="form-group group group1 form-feilds inputstyle inputstyle2 ui-widget" style="width:64px">
    <input name="quantity"  id="quantity" disabled value="" required="" class="disableoption" autocomplete="off" placeholder="quantity" style="max-width:110px;position:relative;top:-15px">
    <span class="highlight"></span> <span class="bar barpass barpass2"></span>
    </div>
     </td>
      <td>
      <div class="form-group group group1 form-feilds inputstyle inputstyle2 ui-widget" style="max-width:50px">
    <input name="price" id="price" disabled value="" required="" class="disableoption" autocomplete="off" placeholder="price" style="max-width:110px">
    <span class="highlight"></span> <span class="bar barpass barpass2"></span>
   
    </div>
      <button class="btn btn-success" id="add_btn" value="check" style="float:right">ADD</button>
      </td>
      
  </tr>
 
</table>
 -->
<div id='cssmenu' style="margin-top:0%">
<ul>
   <li class="open"><a class="stock">Open Job Card</a></li>
   <li class="closed"><a class="stock">Closed Job Card</a></li>
   <li class="billed"><a class="stock">Billed Job Card</a></li>

</ul>
</div>

<table id="customers">
  <tr>
    <th>Card No.</th>
    <th>Customer Name</th>
    <th>Customer Mobile</th>
    <th>Brand</th>
    <th>Modal</th>
     <th>Reg. No.</th>
   	<th>Service Type</th>
    <th>In Date</th>
     <th>Total Amount</th>
     <th>Next</th>
  </tr>
   <c:forEach var="parts" varStatus="counter"  items="${it.data.card_details}">

 <tr>
   <td>${parts.job_card_id}</td>
    <td>${parts.customer_name}</td>
     <td>${parts.customer_mobile}</td>
    <td>${parts.brand}</td>
    <td>${parts.model}</td>
     <td>${parts.registration_no}</td>
     <td>${parts.service_type}</td>
     <td>${parts.service_date}</td>
      <td>${parts.total_amount}</td>
       <td><a href="">Close</a> / <a href="">Re-Open</a></td>
      
  </tr>
  </c:forEach> 
  
 
</table>
   
</div>
</div>


  

      
 <form action="msk/service-invoice" method="post" style="display:none">
<input type="hidden" name="invoice_status"  class ="invoice_status">
<input type="submit" class="invoiceSub">
</form>
    <div style="display:none">
    <div class="page_data">${it.data}</div>
    <div class="page_stockstatus">${it.data.stock_status}</div>
    </div>
    <script src="../js/spareparts.js"></script>
    <script src="../js/bootstrap-select.min.js"></script>
    
<script type="text/javascript">
$(document).ready(function(){
	
	$(".closed").click(function(){
		$('.invoice_status').val("closed");
		$('.invoiceSub').trigger('click');
	});
	$(".open").click(function(){
		$('.invoice_status').val("open");
		$('.invoiceSub').trigger('click');
	});
	
	$(".billed").click(function(){
		$('.invoice_status').val("billed");
		$('.invoiceSub').trigger('click');
	});
	
	$(".newcar_upload").click(function(){
		
	$("#new_logo").val($("#textAreaFileContents").text());

	$('.submit_logo').trigger('click');
	
	});
	
	
});

</script>
</body></html>