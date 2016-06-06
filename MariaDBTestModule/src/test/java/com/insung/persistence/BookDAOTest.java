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
import com.insung.domain.Criteria;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "file:src/main/webapp/WEB-INF/spring/**/*.xml" })

public class BookDAOTest {

	private static final Logger logger = LoggerFactory.getLogger(BookDAOTest.class);

	@Inject
	private BookDAO dao;

	@Test
	public void test() {
		logger.info(dao.getTime());
	}

	@Test
	public void selectTest() {
		List<BookVO> list = dao.selectAll();

		for (BookVO bv : list) {
			logger.info(bv.toString());
		}

	}

	@Test
	public void insertTest() {
		BookVO vo = new BookVO();
		vo.setBook_name("booknamewow");
		vo.setName("hi");
		vo.setAuthor("hi");
		vo.setPrice(10000);

		dao.insertBook(vo);
	}

	@Test
	public void deleteTest() {
		int bno = 1;
		dao.deleteBook(bno);
	}

	@Test
	public void updateTest() {
		int bno = 4;
		BookVO vo = dao.selectMember(bno);
		vo.setAuthor("123456578");
		vo.setPrice(123456);
		dao.updateBook(vo);
	}

	@Test
	public void setmemberTest() {
		Integer bno = 2;
		BookVO vo = dao.selectMember(bno);
		logger.info(vo.toString());
	}

	@Test
	public void testListPage() {
		int page = 2;
		List<BookVO> list = dao.listPage(page);

		for (BookVO bookVO : list) {

			// logger.info(bookVO.getBno() + ":" + bookVO.getBook_name() );
		}
	}

	@Test
	public void testListCriteria() {
		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPerPageNum(10);
		List<BookVO> list = dao.listCriteria(cri);

		for (BookVO bookVO : list) {

			logger.info(bookVO.getBno() + ":" + bookVO.getBook_name());
		}
	}
}
