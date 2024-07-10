$(document).ready(function(){
    //햄판열기
    $('.ham_btn').click(function(){
        $('.hampan').css({
            left:0,
            opacity: '1'
        })
        $('body').css({
            overflow:'hidden'
        })
    })
//햄판닫기
    $('.ham_close').click(function(){
        $('.hampan').css({
            left:'-100%',
            opacity: '0'
        })
        $('body').css({
            overflow:'auto'
        })
    })
//로고로 메인페이지
// $('.header_logo , .ham_logo').click(function(){
//     location.href='./instagram.html'
// })

// $('.make_btn').click(function(){
//     location.href='./instagram2.html'
// })
// $('.reels').click(function(){
//     location.href='./instagram3.html'
// })



})