package com.spring.travelmvc.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("travelDao")
public class TravelDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void insertTravel(TravelDo tdo) {
		String sql = "insert into travel (title, writer, content) values(?, ?, ?)";
		jdbcTemplate.update(sql, tdo.getTitle(), tdo.getWriter(), tdo.getContent());
	}
	
	public TravelDo getTravel(TravelDo tdo) {
		String sql = "select * from travel where seq=?";
		Object []args = {tdo.getSeq()};
		return jdbcTemplate.queryForObject(sql, args, new TravelRowMapper());
	}
	
	public ArrayList<TravelDo> getTravelList(){
		String sql = "select * from travel";		
		Object[] args = {};
		return (ArrayList<TravelDo>) jdbcTemplate.query(sql, args, new TravelRowMapper());
	}
	
	public void updateTravel(TravelDo tdo) {
		String sql = "update travel set title=?, content=? where seq=?";
		jdbcTemplate.update(sql, tdo.getTitle(), tdo.getContent(), tdo.getSeq());
	}
	
	public void deleteTravel(TravelDo tdo) {
		String sql = "delete from travel where seq=?";
		jdbcTemplate.update(sql, tdo.getSeq());
	}
	
	public ArrayList<TravelDo> searchTravelList(String searchCon, String searchKey) {
		String sql = "";
		
		if (searchCon.equals("title")) {
			sql = "select * from travel where title=? order by seq desc;";
		}
		else if (searchCon.equals("content")) {
			sql = "select * from travel where content=? order by seq desc;";
		}
		Object[] args = {searchKey};
		return (ArrayList<TravelDo>)jdbcTemplate.query(sql, args, new TravelRowMapper());
	}
}


class TravelRowMapper implements RowMapper<TravelDo> {

	@Override
	public TravelDo mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		TravelDo tdo = new TravelDo();
		tdo.setSeq(rs.getInt(1));
		tdo.setTitle(rs.getString(2));
		tdo.setWriter(rs.getString(3));
		tdo.setContent(rs.getString(4));
		
		return tdo;
	}
	
}
