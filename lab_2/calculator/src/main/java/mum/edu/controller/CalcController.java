package mum.edu.controller;

import mum.edu.framework.annotation.AutoWired;
import mum.edu.framework.annotation.RequestMapping;
import mum.edu.model.Calculator;
import mum.edu.validator.Validator;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
@mum.edu.framework.annotation.Controller
public class CalcController {
    @AutoWired
    Validator validator;

    @RequestMapping(value = {"/calculator"})
    public String showCalculator() {
        return "/WEB-INF/calculator/calculator.jsp";
    }

    @RequestMapping(value = {"/calculate"})
    public String calculateValues(Calculator calculator, HttpServletRequest request) {
        List<String> errors = validator.validateInputs(calculator);
        if (errors.isEmpty()) {
            float sum = Float.parseFloat(calculator.getAdd1()) + Float.parseFloat(calculator.getAdd2());
            float product = Float.parseFloat(calculator.getMult1()) * Float.parseFloat(calculator.getAdd2());
            request.setAttribute("sum", sum);
            request.setAttribute("product", product);
            request.setAttribute("calculator", calculator);
            return "/WEB-INF/calculator/result.jsp";
        }
        request.setAttribute("calc", calculator);
        request.setAttribute("errors", errors);
        return "/WEB-INF/calculator/calculator.jsp";
    }
}