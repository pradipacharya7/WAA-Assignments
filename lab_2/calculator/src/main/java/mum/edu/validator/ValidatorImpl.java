package mum.edu.validator;

import mum.edu.model.Calculator;
import org.w3c.dom.ls.LSOutput;

import java.util.ArrayList;
import java.util.List;

public class ValidatorImpl implements Validator{

    public List<String> validateInputs(Object  object ) {
        System.out.println("here");

        List<String> errors = new ArrayList<String>();
//
        Calculator calculator = (Calculator) object;
        System.out.println(calculator);
        String add1 = calculator.getAdd1();
        if (add1 == null || add1.trim().isEmpty()) {
            errors.add("Please enter add1");
        }
        String add2 = calculator.getAdd2();
       if (add2 == null || add2.trim().isEmpty()) {
            errors.add("Please enter add2");
        }
        String mult1 = calculator.getMult1();
        if (mult1 == null || mult1.trim().isEmpty()) {
            errors.add("Please enter mult1");
        }
        String mult2 = calculator.getMult2();
        if (mult2 == null || mult2.trim().isEmpty()) {
            errors.add("Please enter mult2");
        }
        return errors;
    }
}
