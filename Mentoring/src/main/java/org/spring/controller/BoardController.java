package org.spring.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.spring.dao.BoardDAO;
import org.spring.dao.UserDAO;
import org.spring.dto.BoardDTO;
import org.spring.dto.PageHandler;
import org.spring.dto.SearchCondition;
import org.spring.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class BoardController {
	
	@Autowired
	private BoardDAO boardDAO;
	@Autowired
	private UserDAO userDAO;
	
	//게시판 전체 리스트
	@RequestMapping("/board")
	public String board(HttpServletRequest request, Model model, SearchCondition sc) {
		
		HttpSession session = request.getSession();
		String session_id = (String)session.getAttribute("session_id");
		String session_name = (String)session.getAttribute("session_name");
		
		//pageHandler
		int totalCnt = boardDAO.searchResultCnt(sc);
		PageHandler pageHandler = new PageHandler(totalCnt, sc);
		
		List<BoardDTO> BoardList = boardDAO.searchSelectPage(sc);
		
		model.addAttribute("List", BoardList);
		model.addAttribute("ph", pageHandler);
		model.addAttribute("totalCnt", totalCnt);
		
		model.addAttribute("session_id", session_id);
		model.addAttribute("session_name", session_name);
		
		return "board";
	}
	
	//게시판 상세
	@RequestMapping("board_cont")
	public String board_cont(HttpServletRequest request, HttpServletResponse response ,@RequestParam("no") int no, Model model) {
		
		HttpSession session = request.getSession();
		String session_id = (String)session.getAttribute("session_id");
		
		BoardDTO dto = boardDAO.boardInfo(no);
		
		model.addAttribute("board_id", dto.getBoard_id());
		model.addAttribute("board_title", dto.getBoard_title());
		model.addAttribute("board_cont", dto.getBoard_content());
		model.addAttribute("board_writer", dto.getBoard_writer());
		model.addAttribute("board_regdate", dto.getBoard_regdate());
		model.addAttribute("board_cnt", dto.getBoard_cnt());
		model.addAttribute("session_id", session_id);
		
		boardDAO.boardCnt(no);
		return "board_cont";
	}
	
	//게시판 글쓰기 페이지로 이동
	@RequestMapping("write_ok")
	public String write_ok() {
			
		return "board_write";
	}
	
	//게시판 글 등록
	@RequestMapping("write_insert")
	@ResponseBody
	public String write_insert(HttpServletRequest request, String board_title, String board_content, BoardDTO dto) {
		HttpSession session = request.getSession();
		String session_id = (String)session.getAttribute("session_id");
		
		dto.setBoard_title(board_title);
		dto.setBoard_content(board_content);
		dto.setBoard_writer(session_id);
		
		boardDAO.boardInsert(dto);
		
		return "board";
	}
	
	//게시글 삭제하기
	@RequestMapping("board_delete")
	@Transactional
	public String write_delete(@RequestParam("no") int no) throws IOException {
		
		boardDAO.boardDelete(no);
		boardDAO.board_minus(no);
		
		return "redirect:board";
	}
	
	//게시글 수정 페이지로 이동하기
	@RequestMapping("board_update")
	public String write_update(@RequestParam("no") int no, Model model) {
		
		BoardDTO dto = boardDAO.boardInfo(no);
		model.addAttribute("board_id", dto.getBoard_id());
		model.addAttribute("board_title", dto.getBoard_title());
		model.addAttribute("board_cont", dto.getBoard_content());
		
		return "board_update";
	}
	
	//게시글 수정하기
	@RequestMapping("update_ok")
	public String write_update_ok(BoardDTO dto, int board_id, String board_title, String board_content) {
		
		dto.setBoard_id(board_id);
		dto.setBoard_title(board_title);
		dto.setBoard_content(board_content);
		
		boardDAO.boardUpdate(dto);
		
		return "board_cont";
	}
}
