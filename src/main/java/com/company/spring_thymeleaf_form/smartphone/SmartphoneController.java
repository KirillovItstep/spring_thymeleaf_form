package com.company.spring_thymeleaf_form.smartphone;

import com.company.spring_thymeleaf_form.firms.Firm;
import com.company.spring_thymeleaf_form.firms.FirmService;
import com.company.spring_thymeleaf_form.os.OsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@Controller
public class SmartphoneController {

    @Autowired
    private SmartphoneService smartphoneService;
    @Autowired
    private FirmService firmService;
    @Autowired
    private OsService osService;

    @GetMapping(value ="/add_smart")
    public String index(Model model) {
        model.addAttribute("smartphone",new Smartphone()); //Если не добавить, то не будет выполняться парсинг шаблона исходной страницы
        model.addAttribute("os",osService.findAll());
        model.addAttribute("firms",firmService.findAll());
        return "add_smart";
    }

    @GetMapping(value ="/list_smarts" )
    public String listSmartphones(Model model) {
        model.addAttribute("smartphones", smartphoneService.findAll());
        return "list_smarts";
    }

    @PostMapping(value="/save_smart")
    public String saveSmartphone(Smartphone smartphone, Model model) {
        System.out.println(smartphone);
        smartphoneService.save(smartphone);
        model.addAttribute("smartphones", smartphoneService.findAll());
        return "redirect:/list_smarts";
    }

    @RequestMapping(value = "/delete_smart", method = RequestMethod.GET)
    public String deleteSmartphone(@RequestParam(name="id")Long id) {
        smartphoneService.deleteById(id);
        return "redirect:/list_smarts";
    }
}
