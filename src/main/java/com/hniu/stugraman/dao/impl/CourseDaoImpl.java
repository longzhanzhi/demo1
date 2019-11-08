package com.hniu.stugraman.dao.impl;

import com.hniu.stugraman.utils.JDBCUtils;
import org.springframework.jdbc.core.JdbcTemplate;

/**
 * @Author: Steel.D虫洞时空
 * @Date: 2019-10-28 21:18
 * @Version 1.0
 */
public class CourseDaoImpl {
public void del(int id){
    JdbcTemplate jtl = new JdbcTemplate(JDBCUtils.getDataSource());
    String sql  =  "delete from course where id=?";
    int update = jtl.update(sql, id);
    System.out.println(update);
}
}
