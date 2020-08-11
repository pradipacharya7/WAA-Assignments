package com.lab_10.solution.controller;


import com.lab_10.solution.model.Employee;
import com.lab_10.solution.service.EmployeeService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @ModelAttribute("employees")
    public List<Employee> addEmployee(Model model) {
        return employeeService.findAll();
    }

    private static final Log logger = LogFactory.getLog(com.lab_10.solution.model.Employee.class);

    @RequestMapping(value = {"/", "EmployeeForm"})
    public String inputEmployee(@ModelAttribute("employee") Employee employee) {
        return "EmployeeForm";
    }

    @RequestMapping(value = "/employee_save")
    public String saveEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult, RedirectAttributes redirectAttributes,
                               Model model) {

        if (bindingResult.hasErrors()) {
            return "EmployeeForm";
        }

        String[] suppressedFields = bindingResult.getSuppressedFields();
        if (suppressedFields.length > 0) {
            throw new RuntimeException("Attempt to bind fields that haven't been allowed in initBinder(): "
                    + StringUtils.addStringToArray(suppressedFields, ", "));
        }

        // save product here
        employeeService.save(employee);
        List<Employee> employees = employeeService.findAll();

        redirectAttributes.addFlashAttribute("employees", employees);


        return ("redirect:/employee-details");

    }

    @GetMapping("/employee-detail/{id}")
    public String showDetails(@PathVariable("id") long id, Model model) {
        Employee employee = employeeService.getEmployeeByNumber(id);
        model.addAttribute("employee", employee);
        return "employee-detail";
    }


    @GetMapping("/employee-details")
    public String showAllEmployee(Model model) {
        return "EmployeeDetails";
    }

    @RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
    public String showEditForm(@PathVariable("id") long id, Model model) {

        Optional<Employee> employeeOptional = employeeService.findById(id);

        model.addAttribute("employee", employeeOptional.get());
        return "EmployeeEdit";
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.POST)
    public String updateEmployee(@Valid @ModelAttribute("employee") Employee employee, BindingResult bindingResult, @PathVariable("id") long id) {

        if (bindingResult.hasErrors()) {
            employee.setId(id);
            return "EmployeeEdit";
        }
        employeeService.save(employee);
        return ("redirect:/employee-details");
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteEmployee(@PathVariable("id") long id, Model model) {
        employeeService.deleteById(id);
        return ("redirect:/employee-details");
    }

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        // binder.setDisallowedFields(new String[]{"firstName"});
    }
}
