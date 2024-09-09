package com.kmoore.dojosninjas.controllers;

import com.kmoore.dojosninjas.models.Dojo;
import com.kmoore.dojosninjas.models.Ninja;
import com.kmoore.dojosninjas.services.DojoService;
import com.kmoore.dojosninjas.services.NinjaService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class NinjaController {
    private final NinjaService ninjaService;
    private final DojoService dojoService;

    public NinjaController(NinjaService ninjaService, DojoService dojoService) {
        this.ninjaService = ninjaService;
        this.dojoService = dojoService;
    }

    @GetMapping("/ninjas/new")
    public String newNinja(@ModelAttribute("ninja") Ninja ninja, Model model) {
        model.addAttribute("dojos", dojoService.getAll());
        return "newNinja.jsp";
    }

//        @GetMapping("/ninja/new")
//        public String createNinjaForm(Model model) {
//            model.addAttribute("dojos", dojoService.findAllDojos());
//            model.addAttribute("ninja", new Ninja());
//            return "/dojoDetails.jsp"; // This should match the JSP file name without the .jsp extension
//        }


    @PostMapping("/ninjas/create")
    public String createNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "newNinja.jsp";
        }
        ninjaService.createNinja(ninja); // Assuming you have a service to save the ninja
        return "redirect:/dojos/" + ninja.getDojo().getId();

    }
//        ninjaService.createNinja(ninja);
//        return "redirect:/dojoDetails.jsp";
}

