package employee_leave_management.service;

import employee_leave_management.entity.Employee;
import employee_leave_management.entity.LeaveRequest;
import employee_leave_management.entity.LeaveType;
import employee_leave_management.repository.EmployeeRepository;
import employee_leave_management.repository.LeaveRequestRepository;
import employee_leave_management.repository.LeaveTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;


@Service
public class LeaveRequestService {

    @Autowired private LeaveRequestRepository leaveRequestRepo;
    @Autowired private EmployeeRepository employeeRepo;
    @Autowired private LeaveTypeRepository leaveTypeRepo;

    public LeaveRequestService() {
    }

    public LeaveRequestService(LeaveRequestRepository leaveRequestRepo, EmployeeRepository employeeRepo, LeaveTypeRepository leaveTypeRepo) {
        this.leaveRequestRepo = leaveRequestRepo;
        this.employeeRepo = employeeRepo;
        this.leaveTypeRepo = leaveTypeRepo;
    }

    public List<LeaveRequest> getAllRequests() {
        return leaveRequestRepo.findAll();
    }

    public LeaveRequest saveRequest(LeaveRequest request) {
        request.setStatus("PENDING");
        request.setCreatedAt(LocalDate.now());
        return leaveRequestRepo.save(request);
    }

    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public List<LeaveType> getAllLeaveTypes() {
        return leaveTypeRepo.findAll();
    }
}

