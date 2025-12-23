package com.sist.web.service;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.BusanMapper;
import com.sist.web.vo.BusanVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BusanServiceImpl implements BusanService {
	private final BusanMapper bMapper;

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
}
