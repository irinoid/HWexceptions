package work.with.exceptions.HWexceptions;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@Service
public class EmployeeService implements EmployeeServiceInterface {

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
        for (int i = 0; i < 100; i++) {
            if (i >= employee.length) {
                throw new EmpIntServErrException();
            } else if (employee[i] == null) {
                employee[i] = new Employee(lastName, firstName);
                return employee[i];
            }
        }
        return null;
    }

    @Override
    public String deleteEmployee(String lastName, String firstName) throws EmpNotFoundException {

        int i = 0;
        for (; i < employee.length; i++) {
            if ((employee[i].getFirstName().equals(firstName)) && (employee[i].getLastName().equals(lastName))) {
                employee[i] = null;
                return "Сотрудник " + firstName + " " + lastName + " удален.";
            }
            if (i == employee.length - 1) {
                throw new EmpNotFoundException();
            }
        }
        return null;
    }

    @Override
    public Employee findEmployee(String lastName, String firstName) throws EmpNotFoundException {
        int i = 0;
        for (; i < employee.length; i++) {
            if ((employee[i].getFirstName().equals(firstName)) && (employee[i].getLastName().equals(lastName))) {
                return employee[i];
            }
            if (i == employee.length - 1) {
                throw new EmpNotFoundException();
            }
        }
        return null;
    }
}
