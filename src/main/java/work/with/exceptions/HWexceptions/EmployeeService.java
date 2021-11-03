package work.with.exceptions.HWexceptions;

public interface EmployeeService {
    Employee addEmployee(String lastName, String firstName) throws EmpIntServErrException;
    Employee deleteEmployee(String lastName, String firstName)throws EmpNotFoundException;
    Employee findEmployee(String lastName, String firstName)throws EmpNotFoundException;
}
