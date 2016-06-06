package com.insung.persistence;

import java.util.List;

import javax.inject.Inject;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.insung.domain.BookVO;
import com.insung.domain.Criteria;

@Repository
public class BookDAO {
	
	
	@Inject
	private SqlSession session;
	private String namespace="com.insung.BookMapper.";
	
	public String getTime() {
			return session.selectOne(namespace+"getNow");
	}
	
	public List<BookVO> selectAll() {
		List<BookVO> list = session.selectList(namespace+"selectList");
		
		return list; 
	}
	
	public BookVO selectMember(int bno) { 
		return session.selectOne(namespace+"selectOne",bno); 
	}

	
	public void insertBook(BookVO vo) {
		session.insert(namespace+"insert",vo); 
	}

	public void updateBook(BookVO vo) {
		session.update(namespace+"update",vo); 
	}

	public void deleteBook(int bno) {
		session.delete(namespace+"delete",bno); 
	}
	
	
	public List<BookVO> listPage(int page){
		
		if( page<=0) {
			page = 1;
		}
		
		page = (page -1) * 10;
		
		return session.selectList(namespace+"listpage", page);
	}
	
	
	public List<BookVO> listCriteria(Criteria cri){
		return session.selectList(namespace+"listCriteria", cri);
	}
	
	public int countPaging(Criteria cri){
		return session.selectOne(namespace+"countPaging",cri);
		
	}
	
	/*
	public List<BookVO> selectPageList(Criteria cri) {
	      return session.selectList(namespace+"selectPageList", cri);
	   }
	*/
	
	
}
