package com.hniu.stugraman.web.servlet;

import com.hniu.stugraman.model.Student;
import com.hniu.stugraman.model.Teacher;
import com.hniu.stugraman.model.User;
import com.hniu.stugraman.service.IStudentService;
import com.hniu.stugraman.service.ITeacherService;
import com.hniu.stugraman.service.impl.StudentServiceImpl;
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


@WebServlet("/updateStudent")
public class StudentUpdateServlet extends HttpServlet {
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

        Student student = new Student();
        try {
            BeanUtils.populate(student,parameterMap);
            System.out.println(student);

            IStudentService studentService = new StudentServiceImpl();
            studentService.update(student);
            if (type == 3){
                req.getRequestDispatcher("/teacherFinStudentList.html").forward(req,resp);
            }else {
                 req.getRequestDispatcher("/stulist.html").forward(req,resp);
            }

        } catch (IllegalAccessException e) {
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
