package com.hniu.stugraman.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.hniu.stugraman.model.Teacher;
import com.hniu.stugraman.service.ITeacherService;
import com.hniu.stugraman.service.impl.TeacherServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @Author: Steel.D虫洞时空
 * @Date: 2019-10-28 23:16
 * @Version 1.0
 */
@WebServlet("/getTeacher")
public class FindTeacherServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        ITeacherService teacherService = new TeacherServiceImpl();
        Teacher teById = teacherService.getTeById(Integer.parseInt(id));
        ObjectMapper objectMapper =  new ObjectMapper();

        resp.setContentType("application/json;charset=utf-8");
        objectMapper.writeValue(resp.getOutputStream(),teById);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req,resp);
    }

}
