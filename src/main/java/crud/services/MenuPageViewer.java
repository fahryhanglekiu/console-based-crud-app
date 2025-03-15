package services;

import java.util.Scanner;

public class MenuPageViewer {
    EmployeeAdder employeeAdder = new EmployeeAdder();
    EmployeeViewer employeeViewer = new EmployeeViewer();
    EmployeeUpdater employeeUpdater = new EmployeeUpdater();
    EmployeeRemover employeeRemover = new EmployeeRemover();

    private static MenuPageViewer instance;

    public static MenuPageViewer getInstance(){
        if(instance == null)
            instance = new MenuPageViewer();

        return instance;
    }

    public void DisplayMainPrompt(){
        Scanner scanner = new Scanner(System.in);

        System.out.println("1. Add employee\n2. View employee\n3. Update employee\n4. Remove employee\n5. Exit");
        System.out.print("Enter your choice: ");

        String input = scanner.nextLine();

        try{
            if(Integer.parseInt(input) <= 5 && Integer.parseInt(input) > 0){
                ProcessInput(Integer.parseInt(input));
            }
            else{
                System.out.println("Not Valid input");

                // Re-prompt
                DisplayMainPrompt();
            }
        }
        catch(NumberFormatException exception){
            System.out.println("Not Valid input");

            //Re-prompt
            DisplayMainPrompt();
        }
    }

    private void ProcessInput(int input){
        switch (input){
            case 1:
                //Add an employee
                employeeAdder.AddAnEmployee();
                break;
            case 2:
                //View the employee
                employeeViewer.ViewEmployee();
                break;
            case 3:
                //Update the employee name and position
                employeeUpdater.PrintUpdateEmployeeInput();
                break;
            case 4:
                //Remove the employee by index
                employeeRemover.RemoveEmployee();
                break;
            case 5:
                //Exit the CLI
                break;
        }
    }
}
