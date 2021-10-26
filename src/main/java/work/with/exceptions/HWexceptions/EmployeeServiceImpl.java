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
    public String deleteEmployee(String lastName, String firstName) throws EmpNotFoundException {

        for (int i = 0; i < employee.length; i++) {
            if ((employee[i].getFirstName().equals(firstName)) && (employee[i].getLastName().equals(lastName))) {
                employee[i] = null;
                return lastName + " " + firstName;
            }
        }
        throw new EmpNotFoundException();
    }

    @Override
    public Employee findEmployee(String lastName, String firstName) throws EmpNotFoundException {

        for (int i = 0; i < employee.length; i++) {
            if ((employee[i].getFirstName().equals(firstName)) && (employee[i].getLastName().equals(lastName))) {
                return employee[i];
            }
        }
        throw new EmpNotFoundException();
    }
}
