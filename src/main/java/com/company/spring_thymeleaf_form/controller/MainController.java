package com.company.spring_thymeleaf_form.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


@Controller
public class MainController {

    @GetMapping( value ={"/", "/index"} )
    public String index(Model model) {
        return "index";
    }

    @PostMapping("/calculate")
    public String calculate(Model model, @RequestParam String a, @RequestParam String b,
                            RedirectAttributes redirectAttributes) {
        int valueA = Integer.parseInt(a);
        int valueB = Integer.parseInt(b);
        int valueC = valueA+valueB;
        String c = String.valueOf(valueC);
        //redirectAttributes.addAttribute("sum", c); //Запись в параметры метода GET
        model.addAttribute("a", a);
        model.addAttribute("b", b);
        model.addAttribute("sum", c);

        return "index";
    }
}
