package com.hniu.stugraman.service.impl;

import com.hniu.stugraman.dao.IUserDao;
import com.hniu.stugraman.dao.impl.UserDaoImpl;
import com.hniu.stugraman.model.User;
import com.hniu.stugraman.service.IUserService;

public class UserServiceImpl implements IUserService {
    // 创建UserDaoImpl实现类以便于后面进行调用dao中的方法进行数据的访问
    IUserDao dao = new UserDaoImpl();

    /**
     * 登录方法，调用dao中的loginUser(User user)方法去进行数据库访问
     * @param user
     * @return
     */
    @Override
    public User loginUser(User user) {

       User loginUser = dao.loginUser(user);

        return  loginUser;
    }
}
