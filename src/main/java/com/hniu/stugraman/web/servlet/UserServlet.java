package com.hniu.stugraman.web.servlet;

import com.hniu.stugraman.model.ResultInfo;
import com.hniu.stugraman.model.User;
import com.hniu.stugraman.service.IUserService;
import com.hniu.stugraman.service.impl.UserServiceImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Map;

@WebServlet("/user/*")
public class UserServlet extends BaseServlet {

    private IUserService service = new UserServiceImpl();

    /**
     * 登录验证
     * @param request
     * @param response
     */
    public void login(HttpServletRequest request, HttpServletResponse response){
        // 获取验证码
        String verifycode = request.getParameter("verifycode");
        String checkcode_server = (String) request.getSession().getAttribute("CHECKCODE_SERVER");
        ObjectMapper mapper = new ObjectMapper();
        ResultInfo info = new ResultInfo();
        // 验证码是否正确
        if (!checkcode_server.equalsIgnoreCase(verifycode)){
            // 不正确直接返回

            info.setFlag(false);
            info.setErrorMsg("验证码错误");
            try {
                writeValue(info,response);
            } catch (IOException e) {
                e.printStackTrace();
            }
            return;
        }
        // 正确获取其他数据
        Map<String, String[]> map = request.getParameterMap();
        User user = new User();
        System.out.println(user);
        try {
            BeanUtils.populate(user,map);
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 调用service方法进行登录业务
        User loginUser = service.loginUser(user);

        System.out.println(loginUser);

        if(loginUser != null){
            info.setFlag(true);
            info.setData(loginUser);
            request.getSession().setAttribute("user",loginUser);
        }else {
            info.setFlag(false);
            info.setErrorMsg("用户名，或密码,或类型错误");
        }
        try {
            writeValue(info,response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 退出功能
     * @param request
     * @param response
     */
    public void quit(HttpServletRequest request, HttpServletResponse response) {
        // 删除session中名为user的键值对
        request.getSession().removeAttribute("user");
        // 并设置
        ResultInfo resultInfo = new ResultInfo();
        resultInfo.setFlag(true);
        try {
            writeValue(resultInfo,response);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public void loginOne(HttpServletRequest request, HttpServletResponse response) {
        // 获取session中key为user的value
        User user = (User) request.getSession().getAttribute("user");

        ResultInfo resultInfo = new ResultInfo();

        if(user != null){
            resultInfo.setFlag(true);
            resultInfo.setData(user);
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
