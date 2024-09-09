package com.kmoore.dojosninjas.controllers;
import com.kmoore.dojosninjas.models.Dojo;
import com.kmoore.dojosninjas.services.DojoService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import jakarta.validation.Valid;
import java.util.List;

@Controller
public class DojoController {
    private final DojoService dojoService;
    private BindingResult result;

    public DojoController(DojoService dojoService) {
        this.dojoService = dojoService;
    }

    @GetMapping("/dojos/new")
    public String newDojo(@ModelAttribute("dojo") Dojo dojo) {
        return "newDojo.jsp";
    }

    @GetMapping("/")
    public String index() {
        return "redirect:/dojos";
    }

    @GetMapping("/dojos")
    public String getAllDojos(Model model) {
        List<Dojo> dojos = dojoService.getAll();
        model.addAttribute("dojos", dojos);
        return "allDojos.jsp";
    }

    @PostMapping("/dojos/create")
    public String createDojo(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
        if (result.hasErrors()) {
            return "newDojo.jsp";
        }
        dojoService.createDojo(dojo);
        return "redirect:/dojos";
    }

    @GetMapping("/dojos/{id}")
    public String showDojo(@PathVariable("id") Long id, Model model) {
        Dojo dojo = dojoService.getById(id);
        model.addAttribute("dojo", dojo);
        return "dojoDetails.jsp";
    }
}

