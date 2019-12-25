<!DOCTYPE html>
<%@ page language="java" errorPage="/error.jsp" pageEncoding="UTF-8" contentType="text/html;charset=utf-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix="sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html lang="en"><head>
  <meta charset="utf-8">
  <title>Bike</title>
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
</head>
<script type="text/javascript">
    
    $(document).ready(function(){
    	
    	
    	
     $(".addcarmodal").click(function(){
    		
    		$("#addcarmyModal").modal("show");
    		modelsId=$(this).prev('span').text();
    	});
    	
    	
    		var modelsId;
    		
    	$(".choose").click(function(){
    		
    		$("#myModal").modal("show");
    		brandId=$(this).prev('span').text();
    		modelId=$(this).prev('span').prev('span').text();
    		
    	});
    	
    	$(".upload").click(function(){
		$("#image").val($("#textAreaFileContents").text());

		$(".brandid").val(brandId);
		$('.modalid').val(modelId);
		
		
		/* modelid */
		
		$("#subImage").trigger("click");
    	});
    		
    		
    });
    function loadImageFileAsURL()
    {
   
        var filesSelected = document.getElementById("inputFileToLoad").files;
     	
        if (filesSelected.length > 0)
        {
            var fileToLoad = filesSelected[0];
     
            var fileReader = new FileReader();
     
            fileReader.onload = function(fileLoadedEvent) 
            {
                var textAreaFileContents = document.getElementById
                (
                    "textAreaFileContents"
                );
                textAreaFileContents.innerHTML = fileLoadedEvent.target.result;
                
                
                if($("#textAreaFileContents").text().length < 45000)
                {
                	$(".error_size").hide();
                		if( $("#textAreaFileContents").text().slice(5,10) === "image") 
                		{
                			$(".error_format").hide();
                		}

                		else 
                		{
                		$(".error_format").show();
                		}
                }
                
                else 
                {
                	$(".error_size").show();
                	
                	if($("#textAreaFileContents").text().slice(5,10) === "image") 
                	{
                		$(".error_format").hide();
                	}

                	else 
                	{
                		$(".error_format").show();
                		$(".error_size").hide();
                	}
                	
                }
            };
     
            fileReader.readAsDataURL(fileToLoad);
        }
        
    }
   
    </script>
    <style>
    .models_name{
    white-space: nowrap;
    overflow: hidden;
    text-overflow: ellipsis;
    }
    
    </style>
<body>
<%@include file="/WEB-INF/common/header.jsp"%>

<div class="col-lg-12">
<div class="container">
<c:forEach var="models" varStatus="counter"  items="${it.data.models}">
    <div class="col-xs-12 col-sm-6 col-md-6 col-lg-2 col-xl-4 card grid-item">
      <div class="thumbnail car_models" id="${models.model_id}">
         <c:if test="${models.image == 'noimage'}">
         <img class="" style="max-height:100px" src="http://personalityanalysistest.com/template/images/logo.png">
         </c:if>
        <c:if test="${models.image != 'noimage'}">
        <img class="zz" style="height:100px" src="${models.image}">
        </c:if>
        <div class="caption">
          <h5 id="thumbnail-label" class="models_name" title="${models.model}">${models.model}</h5>
        </div>
      </div>
      <span id="models_id" style="display:none">${models.model_id}</span>
      <span id="brand_id" style="display:none">${models.brand_id}</span>
   <!-- <button type="button" class="choose">Choose Image</button> -->
    </div>
</c:forEach>

    <div class="col-xs-12 col-sm-6 col-md-6 col-lg-2 col-xl-4 card grid-item">
      <div class="thumbnail addcarmodal">

        
        <img class="zz" style="width:150px;height:100px" src="../images/addcar.png">
        
        <div class="caption">
          <h5 id="thumbnail-label" class="">Add Modal</h5>
        </div>
      </div>
      
    </div>
</div>
</div>


 <div class="modal fade" id="addcarmyModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="modal-title">Add Car Modal</h4>
        </div>
        
       <form action="msk/add-car-model" method="POST">
        <div class="modal-body">
        
        <input type="text" style="display:none" name="brand_id"  value="${it.data.brand_id}">
        
        <div class="form-group">
        <label for="email">Modal Name:</label>
        <input type="text"  class="form-control" name="model" placeholder="brandname" required>
        </div>
        <input type="text" style="display:none" id="new_logo" name="image">
        
        <div class="form-group">
         <label for="email">Car Image</label>
         <input id="inputFileToLoad" type="file" onchange="loadImageFileAsURL();" />
          <input type="hidden" id="textAreaFileContents"  />
       </div>
       
          
        </div>
        <div class="modal-footer">
         <input type="submit" style="display:none" class="submit_logo">
           
          <button type="button" class="btn btn-default newcar_upload">Upload</button>
        </div>
        </form>
      </div>
      
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
		 <input type="hidden" name="model_id" class="modalid" value="">
		 <input type="hidden" name="brand_id" class="brandid">
		  <input type="hidden" name="image" id="image" value=""> 
			 <input type="submit" id="subImage" > 
    </form>
    
    <form action="msk/customer-detail" method="post" style="display:none">
    <input type="text" name="modal_id" id="modalid">
    <input type="submit" class="modalid_submit">
    </form>
    
<script type="text/javascript">
$(document).ready(function(){
	
	$("#textAreaFileContents").text('');
	$(".newcar_upload").click(function(){
		
	$("#new_logo").val($("#textAreaFileContents").text());
	
	console.log("triggggggggggggggggggggg");

   $('.submit_logo').trigger('click');
	
	})
	
	$('.car_models').click(function(){
		
		$('#modalid').val($(this).attr('id'));
		
		$('.modalid_submit').trigger('click');
		
		
		
	})
	
	
});

</script>
</body></html>