package com.asomepig.finance.init;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.multiaction.MultiActionController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * finceMan
 * Created by eric on 15-5-29 上午10:49.
 */
@Controller
public class LoginController extends MultiActionController {

    // ============================================= local field
    public String who;


    // ============================================= local method

    /**
     * 默认首页方法
     * 前期默认,后期取配置文件
     * @param request
     * @param response
     * @return ModelAndView
     * @throws Exception
     */
    @RequestMapping("/")
    public ModelAndView index(HttpServletRequest request, HttpServletResponse response) throws Exception {
        return new ModelAndView("main").addObject("mes","Welcome,happy day !");
    }


    /**
     * 登录页面方法
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/login")
    public ModelAndView login(HttpServletRequest request, HttpServletResponse response) throws Exception {

        return new ModelAndView("login");
    }

    // ============================================= private method


}
