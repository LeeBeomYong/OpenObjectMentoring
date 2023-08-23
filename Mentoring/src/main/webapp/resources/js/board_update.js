function update_ok(){
	
	let num = $('#board_id').val();
	
	let obj = {
			'board_id' : $('#board_id').val(),
			'board_title' : $('#board_title').val(),
			'board_content' : $('#board_content').val()
	};
	
	
	
	$.ajax({
		type:"post",
		url:"update_ok",
		data:obj,
		success: function(data){
			alert('수정 완료');
			location.href='board_cont?no='+num+'';
		}
	});
}

function admin_update_ok(){
	
	let obj = {
			'board_id' : $('#board_id').val(),
			'board_title' : $('#board_title').val(),
			'board_content' : $('#board_content').val()
	};
	
	$.ajax({
		type:"post",
		url:"update_ok",
		data:obj,
		success: function(data){
			alert('수정 완료');
			location.href='admin_boardList';
		}
	});
	
}
