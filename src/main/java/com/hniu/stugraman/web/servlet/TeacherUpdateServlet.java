package com.hniu.stugraman.web.servlet;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.hniu.stugraman.model.Teacher;
import com.hniu.stugraman.model.User;
import com.hniu.stugraman.service.ITeacherService;
import com.hniu.stugraman.service.impl.TeacherServiceImpl;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;


@WebServlet("/updateTeacher")
public class TeacherUpdateServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        Map<String, String[]> parameterMap = req.getParameterMap();

        User user = (User) req.getSession().getAttribute("user");

        int type = user.getType();

        Teacher teacher = new Teacher();
        try {
            BeanUtils.populate(teacher,parameterMap);
            System.out.println(teacher);
            ITeacherService teacherService = new TeacherServiceImpl();
            teacherService.updateTea(teacher);

            if (type == 1){
                req.getRequestDispatcher("/adminFindTeacherList.html").forward(req,resp);
            }
            req.getRequestDispatcher("/teacherList.html").forward(req,resp);

        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
