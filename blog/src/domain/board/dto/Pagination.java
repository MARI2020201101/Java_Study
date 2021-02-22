package domain.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pagination {
	
	private int total; //전체 게시글 수 
	private int criteria = 3; //한 페이지당 게시물 개수
	//private int prevPage;  
	//private int nextPage;
	private int currentPage =1;
	private int startPage;
	private int lastPage;
	private int realLastPage;
	
	//board 게시판의 pageNum 은 10개 기준, 12345678910 -> 11 12 1314...
	// n*(페이지 넘버-1) + 3
	//lastPage = 10, 20, 30, ....
	//lastPage = 10(Math.ceil(currentPage / 10.0))
	//Math.ceil(currentPage / 10.0) 0.1->1 = n

	//realLastPage = Math.ceil(total / criteria*1.0); 100/3 -> 33.3 
	//lastPage =  lastPage < realLastPage ? lastPage : realLastPage;
	
	//쿼리에 들어가는 숫자.  0번째부터 3개 -> 3번째부터 3개 -> 6번째부터 3개 
	//(currentPage -1)*3 = 쿼리 
	public Pagination(int total, int currentPage){
		//10/3.0 ->3.3 올림 하면 4
		this.total = total;
		this.currentPage = currentPage;
		realLastPage = (int) Math.ceil(total / (criteria*1.0));
		lastPage = (int)(10*(Math.ceil(currentPage / 10.0)));
		startPage = lastPage - 9;
		lastPage =  lastPage <= realLastPage ? lastPage : realLastPage;
		//prevPage = currentPage -1;
		//nextPage = lastPage +1;
	
}
}

