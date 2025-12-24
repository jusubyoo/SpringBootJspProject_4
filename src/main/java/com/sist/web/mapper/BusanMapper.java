package com.sist.web.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.sist.web.vo.*;

@Mapper
@Repository
public interface BusanMapper {
	/*
	 *   	<sql id="where-sql">
				WHERE 
				<choose>
					<when test="type==1">
						contenttype=12
					</when>
					<when test="type==2">
						contenttype=14
					</when>
					<when test="type==3">
						contenttype=15
					</when>
					<when test="type==4">
						contenttype=32
					</when>
					<when test="type==5">
						contenttype=38
					</when>
					<when test="type==6">
						contenttype=39
					</when>
				</choose>
			</sql>
			<select id="busanListData" resultType="com.sist.web.vo.BusanVO" parameterType="hashmap">
				SELECT no,title,image1,contentid,address,hit,contenttype
				FROM busantravel
				<include refid="where-sql"/>
				OFFSET #{start} ROWS FETCH NEXT 6 ROWS ONLY
			</select>
			<select id="busanTotalpage" resultType="int" parameterType="hashmap">
				SELECT CEIL(COUNT(*)/6.0) 
				FROM busantravel
				<include refid="where-sql"/>
			</select>
	 */
	public List<BusanVO> busanListData(Map map);
	public int busanTotalpage(Map map);
	
	@Update("UPDATE busantravel SET hit=hit+1 WHERE no=#{no}")
	public void busanHitIncrement(int no);
	
	@Select("SELECT * FROM busantravel WHERE no=#{no}")
	public BusanVO busanDetailData(int no);
}
