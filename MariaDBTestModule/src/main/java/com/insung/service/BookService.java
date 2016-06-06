package com.insung.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.insung.domain.BookVO;
import com.insung.domain.Criteria;
import com.insung.persistence.BookDAO;

@Service
public class BookService {

	@Inject
	BookDAO dao;

	public List<BookVO> getBookList() {
		return dao.selectAll();
	}

	public void insertBook(BookVO vo) {
		dao.insertBook(vo);
	}

	public void deleteBook(int bno) {
		dao.deleteBook(bno);
	}

	public void updateBook(BookVO vo) {
		dao.updateBook(vo);
	}
	
	public List<BookVO> listCriteria(Criteria cri){
		return dao.listCriteria(cri);
		
	}
	public int listCountCriteria(Criteria cri){
		return dao.countPaging(cri);
	}
	
	public BookVO selectBook(int bno){
		return dao.selectMember(bno);
	}
	
	/*
	public List<BookVO> getCri(Criteria cri) {
		return dao.selectPageList(cri);
	}
	*/
}
