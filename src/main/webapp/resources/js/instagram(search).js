$(document).ready(function(){

    //게시 나오게 하기
    $('.commert_text').keyup(function(){
        if($(this).val().length >= 1){
            $(this).nextAll('.comment_uplode').css({
                display: 'block'
            })
        }
        else{
            $(this).nextAll('.comment_uplode').css({
                display: 'none'
            })
        }
    })



})
    


