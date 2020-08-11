package com.lab3.controller;

import com.lab3.model.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller
public class CalcController {
    @GetMapping("/")
    public String showHomePage()
    {
        return "index";
    }

    @RequestMapping(value ="/calculator/", method = RequestMethod.GET)
    public String showCalculator()
    {
        return "calculator";
    }

    @RequestMapping(value = "/calculator", method = RequestMethod.POST)
    public  String calculate(Calculator calculator,Model model)
    {
        if(calculator.getAdd1()!=null&&calculator.getAdd2()!=null&&calculator.getMult1()!=null&&calculator.getMult2()!=null) {
            float sum = Float.parseFloat(calculator.getAdd1()) + Float.parseFloat(calculator.getAdd2());
            float product = Float.parseFloat(calculator.getMult1()) * Float.parseFloat(calculator.getMult2());
            model.addAttribute("sum", sum);
            model.addAttribute("product", product);
            model.addAttribute("calc", calculator);
            return "result";
        }
        List<String>errors=new ArrayList<>();
        errors.add("Please give all values");
        model.addAttribute("errors",errors);
        return "calculator";
    }
}
