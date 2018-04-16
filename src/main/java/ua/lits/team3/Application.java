package ua.lits.team3;

import com.fasterxml.jackson.databind.ObjectMapper;
import ua.lits.team3.model.Employee;

import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @since 2018-04-16.
 *
 */
public class Application {
  public static void main(String[] args) throws IOException {
    File file = new File("src/main/resourses/json/employees.json");
    List<Employee> employeeList = retrieveEmployeesFromFile(file);
    printCollection(employeeList);
  }

  /**
   * Returns Employees from json file.
   *
   * @param file file
   * @return list of Employees objects
   * @throws IOException
   */
  private static List<Employee> retrieveEmployeesFromFile(File file) throws IOException {
    ObjectMapper objectMapper = new ObjectMapper();
    Employee[] employees = objectMapper.readValue(file, Employee[].class);
    return Arrays.asList(employees);
  }

  /**
   * Prints Employees.
   *
   * @param list list of objects.
   */
  private static void printCollection(List<Employee> list) {
    for (Employee employee : list) {
      String stringBuilder = "Name: " + employee.getName() + "\n" +
        "Position: " + employee.getPosition() + "\n" +
        "Salary: " + employee.getSalary() + "\n";
      System.out.println(stringBuilder);
    }
  }
}
