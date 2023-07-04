let exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
let b;
$(document).ready(function(){
    if(new URLSearchParams(window.location.search).has('error')) {
        $('#warning').get(0).innerHTML = '일치하는 회원정보가 없습니다. 다시 로그인해주세요.';
    }
})

$(document).on('click','#submit_btn',function(){
    b = false;
    $('#warning').innerHTML = '';

    if ($('#email').val()==='') {
        $('#warning').get(0).innerHTML = '이메일을 입력해주세요.';
        b = true;
    }else if(exptext.test($('#email').val())===false){
        $('#warning').get(0).innerHTML = '잘못된 이메일 형식입니다.';
        b = true;
    }else if ($('#password').val()===''){
        $('#warning').get(0).innerHTML = '비밀번호를 입력해주세요.';
        b = true;
    }

    if(b) return false;
    else{
        //$("#form").submit();
        func_login();
    }
});

function func_login(){
    $.ajax({
        url: '/login',
        method: 'post',
        data: {
            'email': $('#email').val(),
            'password': $('#password').val()
        },
        success: function (data) {
            if(data=='failed'){
                $('#email').focus();
                $('#warning').get(0).innerText = '일치하는 회원정보가 없습니다. 다시 로그인해주세요.';
            }
            else location.href = '/';
        },
        error: function (report, status, error) {
            alert("code: " + report.status + "\n" + "message: " + report.responseText + "\n" + "error: " + error);
        }
    });
}