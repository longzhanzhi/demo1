package com.hniu.stugraman.web.servlet;

import com.hniu.stugraman.model.ResultInfo;
import com.hniu.stugraman.model.Student;
import com.hniu.stugraman.model.Teacher;
import com.hniu.stugraman.model.User;
import com.hniu.stugraman.service.IStudentService;
import com.hniu.stugraman.service.ITeacherService;
import com.hniu.stugraman.service.impl.StudentServiceImpl;
import com.hniu.stugraman.service.impl.TeacherServiceImpl;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/teacher/*")
public class TeacherServlet extends BaseServlet {
    private ITeacherService service = new TeacherServiceImpl();
    /**
     * 查询所有的成绩信息
     * @param request
     * @param response
     */
    public void findScore(HttpServletRequest request, HttpServletResponse response){
        List<Student> students = service.findAllScore();

        ResultInfo resultInfo = new ResultInfo();

        if(students != null){
            resultInfo.setFlag(true);
            resultInfo.setData(students);
        }
        else {
            resultInfo.setFlag(false);
        }try {
            writeValue(resultInfo,response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    // 查询所有的学生集合
    public void findAllStudnet(HttpServletRequest request, HttpServletResponse response){
        List<Student> students = service.findAllStudent();

        ResultInfo resultInfo = new ResultInfo();

        if(students != null){
            resultInfo.setFlag(true);
            resultInfo.setData(students);
        }
        else {
            resultInfo.setFlag(false);
        }try {
            writeValue(resultInfo,response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void findOne(HttpServletRequest request, HttpServletResponse response){
        User user = (User) request.getSession().getAttribute("user");

        Teacher teacher = service.findOne(user);

        ResultInfo resultInfo = new ResultInfo();

        if(teacher != null){
            resultInfo.setFlag(true);
            resultInfo.setData(teacher);
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
