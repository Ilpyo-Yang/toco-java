let exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
let b = false;

$(document).on('click','#submit_btn',function(){
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

    if(b) return false;
    else{
        $("#form").submit();
    }
});