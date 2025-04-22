package employee_leave_management.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(@AuthenticationPrincipal OAuth2User oauth2User, Model model) {
        String name = oauth2User.getAttribute("name");
        String email = oauth2User.getAttribute("email");

        model.addAttribute("name", name);
        model.addAttribute("email", email);
        return "dashboard"; // tampilkan dashboard.html
    }
}
