package com.hniu.stugraman.web.servlet;

import com.hniu.stugraman.model.EScore;
import com.hniu.stugraman.model.ResultInfo;
import com.hniu.stugraman.model.Student;
import com.hniu.stugraman.service.IStudentService;
import com.hniu.stugraman.service.impl.StudentServiceImpl;
import com.hniu.stugraman.model.User;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/stu/*")
public class StudentServlet extends BaseServlet {
    private IStudentService service = new StudentServiceImpl();
    /**
     * 查询所有的成绩信息
     * @param request
     * @param response
     */
    public void findScore(HttpServletRequest request, HttpServletResponse response){
        //从session中获取User
        User user = (User) request.getSession().getAttribute("user");
        // 调用service方法查询学生的所有成绩
        Student student = service.findScore(user);


        ResultInfo resultInfo = new ResultInfo();

        if(student != null){
            resultInfo.setFlag(true);
            resultInfo.setData(student);
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
        //从session中获取User
        User user = (User) request.getSession().getAttribute("user");
        Student student = service.findAll(user);


        ResultInfo resultInfo = new ResultInfo();

        if(student != null){
            resultInfo.setFlag(true);
            resultInfo.setData(student);
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
