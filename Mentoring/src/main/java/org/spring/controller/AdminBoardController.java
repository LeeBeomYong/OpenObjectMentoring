package org.spring.controller;

import java.util.HashMap;
import java.util.Map;

import org.spring.dao.BoardDAO;
import org.spring.dto.BoardDTO;
import org.spring.dto.SearchCondition;
import org.spring.service.AdminBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AdminBoardController {

	@Autowired
	private AdminBoardService abs;
	
	@Autowired
	private BoardDAO boardDAO;
	
	// 관리자 게시판 목록 불러오기
	@RequestMapping("admin_boardList")
	public String admin_boardList(SearchCondition sc, Model model) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		
		map = abs.board_list(sc);
		model.addAttribute("List", map.get("List"));
		model.addAttribute("totalCnt", map.get("totalCnt"));
		model.addAttribute("ph", map.get("ph"));
		
		return "admin/board_list";
	}
	
	//관리자게시판 목록에서 수정 눌렀을때
	@RequestMapping("admin_board_update")
	public String admin_board_update(@RequestParam("no") int no, BoardDTO dto, Model model) {
		
		dto = abs.admin_board_update(no);
		model.addAttribute("board_id", dto.getBoard_id());
		model.addAttribute("board_writer", dto.getBoard_writer());
		model.addAttribute("board_title", dto.getBoard_title());
		model.addAttribute("board_cont", dto.getBoard_content());
		
		return "admin/board_update";
	}
	
	// 게시판 삭제 및 no 마이너스
	@RequestMapping("admin_board_delete")
	@ResponseBody
	@Transactional
	public String admin_board_delete(@RequestParam("no") int no) {
		
		abs.admin_board_delete(no);
		abs.admin_num_delete(no);
		
		return "<script>location.href='admin_boardList'</script>";
	}
	
	// 관리자가 게시글 등록버튼 눌렀을 때 등록하는 페이지로 이동
	@RequestMapping("admin_board_insert")
	public String admin_board_insert() {
		
		return "admin/board_insert";
	}
	
	// 관리자 게시글 등록하는 페이지에서 등록 버튼 눌름
	@RequestMapping("admin_board_insert_ok")
	@ResponseBody
	public void admin_board_insert_ok(BoardDTO dto, String board_title, String board_content, String board_writer) {
		abs.admin_board_insert(dto, board_title, board_content, board_writer);
		
	}
}
