package employee_leave_management.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
public class LeaveType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long leaveTypeId;

    private String code;
    private String description;

    public LeaveType() {
    }

    public LeaveType(Long leaveTypeId, String code, String description) {
        this.leaveTypeId = leaveTypeId;
        this.code = code;
        this.description = description;
    }

    public Long getLeaveTypeId() {
        return leaveTypeId;
    }

    public void setLeaveTypeId(Long leaveTypeId) {
        this.leaveTypeId = leaveTypeId;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}

