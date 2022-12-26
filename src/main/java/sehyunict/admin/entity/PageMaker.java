package sehyunict.admin.entity;

import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

public class PageMaker {

		private int totalCount;
		private int startPage;
		private int endPage;
		private boolean prev;
		private boolean next;
		private int displayPageNum = 10;
		private PageVo pvo;

		
		public void setPvo(PageVo pvo) {
			this.pvo = pvo;
		}
		
		public void setTotalCount(int totalCount) {
			this.totalCount = totalCount;
			calcData();
		}
		
		public int getTotalCount() {
			return totalCount;
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
		
		public int getDisplayPageNum() {
			return displayPageNum;
		}
		
		public PageVo getpvo() {
			return pvo;
		}
		 
		private void calcData() {
			endPage = (int) (Math.ceil(pvo.getPage() / (double)displayPageNum) * displayPageNum);
			startPage = (endPage - displayPageNum) + 1;
		  
			int tempEndPage = (int) (Math.ceil(totalCount / (double)pvo.getPerPageNum()));
			if (endPage > tempEndPage) {
				endPage = tempEndPage;
			}
			prev = startPage == 1 ? false : true;
			next = endPage * pvo.getPerPageNum() >= totalCount ? false : true;
		}
		
		public String makeQuery(int page) {
			
			if (pvo.getKeyword() != null && pvo.getSelect() != null) {
			UriComponents uriComponents =
			UriComponentsBuilder.newInstance()
								.queryParam("select", pvo.getSelect())
								.queryParam("keyword", pvo.getKeyword())
							    .queryParam("page", page)
								.queryParam("perPageNum", pvo.getPerPageNum())
								.build();
			
			return uriComponents.toUriString();
			
			} else {
				UriComponents uriComponents =
				UriComponentsBuilder.newInstance()
								.queryParam("page", page)
								.queryParam("perPageNum", pvo.getPerPageNum())
								.build();
				
			return uriComponents.toUriString();
			
			}
		}

		@Override
		public String toString() {
			return "PageMaker [totalCount=" + totalCount + ", startPage=" + startPage + ", endPage=" + endPage
					+ ", prev=" + prev + ", next=" + next + ", displayPageNum=" + displayPageNum + ", pvo=" + pvo + "]";
		}
		
		
		
	}

