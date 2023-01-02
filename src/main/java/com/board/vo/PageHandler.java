package com.board.vo;

public class PageHandler {
	
	// 총 게시물 수
	private int totalCnt;
	// 한 페이지의 크기
//	private int pageSize;
	// 페이지에 들어갈 페이지 수 - 우선은 10개씩 
	private int pageNumber = 10;
	// 전체 페이지 수
	private int totalPage;
	// 현재 페이지
//	private int page;
	// 처음에 들어갈 페이지 숫자
	private int startPage;
	// 마지막에 들어갈 페이지 숫자
	private int endPage;
	
	private Search search;

//	private String option;
	
//	private String keyword;
	

	
	public int getTotalCnt() {
		return totalCnt;
	}

	public Search getSearch() {
		return search;
	}

	public void setSearch(Search search) {
		this.search = search;
	}

	public void setTotalCnt(int totalCnt) {
		this.totalCnt = totalCnt;
	}

	public int getPageNumber() {
		return pageNumber;
	}


	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}


	public int getTotalPage() {
		return totalPage;
	}


	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public int getStartPage() {
		return startPage;
	}


	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}


	public int getEndPage() {
		return endPage;
	}


	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}



	@Override
	public String toString() {
		return "PageHandler [totalCnt=" + totalCnt + ", pageNumber=" + pageNumber + ", totalPage=" + totalPage
				+ ", startPage=" + startPage + ", endPage=" + endPage + "]";
	}


	public PageHandler(int totalCnt, Search search) {
		this.totalCnt = totalCnt;
		this.search = search;
		
		doPaging(totalCnt, search);
	}
	/**
	 * 페이징핸들러
	 * 
	 * @param totalCnt
	 * @param page
	 * @param pageSize
	 */
	public void doPaging(int totalCnt, Search search) {
		// 전체 게시물
		this.totalCnt = totalCnt;
		
		// 현재 페이지
//		this.page = page;
		// 한 페이지 크기
//		this.pageSize = pageSize;
		
		// 전체 페이지수 구하기
		// pagesize를 int로 설정하면 정수로 나누기 때문에 오류(페이지가 짤림) 발생했음.
		// math.ceil은 소수 부분을 올림
		totalPage = (int) Math.ceil(totalCnt/(double)search.getPageSize());
		// 시작 페이지 구하기
		startPage = (search.getPage()-1) / pageNumber*pageNumber +1;
		// 종료 페이지 구하기
		// math.min은 작은 숫자를 할당한다.
		endPage = Math.min(startPage + pageNumber -1, totalPage);
		
	}
}
