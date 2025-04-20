package employee_leave_management.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class LeaveType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "leaveType")
    private List<LeaveBalance> leaveBalances;
}

