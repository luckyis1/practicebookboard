package com.insung.controller;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.insung.domain.BookVO;
import com.insung.domain.Criteria;
import com.insung.domain.PageMaker;
import com.insung.service.BookService;

@Controller
@RequestMapping(value = "/book")
public class BookController {

	private static final Logger logger = LoggerFactory.getLogger(BookController.class);

	@Inject
	private BookService service;

	@RequestMapping(value = "", method = RequestMethod.GET)
	public String memberListGET(Criteria cri, Model model) {
		// model.addAttribute("bookList", service.listCriteria(cri));
		// PageMaker pageMaker = new PageMaker();
		// pageMaker.setCri(cri);
		// pageMaker.setTotalCount(131);

		// pageMaker.setTotalCount(service.listCountCriteria(cri));

		// model.addAttribute("pageMaker", pageMaker);

		return "redirect:/book/listCri";
	}

	@RequestMapping(value = "/join", method = RequestMethod.GET)
	public String memberJoinGET() {// 화면을 보여주는애
		return "/book/join";
	}

	@RequestMapping(value = "/join", method = RequestMethod.POST)
	public String memberJoinPOST(BookVO vo) {
		logger.info(vo.toString());
		service.insertBook(vo);
		return "redirect:/book";
	}

	@RequestMapping(value = "/delete/{bno}", method = RequestMethod.POST)
	public @ResponseBody String memberDeletePOST(@PathVariable(value = "bno") int bno) {
		service.deleteBook(bno);
		return "SUCCESS";
	}

	@RequestMapping(value = "/info/{bno}", method = RequestMethod.GET)
	public String memberJoinGET(@PathVariable(value = "bno") int bno, Model model) {
		model.addAttribute("vo", service.selectBook(bno));
		return "/book/info";
	}

	@RequestMapping(value = "/update", method = RequestMethod.POST)
	public String memberUpdateGET(BookVO vo) {
		logger.info(vo.toString());
		service.updateBook(vo);
		return "redirect:/book";
	}

	@RequestMapping(value = "/update/{bno}", method = RequestMethod.GET)
	public String memberUpdateGET(@PathVariable(value = "bno") int bno, Model model) {
		model.addAttribute("vo", service.selectBook(bno));
		// service.deleteBook(bno);
		return "/book/update";
	}

	@RequestMapping(value = "/listCri", method = RequestMethod.GET)
	public void listAll(Criteria cri, Model model) {
		// logger.info(cri.toString());
		model.addAttribute("bookList", service.listCriteria(cri));

		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		// pageMaker.setTotalCount(131);

		pageMaker.setTotalCount(service.listCountCriteria(cri));

		model.addAttribute("pageMaker", pageMaker);

	}

}

// jstl 제거 후 그것을 페이지호출후 ajax로 해서 스크립트로 처리