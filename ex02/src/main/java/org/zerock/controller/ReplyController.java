package org.zerock.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.service.ReplyService;

import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j;

@RequestMapping("/replies/")
@RestController
@Log4j
@AllArgsConstructor

public class ReplyController {
	private ReplyService service;
	
	//등록
	@PostMapping(value = "/new",
			
		//입력(값을 보낼때 json 형태로)
		consumes ="application/json",
		//출력
		produces = {MediaType.TEXT_PLAIN_VALUE})
	
	public ResponseEntity<String> create(@RequestBody ReplyVO vo){
		
		log.info("Reply : "+ vo);
		
		int insertCount = service.register(vo);
		
		log.info("Reply INSERT COUNT: " + insertCount);
		
		return insertCount == 1 ?new ResponseEntity<>("success",HttpStatus.OK)
								:new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		
	}
	
	//목록
	@GetMapping(value="/pages/{bno}/{page}",
			produces = {
					MediaType.APPLICATION_ATOM_XML_VALUE,
					MediaType.APPLICATION_JSON_UTF8_VALUE })
	public ResponseEntity<List<ReplyVO>> getList(
			@PathVariable("page") int page,
			@PathVariable("bno") Long bno) {
				
				log.info("getList.............");
				Criteria cri = new Criteria(page,10);
				log.info(cri);
				
				return new ResponseEntity<>(service.getList(cri, bno), HttpStatus.OK);	
	}
}