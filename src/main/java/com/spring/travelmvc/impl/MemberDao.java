package com.spring.travelmvc.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

@Repository("memberDao")
public class MemberDao {
	
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void insertMember(MemberDo mdo) {
		String sql = "INSERT INTO member VALUES(?, ?, ?, ?, ?)";
		jdbcTemplate.update(sql, mdo.getId(), mdo.getPassword(), mdo.getName(), mdo.getAge(), mdo.getGender());
	}
	
	public ArrayList<MemberDo> getMemberById(String id) {
		String sql = "SELECT * FROM member WHERE id=?";
		Object[]args = {id};
		return (ArrayList<MemberDo>)jdbcTemplate.query(sql, args, new MemberRowMapper());
	}
	
	public void deleteMember(MemberDo mdo) {
		String sql = "DELETE FROM member WHERE id=?";
		jdbcTemplate.update(sql, mdo.getId());
	}
}


class MemberRowMapper implements RowMapper<MemberDo> {

	@Override
	public MemberDo mapRow(ResultSet rs, int rowNum) throws SQLException {
		
		MemberDo mdo = new MemberDo();
		mdo.setId(rs.getString(1));
		mdo.setPassword(rs.getString(2));
		mdo.setName(rs.getString(3));
		mdo.setAge(rs.getInt(4));
		mdo.setGender(rs.getString(5));
		
		return mdo;
	}
	
}
