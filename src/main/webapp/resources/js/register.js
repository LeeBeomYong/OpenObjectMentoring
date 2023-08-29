function join_click(){

	let id_ckeck = /^[a-zA-Z0-9]{8,16}$/;
	let id = $('#exampleID').val();
	
	if($('#exampleID').val()=="") {
		alert('아이디를 입력하세요');
	}else if(!id_ckeck.test(id)){
		alert('아이디는 영어, 숫자로 8~16자리로 해주세요');
	}else if($('#exampleName').val()=="") {
		alert('이름을 입력하세요');
	}else if($('#exampleInputEmail').val()=="") {
		alert('이메일을 입력하세요');
	}else if($('#exampleInputPassword').val()=="") {
		alert('비밀번호를 입력하세요');
	}else if($('#exampleRepeatPassword').val() != $('#exampleInputPassword').val()) {
		alert('비밀번호가 다릅니다.');
	}
	
	
	if($('#exampleID').val()!="" && $('#exampleName').val()!="" && $('#exampleInputEmail').val()!=""
	 && $('#exampleInputPassword').val()!="" && $('#exampleRepeatPassword').val() == $('#exampleInputPassword').val()
	 && id_ckeck.test(id)){
		$.ajax({
			type:"post",
			url: "join_ok",
			data: $("#joinInfo").serialize(),
			contentType: "application/x-www-form-urlencoded; charset=utf-8",
			dataType: "text",
			success: function(test){
				if(test == "d") {
					alert("가입성공");
					location.href="login";
				}else if(test == "a"){
					alert('모든항목을 입력하세요');
				}else if(test == "b"){
					alert('아이디 중복');
				}else if(test == "c"){
					alert('이메일 중복');
				}else if(test == "e"){
					alert('오류');
				}else if(test == "f"){
					alert('비밀번호 잘못입력');
				}
			},error: function(){
				console.log("실패");
			}
		});
	}
	
}