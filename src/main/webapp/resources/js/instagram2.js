$(document).ready(function(){
    //화살표 누르면 돌아가기
    $('.main_direction').click(function(){
        $(this).toggleClass('direction_active')
        $(this).parent().next().toggleClass('direction_bot_active')
    })

    //글치면 밑에 숫자 올라가기
    let length_count = 0;

    $('.main_desc').keydown(function(){
        length_count = $('.main_desc').val().length
        $('.main_descbox_bot>span').text(length_count)
    })
    $('.main_desc').keyup(function(){
        length_count = $('.main_desc').val().length
        $('.main_descbox_bot>span').text(length_count)
    })
    
    // //공유하기 누르면 첫 페이지로 ~
    // $('.main_share_btn').click(function(){
    //     location.href='./instagram.html'
    // })
    $("#file").on('change',function(){
        var fileName = $("#file").val();
        $(".upload-name").val(fileName);
      });


function show(){

}

})
