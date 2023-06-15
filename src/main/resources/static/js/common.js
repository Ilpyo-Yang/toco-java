function func_move(str){
    switch(str){
        case '/': location.href = '/'; break;
        case 'mypage': location.href = '/mypage'; break;
        case 'login': location.href = '/login'; break;
        case 'logout': location.href = '/logout'; break;
        case 'signup': location.href = '/signup'; break;
        case 'info': location.href = '/info'; break;
        case 'edu': location.href = '/edu'; break;
        case 'edudetail': location.href = '/edudetail'; break;
        case 'github': window.open('https://www.naver.com'); break;
        case 'blog': window.open('https://www.naver.com'); break;
    }
}