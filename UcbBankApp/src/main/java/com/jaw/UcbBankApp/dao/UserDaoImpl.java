package com.jaw.UcbBankApp.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.MapSqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import com.jaw.UcbBankApp.model.User;



@Repository
public class UserDaoImpl implements UserDao {
	// using the properties config in application.properties- automatically detects
	// and creates.
	@Autowired
	JdbcTemplate jdbcTemplate;


	@Override
	public void insertUser(User user) {

		String sb = "INSERT INTO users (user_id, username, password) VALUES (?,?,?)";

		int usr =	jdbcTemplate.update(sb.toString(), new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {

				ps.setInt(1, user.getUserId());
				ps.setString(2, user.getUserName());
				ps.setString(3, user.getPassword());
			}
		});
	}

	@Override
	public int checkExistingRecord(int id) {
		String string = "SELECT EXISTS(SELECT * from users WHERE user_id=?)";
		int count = jdbcTemplate.queryForObject(string, new Object[] { id }, Integer.class);
		return count;

	}

	@Override
	public User getSingleUserDetail(int id) {
		//List<Object> data = new ArrayList<Object>();
		String str = "select user_id,username,password from users WHERE user_id=?";
		//data.add(id);
		
	//	Object[] array = data.toArray(new Object[data.size()]);
	/*return  jdbcTemplate.query(str.toString(),
			 new ResultSetExtractor() {

				@Override
				public Object extractData(ResultSet arg0) throws SQLException, DataAccessException {
					return null;
				}
		
	});*/
		 return this.jdbcTemplate.query(str.toString(),new Object[] { id }, (ResultSet rs) -> {
			 User usr = new User();
	           while(rs.next()){
	        	  
	        	   usr.setUserId(rs.getInt("user_id"));
	        	   usr.setUserName(rs.getString("username"));
	               usr.setPassword(rs.getString("password"));
	              
	           }
	           return usr;
	      });
			
		
	}

	@Override
	public void updatePassword(User user) {
		String str = "update users set password=? WHERE user_id=? and password=? ";
		int count = jdbcTemplate.update(str, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				ps.setString(1, user.getNewPassword());
				ps.setInt(2, user.getUserId());
				ps.setString(3, user.getPassword());
			}
			
		});
		
	}

	@Override
	public List<User> getUserList() {
		String str = "select user_id,username,password from users";
		List<User> usr = jdbcTemplate.query(str,new UserDetailRowMapper());
		return usr;
	}

}
class UserDetailRowMapper implements RowMapper<User> {

	@Override
	public User mapRow(ResultSet rs, int arg1) throws SQLException {
		User us = new User();
		us.setUserId(rs.getInt("user_id"));
		us.setUserName(rs.getString("username"));
		us.setPassword(rs.getString("password"));
		return us;
	}

}