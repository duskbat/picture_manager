package com.pm.controller;

import com.pm.entity.FileUp;
import com.pm.entity.MyKeyword;
import com.pm.entity.User;
import com.pm.service.FileService;
import com.pm.service.LoginService;
import com.pm.utils.MD5Utils;
import com.pm.utils.RandomCode;
import com.pm.utils.SendEmailUtil;
import org.apache.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.ws.spi.http.HttpContext;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/")
public class LoginController {

    @Autowired
    LoginService loginService;

    @RequestMapping("/login")
    public String toLogin(Model model, String username, String password, HttpSession session, HttpServletRequest request) {
        User user = loginService.getUser(username, password);
        if (user == null) {
            List<MyKeyword> keywords = loginService.selectKeyword();
            model.addAttribute("keywords", keywords);
            return "redirect:/login.jsp";
        } else {
            session.setAttribute("user", user);

            if (user.getAdmin().equals("管理员")) {

                return "forward:/company_auditing";
            }

            return "redirect:/logged_index";
        }
    }


    @RequestMapping("/login_out")
    public String logout(HttpSession session, Model model) {
        session.removeAttribute("user");
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);
        return "redirect:/login.jsp";
    }


    @RequestMapping("/register")
    public String register(Model model) {
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);
        return "redirect:/register.jsp";
    }


    @RequestMapping("/checkName")
    @ResponseBody
    public String checkName(Model model, @RequestBody String username) {
        System.out.println(username);
        User user = loginService.checkName(username);
        if (user == null) {
            return "notuser";
        } else {
            return "isuser";
        }


    }


    @RequestMapping("/registerForm")
    public String registerForm(String username, String password, String nickname, String email, String admin) {
        loginService.addUser(username, password, nickname, email, admin);
        return "redirect:/login.jsp";
    }

    @RequestMapping("/find_password")
    public String find_password(Model model) {
        List<MyKeyword> keywords = loginService.selectKeyword();
        model.addAttribute("keywords", keywords);
        return "redirect:/find_password.jsp";
    }

    /**
     * 请求发送邮件，目前来说只有找回密码有发送邮件功能，如果多个功能都有，就要考虑复用性和url名字可识性
     * Created by gf on 2017年7月19日
     * 改为ajax方式 2017-07-25
     *
     * @param email
     * @return
     */

    @RequestMapping("/sendEmail")
    @ResponseBody
    public Map sendEmail(@RequestBody String email) {
        HashMap map = new HashMap();

        //根据给定的邮箱发送邮件
        User user = loginService.queryUserByEmail(email);

        if (user == null) {
            //用户为空，说明填写的邮箱就不对
            map.put("success", false);
            map.put("message", "邮箱账号不存在");
            return map;
        }
        //先生成验证码，先发送邮件，发送成功后保存验证码
        String captcha = RandomCode.randomString(4);
        //先发送验证码，发送成功了再保存到数据库
        boolean b = SendEmailUtil.sendPasswordCaptchaEmail(email, captcha);
        if (b) {
            //发送成功，保存
            map.put("success", true);
            map.put("message", "验证码已发送到您的邮箱，请注意查收");
            loginService.updateUserCaptcha(email, captcha);
        } else {
            //发送失败，提醒
            map.put("success", false);
            map.put("message", "验证码发送失败，请检查邮箱账号");
        }

        return map;
    }


    /**
     * 提交邮箱和收到的验证码信息
     * Created by gf on 2017年7月19日
     *
     * @return
     */
    @RequestMapping("/submitCaptcha")
    public String submitCaptcha(String email, String captcha, Model model) {

        //校验验证码和邮箱信息是否有效
        User user = loginService.queryUserByEmail(email);

        if (user == null) {
            //用户为空，说明填写的邮箱就不对
            model.addAttribute("message", "邮箱账号不存在");
        } else {
            if (captcha != null && !captcha.equals("") && captcha.equals(user.getCaptcha())) {


                //验证成功了，返回重置密码的页面
                model.addAttribute("email", email);
                model.addAttribute("captcha", captcha);

                return "forward:/reset_password.jsp";
            } else {
                //验证码不对或验证码不存在
                model.addAttribute("message", "验证码不正确或不存在");
            }
        }
        return "redirect:/find_password.jsp";
    }

    /**
     * 提交重置密码请求，包括新密码、邮箱接收的验证码等
     * Created by gf on 2017年7月19日
     *
     * @return
     */
    @RequestMapping("/resetPass")
    public String resetPass(String email, String captcha, String password, Model model) {
        //重置密码
        //先检查提交的邮箱和验证码信息是否有效，和上一步的验证一样，然后再去更新此邮箱的用户密码
        //这里都省略了数据校验
        //校验验证码和邮箱信息是否有效
        User user = loginService.queryUserByEmail(email);

        System.out.println(email + "666666666666");
        System.out.println(captcha + "8888888888");
        System.out.println(password + "9999999999");


        if (user == null) {
            //用户为空，说明填写的邮箱就不对
            model.addAttribute("message", "邮箱账号不存在");
        } else {

            if (captcha != null && !captcha.equals("") && captcha.equals(user.getCaptcha())) {
                //验证成功了，返回重置密码的页面
                //验证成功了，更新密码，然后跳转到首页，重新让用户登录
                loginService.updateUserPwd(user.getId(), password);
                //删除验证码
//                loginService.cleanCaptcha(user.getEmail());
                model.addAttribute("message", "密码更新成功了，请重新登录");
//              return "front/message";
                //跳到首页了，其实应该用ajax，返回个更新成功的消息的
                return "redirect:/login.jsp";
            } else {
                //验证码不对或验证码不存在
                model.addAttribute("message", "验证码不正确或不存在");
            }
        }

        return "redirect:/find_password.jsp";
    }


}
