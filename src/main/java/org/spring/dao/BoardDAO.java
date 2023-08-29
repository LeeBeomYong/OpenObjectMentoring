package org.spring.dao;



import java.util.List;
import java.util.Map;

import org.spring.dto.BoardDTO;
import org.spring.dto.SearchCondition;

public interface BoardDAO {

	// board 페이징, 전체조회
//	public List<BoardDTO> select_Page(Map map);
	
	// board 상세 정보 조회
	public BoardDTO boardInfo(int no);
	
	// board 글쓰기
	public int boardInsert(BoardDTO dto);
	
	// board 게시글 삭제
	public int boardDelete(int no);
	
	// board 게시글 수정하기
	public int boardUpdate(BoardDTO dto);
	
	// board 게시글 조회수+
	public int boardCnt(int no);
	
	// board 게시글 삭제하고 no 하나씩 줄이기
	public int board_minus(int no);
	
	// board 게시글 전체 개수 구하기
	public int board_total_count();
	
	// board 게시글 검색 개수 구하기
	public int searchResultCnt(SearchCondition sc);
	
	// board 검색
	public List<BoardDTO> searchSelectPage(SearchCondition sc);
	
	
}
