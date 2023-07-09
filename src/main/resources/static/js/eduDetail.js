$(document).on('click','.days',function(){
  if($(this).hasClass('checkedDays')) $(this).removeClass('checkedDays');
  else $(this).addClass('checkedDays');
});

$(document).on('click','#submit_btn',function(){
  $('#warning').innerHTML = '';
  $('#days').val('');

  let checkedDays = [];
  $('.checkedDays').each(function() {
    checkedDays.push($(this).attr('value'));
  });
  $('#days').val(checkedDays.join(','));

  if($('#date').val()==''){
    $('#warning').get(0).innerHTML = '수강 시작일을 선택해주세요.';
    return false;
  }else if($('#days').val()=='') {
    $('#warning').get(0).innerHTML = '메일 수신일을 선택해주세요.';
    return false;
  }

  $("#form").submit()
});