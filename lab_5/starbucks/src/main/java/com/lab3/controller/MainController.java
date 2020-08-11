package com.lab3.controller;

import com.lab3.data.DataFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@SessionAttributes({"user"})
public class MainController {
    @Autowired
    private DataFacade dataFacade;
    @RequestMapping(value = "/")

    public String showIndexPage(Model model,HttpServletRequest request)
    {
        return"index";
    }
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String loginSuccessful(Model model, @RequestParam String name, @RequestParam String password, HttpSession session)
    {
        boolean checkCredential=checkCredential(name,password);
        if(checkCredential==true) {
          model.addAttribute("user",name);
            return "successful-page";
        }
       return"redirect:/";
    }
    @RequestMapping(value = "/advice",method = RequestMethod.GET)
    public String getAdviceForm(Model model,HttpServletRequest request)
    {
        if(request.getSession().getAttribute("user")!=null) {
            return "advice";
        }
        else
        {
            return "redirect:/";
        }
    }
    @RequestMapping(value = "/advice", method = RequestMethod.POST)
    public String showAdvice(Model model,@RequestParam String roast,HttpServletRequest request)
    {

        if(request.getSession().getAttribute("user")!=null) {
            System.out.println( request.getSession().getAttribute("user"));
            model.addAttribute("advices", dataFacade.getAdvice(roast));
            return "display";
        }
        else
        {
            return "redirect:/";
        }
    }

    @RequestMapping(value = "/logout", method = RequestMethod.GET)
    public String logout(HttpServletRequest request, HttpServletResponse response, SessionStatus status)
    {
        status.setComplete();
//            request.getSession().invalidate();
//        System.out.println("here");
//            Cookie cookie=new Cookie("user","null");
//            cookie.setMaxAge(0);
            return "redirect:/";
    }
    private boolean checkCredential(String name, String password) {
        String expectedPassword = dataFacade.findPassword(name);

        if(expectedPassword == null || !expectedPassword.equals(password)) {

            return false;
        } else {

           return true;
        }

    }
}
