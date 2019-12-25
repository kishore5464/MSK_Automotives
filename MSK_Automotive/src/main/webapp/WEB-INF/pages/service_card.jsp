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

<%@include file="/WEB-INF/common/header.jsp"%>
<h5>${it.data}</h5>


<div class="container">

<div>Service Type :</div>
<select class="form-control" id="serviceType">
</select>


<div>Service Adviser :</div>
<select class="form-control" id="serviceAdviser">
</select>

<div class="model_id">${it.data.customer_detail.model_id}</div>

<div>Engine No:</div>
<div class="engine_no">${it.data.customer_detail.engine_no}</div>

<table id="tableID" class="table table-bordered table-striped">
<tr>
<th>Parts</th>
<th>Quantity</th>
<th>Price Per Unit</th>
<th>Amount</th>
</tr>

<tbody>
<tr class="append">
<td><select class="form-control parts" ></select></td> 
<td><input type="number" class="form-control quantity" maxlength="2"> 
(<span class="instock"></span> nos Available)</td> 
<td><input type="number" class="form-control amount"></td>
 <td><p class="total"></p>
 <p class="add">+ Add Another Parts</p>
 </td>
</tr>
</tbody>


</table>




</div>
<script>
$(document).ready(function(){
	
	setTimeout (function(){
		$(".parts").trigger("click")
	},50)
	
	
	
	$.ajax({
		url:"/msk/service-type",
		method:"GET",
		success : function(response){
			var res=JSON.parse(response);
			var size=res.data.service_type_count;
			
				for (var i=0; i<size;i++){
				var list=res.data.service_type[i];
				$('#serviceType').append($("<option></option>").attr("value",list.id).text(list.service_type));
			}
		}
	});
	
	
	
	$.ajax({
		url:"/msk/service-advicer",
		method:"GET",
		success : function(response){
			var res=JSON.parse(response);
			var size=res.data.service_advicer_count;
			
				for (var i=0; i<size;i++){
				var list=res.data.service_advicer[i];
				$('#serviceAdviser').append($("<option></option>").attr("value",list.id).text(list.name));
			}
		}
	});
	
	
	$.ajax({
		url:"/msk/part-stock",
		method:"POST",
		data:{"model_id":$(".model_id").text()},
		success : function(response){
			console.log("res-"+response)
			var res=JSON.parse(response);
			var size=res.data.parts_size;
			for(var i=0;i<size;i++){
				var list=res.data.parts[i];
				$('.parts').append($("<option></option>").attr("value",list.part_id).text(list.part));
			}
		}
	});	
	
	$(document).on("click", ".parts", function(){
	
	$.ajax({
		url:"/msk/part-stock-amt",
		method:"POST",
		data:{"part_id":$(".parts option:selected").val()},
		success : function(response){
			console.log("res-"+response)
			var res=JSON.parse(response);
			var quantity=JSON.stringify(res.data.parts[0].quantity).replace('"','').replace('"','');
			var amount=JSON.stringify(res.data.parts[0].amount).replace('"','').replace('"','');
			
			$(".instock").text(quantity);
			$(".amount").val(amount);
			$(".quantity").val(1);
			$(".total").text(amount);
		}
	});
	
	});
	
	$(".quantity").keyup(function(){
		var quantity=parseInt($(".quantity").val());	
		var amount=parseInt($(".amount").val());
		var total=parseInt(amount*quantity);
		$(".total").text(total);
	});
	
	
	$(".amount").keyup(function(){
		var quantity=parseInt($(".quantity").val());	
		var amount=parseInt($(".amount").val());
		var total=parseInt(amount*quantity);
		$(".total").text(total);
	});
	
	$(document).on("click",".add", function(){
		$("#tableID").find('tbody').append('<tr><td><select class="form-control" id="parts"></select></td> <td><input type="number" class="form-control quantity" maxlength="2"> (<span class="instock"></span> nos Available)</td> <td><input type="number" class="form-control amount"></td> <td class="total"></td></tr>');

	});
	
	if($(".engine_no").text() == "not available"){
		$(".engine_no").text('');
		$(".engine_no").append('<input type="text" class="form-control" name="engineNo">');
	}
});

</script>
</body>
</html>
