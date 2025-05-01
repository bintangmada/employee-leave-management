package employee_leave_management.repository;

import employee_leave_management.entity.LeaveType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LeaveTypeRepository extends JpaRepository<LeaveType, Long> {
}
