package com.lab3.controller;

import com.lab3.model.Calculator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

//import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@Controller
public class CalcController {
    @GetMapping("/")
    public String showHomePage()
    {
        return "index";
    }

    @RequestMapping(value ="/calculator", method = RequestMethod.GET)
    public String showCalculator()
    {
        return "calculator";
    }

    @RequestMapping(value = "/calculator", method = RequestMethod.POST)
    public  String calculate( @ModelAttribute("newCalculator") Calculator calculator,  BindingResult bindingResult,RedirectAttributes redirectAttributes,Model model)
    {
        if(bindingResult.hasErrors())
        {
            return "calculator";
        }

//        if(calculator.getAdd1()!=null&&calculator.getAdd2()!=null&&calculator.getMult1()!=null&&calculator.getMult2()!=null)
    else{
            float sum = Float.parseFloat(calculator.getAdd1()) + Float.parseFloat(calculator.getAdd2());
            float product = Float.parseFloat(calculator.getMult1()) * Float.parseFloat(calculator.getMult2());
            redirectAttributes.addFlashAttribute("sum",sum);
            redirectAttributes.addFlashAttribute("product",product);
            redirectAttributes.addFlashAttribute("calculator",calculator);
            redirectAttributes.addFlashAttribute("greeting","Sucessful!!! Your Results are below");
            return "redirect:/result";
        }
//    else {
//        List<String> errors = new ArrayList<>();
//        errors.add("Please give all values");
//        redirectAttributes.addAttribute("errors", errors);
//        return "redirect:/calculator";
//    }
    }
    @GetMapping("/result")
    public String showResult(Model model)
    {
        return "result";
    }
}
