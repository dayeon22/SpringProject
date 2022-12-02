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
		String sql = "INSERT INTO travel (title, writer, content) VALUES(?, ?, ?)";
		jdbcTemplate.update(sql, tdo.getTitle(), tdo.getWriter(), tdo.getContent());
	}
	
	public TravelDo getTravel(TravelDo tdo) {
		String sql = "SELECt * FROM travel WHERE seq=?";
		Object []args = {tdo.getSeq()};
		return jdbcTemplate.queryForObject(sql, args, new TravelRowMapper());
	}
	
	public ArrayList<TravelDo> getTravelList(){
		String sql = "SELECT * FROM travel";		
		Object[] args = {};
		return (ArrayList<TravelDo>) jdbcTemplate.query(sql, args, new TravelRowMapper());
	}
	
	public void updateTravel(TravelDo tdo) {
		String sql = "UPDATE travel SET title=?, content=? WHERE seq=?";
		jdbcTemplate.update(sql, tdo.getTitle(), tdo.getContent(), tdo.getSeq());
	}
	
	public void deleteTravel(TravelDo tdo) {
		String sql = "DELETE FROM travel WHERE seq=?";
		jdbcTemplate.update(sql, tdo.getSeq());
	}
	
	public ArrayList<TravelDo> searchTravelList(String searchCon, String searchKey) {
		String sql = "";
		
		if (searchCon.equals("title")) {
			sql = "SELECT * FROM travel WHERE title=? ORDER BY seq DESC;";
		}
		else if (searchCon.equals("content")) {
			sql = "SELECT * FROM travel WHERE content=? ORDER BY seq DESC;";
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
		tdo.setRegdate(rs.getString(5));
		
		return tdo;
	}
	
}
