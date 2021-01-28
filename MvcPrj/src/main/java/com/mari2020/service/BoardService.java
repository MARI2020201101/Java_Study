package com.mari2020.service;

import java.util.List;

import com.mari2020.domain.BoardVO;
import com.mari2020.domain.Criteria;

public interface BoardService {
	
	long register(BoardVO board);
	BoardVO get(Long bno);
	int modify(BoardVO board);
	int remove(Long bno);
	List<BoardVO> getList();
	List<BoardVO> getListWithPaging(Criteria cri);
	int getTotal(Criteria cri);
}
