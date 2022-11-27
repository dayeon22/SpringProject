package com.spring.travelmvc.impl;

public class TravelDo {
	private int seq;
	private String title;
	private String writer;
	private String content;
	
	@Override
	public String toString() {
		return "BoardDo [seq=" + seq + 
				", title=" + title + 
				", writer=" + writer + 
				", content=" + content + "]";
	}
	
	public int getSeq() {
		return seq;
	}
	public void setSeq(int seq) {
		this.seq = seq;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
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

}
