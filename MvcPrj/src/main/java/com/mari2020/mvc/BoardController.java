package com.mari2020.mvc;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.mari2020.domain.BoardVO;
import com.mari2020.domain.Criteria;
import com.mari2020.domain.PageDTO;
import com.mari2020.service.BoardService;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@RequiredArgsConstructor
@Log4j
@RequestMapping("/board/*")
public class BoardController {
	private final BoardService service;
	@RequestMapping("/list")
	public void list(Model model, Criteria cri) {
		model.addAttribute("list", service.getListWithPaging(cri));
		model.addAttribute("pageMaker",new PageDTO(cri,service.getTotal(cri)));
		log.info("list....................");
		
	}
	
	
	/*
	 * @RequestMapping("/list") public void list(Model model) {
	 * model.addAttribute("list", service.getList());
	 * log.info("list....................");
	 * 
	 * }
	 */
	@GetMapping("/register")
	public void registerForm() {
		log.info("register.......................");
	}
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		log.info("Registered Bno : " + board.getBno());
		log.info("register and redirect.......................");
		return "redirect:/board/list";
	}
	@GetMapping({"/get","/modify"})
	public void get(@RequestParam("bno")long bno, @ModelAttribute("cri")Criteria cri, Model model) {
		model.addAttribute("board",service.get(bno));
	}
	
	@PostMapping("/modify")
	public String modify(BoardVO board, @ModelAttribute("cri")Criteria cri, RedirectAttributes rttr) {
		int count = service.modify(board);
		if(count == 1) {
			rttr.addFlashAttribute("result", "success");
		}
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:/board/list";
	}

	@PostMapping("/remove")
	public String remove(long bno, @ModelAttribute("cri")Criteria cri, RedirectAttributes rttr) {
		int count = service.remove(bno);
		if(count == 1) {
			rttr.addFlashAttribute("result", "success");
		}
		rttr.addAttribute("pageNum", cri.getPageNum());
		rttr.addAttribute("amount", cri.getAmount());
		rttr.addAttribute("type", cri.getType());
		rttr.addAttribute("keyword", cri.getKeyword());
		return "redirect:/board/list";
	}
}
