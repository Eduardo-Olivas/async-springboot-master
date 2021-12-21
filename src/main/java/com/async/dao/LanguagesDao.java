package com.async.dao;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import com.async.model.Languages;



@Repository
public class LanguagesDao {
	
	@SuppressWarnings("unused")
	private static Logger logJava = Logger.getLogger(LanguagesDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Languages> list() {
		String sql = "SELECT * FROM Languages";

		List<Languages> listLanguages = jdbcTemplate.query(sql, 
				BeanPropertyRowMapper.newInstance(Languages.class));

		return listLanguages;
	}
	
	public void save(Languages Languages) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("Languages").usingColumns("ID", "Name");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(Languages);
		
		insertActor.execute(param);		
	}
	
	public Languages get(int ID) {
		String sql = "SELECT * FROM Languages WHERE ID = ?";
		Object[] args = {ID};
		Languages Languages = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Languages.class));
		return Languages;
	}
	
	public void update(Languages Languages) {
		
		String sql = "UPDATE Languages SET ID=:ID, Name=:Name WHERE ID=:ID";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(Languages);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);		
	}
	
	public void delete(int ID) {
		String sql = "DELETE FROM Languages WHERE ID = ?";

		jdbcTemplate.update(sql, ID);
	}
}