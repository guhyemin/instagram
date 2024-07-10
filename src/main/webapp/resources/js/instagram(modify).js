function register_check(){
    let name = document.getElementById("name");
    let pone = document.getElementById("pone");
    let error = document.getElementById("error");
    
    if (name.value == "") {
        error.textContent = "이름을 입력하세요.";
        name.focus();
        return false;
    }
    else if (pone.value == "") {
        error.textContent = "핸드폰 번호를 입력해주세요.";
        pone.focus();
        return false;
    } 
    else if (pone.value.length !== 11 ) {
        error.textContent = "핸드폰 번호 11자리 입력해주세요.";
        pone.focus();
        return false;
    } 
    else if (!/^[0-9]+$/.test(pone.value)) {
        error.textContent = "핸드폰번호는 번호만 입력해주세요";
        pone.focus();
        return false;
    }
    else{
        return true;
    }
}




$(document).ready(function(){

    $("#file").on('change',function(){
        var fileName = $("#file").val();
        $(".upload-name").val(fileName);
      });

      let length_count = 0;

      $('.main_desc').keydown(function(){
          length_count = $('.main_desc').val().length
          $('.main_descbox_bot>span').text(length_count)
      })
      $('.main_desc').keyup(function(){
          length_count = $('.main_desc').val().length
          $('.main_descbox_bot>span').text(length_count)
      })

    
})