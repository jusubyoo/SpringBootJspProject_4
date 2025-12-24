package com.sist.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.FoodMapper;
import com.sist.web.mapper.SeoulMapper;
import com.sist.web.vo.FoodVO;
import com.sist.web.vo.SeoulVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class SeoulServiceImpl implements SeoulService {
	private final SeoulMapper sMapper;
	private final FoodMapper fMapper;

	@Override
	public List<SeoulVO> seoulListData(Map map) {
		// TODO Auto-generated method stub
		return sMapper.seoulListData(map);
	}

	@Override
	public int seoulTotalPage(Map map) {
		// TODO Auto-generated method stub
		return sMapper.seoulTotalPage(map);
	}

	@Override
	public SeoulVO seoulDetailData(Map map) {
		// TODO Auto-generated method stub
		sMapper.seoulHitIncrement(map);
		return sMapper.seoulDetailData(map);
	}

	@Override
	public List<FoodVO> foodNearData4(String address) {
		// TODO Auto-generated method stub
		return fMapper.foodNearData4(address);
	}
	
	
}
