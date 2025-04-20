package employee_leave_management.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class LeaveBalance {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private User user;

    @ManyToOne
    private LeaveType leaveType;

    private int remainingDays;

    // Audit Trail
    private Long createdBy;
    private LocalDateTime createdAt;
    private Long updatedBy;
    private LocalDateTime updatedAt;
    private Long deletedBy;
    private LocalDateTime deletedAt;
    private boolean deletedStatus;
}

