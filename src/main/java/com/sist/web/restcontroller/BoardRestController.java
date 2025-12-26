package com.sist.web.restcontroller;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.sist.web.controller.MainController;
import com.sist.web.service.BoardService;
import com.sist.web.vo.BoardVO;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
public class BoardRestController {

    private final MainController mainController;
	private final BoardService bService;
	
	@GetMapping("/board/list_vue/")
	public ResponseEntity<Map> board_list(@RequestParam("page") int page)
	{
		Map map = new HashMap();		
			
		try {
			List<BoardVO> list = bService.boardListData((page-1) * 10);
			int totalpage = bService.boardTotalPage();
			map.put("list", list);
			map.put("curpage", page);
			map.put("totalpage", totalpage);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
	
	// 글쓰기
	/*	
		@RequestBody => JSON => 객체변환
							 => javascript에서 전송된 값
		@ModelAttribute => SPring 자체에서 처리
			| 커맨드 객체값 받는 경우
			  --------- VO
		@RequestParam => getParameter() // 단일값 받는 경우
		
		=> mybatis : procedure / function / trigger
		
		=> 동적 쿼리 : 검색
		--------------------------------------- JPA
	*/
	@PostMapping("/board/insert_vue/")
	public ResponseEntity<Map> board_insert(@RequestBody BoardVO vo)
	{
		Map map = new HashMap();		
		
		try {
			bService.boardInsert(vo);
			map.put("msg", "yes");
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
				
		return new ResponseEntity<>(map, HttpStatus.OK);
	}
}
