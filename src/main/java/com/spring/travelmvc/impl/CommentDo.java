package com.spring.travelmvc.impl;

public class CommentDo {
	private int commentSeq;
	private int travelSeq;
	private String writer;
	private String content;
	private String regdate;
	
	
	public int getCommentSeq() {
		return commentSeq;
	}
	public void setCommentSeq(int commentSeq) {
		this.commentSeq = commentSeq;
	}
	public int getTravelSeq() {
		return travelSeq;
	}
	public void setTravelSeq(int travelSeq) {
		this.travelSeq = travelSeq;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getRegdate() {
		return regdate;
	}
	public void setRegdate(String regdate) {
		this.regdate = regdate;
	}
}
