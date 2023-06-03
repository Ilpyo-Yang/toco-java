window.addEventListener("DOMContentLoaded", () => {
    let warning = document.getElementById('warning');
    let exptext = /^[A-Za-z0-9_\.\-]+@[A-Za-z0-9\-]+\.[A-Za-z0-9\-]+/;
    let b = false;

    document.getElementById('signup_btn').addEventListener('click', function () {
        if (document.getElementById('email').value=='') {
            warning.innerHTML = '이메일을 입력해주세요.';
            b = true;
        }else if(exptext.test(document.getElementById('email').value)==false){
            warning.innerHTML = '잘못된 이메일 형식입니다.';
            b = true;
        }else if (document.getElementById('name').value==''){
            warning.innerHTML = '이름을 입력해주세요.';
            b = true;
        }else if (document.getElementById('password').value==''){
            warning.innerHTML = '비밀번호를 입력해주세요.';
            b = true;
        }else if (document.getElementById('password_confirm').value==''){
            warning.innerHTML = '비밀번호 확인를 입력해주세요.';
            b = true;
        }else if (document.getElementById('password').value!=document.getElementById('password_confirm').value){
            warning.innerHTML = '비밀번호가 다릅니다. 다시 입력해주세요';
            b = true;
        }

        if(b) return false;
        else{
            document.getElementById("form").submit();
        }
    });
});