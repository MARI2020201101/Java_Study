package com.mari2020.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mari2020.domain.BoardVO;
import com.mari2020.domain.Criteria;
import com.mari2020.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j;

@Service
@RequiredArgsConstructor
@Log4j
@ToString
public class BoardServiceImpl implements BoardService{

	private final BoardMapper mapper;
	
	@Override
	public long register(BoardVO board) {
		mapper.insertSelectKey(board);
		return board.getBno();
	
		
	}

	@Override
	public BoardVO get(Long bno) {	
		return mapper.read(bno);
	}

	@Override
	public int modify(BoardVO board) {
		return mapper.update(board);
	}

	@Override
	public int remove(Long bno) {
		return mapper.delete(bno);
	}

	@Override
	public List<BoardVO> getList() {
		return mapper.getList();
	}

	@Override
	public List<BoardVO> getListWithPaging(Criteria cri) {
		return mapper.getListWithPaging(cri);
	}

	@Override
	public int getTotal(Criteria cri) {
		return mapper.getTotalCount(cri);
	}

}
