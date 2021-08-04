package com.artemstukalenko.library.project_library_boot.controller;

import com.artemstukalenko.library.project_library_boot.view.FirstView;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LibrarianController {

    FirstView controlledView = new FirstView();

    @RequestMapping("/asLibrarian")
    public String getLibrarianEntryPage(Model model) {
        model.addAttribute("locale", controlledView);

        return "librarian-entry-page";
    }

}
