# employee-leave-management
A Spring Boot app for managing employee leave requests, approvals, and remaining leave days.

## 📋 Description
This project is an **Employee Leave Management System** designed to handle leave requests, manage balances, and allow HR/Admin users to approve or reject requests. It also provides a way for employees to view their remaining leave days and request time off.

![Image](https://github.com/user-attachments/assets/491639b5-6c37-478d-9d15-9008c8bdd6d3)

## 🧠 1. Main Features

### For Employees:
- **Register**: New users can register by providing necessary details (name, email, password).
- **Login**: Secure login to access the system.
- **View Leave Balance**: Check remaining leave days.
- **Request Leave**: Submit leave requests with reasons and dates.
- **View Request Status**: Check the status of leave requests (Pending, Approved, Rejected).

### For HR/Admin:
- **Login**: Secure login for HR/Admin users.
- **View Leave Requests**: View all leave requests from employees.
- **Approve/Reject Requests**: Approve or reject leave requests.
- **View Leave Reports**: See leave reports for all employees.

## 🧱 2. Entity Design (Database Schema)

### **User**
- `id`: Unique identifier for the user.
- `name`: Full name of the user.
- `email`: Email address of the user.
- `password`: User's password (encrypted).
- `role`: Enum (Employee, HR/Admin).

### **LeaveRequest**
- `id`: Unique identifier for the leave request.
- `user_id`: Many-to-One relationship to User.
- `startDate`: Start date of the requested leave.
- `endDate`: End date of the requested leave.
- `reason`: Reason for the leave request.
- `status`: Enum (Pending, Approved, Rejected).
- `createdAt`: Date and time when the leave request was created.

### **LeaveType (optional)**
- `id`: Unique identifier for the leave type (e.g., Annual Leave, Sick Leave).
- `name`: Name of the leave type.

### **LeaveBalance**
- `id`: Unique identifier for the leave balance.
- `user_id`: Relationship to the User.
- `leaveType_id`: Relationship to the LeaveType.
- `remainingDays`: Number of days left for the specific leave type.

### **Audit Trail Columns**
- **createdBy**: Stores the ID of the user who created the leave request.
- **createdAt**: Timestamp when the leave request was created.
- **updatedBy**: Stores the ID of the user who last updated the leave request.
- **updatedAt**: Timestamp when the leave request was last updated.
- **deletedBy**: Stores the ID of the user who deleted the leave request (soft delete).
- **deletedAt**: Timestamp when the leave request was deleted (soft delete).
- **status**: Tracks the status of the leave request (e.g., approved, rejected, pending).
- **deletedStatus**: Indicates whether the leave request is deleted (soft delete).

## 🧭 3. Leave Request Flow
1. Employee registers and logs in.
2. Employee selects leave dates and provides a reason.
3. System checks available leave balance.
4. If sufficient balance → store request with status `PENDING`.
5. HR/Admin logs in and approves or rejects the leave request.
6. If approved → reduce the leave balance accordingly.

## 🧰 4. Technologies Used
- **Spring Boot** (Backend)
- **Spring Security** (Login & role management)
- **Spring Data JPA** (Database access)
- **MySQL** (Database)
- **Thymeleaf** (Frontend choice)
- (Optional) **Spring Mail** for email notifications

## 🧾 5. Audit Trail
Every change to an entity (like `LeaveRequest`) is tracked with an audit trail.

## 🎯 6. How to Run

1. Clone this repository:  
   `git clone https://<token>@github.com/bintangmada/employee-leave-management.git`  
   *Contact me to get the token: bintang.mada@gmail.com*
   
2. Set up the DBMS (MySQL).
3. Configure application properties (`application.properties` or `application.yml`).
4. Build and run the Spring Boot application.
5. Access the application through your browser at `http://localhost:8080`.

## 🤝 7. Contributing

Contributions are welcome! Please fork this repository and create a pull request with your changes. Ensure you follow the coding standards and write tests for your changes.

## 📜 8. License

This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.
