package com.mari2020.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.mari2020.domain.BoardVO;

import lombok.extern.log4j.Log4j;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("file:src/main/webapp/WEB-INF/spring/root-context.xml")
@Log4j
public class ServiceTests {
	
	@Autowired
	private BoardService service;

	@Test
	public void testPrint() {
		log.info(service);
	}
	
	
	  @Test 
	  public void testGetList() { 
		  service.getList().forEach(board -> log.info(board)); }
	 
	  @Test
	  public void testRegister() {
		  BoardVO board = new BoardVO();
		  board.setTitle("spring study");
		  board.setContent("공부입니다.");
		  board.setWriter("user06");
		  log.info("--------------------------------registerTest----------------------------------");
		 log.info(service.register(board));
	  }
}
