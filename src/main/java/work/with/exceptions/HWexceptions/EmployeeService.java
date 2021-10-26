package work.with.exceptions.HWexceptions;

public interface EmployeeService {
    Employee addEmployee(String lastName, String firstName) throws EmpIntServErrException;
    String deleteEmployee(String lastName, String firstName)throws EmpNotFoundException;
    Employee findEmployee(String lastName, String firstName)throws EmpNotFoundException;
}
