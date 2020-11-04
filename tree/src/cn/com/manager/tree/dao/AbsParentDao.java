package cn.com.manager.tree.dao;

import java.util.List;
更哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈哈但是发发发撒打发啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊啊
import javax.annotation.Resource;

import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;

//提供所有dao的公用方法，例如jdbctemplate
@Controller
public abstract class AbsParentDao {
	@Resource
	private NamedParameterJdbcTemplate jdbcTemplate;
	public List query(String sql,Object o,Class clazz){
		
		SqlParameterSource ps=new BeanPropertySqlParameterSource(o);
		return this.jdbcTemplate.query(sql, ps,new BeanPropertyRowMapper(clazz));
		
	}
	
	public void update(String sql,Object o){
		SqlParameterSource para=new BeanPropertySqlParameterSource(o);
		this.jdbcTemplate.update(sql,para);
	}
	public Integer query1(String sql){
		//return this.getJdbcTemplate().getJdbcOperations().query(sql, new BeanPropertyRowMapper(clazz));
		return this.jdbcTemplate.getJdbcOperations().queryForInt(sql);
	}
	
	/*public void setJdbcTemplate(DriverManagerDataSource dataSource){
		jdbcTemplate=new NamedParameterJdbcTemplate(dataSource);
	}
*/
}
