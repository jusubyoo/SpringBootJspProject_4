package com.sist.web.service;

import org.springframework.stereotype.Service;

import com.sist.web.mapper.MemberMapper;
import com.sist.web.vo.MemberVO;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	private final MemberMapper fMapper;

	@Override
	public MemberVO isLogin(String id, String pwd) {
		// TODO Auto-generated method stub
		MemberVO vo=new MemberVO();
		int count=fMapper.memberIdCheck(id);
		if(count==0)
		{
			vo.setMsg("NOID");
		}
		else
		{
			MemberVO dbVO=fMapper.memberInfoData(id);
			if(pwd.equals(dbVO.getPwd()))
			{
				vo.setMsg("OK");
				vo.setId(dbVO.getId());
				vo.setSex(dbVO.getSex());
				vo.setAddress(dbVO.getAddress());
				vo.setName(dbVO.getName());
			}
			else
			{
				vo.setMsg("NOPWD");
			}
		}
		return vo;
	}

}
