$(function(){
  func_list();
});

const template = {
  eduList: '<ul class="list-group list-group-flush"><li class="list-group-item pointer" onclick="func_move({0})"><span class="name">{1}</span><span class="badge bg-secondary">{2}</span><span class="badge bg-secondary">{3}</span><span class="badge bg-secondary">{4}</span><br><span class="intro">{5}</span></li></ul>',
  subTypeOption: '<option value="all" selected>세부 카테고리 전체</option>',
  subTypeList: '<option value="{0}">{1}</option>'
}

function func_list(){
  $.ajax({
    url: '/edu/list',
    data: {
      'period': $("input[name='periodRadio']:radio:checked").val(),
      'star': $("input[name='starRadio']:radio:checked").val(),
      'level': $("input[name='levelRadio']:radio:checked").val(),
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

function func_sub(){
  $.ajax({
    url: '/edu/type/sub',
    data: {
      'main': $("select[name='main']").val()
    },
    success: function (data) {
      let str = template.subTypeOption;
      $.each(data, function(idx, val) {
        str += String.Format(template.subTypeList, val.uuid, val.sub);
      });
      $("select[name='sub']").get(0).innerHTML = str;
    },
    error: function (report, status, error) {
      alert("code: " + report.status + "\n" + "message: " + report.responseText + "\n" + "error: " + error);
    }
  });
}