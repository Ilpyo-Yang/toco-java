let exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
let b;

$(document).on('click','#submit_btn',function(){
    b = false;
    if(func_inputCheck()) return false;
    else if(func_checkEmail($('#email').val())) return false;
    else{
        $("#form").submit();
    }
});

function func_inputCheck(){
    if($('#name').val()===''){
        $(".warning").get(0).innerHTML = '이름을 입력해주세요.';
        b = true;
    }else if ($('#email').val()==='') {
        $(".warning").get(0).innerHTML = '이메일을 입력해주세요.';
        b = true;
    }else if(exptext.test($('#email').val())===false){
        $(".warning").get(0).innerHTML = '잘못된 이메일 형식입니다.';
        b = true;
    }else if ($('#password').val()===''){
        $(".warning").get(0).innerHTML = '비밀번호를 입력해주세요.';
        b = true;
    }
    return b;
}

function func_checkEmail(email){
    $.ajax({
        url: '/member/existEmail',
        data: { 'email': email },
        async: false,
        success: function (data) {
            if(data!=''){
                $(".warning").get(0).innerHTML = '이미 가입된 이메일입니다.';
                $('#email').focus();
                $('#email').val(null);
                b = true;
            }
            console.log(data);
        },
        error: function (report, status, error) {
            alert("code: " + report.status + "\n" + "message: " + report.responseText + "\n" + "error: " + error);
        }
    });
    return b;
}