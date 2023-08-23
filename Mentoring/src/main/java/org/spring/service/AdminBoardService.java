package org.spring.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.spring.dao.AdminBoardDAO;
import org.spring.dao.BoardDAO;
import org.spring.dto.BoardDTO;
import org.spring.dto.PageHandler;
import org.spring.dto.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminBoardService {

	@Autowired
	private AdminBoardDAO abd;
	@Autowired
	private BoardDAO boardDAO;
	
	// 검색 페이징 목록 불러오기
	public Map<String, Object> board_list(SearchCondition sc){
		
		List<BoardDTO> boardList = abd.board_list(sc);
		int totalCnt = abd.board_count(sc);
		PageHandler ph = new PageHandler(totalCnt, sc);
		
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("List", boardList);
		map.put("totalCnt", totalCnt);
		map.put("ph", ph);
		return map;
	}
	
	//관리자가 게시판 목록에서 수정 눌렀을 때
	public BoardDTO admin_board_update(int no) {
		return boardDAO.boardInfo(no);
	}
	
	//관리자가 게시판 목록에서 삭제 눌렀을 때
	public void admin_board_delete(int no) {
		boardDAO.boardDelete(no);
	}
	
	//관리자가 게시판에서 목록 지우면 no 하나씩 줄어들도록
	public void admin_num_delete(int no) {
		boardDAO.board_minus(no);
	}
	
	//관리자가 게시판등록버튼 눌렀을 때
	public void admin_board_insert(BoardDTO dto, String board_title, String board_content, String board_writer) {
		dto.setBoard_title(board_title);
		dto.setBoard_writer(board_writer);
		dto.setBoard_content(board_content);
		
		boardDAO.boardInsert(dto);
	}
	
}
