package org.spring.dto;

import org.springframework.web.util.UriComponentsBuilder;

public class SearchCondition {

	// 기본값을 주는 이유는 컨트롤러에서 못받았을 때 기본값을 사용함
	private Integer page = 1;
	private Integer pageSize = 10;
//	private Integer offset = 0;
	private String keyword = "";
	private String option = "";
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getPageSize() {
		return pageSize;
	}
	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}
	public Integer getOffset() {
		return (page-1) * pageSize;
	}
	public String getKeyword() {
		return keyword;
	}
	public void setKeyword(String keyword) {
		this.keyword = keyword;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	
	public SearchCondition() {}
	public SearchCondition(Integer page, Integer pageSize, Integer offset, String keyword, String option) {
		this.page = page;
		this.pageSize = pageSize;
//		this.offset = offset;
		this.keyword = keyword;
		this.option = option;
	}
	@Override
	public String toString() {
		return "SearchCondition [page=" + page + ", pageSize=" + pageSize + ", offset=" + ((page-1) * pageSize) + ", keyword="
				+ keyword + ", option=" + option + "]";
	}
	
	//검색결과 보고 목록으로 돌아올 때 값들을 유지하기 위해 만든 메서드
	public String getQueryString(Integer page) {
		//?page=1&pageSize=1-&option=T&keyword="title"
		return UriComponentsBuilder.newInstance().queryParam("page", page)
				.queryParam("pageSize", pageSize)
				.queryParam("keyword", keyword)
				.queryParam("option", option)
				.build().toString();
				
	}
	
	public String getQueryString() {
		return getQueryString(page);
	}
	
	
}
