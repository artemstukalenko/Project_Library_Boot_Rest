package com.artemstukalenko.library.project_library_boot.controller;


import com.artemstukalenko.library.project_library_boot.view.FirstView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class FirstController {

    FirstView controlledView = new FirstView();

//    @RequestMapping(value = "/", method = RequestMethod.GET)
//    public String getGreeting() {
//        return "hello";
//    }

    @RequestMapping("/")
    public String getChangeLanguagePage(Model model) {
        model.addAttribute("locale", controlledView);
        return "homepage";
    }

    @RequestMapping("en")
    public String getPageWithEnLang(Model model) {
        model.addAttribute("locale", controlledView);

        FirstView.changeLanguageToEn();

        return "homepage";
    }

    @RequestMapping("ua")
    public String getPageWithUaLang(Model model) {
        model.addAttribute("locale", controlledView);

        FirstView.changeLanguageToUa();

        return "homepage";
    }

    @RequestMapping("/booksList")
    public String getUserEntryPage(Model model) {
        model.addAttribute("locale", controlledView);

        return "user-entry-page";
    }

    @RequestMapping("/asAdmin")
    public String getAdminEntryPage(Model model) {
        model.addAttribute("locale", controlledView);

        return "admin-entry-page";
    }

    @RequestMapping("/asLibrarian")
    public String getLibrarianEntryPage(Model model) {
        model.addAttribute("locale", controlledView);

        return "librarian-entry-page";
    }

}
