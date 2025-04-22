package employee_leave_management.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class LoginController {
    @GetMapping({"/", "/login"})
    public String loginPage() {
        return "login"; // mengarah ke src/main/resources/templates/login.html
    }
}
