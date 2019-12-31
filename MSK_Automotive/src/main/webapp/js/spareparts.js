
$.ajax({
        url: 'msk/check-brand-stock',
        method : 'post',
        datatype: 'text',
        success: function(response) {

        	
          var output = JSON.parse(response);

          
          
          $.each(output.data.brands, function(key, value) {
            


            $('#car_brands').append($("<option></option>").attr("value", key).val(value.brand_id).text(value.brand));

          });
          
          $('.brandlist').selectpicker('refresh');
          

        },
        error: function() {
          console.log("Error AJax")
        }
      })
      
      
      
      $(document).on("change",".brandlist",function(){
					  		  
							  var selectedbrand=$(this).val();
							  
							  console.log("selectedbrand======>"+selectedbrand);
	
							  $('#car_modals')
							    .find('option')
							    .remove()
							    .end()
							    .append('<option value="" selected disabled>Select Modal</option>')
							    .val('whatever');
			  
							$.ajax({
						          url: 'msk/check-model-stock',
						          type: 'POST',
						          dataType: 'text',
						          data: {'brand_id':selectedbrand},
						          success: function(responseText) {
						        	  
						        	  console.log("output========>"+responseText);
						        	  
						        	  var output=JSON.parse(responseText);
						        	  
						        	
						          	             
						           $.each(output.data.models, function(key, value) {   
						            	 
						       		  $('#car_modals').append($("<option></option>").attr("value",key).val(value.model_id).text(value.model));
						       		 
						       		
						            
						          }); 
						           $('.modallist').selectpicker('refresh');
						      
						          },
						          error: function() {
						          	console.log("error ajax");
						          	
						          }
						      });
						  
						  });



$(document).on("change",".modallist",function(){
	  
	  var selectedbrand=$(this).val();
	  
	  console.log("modal selectedbrand======>"+selectedbrand);


	$.ajax({
        url: 'msk/check-part-stock',
        type: 'POST',
        dataType: 'text',
        data: {'model_id':selectedbrand},
        success: function(responseText) {
  	  
      	  var output=JSON.parse(responseText);
   	  
     	var availableTags = [];
	        
         $.each(output.data.parts, function(key, value) {
           
            availableTags.push(value);
             
        	 console.log("eeeee------>"+value);
            
           });
         
        
         $( ".parts_name" ).autocomplete({
             source: availableTags
           });
         
    
        },
        error: function() {
        	console.log("error ajax");
        	
        }
    });

});


$(document).on("click",".chk_stock",function(){
	
	
	$('#loading').show();
	
	$.ajax({
        url: 'msk/exists-parts',
        type: 'POST',
        dataType: 'text',
        data: {'model_id':$('.modallist').val(),'part':$('.parts_name').val()},
        success: function(responseText) {
        	 $('#loading').hide();
      	  console.log("output========>"+responseText);
      	 var output=JSON.parse(responseText);
      	 
      	 console.log("output====>"+output.data.spare_parts);
      	 
         if(output.data.spare_parts == "empty"){
        	 $('#quantity').val('');
        	 $('#price').val('');
        	 $('.disableoption').removeAttr("disabled");
        	 $('#add_btn').removeClass('update_spare');
        	 $('#add_btn').addClass('add_spare');
        	 
         }
         else{
        	 $('.disableoption').removeAttr("disabled");
        	 $('#add_btn').removeClass('add_spare');
        	 $('#add_btn').addClass('update_spare');

        	 
        	 $('#sparepart_id').val(output.data.spare_parts.spare_part_id);
        	 $('#quantity').val(output.data.spare_parts.quantity);
        	 $('#price').val(output.data.spare_parts.price_per_unit);
        	 
         }
    
        },
        error: function() {
        	console.log("error ajax");
        	
        }
    });
	
});


$(document).on("click",".update_spare",function(){
	
	
	$('#tot_modal').val($('.modallist').val());
	$('#part_name').val($('.parts_name').val());
	$('#tot_quantity').val($('#quantity').val());
	$('#tot_amout').val($('#price').val());
	
	$('#update_submit_parts').trigger('click');

});

$(document).on("click",".add_spare",function(){
	
	
	$('#model_id').val($('.modallist').val());
	$('#part_name2').val($('.parts_name').val());
	$('#tot_quantity2').val($('#quantity').val());
	$('#tot_amout2').val($('#price').val());
	
	$('#add_submit_parts').trigger('click');

});


$(document).on("click",".stock",function(){
	
	var click_status = $(this).text().toLowerCase().trim().replace(' ','');
	
	$('.stockvalue').val(click_status);
	
	$('.spare_submit').trigger('click');

	
});


var page_stockstatus = $('.page_stockstatus').text();

if(page_stockstatus == 'outstock'){
	console.log("iffffff");
	$('.outstock').addClass('active');
}
else if(page_stockstatus == 'instock'){
	console.log("elsseeeeeeeeee");
	$('.instock').addClass('active');
}
      
     