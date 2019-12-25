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

<table id="customers">
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

<div id='cssmenu' style="margin-top:5%">
<ul>
   <li class="instock"><a class="stock">In Stock</a></li>
   <li class="outstock"><a class="stock">Outstock</a></li>
   <li class="notavailable"><a class="stock">Not Purchased</a></li>

</ul>
</div>

<table id="customers">
  <tr>
    <th>S.No</th>
    <th>Brand</th>
    <th>Modal</th>
    <th>Part</th>
    <th>Quality</th>
     <th>Price</th>
  </tr>
   <c:forEach var="parts" varStatus="counter"  items="${it.data.spare_parts}">

 <tr>
   <td>${parts.id}</td>
    <td>${parts.brand}</td>
    <td>${parts.model}</td>
    <td>${parts.spare_part_name}</td>
     <td>${parts.quantity}</td>
      <td>${parts.price_per_unit}</td>
      
  </tr>
  </c:forEach> 
  
 
</table>
   
</div>
</div>


  
<!-- Model Content End -->
<form name="submitForm" method="POST" id="menuurl" action=""
		style="display: none;">
		 <input type="hidden" name="models_id" id="modelsid" value="">
		
		 <input type="hidden" name="applicationState" id="formapplicationState"
			value='${it.applicationStateJson}'> <input type="hidden"
			name="job_id" id="form_job_id" value=''> <a
			href="javascript:document.submitForm.submit()" id="formsubmit"></a>

    </form>
<form  method="POST" action="msk/upload-model" style="display: none;">
		 <input type="hidden" name="models_id" class="modelsid" value="">
		  <input type="hidden" name="image" id="image" value=""> 
			<input type="button" id="subImage" > 
    </form>
    
    
    <form  method="POST" action="msk/update-spare-part" style="display: none;">
		  <input type="hidden" name="spare_part_id" id="sparepart_id" class="" value="">
		  <input type="hidden" name="part" id="part_name" value=""> 
		   <input type="hidden" name="quantity" id="tot_quantity" value=""> 
		    <input type="hidden" name="amount" id="tot_amout" value=""> 
		    
			
			<input type="submit" id="update_submit_parts">
    </form>
    
        <form  method="POST" action="msk/add-spare-part" style="display: none;">
		 <input type="hidden" name="model_id" id="model_id" value=""> 
		  <input type="hidden" name="part" id="part_name2" value=""> 
		   <input type="hidden" name="quantity" id="tot_quantity2" value=""> 
		    <input type="hidden" name="amount" id="tot_amout2" value=""> 
			<input type="submit" id="add_submit_parts">
      </form>
      
 <form action="msk/spare-parts" method="post" style="display:none">
<input type="hidden" name="stock_status"  class ="stockvalue">
<input type="submit" class="spare_submit">
</form>
    <div style="display:none">
    <div class="page_data">${it.data}</div>
    <div class="page_stockstatus">${it.data.stock_status}</div>
    </div>
    <script src="../js/spareparts.js"></script>
    <script src="../js/bootstrap-select.min.js"></script>
    
<script type="text/javascript">
$(document).ready(function(){
	
	
	$(".notavailable").click(function(){
		$('.stockvalue').val(not_purchased);
		$('.spare_submit').trigger('click');
	})
	
	$(".newcar_upload").click(function(){
		
	$("#new_logo").val($("#textAreaFileContents").text());

	$('.submit_logo').trigger('click');
	
	});
	
	
});

</script>
</body></html>