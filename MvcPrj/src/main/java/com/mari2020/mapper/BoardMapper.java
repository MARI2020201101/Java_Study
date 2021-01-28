package com.mari2020.mapper;

import java.util.List;

import com.mari2020.domain.BoardVO;
import com.mari2020.domain.Criteria;

public interface BoardMapper {

	List<BoardVO> getList();
	
	void insert(BoardVO board);
	
	void insertSelectKey(BoardVO board);
	
	BoardVO read(Long bno);
	
	int delete(Long bno);
	
	int update(BoardVO board);
	
	List<BoardVO> getListWithPaging(Criteria cri);
	
	int getTotalCount(Criteria cri);
}
