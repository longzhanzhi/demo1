package com.hniu.stugraman.dao.impl;

import com.hniu.stugraman.dao.IUserDao;
import com.hniu.stugraman.model.User;
import com.hniu.stugraman.utils.JDBCUtils;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;

public class UserDaoImpl implements IUserDao {
    String sql=null;
    private JdbcTemplate jdbcTemplate = new JdbcTemplate(JDBCUtils.getDataSource());
    @Override
    public User loginUser(User user) {
        sql = "select id,username, type,name from user where username = ? and password = ? and type = ?";
        try {
            return jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(User.class), user.getUsername(), user.getPassword(), user.getType());

        } catch (DataAccessException e) {
            return null;
        }
    }
}
