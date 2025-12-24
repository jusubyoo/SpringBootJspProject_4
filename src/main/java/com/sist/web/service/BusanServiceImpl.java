package com.sist.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.BusanMapper;
import com.sist.web.mapper.FoodMapper;
import com.sist.web.vo.BusanVO;
import com.sist.web.vo.FoodVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BusanServiceImpl implements BusanService {
	private final BusanMapper bMapper;
	private final FoodMapper fMapper;

	@Override
	public List<BusanVO> busanListData(Map map) {
		// TODO Auto-generated method stub
		return bMapper.busanListData(map);
	}

	@Override
	public int busanTotalpage(Map map) {
		// TODO Auto-generated method stub
		return bMapper.busanTotalpage(map);
	}

	@Override
	public BusanVO busanDetailData(int no) {
		// TODO Auto-generated method stub
		bMapper.busanHitIncrement(no);
		return bMapper.busanDetailData(no);
	}

	@Override
	public List<FoodVO> foodNearData4(String address) {
		// TODO Auto-generated method stub
		return fMapper.foodNearData4(address);
	}
}
