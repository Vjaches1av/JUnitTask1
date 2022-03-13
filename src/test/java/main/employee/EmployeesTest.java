package main.employee;

import main.employee.util.EmployeeGeneration;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

class EmployeesTest {
    private static List<Employee> employeeArr;

    @BeforeAll
    static void createEmployees() throws IOException {
        employeeArr = EmployeeGeneration.readCSV("data.csv");
    }

    @Test
    void count() {
        Assertions.assertEquals(10001, new Employees(employeeArr).count());
    }

    @Test
    void filterEmployeeByGender() throws IOException {
        List<Employee> expected = EmployeeGeneration.readCSV(ClassLoader.getSystemResource("FilterDataByGender.csv").getPath());
        List<Employee> actual = new Employees(employeeArr).filterEmployeeByGender(Sex.MALE);
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void filterEmployeeOlder() throws IOException { // требуется ежедневное изменение ожидаемых входных данных
        List<Employee> expected = EmployeeGeneration.readCSV(ClassLoader.getSystemResource("FilterEmployeeOlder18.csv").getPath());
        List<Employee> actual = new Employees(employeeArr).filterEmployeeOlder(18);
        Assertions.assertEquals(expected, actual);
    }
}
