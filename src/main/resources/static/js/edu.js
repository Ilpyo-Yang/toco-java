$(function(){
  func_list();
});

const template = {
  eduList: '<ul class="list-group list-group-flush"><li class="list-group-item pointer" onclick="func_move({0})"><span class="name">{1}</span><span class="badge bg-secondary">{2}</span><span class="badge bg-secondary">{3}</span><span class="badge bg-secondary">{4}</span><br><span class="intro">{5}</span></li></ul>'
}

function func_list(){
  $.ajax({
    url: '/edu/list',
    data: {
      'period': $("input[name='periodRadio']:radio:checked").val(),
      'star': $("input[name='starRadio']:radio:checked").val(),
      'main': $("select[name='main']").val(),
      'sub': $("select[name='sub']").val()
    },
    success: function (data) {
      let str = '';
      $.each(data, function(idx, val) {
        str += String.Format(template.eduList, '/eduDetail/'+val.uuid, val.name, val.score+'점', val.period+'일', val.level, val.intro);
      });
      $(".recommended").get(0).innerHTML = str;
    },
    error: function (report, status, error) {
      alert("code: " + report.status + "\n" + "message: " + report.responseText + "\n" + "error: " + error);
    }
  });
}