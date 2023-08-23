function update_click(){

	if($('#user_name').val()=="") {
		alert('이름을 입력하세요');
	}
	if($('#user_pwd').val()=="") {
		alert('비밀번호를 입력하세요');
	}
	if($('#user_name').val()!="" && $('#user_pwd').val()!=""){
		let obj={
			'user_id' : $('#user_id').val(),
			'user_pwd' : $('#user_pwd').val(),
			'user_name' : $('#user_name').val(),
			'user_email' : $('#user_email').val()
		};
		$.ajax({
			type:"post",
			url: "profile_ok",
			data: obj,
			success : function(data) {
					alert("수정완료");
					location.reload();
			}
		});
	}
}

function admin_update_click(){
	
	if($('#user_name').val()=="") {
		alert('이름을 입력하세요');
	}
	if($('#user_pwd').val()=="") {
		alert('비밀번호를 입력하세요');
	}
	
	if($('#user_name').val()!="" && $('#user_pwd').val()!=""){
		let obj={
			'user_id' : $('#user_id').val(),
			'user_pwd' : $('#user_pwd').val(),
			'user_name' : $('#user_name').val(),
			'user_email' : $('#user_email').val()
		};
		
		$.ajax({
			type:"post",
			url:"admin_userUpdate_ok",
			data:obj,
			success: function(data) {
				alert('수정성공');
				location.href='admin_userList';
			}
		});
	}
}
