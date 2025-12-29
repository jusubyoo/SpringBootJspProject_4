package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.ReplyMapper;
import com.sist.web.vo.ReplyVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ReplyServiceImpl implements ReplyService {
	private final ReplyMapper rMapper;

	@Override
	public List<ReplyVO> replyListData(int cno, int type) {
		// TODO Auto-generated method stub
		return rMapper.replyListData(cno, type);
	}

	@Override
	public void replyInsert(ReplyVO vo) {
		// TODO Auto-generated method stub
		rMapper.replyInsert(vo);
	}
	
	
}
