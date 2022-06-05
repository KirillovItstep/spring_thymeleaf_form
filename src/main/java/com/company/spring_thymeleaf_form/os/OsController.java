package com.company.spring_thymeleaf_form.os;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
    public class OsController {

        @Autowired
        private OsService osService;

        @GetMapping(value ="/add_os")
        public String indexOs(Model model) {
            model.addAttribute("os",new Os()); //Если не добавить, то не будет выполняться парсинг шаблона исходной страницы
            return "add_os";
        }

        @GetMapping(value ="/list_os" )
        public String listOs(Model model) {
            model.addAttribute("os", osService.findAll());
            return "list_os";
        }

        @PostMapping(value="/save_os")
        public String saveOs(Os os, Model model) {
            osService.save(os);
            model.addAttribute("os", osService.findAll());
            return "list_os";
        }

        @RequestMapping(value = "/delete_os", method = RequestMethod.GET)
        public String deleteOs(@RequestParam(name="id")Long id) {
            osService.deleteById(id);
            return "redirect:/list_os";
        }
    }

