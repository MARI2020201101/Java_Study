package com.mari2020.persistence;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mari2020.domain.BoardVO;
import com.mari2020.domain.Criteria;
import com.mari2020.mapper.BoardMapper;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class BoardMapperTests {
	
	@Autowired
	private BoardMapper boardMapper;
	
	@Test
	public void getListTest() {
		log.info("-------------------------getListTest--------------------------");
		boardMapper.getList();
	}
	
	@Test
	public void insertTest() {
		log.info("---------------------------insertTest-------------------------");
		BoardVO board = new BoardVO();
		board.setTitle("테스트입니다.");
		board.setContent("test");
		board.setWriter("user04");
		boardMapper.insert(board);
	}
	
	@Test
	public void insertSelectKeyTest() {
		log.info("----------------------insertSelectKeyTest---------------------");
		BoardVO board = new BoardVO();
		board.setTitle("aaatest");
		board.setContent("aaatestContent");
		board.setWriter("user03");
		boardMapper.insertSelectKey(board);
	}
	
	@Test
	public void readTest() {
		log.info("-----------------------readTest-----------------------");
		boardMapper.read(1L);
	}
	
	@Test
	public void deleteTest() {
		log.info("-----------------------deleteTest-----------------------");
		int n = boardMapper.delete(38L);
		log.info("delete bno : " + n);
	}
	
	@Test
	public void updateTest() {
		log.info("-----------------------updateTest-----------------------");
		BoardVO board = new BoardVO();
		board.setBno(39L);
		board.setTitle("변경update");
		board.setContent("변경 content");
		board.setWriter("user05");
		int n = boardMapper.update(board);
		log.info("update bno : " + n);
	}
	
	@Test
	public void getListWithPagingTest() {
		log.info("-----------------------getListWithPagingTest--------------------------");
		Criteria cri = new Criteria();
		List<BoardVO>list = boardMapper.getListWithPaging(cri);
		list.forEach(board -> log.info(board));
	
	}
	
	@Test
	public void testSearchPaging() {
		log.info("-----------------------searchTest--------------------------");
		Criteria cri = new Criteria();
		cri.setType("TWC");
		cri.setKeyword("test");
		List<BoardVO> list = boardMapper.getListWithPaging(cri);
		list.forEach(b -> log.info(b));
	}

}
