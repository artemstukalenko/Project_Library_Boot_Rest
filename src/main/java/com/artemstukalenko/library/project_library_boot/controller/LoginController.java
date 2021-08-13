package com.artemstukalenko.library.project_library_boot.controller;

import com.artemstukalenko.library.project_library_boot.view.FirstView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class LoginController {

    @Autowired
    FirstView controlledView;

    @RequestMapping("/login")
    public String getLoginPage(@RequestParam(value = "error", required = false) String error,
                               @RequestParam(value = "logout", required = false) String logout,
                               Model model) {
        model.addAttribute("error", error != null);
        model.addAttribute("logout", logout != null);
        model.addAttribute("locale", controlledView);
        return "homepage";
    }

    @RequestMapping("/logout")
    public String whenLoggedOut() {
        return "redirect:/login";
    }

    @RequestMapping("uaLogin")
    public String getUaLoginPage(Model model) {
        model.addAttribute("locale", controlledView);

        FirstView.changeLanguageToUa();

        return "redirect:/.";
    }

    @RequestMapping("enLogin")
    public String getEnLoginPage(Model model) {
        model.addAttribute("locale", controlledView);

        FirstView.changeLanguageToEn();

        return "redirect:/.";
    }
}
