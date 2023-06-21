$(document).on('click','.submit_btn',function(){
  if($(".form-select").val()==''){ $(".form-select").focus();}
  else location.href = '/eduDetail/'+$(".form-select").val();
});