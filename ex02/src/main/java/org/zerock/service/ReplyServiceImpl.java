package org.zerock.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.zerock.domain.Criteria;
import org.zerock.domain.ReplyVO;
import org.zerock.mapper.ReplyMapper;

import lombok.Setter;
import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ReplyServiceImpl implements ReplyService {
	
	//Spring문법은 @Setter대신
	//@Autowired
	
	@Setter(onMethod_= @Autowired)
	private ReplyMapper mapper;

	@Override
	public int register(ReplyVO vo) {
		
		log.info("register...." + vo);
		return mapper.insert(vo);
	}

	@Override
	public List<ReplyVO> getList(Criteria cri, Long bno) {
		log.info("get Reply List of a Board "+bno);
		return mapper.getListWithPaging(cri,bno);
	}


}
