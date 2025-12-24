package com.sist.web.restcontroller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
// front 연동 => vue : pinia => vue 의 문법 => javascript
// 1. java 2. oracle 3. jsp (mvc) 4. spring
import java.util.*;
import com.sist.web.service.*;
import com.sist.web.vo.*;

import lombok.RequiredArgsConstructor;
@RestController
@RequiredArgsConstructor
public class SeoulRestController {
	private final SeoulService sService;
	private String[] tables= {
		"","seoul_location","seoul_nature","seoul_shop"
	};
	
	@GetMapping("/seoul/list_vue/")
	// ResponseEntity => 비동기적으로 처리
	public ResponseEntity<Map> seoul_list_vue(@RequestParam("page") int page, @RequestParam("type") int type)
	{
		Map map=new HashMap();
		try
		{
			map.put("table_name", tables[type]);
			map.put("start", (page-1)*6);
			List<SeoulVO> list=sService.seoulListData(map);
			int totalpage=sService.seoulTotalPage(map);
			
			final int BLOCK=10;
			int startPage=((page-1)/BLOCK*BLOCK)+1;
			int endPage=((page-1)/BLOCK*BLOCK)+BLOCK;
			
			if(endPage>totalpage)
				endPage=totalpage;
			
			// 출력에 필요한 데이터를 Vue 로 전송
			map=new HashMap();
			map.put("list", list);
			map.put("curpage", page);
			map.put("startPage", startPage);
			map.put("endPage", endPage);
			map.put("totalpage", totalpage);
			map.put("type", type);
			
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
	
	@GetMapping("/seoul/detail_vue/")
	public ResponseEntity<Map> seoul_detail_vue(@RequestParam("no") int no, @RequestParam("type") int type)
	{
		Map map=new HashMap();
		try
		{
			map.put("table_name", tables[type]);
			map.put("no", no);
			SeoulVO vo=sService.seoulDetailData(map);
			String[] datas=vo.getAddress().split(" ");
			// 03718 서울특별시 서대문구 연희로32길 51 (연희동)
			List<FoodVO> list=sService.foodNearData4(datas[2]);
			// => 주변 맛집
			map=new HashMap();
			map.put("vo", vo);
			map.put("list", list);
		}catch(Exception ex)
		{
			ex.printStackTrace();
			return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
		}
		return new ResponseEntity<>(map,HttpStatus.OK);
	}
}
