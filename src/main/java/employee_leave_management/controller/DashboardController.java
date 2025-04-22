package employee_leave_management.controller;

import employee_leave_management.entity.CustomOAuth2User;
import employee_leave_management.entity.User;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/dashboard")
    public String dashboard(@AuthenticationPrincipal CustomOAuth2User customOAuth2User, Model model) {
        User user = customOAuth2User.getUser();
        model.addAttribute("name", user.getName());
        model.addAttribute("email", user.getEmail());
        model.addAttribute("role", user.getRole().name());

        return "dashboard"; // tampilkan dashboard.html
    }
}
