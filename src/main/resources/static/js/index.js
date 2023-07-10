$(document).on('click','.submit_btn',function(){
  if($(".form-select").val()==''){ $(".form-select").focus();}
  else location.href = '/edu/detail/'+$(".form-select").val();
});