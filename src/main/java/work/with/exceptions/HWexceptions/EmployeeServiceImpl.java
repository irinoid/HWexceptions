package work.with.exceptions.HWexceptions;

import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    Employee[] employee = {
            new Employee("Иванов", "Иван"),
            new Employee("Петров", "Петр"),
            new Employee("Киркоров", "Филипп"),
            new Employee("Питт", "Брэд"),
            new Employee("Дудь", "Юрий"),
            new Employee("Собчак", "Ксения"),
            new Employee("Милонов", "Виталий"),
            new Employee("Басков", "Николай")
    };
//        new Employee("Васильев", "Василий")};
//        new Employee("Капелько", "Ирина");

    @Override
    public Employee addEmployee(String lastName, String firstName) throws EmpIntServErrException {
        for (int i = 0; i < employee.length; i++) {
            if (employee[i] == null) {
                employee[i] = new Employee(lastName, firstName);
                return employee[i];
            }
        }
        throw new EmpIntServErrException();
    }

    @Override
    public Employee deleteEmployee(String lastName, String firstName) throws EmpNotFoundException {
        Employee delEmp = new Employee(lastName, firstName);
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].equals(delEmp)) {
                employee[i] = null;
                return delEmp;
            }
        }
        throw new EmpNotFoundException();
    }

    @Override
    public Employee findEmployee(String lastName, String firstName) throws EmpNotFoundException {
        Employee findEmp = new Employee(lastName, firstName);
        for (int i = 0; i < employee.length; i++) {
            if (employee[i].equals(findEmp)) {
                return findEmp;
            }
        }
        throw new EmpNotFoundException();
    }
}
