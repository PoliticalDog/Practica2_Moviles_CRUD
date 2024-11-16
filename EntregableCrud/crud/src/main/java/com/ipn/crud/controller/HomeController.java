package com.ipn.crud.controller;

import com.ipn.crud.models.AppUser;
import com.ipn.crud.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private AppUserRepository repo;

    @GetMapping({"", "/"})
    public String home(Model model) {
        // Obtener la lista de todos los usuarios registrados
        var users = repo.findAll();
        model.addAttribute("users", users);
        return "index";
    }

    @GetMapping("/contact")
    public String contact() {
        return "contact";
    }
}
