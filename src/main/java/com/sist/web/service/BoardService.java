package com.sist.web.service;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;
import org.apache.ibatis.annotations.Update;

import com.sist.web.vo.BoardVO;

public interface BoardService {
	/*
	 *   	@Select("SELECT no, subject, name, TO_CHAR(regdate, 'yyyy-mm-dd') as dbday "
			+ "FROM board_2 "
			+ "ORDER BY no DESC "
			+ "OFFSET #{start} ROWS FETCH NEXT 10 ROWS ONLY")
			public List<BoardVO> boardListData(int start);
			
			@Select("SELECT CEIL(COUNT(*) / 10.0) FROM board_2")
			public int boardTotalPage();
			// 데이터 추가
			@SelectKey(keyProperty = "no", resultType = int.class, before = true, 
					statement = "SELECT NVL(MAX(no) + 1, 1) as no FROM board_2") // db에서 sequence가 없을 떄 사용
			@Insert("INSERT INTO board_2 VALUES("
					+ "#{no}, #{name}, #{subject}, #{content}, #{pwd}, SYSDATE, 0")
			public void boardInsert(BoardVO vo);
			
			
			// 데이터 상세보기
			@Update("UPDATE board SET "
					+ "hit = hit + 1 "
					+ "WHERE no = #{no}")
			public void updateHitIncrement(int no);
			@Select("SELECT no, name, subject, content, TO_CHAR(regdate, 'yyyy-mm-dd') as dbday, hit "
					+ "FROM board_2 "
					+ "WHERE no = #{no}")
			public BoardVO boardDetailData(int no);
	 */
	public List<BoardVO> boardListData(int start);
	public int boardTotalPage();
	public void boardInsert(BoardVO vo);
	public BoardVO boardDetailData(int no);
}
