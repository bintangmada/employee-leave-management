package employee_leave_management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDate;

@Entity
public class ApprovalLog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long approvalLogId;

    private Long leaveRequestId;
    private String action;
    private String approverName;
    private LocalDate timeStamp;

    private String note;

    public ApprovalLog() {
    }

    public ApprovalLog(Long approvalLogId, Long leaveRequestId, String action, String approverName, LocalDate timeStamp, String note) {
        this.approvalLogId = approvalLogId;
        this.leaveRequestId = leaveRequestId;
        this.action = action;
        this.approverName = approverName;
        this.timeStamp = timeStamp;
        this.note = note;
    }

    public Long getApprovalLogId() {
        return approvalLogId;
    }

    public void setApprovalLogId(Long approvalLogId) {
        this.approvalLogId = approvalLogId;
    }

    public Long getLeaveRequestId() {
        return leaveRequestId;
    }

    public void setLeaveRequestId(Long leaveRequestId) {
        this.leaveRequestId = leaveRequestId;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public String getApproverName() {
        return approverName;
    }

    public void setApproverName(String approverName) {
        this.approverName = approverName;
    }

    public LocalDate getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDate timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }
}
