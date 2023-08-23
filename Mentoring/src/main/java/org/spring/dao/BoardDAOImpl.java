package org.spring.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.spring.dto.BoardDTO;
import org.spring.dto.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BoardDAOImpl implements BoardDAO {

	@Autowired
	private SqlSessionTemplate sqlSession;

	// 페이징으로 아래 새로 만들었음.
//	@Override
//	public List<BoardDTO> select_Page(Map map) {
//		
//		return this.sqlSession.selectList("select_page", map);
//	}

	@Override
	public BoardDTO boardInfo(int no) {
		return this.sqlSession.selectOne("board_cont", no);
	}

	@Override
	public int boardInsert(BoardDTO dto) {
		return this.sqlSession.insert("board_insert", dto);
	}

	@Override
	public int boardDelete(int no) {
		return this.sqlSession.delete("board_delete", no);
	}

	@Override
	public int boardUpdate(BoardDTO dto) {
		return this.sqlSession.update("board_update", dto);
	}

	@Override
	public int boardCnt(int no) {
		return this.sqlSession.update("board_cnt", no);
	}

	@Override
	public int board_minus(int no) {
		return this.sqlSession.update("board_minus", no);
	}

	@Override
	public int board_total_count() {
		return this.sqlSession.selectOne("board_count");
	}

	@Override
	public int searchResultCnt(SearchCondition sc) {
		return this.sqlSession.selectOne("searchResultCnt", sc);
	}

	@Override
	public List<BoardDTO> searchSelectPage(SearchCondition sc) {
		return this.sqlSession.selectList("searchSelectPage", sc);
	}




	

}
