package cn.sixboys.controller;

import cn.sixboys.domain.Employee;
import cn.sixboys.domain.JsonResult;
import cn.sixboys.service.IEmployeeService;
import com.wf.captcha.utils.CaptchaUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * @author mingjuntang
 * @Data 2021/5/24 21:49
 */
@Controller
@RequestMapping("/login")
public class LoginController {
    @Resource
    private IEmployeeService employeeService;
    @RequestMapping("/captcha")
    public void captcha(HttpServletRequest request, HttpServletResponse response) throws Exception {
        CaptchaUtil.out(request, response);
    }

    @RequestMapping("/login")
    @ResponseBody
    private JsonResult login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("username");
        String password = req.getParameter("password");
        String code = req.getParameter("code");
        if (CaptchaUtil.ver(code, req)) {
            CaptchaUtil.clear(req);  // 清除session中的验证码
            return new JsonResult(false, "登录失败");
        }
        Employee employee = new Employee();
        employee.setName(name);
        employee.setPassword(password);

        Employee login = employeeService.login(employee);
        if (login == null) {
            // 登陆失败
            return new JsonResult(false, "登录失败");
        } else {
            // 登陆成功， 返回login，并设置cookie，免用户名登陆
            Cookie cookiename = new Cookie("name", URLEncoder.encode(employee.getName(), "UTF-8"));
            // 设置cookie时间
            cookiename.setMaxAge(60 * 60 * 24 * 7);
            Map extend = new HashMap();
            extend.put("info", login);
            extend.put("token", cookiename);
            return new JsonResult(true, "登录成功", extend);
        }
    }
}
