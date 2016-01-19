package com.myapp.app.controller;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.lang3.StringUtils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.util.WebUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.myapp.app.entity.User;
import com.myapp.app.util.ValidateCode;

@Controller
public class LoginController {
	
    @RequestMapping(value = "/login" ,method=RequestMethod.POST,produces={"application/json;charset=UTF-8"})
    public String login(User currUser,HttpSession session, HttpServletRequest request){
//        String code = (String) session.getAttribute("validateCode");
//        String submitCode = WebUtils.getCleanParam(request, "validateCode");
//        if (StringUtils.isEmpty(submitCode) || !StringUtils.equals(code,submitCode.toLowerCase())) {
//            return "redirect:/login";
//        }
        Subject user = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(currUser.getAccount(),currUser.getPassword());
        token.setRememberMe(true);
        try {
            user.login(token);
            return "redirect:backer/index.html";
        }catch (AuthenticationException e) {
            token.clear();
            return "redirect:backer/login.jsp";
        }
    }

    /**
     * 生成验证码
     * @param request
     * @param response
     * @throws IOException
     */
    @RequestMapping(value = "/validateCode")
    public void validateCode(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setHeader("Cache-Control", "no-cache");
        String verifyCode = ValidateCode.generateTextCode(ValidateCode.TYPE_NUM_ONLY, 4, null);
        request.getSession().setAttribute("validateCode", verifyCode);
        response.setContentType("image/jpeg");
        BufferedImage bim = ValidateCode.generateImageCode(verifyCode, 90, 30, 3, true, Color.WHITE, Color.BLACK, null);
        ImageIO.write(bim, "JPEG", response.getOutputStream());
    }
}