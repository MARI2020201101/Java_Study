package domain.board.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Pagination {
	
	private int total; //��ü �Խñ� �� 
	private int criteria = 3; //�� �������� �Խù� ����
	//private int prevPage;  
	//private int nextPage;
	private int currentPage =1;
	private int startPage;
	private int lastPage;
	private int realLastPage;
	
	//board �Խ����� pageNum �� 10�� ����, 12345678910 -> 11 12 1314...
	// n*(������ �ѹ�-1) + 3
	//lastPage = 10, 20, 30, ....
	//lastPage = 10(Math.ceil(currentPage / 10.0))
	//Math.ceil(currentPage / 10.0) 0.1->1 = n

	//realLastPage = Math.ceil(total / criteria*1.0); 100/3 -> 33.3 
	//lastPage =  lastPage < realLastPage ? lastPage : realLastPage;
	
	//������ ���� ����.  0��°���� 3�� -> 3��°���� 3�� -> 6��°���� 3�� 
	//(currentPage -1)*3 = ���� 
	public Pagination(int total, int currentPage){
		//10/3.0 ->3.3 �ø� �ϸ� 4
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

