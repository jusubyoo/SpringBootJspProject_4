package com.sist.web.vo;

import java.sql.Date;

import lombok.Data;

@Data
public class ReplyVO {
	private int no,cno,type;
	private String id,name,msg,dbday;
	private Date regdate;
}
