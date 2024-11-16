package com.ipn.crud.controller;

import com.ipn.crud.models.AppUser;
import com.ipn.crud.repositories.AppUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin")
public class AdminController {

    @Autowired
    private AppUserRepository userRepository;

    // Método para mostrar el formulario de edición de usuario
    @GetMapping("/edit/{id}")
    public String editUserForm(@PathVariable("id") int id, Model model) {
        AppUser user = userRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Usuario no encontrado: " + id));
        model.addAttribute("user", user);
        return "edit-user";
    }

    // Método para procesar la actualización de usuario
    @PostMapping("/edit/{id}")
    public String updateUser(@PathVariable("id") int id, @ModelAttribute("user") AppUser user) {
        userRepository.save(user);
        return "redirect:/";
    }

    // Método para eliminar un usuario
    @GetMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") int id) {
        userRepository.deleteById(id);
        return "redirect:/";
    }
}