package services;
import Helper.StringExtension;
import model.User;
import repository.EmployeeRepository;

import java.util.Scanner;

public class EmployeeAdder {
    public void AddAnEmployee(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter name : ");

        var employeeName = scanner.nextLine();

        if(employeeName != null && !employeeName.trim().isEmpty()){
            AddEmployeePosition(scanner, employeeName);
        }
        else{
            System.out.println("Name can't be empty");
            AddAnEmployee();
        }
    }

    private void AddEmployeePosition(Scanner scanner, String employeeName){
        String employeePosition;

        System.out.print("Enter position : ");
        employeePosition = scanner.nextLine();

        if(employeePosition != null && !employeePosition.trim().isEmpty()) {
            System.out.println("Successfully added employee: " + employeeName + " with position " + employeePosition);

            User newUser = new User() {{
                Name = StringExtension.Trim(employeeName);
                Position = StringExtension.Trim(employeePosition);
            }};

            EmployeeRepository.getInstance().addUser(newUser);

            MenuPageViewer.getInstance().DisplayMainPrompt();
        }
        else{
            System.out.println("Position can't be empty");
            AddEmployeePosition(scanner, employeeName);
        }
    }
}
