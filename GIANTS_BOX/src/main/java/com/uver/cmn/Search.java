package com.uver.cmn;

public class Search extends DTO {
/**
1.검색구분:전체,아이디(10),이름(20)
2.검색어:
3.페이지 사이즈
4.페이지 넘
 */
    /**검색구분:전체,아이디(10),이름(20) */
	private String searchDiv;
	
	/**검색어*/
	private String searchWord;
	
	/**날짜 검색 조건*/
	private String searchDate;
	
	/** seq 검색 */
	private int searchSeq;
	private int searchSeqSub;
	
	/**페이지 사이즈 */
	private int pageSize;
	
	/**페이지 넘 */
	private int pageNum;
	
	public Search() {}
	
	public Search(String searchDiv, String searchWord) {
		super();
		this.pageSize = 1;
		this.pageNum = 10;
		this.searchDiv = searchDiv;
		this.searchWord = searchWord;
	}
	
	public Search(int searchSeq, int pageNum, int pageSize) {
		super();
		this.searchSeq = searchSeq;
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}
	
	public Search(String searchWord, int pageNum, int pageSize) {
		super();
		this.searchWord = searchWord;
		this.pageNum = pageNum;
		this.pageSize = pageSize;
	}

	public Search(String searchDiv, String searchWord, int pageSize, int pageNum) {
		super();
		this.searchDiv = searchDiv;
		this.searchWord = searchWord;
		this.pageSize = pageSize;
		this.pageNum = pageNum;
	}

	public Search(String searchDiv, String searchWord, String searchDate, int pageSize, int pageNum) {
		super();
		this.searchDiv = searchDiv;
		this.searchWord = searchWord;
		this.searchDate = searchDate;
		this.pageSize = pageSize;
		this.pageNum = pageNum;
	}
	
	public String getSearchDiv() {
		return searchDiv;
	}

	public void setSearchDiv(String searchDiv) {
		this.searchDiv = searchDiv;
	}

	public String getSearchWord() {
		return searchWord;
	}

	public void setSearchWord(String searchWord) {
		this.searchWord = searchWord;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}

	public int getPageNum() {
		return pageNum;
	}

	public void setPageNum(int pageNum) {
		this.pageNum = pageNum;
	}

	
	public int getSearchSeq() {
		return searchSeq;
	}

	public void setSearchSeq(int searchSeq) {
		this.searchSeq = searchSeq;
	}
	
	
	

	public int getSearchSeqSub() {
		return searchSeqSub;
	}

	public void setSearchSeqSub(int searchSeqSub) {
		this.searchSeqSub = searchSeqSub;
	}
	
	

	public String getSearchDate() {
		return searchDate;
	}

	public void setSearchDate(String searchDate) {
		this.searchDate = searchDate;
	}

	@Override
	public String toString() {
		return "Search [searchDiv=" + searchDiv + ", searchWord=" + searchWord + ", searchDate=" + searchDate
				+ ", searchSeq=" + searchSeq + ", searchSeqSub=" + searchSeqSub + ", pageSize=" + pageSize
				+ ", pageNum=" + pageNum + ", toString()=" + super.toString() + "]";
	}

	
	
	
	
	
}
