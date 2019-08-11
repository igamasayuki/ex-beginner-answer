package com.example.repository;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Member;

/**
 * membersテーブルを操作するリポジトリ.
 * 
 * @author igamasayuki
 *
 */
@Repository
@Transactional
public class MemberRepository {
	
	@Autowired
	private NamedParameterJdbcTemplate template;
	
	/** DBテーブルネーム */
	private static final RowMapper<Member> MEMBER_ROW_MAPPER = (rs, i) -> {
		
		Member member = new Member();
		member.setId(rs.getInt("id"));
		member.setName(rs.getString("name"));
		member.setAge(rs.getInt("age"));
		member.setDepId(rs.getInt("dep_id"));
		
		return member;
	};
	
	
	/**
	 * 名前の曖昧検索を行い条件に一致する値を取得します.
	 * 
	 * @param name 名前
	 * @return メンバー情報
	 */
	public List<Member> findByName(String name) {
		StringBuilder sql = new StringBuilder();
		sql.append("SELECT id, name, age, dep_id FROM members WHERE name LIKE :name");
		
		SqlParameterSource param = new MapSqlParameterSource().addValue("name", ("%" + name +"%"));
		
		List<Member> memberList = template.query(sql.toString(), param, MEMBER_ROW_MAPPER);
		
		return memberList;
	}
	
}
