package employee_leave_management.controller;

import employee_leave_management.entity.LeaveRequest;
import employee_leave_management.service.LeaveRequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/leave-requests")
public class LeaveRequestController {

    @Autowired
    private LeaveRequestService leaveRequestService;

    @GetMapping
    public String list(Model model) {
        model.addAttribute("leaveRequests", leaveRequestService.getAllRequests());
        return "leave-request/list";
    }

    @GetMapping("/form")
    public String form(Model model) {
        model.addAttribute("leaveRequest", new LeaveRequest());
        model.addAttribute("employees", leaveRequestService.getAllEmployees());
        model.addAttribute("leaveTypes", leaveRequestService.getAllLeaveTypes());
        return "leave-request/form.html";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute LeaveRequest request) {
        leaveRequestService.saveRequest(request);
        return "redirect:/leave-requests";
    }
}
