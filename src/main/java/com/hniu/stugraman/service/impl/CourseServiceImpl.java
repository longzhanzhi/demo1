package com.hniu.stugraman.service.impl;

import com.hniu.stugraman.dao.impl.CourseDaoImpl;

/**
 * @Author: Steel.D虫洞时空
 * @Date: 2019-10-28 21:17
 * @Version 1.0
 */
public class CourseServiceImpl {
    public void del(int id ){
        CourseDaoImpl courseDao = new CourseDaoImpl();
        courseDao.del(id);
    }
}
