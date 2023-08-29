function write_ok(){
	
	let obj={
			'board_title' : $('#board_title').val(),
			'board_content' : $('#board_content').val()
	};
	
	if($('#board_title').val()=="" || $('#board_content').val()=="") {
		alert('제목, 내용을 입력하세요');
	}else {
		$.ajax({
		type:"post",
		url:"write_insert",
		data: obj,
		success : function(data) {
			alert('등록 완료');
			location.href='board';
			}
		});
	}
	
	
}

function admin_insert_ok(){

	let obj={
			'board_title' : $('#board_title').val(),
			'board_content' : $('#board_content').val(),
			'board_writer' : $('#session_id').val()
	};
	
	if($('#board_title').val()=="" || $('#board_content').val()=="") {
		alert('제목, 내용을 입력하세요');
	}else {
		$.ajax({
		type:"post",
		url:"admin_board_insert_ok",
		data: obj,
		success : function(data) {
			alert('등록 완료');
			location.href='admin_boardList';
			}
		});
	}

	
}