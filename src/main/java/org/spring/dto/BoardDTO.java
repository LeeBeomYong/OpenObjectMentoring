package org.spring.dto;

public class BoardDTO {

	private int board_id;
	private String board_title;
	private String board_content;
	private String board_writer;
	private String board_regdate;
	private int board_cnt;
	
	public int getBoard_id() {
		return board_id;
	}
	public void setBoard_id(int board_id) {
		this.board_id = board_id;
	}
	public String getBoard_title() {
		return board_title;
	}
	public void setBoard_title(String board_title) {
		this.board_title = board_title;
	}
	public String getBoard_content() {
		return board_content;
	}
	public void setBoard_content(String board_content) {
		this.board_content = board_content;
	}
	public String getBoard_writer() {
		return board_writer;
	}
	public void setBoard_writer(String board_writer) {
		this.board_writer = board_writer;
	}
	public String getBoard_regdate() {
		return board_regdate;
	}
	public void setBoard_regdate(String board_regdate) {
		this.board_regdate = board_regdate;
	}
	public int getBoard_cnt() {
		return board_cnt;
	}
	public void setBoard_cnt(int board_cnt) {
		this.board_cnt = board_cnt;
	}
	
	public BoardDTO() {
		
	}
	// 인텔리제이 깃허브 테스트
	// 인텔리제이 깃허브 테스트
	public BoardDTO(int board_id, String board_title, String board_content, String board_writer, String board_regdate,
			int board_cnt) {
		this.board_id = board_id;
		this.board_title = board_title;
		this.board_content = board_content;
		this.board_writer = board_writer;
		this.board_regdate = board_regdate;
		this.board_cnt = board_cnt;
	}
}