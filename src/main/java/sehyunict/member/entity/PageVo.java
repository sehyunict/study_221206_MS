package sehyunict.member.entity;

public class PageVo {
	
	// 시작 페이지
	private int startPage;
	
	// 끝 페이지
	private int endPage;
	
	// 이전 페이지, 다음 페이지 존재 유무
	private boolean prev, next;
	
	// 전체 게시물 수
	private int total;
	
	// 현재 페이지, 페이지당 게시물 표시수 정보
	private Criteria cri;
	
	public PageVo(Criteria cri, int total) {
		
		this.cri = cri;
		this.total = total;
		
		// 시작 페이지, 마지막 페이지 계산
		this.endPage = (int)(Math.ceil(cri.getPageNum() / 10.0)) * 10;
		this.startPage = this.endPage - 9;
		
		// 전체 마지막 페이지
		int realEnd = (int) (Math.ceil((total * 1.0) / cri.getAmount()));
		
		// 전체 마지막 페이지(realend)가 화면에 보이는 마지막페이지(endPage)보다 작은 경우, 보이는 페이지(endPage) 값 조정
		if(realEnd < this.endPage) {
			this.endPage = realEnd;
		}
		
		// 이전, 다음 버튼 표출 여부 결정
		this.prev = this.startPage > 1;
		this.next = this.endPage < realEnd;
	}

	public int getStartPage() {
		return startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public boolean isPrev() {
		return prev;
	}

	public boolean isNext() {
		return next;
	}

	public int getTotal() {
		return total;
	}

	public Criteria getCri() {
		return cri;
	}

	@Override
	public String toString() {
		return "PageVo [startPage=" + startPage + ", endPage=" + endPage + ", prev=" + prev + ", next=" + next
				+ ", total=" + total + ", cri=" + cri + "]";
	}
	
}
