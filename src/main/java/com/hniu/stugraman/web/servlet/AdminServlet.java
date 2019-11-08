package com.hniu.stugraman.web.servlet;

import com.hniu.stugraman.model.*;
import com.hniu.stugraman.service.IAdminService;
import com.hniu.stugraman.service.impl.AdminServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/admin/*")
public class AdminServlet extends BaseServlet {
    IAdminService service = new AdminServiceImpl();
    /**
     * 查询所有的课程信息
     * @param request
     * @param response
     */
    public void findCource(HttpServletRequest request, HttpServletResponse response){


        List<Course> list = service.findCource();
        try {
            writeValue(list,response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

/**
 * 查询所有的账号信息
 * @param request
 * @param response
 */
public void findAccont(HttpServletRequest request, HttpServletResponse response){

    List<User> list = service.findAccount();
    try {
        writeValue(list,response);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
/**
 * 查询所有的老师基本信息
 * @param request
 * @param response
 */
public void findAllTeacher(HttpServletRequest request, HttpServletResponse response){
    List<Teacher> teachers = service.findAllTeacher();

    ResultInfo resultInfo = new ResultInfo();

    if(teachers != null){
        resultInfo.setFlag(true);
        resultInfo.setData(teachers);
    }
    else {
        resultInfo.setFlag(false);
    }try {
        writeValue(resultInfo,response);
    } catch (IOException e) {
        e.printStackTrace();
    }
}
}
