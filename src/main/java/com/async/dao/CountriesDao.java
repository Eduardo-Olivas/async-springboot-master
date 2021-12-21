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

import com.async.model.Countries;


@Repository
public class CountriesDao {
	
	@SuppressWarnings("unused")
	private static Logger logJava = Logger.getLogger(CountriesDao.class);
	
	@Autowired
	private JdbcTemplate jdbcTemplate;

	public List<Countries> list() {
		String sql = "SELECT * FROM Countries";

		List<Countries> listCountries = jdbcTemplate.query(sql, 
				BeanPropertyRowMapper.newInstance(Countries.class));

		return listCountries;
	}
	
	public void save(Countries Countries) {
		SimpleJdbcInsert insertActor = new SimpleJdbcInsert(jdbcTemplate);
		insertActor.withTableName("Countries").usingColumns("ID", "Name", "Capital","Population","LanguageID");
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(Countries);
		
		insertActor.execute(param);		
	}
	
	public Countries get(int ID) {
		String sql = "SELECT * FROM Countries WHERE ID = ?";
		Object[] args = {ID};
		Countries Countries = jdbcTemplate.queryForObject(sql, args, BeanPropertyRowMapper.newInstance(Countries.class));
		return Countries;
	}
	
	public void update(Countries Countries) {
		
		String sql = "UPDATE Countries SET ID=:ID, Name=:Name, Capital=:Capital, Population=:Population, LanguageID=:LanguageID WHERE ID=:ID";
		BeanPropertySqlParameterSource param = new BeanPropertySqlParameterSource(Countries);
		NamedParameterJdbcTemplate template = new NamedParameterJdbcTemplate(jdbcTemplate);
		template.update(sql, param);		
	}
	
	public void delete(int ID) {
		String sql = "DELETE FROM Countries WHERE ID = ?";

		jdbcTemplate.update(sql, ID);
	}
}