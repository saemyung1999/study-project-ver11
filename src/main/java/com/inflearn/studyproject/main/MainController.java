package com.inflearn.studyproject.main;

import com.inflearn.studyproject.account.CurrentUser;
import com.inflearn.studyproject.domain.Account;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Slf4j
@Controller
public class MainController {

    @GetMapping("/")
    public String home(@CurrentUser Account account, Model model, Principal principal) {
        if (account != null) {
            model.addAttribute(account);
        }
        return "index";
    }
}