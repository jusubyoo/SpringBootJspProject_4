package com.sist.web.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.BoardMapper;
import com.sist.web.vo.BoardVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService {
	private final BoardMapper bMapper;
	
	@Override
	public List<BoardVO> boardListData(int start) {
		// TODO Auto-generated method stub
		return bMapper.boardListData(start);
	}

	@Override
	public int boardTotalPage() {
		// TODO Auto-generated method stub
		return bMapper.boardTotalPage();
	}

	@Override
	public void boardInsert(BoardVO vo) {
		// TODO Auto-generated method stub
		bMapper.boardInsert(vo);
	}

	@Override
	public BoardVO boardDetailData(int no) {
		// TODO Auto-generated method stub
		bMapper.updateHitIncrement(no);
		return bMapper.boardDetailData(no);
	}

	@Override
	public String boardDelete(int no, String pwd) {
		// TODO Auto-generated method stub
		String res="no";
		String db_pwd=bMapper.boardGetPassword(no);
		if(db_pwd.equals(pwd))
		{
			res="yes";
			bMapper.boardDelete(no);
		}
		return res;
	}

	@Override
	public String boardUpdate(BoardVO vo) {
		// TODO Auto-generated method stub
		String res="no";
		String db_pwd=bMapper.boardGetPassword(vo.getNo());
		if(db_pwd.equals(vo.getPwd()))
		{
			res="yes";
			bMapper.boardUpdate(vo);
		}
		return res;
	}

	@Override
	public BoardVO boardUpdateData(int no) {
		// TODO Auto-generated method stub
		return bMapper.boardDetailData(no);
	}

}
