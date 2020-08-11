package com.lab3.controller;

import com.lab3.data.DataFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class MainController {
    @Autowired
    private DataFacade dataFacade;
    @RequestMapping(value = "/")

    public String showIndexPage(Model model)
    {
        return "index";
    }
    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String loginSuccessful(Model model,@RequestParam String name,@RequestParam String password)
    {
        boolean checkCredential=checkCredential(name,password);
        if(checkCredential==true) {
            return "successful-page";
        }
        return "index";
    }
    @RequestMapping(value = "/advice",method = RequestMethod.GET)
    public String getAdviceForm(Model model)
    {
        return "advice";
    }
    @RequestMapping(value = "/advice", method = RequestMethod.POST)
    public String showAdvice(Model model,@RequestParam String roast)
    {
        model.addAttribute("advices",dataFacade.getAdvice(roast));
       return "display";
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
