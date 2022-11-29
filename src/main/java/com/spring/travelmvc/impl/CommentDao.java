package com.spring.travelmvc.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("commentDao")
public class CommentDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void insertComment(TravelDo tdo, CommentDo cdo) { // 잘 안되면 tdo대신 글 번호만 받아서 하기
		String sql = "INSERT INTO comment(travel_seq, writer, content) VALUES(?, ?, ?)";
		jdbcTemplate.update(sql, tdo.getSeq(), cdo.getWriter(), cdo.getContent());
	}
	
	public ArrayList<CommentDo> getCommentList(TravelDo tdo) {
		String sql = "SELECT * FROM comment WHERE travel_seq=?";
		Object[] args = {tdo.getSeq()};
		return (ArrayList<CommentDo>) jdbcTemplate.query(sql, args, new CommentRowMapper());
	}
	
	public void updateComment(CommentDo cdo) {
		String sql = "UPDATE comment SET content=? WHERE comment_seq=?";
		jdbcTemplate.update(sql, cdo.getContent(), cdo.getCommentSeq());
		System.out.println("UPDATE FINISHED!!!");
	}
	
	public void deleteComment(CommentDo cdo) {
		System.out.println(cdo.getCommentSeq());
		String sql = "DELETE FROM comment WHERE comment_seq=?";
		jdbcTemplate.update(sql, cdo.getCommentSeq());
	}
}

class CommentRowMapper implements RowMapper<CommentDo> {

	@Override
	public CommentDo mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		CommentDo cdo = new CommentDo();
		cdo.setCommentSeq(rs.getInt(1));
		cdo.setTravelSeq(rs.getInt(2));
		cdo.setWriter(rs.getString(3));
		cdo.setContent(rs.getString(4));
		cdo.setRegdate(rs.getString(5));
		
		return cdo;
	}
	
}