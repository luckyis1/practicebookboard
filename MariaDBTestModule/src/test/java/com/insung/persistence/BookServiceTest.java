package com.insung.persistence;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.insung.domain.BookVO;
import com.insung.service.BookService;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })

public class BookServiceTest {

	
	private static final Logger logger = LoggerFactory.getLogger(BookServiceTest.class);
	
	@Inject
	private BookService service;

	
	@Test
	public void getMemberListTest(){
		List<BookVO> vo = service.getBookList();
		for (BookVO booklist : vo) {
			logger.info(booklist.toString());
		}
	}
	
	@Test
	public void getMemberSerch(){
		int bno = 2;
		BookVO vo = service.selectBook(bno);
		
		logger.info(vo.toString() );
	}
	
	@Test
	public void getMemberUpdateTest(){
		int bno = 28;
		BookVO vo = service.selectBook(bno);
		vo.setBook_name("22222");
		service.updateBook(vo);
		
		logger.info(vo.toString());
	}

}
