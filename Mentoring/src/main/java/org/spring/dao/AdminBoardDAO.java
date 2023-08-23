package org.spring.dao;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.spring.dto.BoardDTO;
import org.spring.dto.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminBoardDAO {

	@Autowired
	private SqlSessionTemplate SqlSession;
	
	//관리자로 게시판 목록 불러오기
	public List<BoardDTO> board_list(SearchCondition sc){
		return this.SqlSession.selectList("admin_board_list", sc);
	}
	
	//관리자로 게시판 목록 불러올때 개수 세기
	public int board_count(SearchCondition sc) {
		return this.SqlSession.selectOne("admin_board_count", sc);
	}
	
	
}
