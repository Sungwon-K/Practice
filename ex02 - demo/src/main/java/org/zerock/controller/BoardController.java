package org.zerock.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import org.zerock.domain.BoardVO;
import org.zerock.domain.Criteria;
import org.zerock.domain.PageDTO;
import org.zerock.service.BoardService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@Controller
@Log4j
@RequestMapping("/board/*")
@AllArgsConstructor
public class BoardController {
	
	private BoardService service;
	
	////목록
	//@GetMapping("/list")
	//public void list(Model model) {
	//	log.info("list");
	//	model.addAttribute("list",service.getList());
	//}
	
	//목록
	/*
	 * @GetMapping("/list") public void list(Criteria cri, Model model) {
	 * log.info("list"); model.addAttribute("list",service.getList()); }
	 */
	  @GetMapping("/list")
	   public void list (Criteria cri,Model model) {
	      
	      log.info("/list");
	      //model을 사용해서 list라는 이름으로 jsp에 목록을 표시하게됨. jsp에서는 list로 모든 attribute전달받게되어, 리스트로 쭉- 나오게 됨.
	      model.addAttribute("list",service.getList(cri));
	      model.addAttribute("pageMaker",new PageDTO(cri,service.getTotal(cri)));
	   }

	
	//등록화면
	@GetMapping("/register")
	public void register() {//register.jsp로 이동
	}
	
	//등록처리
	@PostMapping("/register")
	public String register(BoardVO board, RedirectAttributes rttr) {
		log.info("register: " + board);
		service.register(board);
		rttr.addFlashAttribute("result", board.getBno());
		return "redirect:/board/list";
	}
	
	// 상세보기
	@GetMapping("/get")
	public void get(@RequestParam("bno") Long bno, @ModelAttribute("cri") Criteria cri,Model model) {
		log.info("/get");
		model.addAttribute("board", service.get(bno));
	}
		
	//수정화면
	@GetMapping("/modify")
	public void modify(@RequestParam("bno") Long bno,@ModelAttribute("cri") Criteria cri, Model model) {
		log.info("/modify");
		model.addAttribute("board", service.get(bno));
	}
	
	//수정처리
	@PostMapping("/modify")
	public String modify(BoardVO board, @ModelAttribute("cri") Criteria cri, RedirectAttributes rttr) {
		log.info("modify : " +board);
		if(service.modify(board)) {
			rttr.addFlashAttribute("result","success");
		}
		
		/*
		 * rttr.addAttribute("pageNum",cri.getPageNum());
		 * rttr.addAttribute("amount",cri.getAmount());
		 * rttr.addAttribute("type",cri.getType());
		 * rttr.addAttribute("keyword",cri.getKeyword());
		 */
		
		return "redirect:/board/list"+cri.getListLink();
	}
	
	//삭제처리
	@PostMapping("/remove")
	public String remove(@RequestParam("bno") Long bno, RedirectAttributes rttr,@ModelAttribute("cri") Criteria cri) {
		log.info("remove...." + bno);
		if(service.remove(bno)) {
			rttr.addFlashAttribute("result","success");
		}
		/*
		 * rttr.addAttribute("pageNum", cri.getPageNum()); rttr.addAttribute("amount",
		 * cri.getAmount()); rttr.addAttribute("type",cri.getType());
		 * rttr.addAttribute("keyword",cri.getKeyword());
		 */
		return "redirect:/board/list"+cri.getListLink();
	}
	
	
}